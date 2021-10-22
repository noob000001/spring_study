package com.kh.spring.member.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kh.spring.member.model.repository.MemberRepository;

@Component
public class JoinFormValidator implements Validator{

	private final MemberRepository memberRepository;
	
	public JoinFormValidator(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return JoinForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		JoinForm form = (JoinForm) target;
	
		//1. ¾ÆÀÌµğ Á¸Àç À¯¹«
		if(memberRepository.selectMemberByUserId(form.getUserId()) != null) {
			errors.rejectValue("userId", "error-userId","ÀÌ¹Ì Á¸ÀçÇÏ´Â ¾ÆÀÌµğÀÔ´Ï´Ù.");
		}
		//2. ºñ¹Ğ¹øÈ£°¡ 8±ÛÀÚ ÀÌ»ó, ¼ıÀÚ ¿µ¹®ÀÚ Æ¯¼ö¹®ÀÚ Á¶ÇÕÀÎÁö È®ÀÎ
		boolean valid = Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z¤¡-ÆR0-9]).{8,}", form.getPassword());
		if(!valid) {
			errors.rejectValue("password", "error-password", "ºñ¹Ğ¹øÈ£´Â 8±ÛÀÚ ÀÌ»óÀÇ ¼ıÀÚ ¿µ¹®ÀÚ Æ¯¼ö¹®ÀÚ Á¶ÇÕ ÀÔ´Ï´Ù.");
			System.out.println(form.getPassword());
		}
		//3. ÀÌ¸ŞÀÏ Á¸Àç À¯¹«
		valid=Pattern.matches("^\\d{9,11}$", form.getTell());
		if(!valid) {
			errors.rejectValue("tell", "error-tell", "ÀüÈ­¹øÈ£´Â 9~11ÀÚ¸®ÀÇ ¼ıÀÚÀÔ´Ï´Ù.");
		}
		
		
	}

	
}

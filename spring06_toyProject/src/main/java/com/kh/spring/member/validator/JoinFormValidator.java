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
	
		//1. ���̵� ���� ����
		if(memberRepository.selectMemberByUserId(form.getUserId()) != null) {
			errors.rejectValue("userId", "error-userId","�̹� �����ϴ� ���̵��Դϴ�.");
		}
		//2. ��й�ȣ�� 8���� �̻�, ���� ������ Ư������ �������� Ȯ��
		boolean valid = Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z��-�R0-9]).{8,}", form.getPassword());
		if(!valid) {
			errors.rejectValue("password", "error-password", "��й�ȣ�� 8���� �̻��� ���� ������ Ư������ ���� �Դϴ�.");
			System.out.println(form.getPassword());
		}
		//3. �̸��� ���� ����
		valid=Pattern.matches("^\\d{9,11}$", form.getTell());
		if(!valid) {
			errors.rejectValue("tell", "error-tell", "��ȭ��ȣ�� 9~11�ڸ��� �����Դϴ�.");
		}
		
		
	}

	
}

package com.kh.spring.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.CookieGenerator;

import com.kh.spring.common.mybatis.validator.ValidateResult;
import com.kh.spring.member.model.dto.Member;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.validator.JoinForm;
import com.kh.spring.member.validator.JoinFormValidator;

@Controller
@RequestMapping("member")
public class MemberController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//1. @Controller : �ش� Ŭ������ applicationContext�� bean���� ���
		//					Controller�� ���õ� annotation�� ����� �� �ְ� ���ش�.
		//2. @RequestMapping : ��û URL�� Controller�� �޼��� ������ ����
		//					Ŭ���� ���� ������ ���, �ش� Ŭ������ ��� �޼��尡 ������ ��θ� ������η� ������.
		//3. @GetMapping : Get ����� ��û URL�� Controller�� �޼��� ������ ����
		//4. @PostMapping : post ����� ��û URL�� Controller�� �޼��� ������ ����
		//5. @RequestParam : ��û �Ķ���͸� ��Ʈ�ѷ� �޼����� �Ű������� ���ε�
		//					�� Content-type�� application/x-www-form-urlEncoded�� ��쿡�� ����
		//					FormHttpMessageConverter�� ����
		//6. @ModelAttribute : ��û �Ķ���͸� setter ����� �޼��� �Ű������� ����� ��ü�� ���ε�, 
		//					Model��ü�� attribute�� �ڵ����� ����
		//7. @RequestBody : ��û body�� �о �ڹ��� ��ü�� ���ε�
		//					application/x-www-form-urlEncoded�� �������� �ʴ´�.
		//8. @RequestHeader : ��û ����� �޼����� �Ű������� ���ε�
		//9. @SessionAttribute : ���ϴ� session�� �Ӽ����� �Ű������� ���ε�
		//10. @CookieValue : ���ϴ� cookie���� �Ű������� ���ε�
		//11. @PathVariable : url���ø��� ��� �Ķ���Ͱ��� �Ű������� ���ε�
		//12. @ResponseBody : �޼��尡 ��ȯ�ϴ� ���� ���� body�� �ۼ�
		//13. Servlet��ü�� ��Ʈ�ѷ��� �Ű������� ������ ���Թ��� �� �ִ�.
		//HttpServletRequest, HttpServletResponse, HttpSession
	
	
	
	private MemberService memberService;
	private JoinFormValidator joinFormValidator;
	
	public MemberController(MemberService memberService, JoinFormValidator joinFormValidator) {
		super();
		this.memberService = memberService;
		this.joinFormValidator = joinFormValidator;
	}
	
	//Model�Ӽ��� ���� ��Ģ
	//com.myapp.Product becomes "product"
	//com.myapp.MyProduct becomes "myProduct"
	//com.myapp.UKProduct becomes "UKProduct"

	
	@InitBinder(value="joinForm")//model�� �Ӽ� �� �Ӽ����� joinForm�� �Ӽ��� �ִ� ��� initBinder �޼��� ����
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(joinFormValidator);
	}
	
	
	@GetMapping("join")
	public void joinForm(Model model) {
		model.addAttribute(new JoinForm());
	}
	
	@PostMapping("join")
	public String join(@Validated JoinForm form
			, Errors errors //�ݵ�� ������ ��ü �ڿ� �ۼ�
			, Model model
		) {
		
		ValidateResult vr = new ValidateResult();
		model.addAttribute("error",vr.getError());
		
		if(errors.hasErrors()) {
			vr.addError(errors);
			return "member/join";
		}
		
		memberService.insertMember(form);
		return "index";
	}
	
	@PostMapping("join-json")
	public String joinWithJson(@RequestBody Member member) {
		logger.debug(member.toString());
		return "index";
	}
	
	//�α��� ������ �̵� �޼���
	//�޼���� : login
	@GetMapping("login")
	public void login() {
		
	}
	
	//�α��� ���� �޼���
	//�޼���� : loginImpl
	//�������� jsp : mypage
	@PostMapping("login")
	public String loginImpl(Member member, HttpSession session, RedirectAttributes redirectAttr) {
		
		Member certifiedUser = memberService.authenticateUser(member);
		
		if(certifiedUser == null) {
			redirectAttr.addFlashAttribute("message","���̵� ��й�ȣ�� ��Ȯ���� �ʽ��ϴ�.");
			return "redirect:/member/login";
		}
		
		session.setAttribute("authentication", certifiedUser);
		logger.debug(certifiedUser.toString());
		return "redirect:/member/mypage";
	}
	
	@GetMapping("mypage")
	public String mypage(@CookieValue(name="JSESSIONID") String sessionId
						, @SessionAttribute(name="authentication") Member member
						, HttpServletResponse response){

		//Cookie ���� �� ��������� �߰�
		CookieGenerator cookieGenerator = new CookieGenerator();
		cookieGenerator.setCookieName("testCookie");
		cookieGenerator.addCookie(response, "test_cookie");

		logger.debug("@CookieValue : " + sessionId);
		logger.debug("@SessionAttribute : " + member);
	
		return "member/mypage";
		
	}
						
	@GetMapping("id-check")
	@ResponseBody
	public String idCheck(String userId) {
		Member member = memberService.selectMemberByUserId(userId);
		
		if(member == null) {
			return "available";
		}else {
			return "disable";
		}
		
	}
	
	
	
	}

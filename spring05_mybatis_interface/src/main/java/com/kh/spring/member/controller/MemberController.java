package com.kh.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.spring.member.model.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberSerivce;
	
	@GetMapping("search-pw")
	public String searchPassword() {
		System.out.println("비밀번호는 " + memberSerivce.selectPasswordByUserId());
		return "home";
	}
	
}

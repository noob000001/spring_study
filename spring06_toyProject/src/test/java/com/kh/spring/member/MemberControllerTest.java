package com.kh.spring.member;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring.member.model.dto.Member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.servlet.http.Cookie;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MemberControllerTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//MockMvc : http ��û �� ���� ��Ȳ �׽�Ʈ�� ���� ��ü
	
	@Autowired
	WebApplicationContext wac;
	

	MockMvc mockMvc;
	
	
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void joinTest() throws Exception {
		mockMvc.perform(post("/member/join")
				.param("userId", "testMethod")
				.param("password", "1234")
				.param("tell", "010-2222-3333")
				.param("email", "aaa@bbb.com"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void joinWithJson() throws Exception{
		
		Member member = new Member();
		member.setUserId("testJson");
		member.setPassword("1234");
		member.setEmail("json@pclass.com");
		member.setTell("010-0000-1324");
		
		ObjectMapper mapper = new ObjectMapper();
		String memberJson = mapper.writeValueAsString(member);
		logger.debug(memberJson);
		//logger.debug(mapper.readValue(memberJson, Member.class).toString());
	
		mockMvc.perform(post("/member/join-json")
				.contentType(MediaType.APPLICATION_JSON)
				.content(memberJson))
		.andExpect(status().isOk())
		.andDo(print());
		
	}
	
	@Test
	public void loginImpl() throws Exception{
		
		mockMvc.perform(post("/member/login")
				.param("userId", "test")
				.param("password", "1234"))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}

	@Test
	public void mypage() throws Exception{
		Member member = new Member();
		member.setUserId("testJson");
		member.setPassword("1234");
		member.setEmail("json@pclass.com");
		member.setTell("010-0000-1324");
		
		
		
		mockMvc.perform(get("/member/mypage")
				.cookie(new Cookie("JSESSIONID","12398712984178923"))
				.sessionAttr("authentication", member))
				.andExpect(status().isOk())
				.andDo(print());
		
		
		
	}
	
	@Test
	public void idCheck() throws Exception{
		mockMvc.perform(get("/member/id-check?userId=test"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	
	
	
	
}

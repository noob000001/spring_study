package com.kh.spring.common;

import java.util.Date;
import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MailSenderTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	@Autowired
	RestTemplate http;
	
	@Autowired
	ObjectMapper mapper;
	
	@Test
	public void sendEmail() throws Exception{
		
		MimeMessage msg = mailSender.createMimeMessage();
		
		 msg.setFrom("pclassgyu@gmail.com");
	     msg.setRecipients(Message.RecipientType.TO,"pclassgyu@gmail.com");
	     msg.setSubject("�����׽�Ʈ");
	     msg.setSentDate(new Date());
	     msg.setText("<h1>Email Test</h1>","UTF-8","html");
	     mailSender.send(msg);
		
	}
	
	@Test
	   public void restTemplateTest() {
	      //String naver = http.getForObject("https://www.naver.com", String.class);
	      
	      MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
	      body.add("userId", "test");
	      body.add("password", "1234");
	      
	      HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	      HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
	      
	      String login = http.postForObject("http://localhost:9090/member/login", entity, String.class);
	            
	      logger.debug(login);
	      
	   }
	
	@Test
	public void restTemplateGetTest() throws JsonMappingException, JsonProcessingException, RestClientException {
		RequestEntity<Void> request = RequestEntity
				.get("https://dapi.kakao.com/v3/search/book?query=java")
				.header("Authorization", "KakaoAK ba112efcf314ada7501dcec64b02b5f9")
				.build();
		
		JsonNode root = mapper.readTree(http.exchange(request, String.class).getBody()); 
		
		for(JsonNode jsonNode : root.findValues("url")) {
			logger.debug(jsonNode.asText());
		}
		
		//logger.debug(response.toString());
	}
	
	@Test
	public void restTemplatePostTest() throws Exception{
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("source", "en");
		body.add("target", "ko");
		body.add("text", "Set the length of the body in bytes, as specified by the Content-Length header.");
		
		RequestEntity<MultiValueMap<String,String>> request =
				RequestEntity.post("https://openapi.naver.com/v1/papago/n2mt")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
				.header("X-Naver-Client-Id", "f8qi488Jog2fYe7V6PDi")
				.header("X-Naver-Client-Secret", "h8mKJw2_bC")
				.body(body);
		
		JsonNode root = mapper.readTree(http.exchange(request, String.class).getBody());
		logger.debug(root.findValue("translatedText").asText());
	}
	
	
	
}

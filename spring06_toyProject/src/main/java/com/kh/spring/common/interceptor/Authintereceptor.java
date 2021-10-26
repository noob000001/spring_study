package com.kh.spring.common.interceptor;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring.common.code.ErrorCode;
import com.kh.spring.common.code.MemberGrade;
import com.kh.spring.common.exception.HandlableException;
import com.kh.spring.member.model.dto.Member;

public class Authintereceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object handler) {
		
		String[] uriArr = httpRequest.getRequestURI().split("/");
		
		//  /member/join  =>  [ , member, join]
		if(uriArr.length != 0) {
			
			switch (uriArr[1]) {
			case "member":
				memberAuthorize(httpRequest, httpResponse, uriArr);
				break;
			case "admin":
				adminAuthorize(httpRequest, httpResponse, uriArr);
				break;
			case "board":
				boardAuthorize(httpRequest, httpResponse, uriArr);
				break;
			default:
				break;
			}
			
		}
		
		
		return true;
	}
	
	private void boardAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		HttpSession session = httpRequest.getSession();
		Member member= (Member) session.getAttribute("authentication");
		switch (uriArr[2]) {
		case "board-form":
			if(member==null) {
				throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE_ERROR);
			}
			break;
		case "upload":
			if(member==null) {
				throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE_ERROR);
			}
			break;

		default:
			break;
		}
		
	}

	private void adminAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		
		HttpSession session = httpRequest.getSession();
		Member member= (Member) session.getAttribute("authentication");
		
		// ��ȸ����, ����� ȸ�������� �Ǵ�
		if(member == null || MemberGrade.valueOf(member.getGrade()).ROLE.equals("user")) {
			throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE_ERROR);
		}
		
		//���۰��������� �Ǵ��� ���۰����ڶ�� ��� admin�������� ������ �� �ִ�.
		if(MemberGrade.valueOf(member.getGrade()).DESC.equals("super")) {
			return;
		}
		switch (uriArr[2]) {
		case "member":
			if(!MemberGrade.valueOf(member.getGrade()).DESC.equals("member")) {
				throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE_ERROR);
			}
			break;
		case "board":
			if(!MemberGrade.valueOf(member.getGrade()).DESC.equals("board")) {
				throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE_ERROR);
			}
			break;

		default:
			break;
		}
		
	}

	private void memberAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		HttpSession session = httpRequest.getSession();
		switch (uriArr[2]) {
		
		case "mypage":
			if(session.getAttribute("authentication") == null) {
				throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE_ERROR);
			}
			
			break;
			
		default:
			break;
		}

		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
}

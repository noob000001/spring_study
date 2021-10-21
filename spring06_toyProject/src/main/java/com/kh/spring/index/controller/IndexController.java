package com.kh.spring.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

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
	//10. @CookieVariable : ���ϴ� cookie���� �Ű������� ���ε�
	//11. @PathVariable : url���ø��� ��� �Ķ���Ͱ��� �Ű������� ���ε�
	//12. @ResponseBody : �޼��尡 ��ȯ�ϴ� ���� ���� body�� �ۼ�
	//13. Servlet��ü�� ��Ʈ�ѷ��� �Ű������� ������ ���Թ��� �� �ִ�.
	//HttpServletRequest, HttpServletResponse, HttpSession
	
	
	@GetMapping("/")
	public String index() {
	
		//Controller �޼����� returnŸ��
		//void : �ش� �޼��尡 ȣ��� url�� ��ο� ���� ��ġ�� �ִ� jsp���Ϸ� ��û�� ������
		//		��û url : /index/index => WEB-INF/views/index/index.jsp
		//String : ��ȯ�ϴ� ���� jsp ������ ��ġ, return "index/index" -> WEB-INF/views/index/index.jsp
		//ModelAndView : Model��ü + view(jsp������ ���)
		
		return "index";
	}
}

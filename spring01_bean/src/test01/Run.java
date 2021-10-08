package test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context
			=new ClassPathXmlApplicationContext("test01/applicationContext.xml");
		
		Address hong = (Address) context.getBean("hong");
		System.out.println(hong);
		
		Address lee = context.getBean("lee",Address.class);
		System.out.println(lee);
		
		Address kim = context.getBean("kim",Address.class);
		System.out.println(kim);
		
	}

}

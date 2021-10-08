package test03;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		// ApplicationContext�� 2021�� 10�� 9�� ��¥�� ������ java.util.Date ���� ����ϰ�
		// main�޼��忡�� �ش� ���� ȣ���� toString�޼��带 ����ϼ���.
		//�ش� ���� ���̵�� date�Դϴ�.
		
		ApplicationContext context 
			= new ClassPathXmlApplicationContext("test03/applicationContext.xml");
		
		System.out.println(context.getBean("dateBean", Date.class));
		System.out.println(context.getBean("scoreBean", Score.class));
		
	}

}

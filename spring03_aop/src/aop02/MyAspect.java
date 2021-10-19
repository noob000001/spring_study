package aop02;

import org.springframework.stereotype.Component;

@Component
public class MyAspect {

	public void before() {
		System.out.println("��� ī�带 ��´�.");
	}
	
	public void after() {
		System.out.println("���� ����.");
	}
	
	public void afterReturning() {
		System.out.println("��� ī�带 ��´�.");
	}
	
	public void afterThrowing() {
		System.out.println("���� ���̾���.");
	}
}

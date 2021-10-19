package aop03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Before(value = "execution(* *(..))")
	public void before() {
		System.out.println("��� ī�带 ��´�.");
	}
	
	@After(value = "execution(* *(..))")
	public void after() {
		System.out.println("���� ����.");
	}
	
	@AfterReturning(value = "execution(* *(..))", returning="res")
	public void afterReturning(Object res) {
		System.out.println(res);
		System.out.println("��� ī�带 ��´�.");
	}
	
	@AfterThrowing(value = "execution(* *(..))", throwing = "exception") //���ܰ�ü�� ���� �޼��� �Ű�������
	public void afterThrowing(Exception exception) {
		System.out.println(exception.getMessage());
		System.out.println("���� ���̾���.");
	}
}

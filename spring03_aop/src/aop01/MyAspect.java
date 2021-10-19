package aop01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("��� ī�带 ��´�.");
		
		try {
			invocation.proceed();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���� ���̾���.");
		}finally {
			System.out.println("���� ����.");
		}
		
		return null;
	}
}

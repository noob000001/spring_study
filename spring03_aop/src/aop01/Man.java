package aop01;

import org.springframework.stereotype.Component;

@Component
public class Man{
	
	public void develop() {
		System.out.println("���̽����� �����Ѵ�.");
	}
	
	private void play() {
		System.out.println("������W�� �÷����Ѵ�.");
	}
}

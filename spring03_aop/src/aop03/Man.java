package aop03;

import org.springframework.stereotype.Component;

@Component
public class Man{
	
	public void develop() {
		//int i = 1/0;
		System.out.println("���̽����� �����Ѵ�.");
	}
	
	public String play() {
		return "������W";
	}
}

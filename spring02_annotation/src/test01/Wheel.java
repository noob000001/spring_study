package test01;

import org.springframework.stereotype.Component;

public class Wheel {

	private int radius = 5;
	
	public Wheel() {
		System.out.println("�⺻������ ȣ��");
	}

	@Override
	public String toString() {
		return "Wheel [radius=" + radius + "]";
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		System.out.println("setRadius : " + radius);
		this.radius = radius;
	}

	public Wheel(int radius) {
		super();
		this.radius = radius;
	}
	
	
}

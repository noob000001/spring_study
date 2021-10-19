package test01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

	//@Autowired : Ÿ���� �������� ���� ã�Ƽ� ������ ����
	//				�ش� Ÿ���� ���� 2�� �̻��� ��� ���� id�� �������� �������� ������ ����
	
	@Autowired
	@Qualifier(value="wheel2")
	private Wheel wheel;
	
	public Car() {
		
	}
	//@Autowired
	public Car(Wheel wheel) {
		super();
		this.wheel = wheel;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	@Override
	public String toString() {
		return "Car [wheel=" + wheel + "]";
	}
	
}

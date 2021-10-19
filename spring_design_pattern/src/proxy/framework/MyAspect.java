package proxy.framework;

import java.lang.reflect.InvocationTargetException;

public class MyAspect implements Developer{
	
	private Developer developer;
	
	//�ڹ� Reflection : ��ü �Ǵ� Ŭ�������� ���� Ÿ�Կ� ���� ������ ������ �� �ִ� ���
	
	public MyAspect(String className) {
		try {
			developer = (Developer) Class.forName(className).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void develop() {
		System.out.println("��� ī�带 ��´�.");
		
		try {
			developer.develop();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���� ���̾���.");
		}finally {
			System.out.println("���� ����.");
		}
	}

}

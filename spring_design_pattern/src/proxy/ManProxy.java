package proxy;

import proxy.client.Man;

public class ManProxy {
	
	public void develop() {
	
		System.out.println("���ī�带 ��´�.");
	
	try {
		new Man().develop();
	} catch (Exception e) {
		System.out.println("���� ���̾���.");
	
	}finally {
		System.out.println("���� ����.");
	}
}
}

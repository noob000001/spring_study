package proxy;

import proxy.client.Woman;

public class WomanProxy {

	public void develop() {
		
		System.out.println("���ī�带 ��´�.");
		try {
			new Woman().develop();
		} catch (Exception e) {
			System.out.println("���� ���̾���.");
		}finally {
			System.out.println("���� ����.");
		}
		
		
	}
	
}

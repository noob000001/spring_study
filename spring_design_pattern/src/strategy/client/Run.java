package strategy.client;

import strategy.framework.MemberDao;

public class Run {
	
	public static void main(String[] args) {
	
		String password = new MemberDao().selectPassword("DEV", new ConnectionFactory());
		System.out.println("��й�ȣ�� " + password + "�Դϴ�.");
	}
}

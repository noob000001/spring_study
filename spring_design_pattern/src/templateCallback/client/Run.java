package templateCallback.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import strategy.framework.ConnectionMaker;
import strategy.framework.MemberDao;

public class Run {
	
	//�ڹ� ����
	//Functional Interface : �߻�޼��尡 �ϳ��� �����ϴ� �������̽�
	//						 �������̽� ���� @FunctionalInterface ������̼��� �ۼ�
	//Functional Interface�� �߻�޼���� ȭ��ǥ�Լ� ���·� �������̵尡 ����
	
	// * �ڹ��� ȭ��ǥ�Լ��� �Ű������� Ÿ���� ���� ����
	// * ȭ��ǥ �Լ��� �޼��� body block�� ������ ���, ; �� ����
	// * �Ű������� �ϳ��� �ִ� ��� () ���� ����
	// * return�� �ۿ� ���� ���, �޼��� body block�� return ����
	// * �޼��� ������ 1���� ��� �޼��� body block�� ����
	
	
	
	public static void main(String[] args) {
	
		String password = new MemberDao().selectPassword("DEV", () -> {
			Connection conn = null;
				try {
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bm", "1234");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return conn;
			}
		);
		
		System.out.println("��й�ȣ�� " + password + " �Դϴ�.");
	}
}

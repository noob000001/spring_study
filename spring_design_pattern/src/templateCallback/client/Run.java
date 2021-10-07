package templateCallback.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import strategy.framework.ConnectionMaker;
import strategy.framework.MemberDao;

public class Run {
	
	public static void main(String[] args) {
	
		String password = new MemberDao().selectPassword("DEV", new ConnectionMaker() {
			
			@Override
			public Connection getConnection() {
				Connection conn = null;
				
				try {
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bm", "1234");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return conn;
			}
		});
		
		System.out.println("��й�ȣ�� " + password + " �Դϴ�.");
	}
}

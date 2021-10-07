package factory.client;

import factory.framework.ConnectorFactory;
import factory.framework.SMTPConnector;

public class Run {

	public static void main(String[] args) {
		
		//���̹� SMTP������ ������ �غ���
		try {
			SMTPConnector conn = ConnectorFactory.builder()
					.url("smtp.daum.net")
					.id("azimemory@naver.com")
					.password("123456")
					.build()
					.getConnector();
			conn.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		

	}
}

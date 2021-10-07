package factory.framework;

import java.util.Date;

public class ConnectorFactory {
	
	private String url;
	private String id;
	private String password;
	private Date connectTime;
	
	public ConnectorFactory(ConnectorFactoryBuilder builder) {
		this.url = builder.url;
		this.id = builder.id;
		this.password = builder.password;
		this.connectTime = new Date();
	}
	
	public static ConnectorFactoryBuilder builder() {
		return new ConnectorFactoryBuilder();
	}
	
	public static class ConnectorFactoryBuilder{
		private String url;
		private String id;
		private String password;
		
		public ConnectorFactoryBuilder url(String url) {
			this.url = url;
			return this;
		}
		
		public ConnectorFactoryBuilder id(String id) {
			this.id = id;
			return this;
		}
		
		public ConnectorFactoryBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public ConnectorFactory build() {
			return new ConnectorFactory(this);
		}
	}
	
	
	
	public SMTPConnector getConnector() throws Exception {
		
		if(url.equalsIgnoreCase("smtp.naver.com")) {
			return new NaverMailConnector(url, id, password, connectTime);
		}else if(url.equalsIgnoreCase("smtp.daum.net")){
			return new DaumMailConnector(url, id, password, connectTime);
		}else if(url.equalsIgnoreCase("smtp.google.com")) {
			return new GoogleMailConnector(url, id, password, connectTime);
		}else {
			throw new Exception("�߸��� smtp host�� �Է��Ͽ����ϴ�.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package com.kh.spring.common.code;

public enum ErrorCode {

	DATABASE_ACCESS_ERROR("�����ͺ��̽��� ��� �� ������ �߻��Ͽ����ϴ�."),
	VALIDATOR_FAIL_ERROR("�������� ����� �������Դϴ�."),
	MAIL_SEND_FAIL_ERROR("�̸��� �߼� �� ������ �߻��߽��ϴ�."),
	HTTP_CONNECT_ERROR("HTTP ��� �� ������ �߻��Ͽ����ϴ�."),
	AUTHENTICATION_FAILED_ERROR("��ȿ���� ���� �����Դϴ�."),
	UNAUTHORIZED_PAGE_ERROR("���� ������ ���� ������ �Դϴ�."),
	FAILED_FILE_UPLOAD_ERROR("���Ͼ��ε忡 �����Ͽ����ϴ�."),
	REDIRECT("");
	
	public final String MESSAGE;
	public String URL;
	
	private ErrorCode(String msg) {
		this.MESSAGE = msg;
		this.URL = "/";
		
	}

	private ErrorCode(String msg, String url) {
		this.MESSAGE = msg;
		this.URL = url;
		
	}

	public ErrorCode setURL(String uRL) {
		this.URL = uRL;
		return this;
	}

	
}

package com.kh.spring.common.code;


//enum(enumerated type) : ������
//���� ������ ������� ����.
//���� ������ ������� �ϳ��� �������� �ٷ�� ���� enum���� ������ ���İ� �޼��� ����
public enum MemberGrade {

	
	//ȸ������ڵ� ME00�� info�� '�Ϲ�'�̰� ���尡��Ƚ���� 1ȸ
	//enum�� ���������� class�̴�.
	//ME00("�Ϲ�",1) -> public static final MemberGrade ME00 = new MemberGrade("�Ϲ�",1);
	ME00("�Ϲ�","user",1),
	ME01("����","user",2),
	ME02("���","user",3),
	ME03("VIP","user",4),
	
	AD00("super", "admin",9999),//���۰�����
	AD01("member","admin",9999),//ȸ�� ������ ����ڵ�
	AD02("board","admin",9999);//�Խ��� ������ ����ڵ�
	
	public final String DESC;
	public final String ROLE;
	public final int EXTENDABLE_CNT;
	
	private MemberGrade(String desc, String role, int extendableCnt) {
		this.DESC = desc;
		this.ROLE = role;
		this.EXTENDABLE_CNT = extendableCnt;
		
	}
	
}

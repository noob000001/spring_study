package com.kh.spring.member.model.dto;

import java.sql.Date;

import lombok.Data;

//DTO(DATA TRANSFER OBJECT)
//������ ���� ��ü
//�����ͺ��̽��κ��� ��� �� �����͸� service(�����Ͻ�����)���� ���� �� ����� ��ü
//�����Ͻ� ������ �����ϰ� ���� ����, �����ϰ� ������ ���۸��� ���� ��ü
//getter/setter, equals, hashCode, toString �޼��常�� ���´�.

// *** ���� 
//   ������ ��ü : �����ͺ��̽� ���̺��� ��ȸ �ؿ� �� ��(row)�� ���� �����ϴ� �뵵�� ����ϴ� ��ü
//   DOMAIN OBJECT, VALUE OBJECT(VO), DTO, ENTITY, BEAN

//DTO�� ���� (JAVA BEAN �Ծ�)
//1. ��� �ʵ庯���� PRIVATE�� ��
//2. �ݵ�� �⺻ �����ڰ� ������ ��. (�Ű������� �ִ� �����ڰ� �ִ���, �⺻ �����ڰ� �־����)
//3. ��� �ʵ庯���� GETTER/SETTER �޼��带 ������ �Ѵ�.

//����Ŭ - �ڹ� Ÿ�� ����
//CHAR, VARCHAR2 -> String
//DATE -> java.util.Date, java.sql.Date
//number -> int, double
@Data
public class Member {   
   
   private String userId;
   private String password;
   private String email;
   private String grade;
   private String tell;
   private Date rentableDate;
   private Date regDate;
   private int isLeave;
   
  
   
   
}
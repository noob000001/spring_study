package com.kh.spring.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring.member.model.dto.Member;

//�������� ��������� web.xml�� ����� �׽�Ʈȯ���� ����
@WebAppConfiguration
//Junit�� ������ ���
//�׽�Ʈ �� ����� ������ applicationContext�� �����ϰ� ����
@RunWith(SpringJUnit4ClassRunner.class)
//������ applicationContext�� ������ �� ����� spring bean ���������� ��ġ�� ����
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MybatisTest {

   @Autowired
   private MybatisRepository mybatisRepository;
   private String userId = "DEV";
   
   @Test
   public void selectOneTest() {
      mybatisRepository.selectPasswordByUserId(userId);
      //session.selectOne(NAMESPACE + "selectPasswordByUserId", userId);
   }
   
   @Test
   public void selectOneAsDto() {
      Member member = mybatisRepository.selectMemberByUserId(userId);
      //Member member = session.selectOne(NAMESPACE+"selectMemberByUserId", userId);
      
   }
   
   @Test
   public void selectListAsMap() {
      List<Map<String,Object>> res = mybatisRepository.selectRentAndMemberByUserId(userId);
   }
   
   @Test
   public void selectListUsingResultMap() {
      List<Map<String,Object>> res = mybatisRepository.selectRentBookByUserId(userId);
   }
   
   @Test
   public void insertWithDto() {
      Member member = new Member();
      member.setUserId("mybatis");
      member.setPassword("abcdefg");
      member.setEmail("pclass@kh.com");
      member.setTell("010-0000-1111");
      
      //session.insert(NAMESPACE+"insertWithDto", member);
   }
   
   @Test
   public void insertWithMap() {
      Member member = new Member();
      member.setUserId("spring-easy");
      
      Map<String,Object> commandMap = new HashMap<String, Object>();
      commandMap.put("member", member);
      commandMap.put("title", "���ǰ� �ϰ� ��Ű��");
      commandMap.put("rentBookCnt", 1);
      
      //session.insert(NAMESPACE + "insertWithMap", commandMap);
   }
   
   @Test
   public void delete() {
      //session.delete(NAMESPACE+"delete","spring-easy");
   }
   
   //session.update
   //����� ���̵� DEV�� ȸ���� ã�� ��й�ȣ�� ppppp�� �����Ͻÿ�
   @Test
   public void update() {
      Member member = new Member();
      member.setUserId("DEV");
      member.setPassword("ppppp");
      //session.update(NAMESPACE + "update",member);
   }
   
   @Test
   public void procedure() {
      
      //session.update(NAMESPACE + "procedure","100001");
   }
   
   //mybatis mapper escape ó��
   //<![CDATA[ escapeó���� ���� ]]>
   //�񱳿����� escape
   // &lt;  &gt;
   
    //1. ������ : ��Ű�� ����, 
   //    �۰�   : �迵��
   //    ������ȣ : ������ ���
   //   �� ������ BOOK ���̺� �����ϱ�
   //   �޼��� �̸� : test01
   @Test
   public void test01() {
      //session.insert(NAMESPACE + "test01", Map.of("title", "��Ű�� ����","author","�迵��"));
   }
   
   //2. ����Ƚ���� 2ȸ �̻��� ��� ���⵵�� ������
   //    ����Ƚ�� 0ȸ�� �ʱ�ȭ ���ּ���.
   //  �޼��� �̸� : test02
   @Test
   public void test02() {
      //session.update(NAMESPACE+"test02");
   }
   
   //3. 2021�� 9�� ���� 10�� ������ ���Ե� ȸ�������� ����
   //  �޼��� �̸� : test03
   @Test
   public void test03() {
      //session.delete(NAMESPACE+ "test03");
   }
   
   //4. ���� Ƚ���� ���� ���� 3���� ������ ��ȸ
   //  �޼��� �̸� : test04
   @Test
   public void test04() {
      //session.selectList(NAMESPACE + "test04");
   }
   
   @Test
   public void dynamicIf() {
      //����ڰ� ���� �˻����Ϳ� info �� �����ϰ� �˻��ϸ�, ����ڰ� �Է��� Ű���尡 info�� ���Ե� ���� �˻�
      //����ڰ� ���� �˻����Ϳ� author�� �����ϰ� �˻��ϸ�, ����ڰ� �Է��� Ű���尡 author�� ���Ե� ���� �˻�
      //����ڰ� ������ ���� : info
      //����ڰ� �Է��� Ű����� : ��ֶ�
      //session.selectList(NAMESPACE + "dynamicIf",Map.of("filter", "author","keyword","��ֶ�"));
   }
   
   @Test
   public void dynamicChoose() {
      //����ڰ� ���� �˻����Ϳ� info �� �����ϰ� �˻��ϸ�, ����ڰ� �Է��� Ű���尡 info�� ���Ե� ���� �˻�
      //����ڰ� ���� �˻����Ϳ� author�� �����ϰ� �˻��ϸ�, ����ڰ� �Է��� Ű���尡 author�� ���Ե� ���� �˻�
      //����ڰ� ������ ���͸� �������� ���� ��� �������� �˻�
      //����ڰ� ������ ���� : info
      //����ڰ� �Է��� Ű����� : ��ֶ�
      //session.selectList(NAMESPACE+"dynamicChoose", Map.of("keyword","���"));
   }
   
   @Test
   public void dynamicForeachAndWhereTag() {
      //����ڰ� �˻������� ������ ������ ���
      //�ش� ���ǵ��� or�����Ͽ� �˻��Ǵ� ������ ��ȯ
      //����ڰ�, ����, ����, �۰� �˻������� �����ϰ�
      //Ű���忡 '��ֶ�' �� �Է��� ��� ����, �۰�, ���� �߿��� �ϳ��� ��ֶ��� ��ȸ�Ǹ� �ش� ���� ��ȯ
      String[] filters = {"author","info"};
      //session.selectList(NAMESPACE+"dynamicForeachAndWhereTag", Map.of("filters",filters,"keyword","��ֶ�"));
   }
   
   @Test
   public void test05() {
      //����ڰ� �˻������� ������ ������ ���
      //�ش� ���ǵ��� and �����Ͽ� �˻��Ǵ� ������ ��ȯ
      //����ڰ�, ����, ����, �۰� �˻������� �����ϰ�
      //Ű���忡 '��ֶ�' �� �Է��� ��� ����, �۰�, ���� �߿��� �ϳ��� ��ֶ��� ��ȸ�Ǹ� �ش� ���� ��ȯ
      String[] filters = {"author","info"};
      //session.selectList(NAMESPACE+"test05", Map.of("filters",filters,"keyword","��ֶ�"));
   }
   
   @Test
   public void dynamicForeachWithList() {
      //����ڰ� ������ ������ �߿��� DB�� �����ϴ� ������ ��� ��ȯ
      //session.selectList(NAMESPACE + "dynamicForeachWithList",List.of("�����","���ѻ꼺","��¡�����"));
   }
   
   @Test
   public void insertTemplate() {
      //����ڷκ��� �����͸� �Է���
      //���̺��, �÷���, ���� ���޹޾� �ش� ���̺� ����ڰ� ���ϴ� �����͸� �Է��ϴ� ����
      //session.insert(NAMESPACE+"insertTemplate"
      //            ,Map.of("tableName","book"
      //                     ,"sec",Map.of("colName","bk_idx","val","sc_bk_idx.nextval")
      //                     ,"data",Map.of("title","������ �������� ����","author","�ֹ���")
      //                     )
      //            );
   }
   
   @Test
   public void dynamicSet() {
      Member member = new Member();
      member.setUserId("DEV");
      member.setEmail("AAAA@AAA.com");
      member.setTell("010-2222-3333");
      //session.update(NAMESPACE + "dynamicSet",member);
   }
   
   
   @Test
   public void procedureUseTypeHandler() {
      //session.insert(NAMESPACE+"procedureUseTypeHandler",
      //      Map.of("userId","DEV","title","Ÿ���ڵ鷯�� ���̹�Ƽ��","rentBookCnt",2
      //            ,"bkIdxs",List.of("100001","100002")));
   }
   
   
   
   
   
   
   
   
   

}
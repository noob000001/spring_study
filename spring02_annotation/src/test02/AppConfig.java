package test02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
//@Configuration
//Spring bean ���������� ����ϴ� bean ����� �ڹ��� Ŭ�������� �� �� �ְԲ� ���ִ� ������̼�
//@Bean : @Bean ������̼��� ����Ǿ��ִ� �޼��尡 return�ϴ� ��ü�� bean���� ���
public class AppConfig {

	
	//@Bean : �޼������ bean�� id�� �ؼ� applicationContext�� ���
	@Bean
	public Book book() {
		return new Book("�ظ�����","�Ѹ�",80000);
	}
	
}

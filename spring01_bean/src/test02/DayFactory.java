package test02;

import java.time.DayOfWeek;
import java.util.Calendar;

public class DayFactory {

	//ApplicationContext�� bean�� ����ϱ� ���� ����ϴ� Factory method, static�̾�� ��

	public static Week getInstance() {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		switch (day) {
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Wendsday();
		case 5: return new Thursday();
		case 6: return new Friday();
		case 7: return new Saturday();
		default: throw new RuntimeException("Calendar�� �߸��� ���� ��ȯ��...");
		}
	}
	
}

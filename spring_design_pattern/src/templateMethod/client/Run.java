package templateMethod.client;

public class Run {

	public static void main(String[] args) {
		
		String userId = "DEV";
		String password = new MemberDao().selectPassword(userId);
		System.out.println(userId + " ������� ��й�ȣ�� " + password + "�Դϴ�.");

	}
}

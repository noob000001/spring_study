package test01;

public class Address {

	private String name;
	private String address;
	private String phone;
	
	public Address() {
		System.out.println("Address�� �⺻ ������ ȣ��");
	}
	
	public Address(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		
		System.out.println("Address�� �Ű������� �ִ� ������ ȣ��");
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("setName ȣ��");
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
		System.out.println("setAeedrss ȣ��");

	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("setPhone ȣ��");

	}
	@Override
	public String toString() {
		return "Address [name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
}

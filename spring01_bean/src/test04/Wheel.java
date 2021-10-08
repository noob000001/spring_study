package test04;

public class Wheel {

	private int radius = 5;
	
	public Wheel() {
		
	}

	@Override
	public String toString() {
		return "Wheel [radius=" + radius + "]";
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Wheel(int radius) {
		super();
		this.radius = radius;
	}
	
	
}

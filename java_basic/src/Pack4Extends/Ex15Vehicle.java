package Pack4Extends;

public class Ex15Vehicle {
	protected String brand;
    protected int speed;
    
    public Ex15Vehicle(String brand, int speed) {
		this.brand = brand;
		this.speed = speed;
	}
    
    public void describe() {
    	System.out.println("This is a vehicle");
    }
}

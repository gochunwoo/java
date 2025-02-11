package Pack4Extends;

public class Ex15Car extends Ex15Vehicle{
	private int fuelCapacity;
	
	public Ex15Car(String brand, int speed, int fuelCapacity) {
		super(brand, speed);
		this.fuelCapacity = fuelCapacity;
	}
	
	@Override
	public void describe() {
		System.out.println("This is a car of brand " + brand + " with a fuel capacity of " + fuelCapacity + " liters");
	}
	
}

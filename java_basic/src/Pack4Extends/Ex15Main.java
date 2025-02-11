package Pack4Extends;

public class Ex15Main {

	public static void main(String[] args) {
		// Car 객체 생성
		Ex15Car car = new Ex15Car("Kia", 100, 50);
		car.describe();
		
		// Bicycle 객체 생성
		Ex15Bicycle bicycle = new Ex15Bicycle("Giant", 35, 21);
		bicycle.describe();
	}

}

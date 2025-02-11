package Pack4Extends;

public class Ex17PolyMain {

	public static void main(String[] args) {
		// ----------------부모클래스 카 객체 생성------------------------
		Ex17PolyCar car1 = new Ex17PolyCar();
		System.out.println();
		car1.dispData();
		System.out.println(car1.getSpeed());
		
		// ---------------자식 클래스 버스 객체--------------------------
		System.out.println("\n뻐스에 대해");
		Ex17PolyBus	bus1 = new Ex17PolyBus();
		
		bus1.dispData();
		System.out.println(bus1.getSpeed());
		System.out.println();
		bus1.show();
		
		// ---------------자식 클래스 택시 객체 -------------------------
		Ex17PolyTaxi taxi1 = new Ex17PolyTaxi();
		System.out.println("\n택시에 대해");
		taxi1.dispData();
		System.out.println(taxi1.getSpeed());
		
		// ------------------------------업 캐스팅-----------------------------------------
		System.out.println("\n======업캐스팅 (버스 → 자동차)=======");
		// 다형성에 대해..
		Ex17PolyCar car2 = new Ex17PolyBus();	// 자식(부모)의 주소 부모에게 치환
		// ***** 자식의 고유 메소드는 호출불가 *****
		car2.dispData(); // 오버라이딩된 뻐스 메서드 호출
		
		System.out.println();
		
		Ex17PolyCar car3 = taxi1;	// 자식(택시)의 주소 부모에게 치환
		car3.dispData(); // 오버라이딩된 택시 메서드 호출
		
		// -------------------------------다운 캐스팅 -------------------------------------
		System.out.println("\n=======다운캐스팅 (부모 → 자식=======)");
		// 부모타입이지만 자식의 주소를 가지므로 다운캐스팅 가능
		// Ex17PolyBus bus2 = new Ex17PolyCar();
		Ex17PolyBus bus2 = (Ex17PolyBus) car2;	// 다운캐스팅 (자동차 → 버스)
		bus2.dispData();
		bus2.show();	// 뻐스만의 고유 메소드이므로 호출 가능
		System.out.println();
		Ex17PolyTaxi taxi2 = (Ex17PolyTaxi) car3; // 다운캐스팅 (자동차 → 택시)
		taxi2.dispData();
	
		// -------------------------배열--------------------------------------------------
		System.out.println("^^^^^배열^^^^^");
		Ex17PolyCar p[] = new Ex17PolyCar[3];	// car 타입의 배열 선언 (1차원배열)
		// 업캐스팅하여 배열에 저장
		p[0] = car1; // 부모객체
		p[1] = bus1; // 버스 객체 (업 캐스팅)
		p[2] = taxi1; // 택시 객체 ( 업 캐스팅)
		
		p[0].dispData(); // 부모 클래스 메서드 실행
		p[1].dispData(); // 버스 클래스 오버라이딩 메소드 실행
		p[2].dispData(); // 택시 클래스 오버라이딩 메소드 실행
				
		System.out.println("\n=== for 문을 이용한 다형성 활용 ===");
		for(int i = 0; i <p.length; i++) {
			p[i].dispData(); // 다형성을 활용하여 모든 객체의 dispData() 실행
		}
		System.out.println("\n=== 향상된 for 문을 이용한 다형성 활용 ===");
		for(Ex17PolyCar car:p) {
			car.dispData(); // 다형성을 활용하여 모든 객체의 dispData() 실행
		}
	}

}

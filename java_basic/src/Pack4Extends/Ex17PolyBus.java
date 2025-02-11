package Pack4Extends;

public class Ex17PolyBus extends Ex17PolyCar{	// car 의 자식인 bus 입니다
	private int passenger = 10;
	
	public Ex17PolyBus() {
		System.out.println("난 Car의 자식인 Bus 생성자입니다");
		
	}
	@Override
	// 재정의
		public void dispData() {
		System.out.println("버스 승객 수 : " + passenger);
		System.out.println("버스 속도는 " + speed);
		}
	public void show() {
		System.out.println("뻐스 고유 메소드 show");
		
	}

}

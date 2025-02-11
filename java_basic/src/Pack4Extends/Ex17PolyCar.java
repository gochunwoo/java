package Pack4Extends;

// parent, super, 부모, 원형 클래스
public class Ex17PolyCar {	// 모든 자동차들이 가져야할 멤버 ( 필드, 메소드 ) 선언 
	protected int speed = 100;	// protected 퍼블릭과 디폴드 사이에 있는게 프로텍티드
	
	public Ex17PolyCar() {
		System.out.println("나는 자동차 원형 클래스야");
	}
	
	public void dispData() {
		System.out.println("속도 : " + speed);
		
	}
	
	public int getSpeed() {
		return speed;
	}
	
	
	
}

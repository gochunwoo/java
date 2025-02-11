package pack2;

// 클래스 형식 : [접근지정자] Class 클래스명/ 첫글짜 대문자 / 파일명도 같아야된다
public class Ex1Car { // Car 객체(Object)를 생산하기 위한 설계도 : 클래스
	// 새로운 타입 (type, 형) 을 만들기 위한
	// field(필드, 속성)과 method(행위)를 멤버로 가질수 있다.
	// 동일한 field 와 method를 수행하는 객체의 집합을 설계

	int Wheel;		// 멤버 필드 , 형식은 [접근지정자] type 필드명
	private int airBag = 1;		//캡슐화 : 멤버 접근지정자가 private인 경우
	private int speed;
	public String irum;

	public Ex1Car() {		// 특별한 메소드(클래스와 메소드명이 일치) ==> 생성자(constructor)
		System.out.println("객체 생성자 가장먼저 수행 : 초기화를 담당 ");
		Wheel = 4;
		irum = "그랜저";
	}
	public void abc() {		//멤버 메소드, 형식은 [접근지정자] 반환형 메소드명(매개변수....)()
		System.out.println("abc 메소드 실행 ");
	}
	void def() { // 메소드 수행후 반환값이 없이 돌아갈 경우는 void //	// 반환값 없이 실행되는 메소드
		System.out.println("def 메소드 실행 ");
		System.out.println("바퀴수는 " + Wheel);
		System.out.println("에어백 수는 " + airBag);		// private 필드이나 현재 클래스내에서 호출가능
		abc();	// private 필드이나 현재 크래스 내에서 호출가능
		
	}
	public String driving() {	// 메소드 수행 후 String 타입의 반환값이 있는 경우는 문자열 반환
		System.out.println("운전하기");
		return "현재 고속도로를 달리는 중";
	}
	public int drivingStop() {
		System.out.println("운전 멈추기");
		return 0;	// return 정수, 0의 의미를 주석으로 설명: 0은 "운전 정지"를나타냄
	}
	// 참고 : 변수의 값을 저장하는 방법은 2가지
	// 1. 변수 = 값	ex: a = 5
	// 2. 매개변수를 이용.	메소드명(타입 매개변수)(...) 하고 메소드명(값)한다
	public void dirvingGood(int w) {	// 매개 변수 (parameter)가 있는 메소드가된다
		Wheel = w;
		System.out.println(Wheel + "개의 바퀴를 가진 이동 수단 사용");
	}
}

// 클래스를 공부하는 이유
// 1. 직접 객체를 생성후 사용하기 위한
// 2. 다른 사람이 만든 클래스를 활용하기 위함
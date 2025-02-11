package pack2;

import java.awt.CardLayout;

public class Ex1Main {		// Ex1main 은 main 메소드를 실행하기 위한 클래스임.

	public static void main(String[] args) {
		// main 은 메소드는 응용 프로그램 시작을 위해 정해진 메소드이다.
		// 다시말해 클래스로부터 객체를 만드는 과정을 클래스의 인스턴스화라고 하며 어떤 클래스로부터
		// 만들어진 객체를 클래스의 인스턴스라고 한다
		// 객체는 모든 인스턴스를 대표하는 포괄적인 의미다
		// 클래스 -- 인스턴스화
		
		// Ex1Car 설계도로 객체를 생성 , 이런 과정을 객체를 인스턴스(instance)화 하고함
		
		// Ex1Car.class를 주 기억장치로 읽은 후 car1 객체변수를 선언.
		// new 키워드로 인스턴스 를 진행 , 이 때 Ex1Car() 이라는 생성자를 호출.
		Ex1Car Car1 = new Ex1Car();		// 이렇게 하면 객체를 만들었음
		
		//Ex1Car 멤버필드(전역변수) 호출----
		System.out.println(Car1.Wheel);		 // 접근지정자가 default 이므로 호출 가능
		//System.out.println(Car1.airBag); 	//private 맴버이므로 호출불가능
		System.out.println(Car1.irum);		
		
		System.out.println();
		// Ex1Car 멤버메소드 호출
		// System.out.println(Car1.abc()); // 메소드이므로 후출불가
		Car1.def();
		
		System.out.println();
		String ss = Car1.driving();
		ss = "와우" + ss;
		System.out.println(ss);
		
		System.out.println(Car1.driving()); // 1회용임
		
		System.out.println();
		Car1.dirvingGood(2);	// 매개변수가 있는 메소드를 호출 객체변수.메소드명(인자,,,) 또는 인자 , 인수, argumet
		
		System.out.println("\n=================");
		Ex1Car Car2 = new Ex1Car();
		// car1 과 car2는 type의 같은 두 개의 객체 변수
		System.out.println(Car2.Wheel);
		Car2.def();
		
		
		
		
		
		
		
	}

}

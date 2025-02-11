package pack2;

public class Ex5BankMain {

	public static void main(String[] args) {
		
		Ex5Bank tom = new Ex5Bank();
		tom.dePosit(5000);
		tom.withDraw(3000);
		System.out.println("tom의 예금은(잔고)" + tom.getMoney());
		
		Ex5Bank oscar = new Ex5Bank(2000);
		oscar.dePosit(1000);
		oscar.withDraw(6000);	// 출금액에 문제가 있네요
		oscar.withDraw(3000);
		System.out.println("oscar의 예금액(잔고)" + oscar.getMoney());
		
		System.out.println("객체의 주소 관련...");
		System.out.println("tom 객체변수의 주소:" + tom + " " + tom.toString() + tom.hashCode());
		System.out.println("tom 객체변수의 주소:" + oscar + " " + oscar.hashCode());
		System.out.println(tom == oscar);	// 두객체변수의 주소가 같은가? false
		
		Ex5Bank james = null;
		System.out.println("james 객체변수의 주소:" + james);
		// System.out.println(james.getMoney()); 주소가 없서서 에러
		james = oscar;	// oscar 주소를 치환. 하나의 객체를 두 개의 객체변수가 참조
		System.out.println("james 객체변수의 주소:" + james);	// oscar의 주소를 james 한테 치환출력
		System.out.println(james.getMoney());
		
		if(james == oscar)
			System.out.println("둘은 같은주소야");
		else
			System.out.println("둘은 같은주소 아니야");
		
		if(james == tom)
			System.out.println("둘은 같은주소야");
		else
			System.out.println("둘은 같은주소 아니야");
		
		if(james instanceof Ex5Bank)	// instanceof : 타입 비교 연산자
			System.out.println("Ex5Bank 타입이군요");
		else
			System.out.println("Ex5Bank 타입이 아니군요");
		
		
	System.out.println("\n스트링 타입(String type) 값 비교에 대해....");
		String ss1 = "kor";		// String 클래스는 클래스이지만 기본형 처럼 사용할 수 있도록 자바가 배려해줌
		String ss2 = new String();
		ss2 = "kor";
		String ss3 = new String("kor");
		System.out.println(ss1 + " " + ss2 + " " + ss3);
		
		if(ss1 == ss2)
			System.out.println("ss1과 ss2는 같음");
		else
			System.out.println("ss1과 ss2는 같지 않음");
		
		if(ss1 == ss3)
			System.out.println("ss1과 ss3는 같음");
		else
			System.out.println("ss1과 ss3는 같지 않음");
		
		if(ss2 == ss3)
			System.out.println("ss2과 ss3는 같음");
		else
			System.out.println("ss2과 ss3는 같지 않음");
		
		// 문자열(String type) 비교는 == 이 아니라 equals() 메소드를 사용
		if(ss1.equals(ss3)) {
			System.out.println("ss1과 ss3는 같음");
		}
		else {
			System.out.println("ss1과 ss2는 같지 않음");
		}
		
		if(ss2.equals(ss3)) {
			System.out.println("ss2과 ss3는 같음");
		}
		else {
			System.out.println("ss2과 ss2는 같지 않음");
		}
		
		
		System.out.println("\n배열도 객체(참조형)");
		int ar[] = new int[3];
		ar[0] = 10;
		System.out.println(ar[0] + " " + ar);
		
		int ar2[] = {1,2,3,4};
		System.out.println(ar2[0] + " " + ar2);
		
		
		System.out.println("휴 주소 얘기 그만! 이제는 접근지정자에 대해...");
		// 같은 현재 클래스와 Ex5Bank 클래스는 같은 package 에 있다.
		Ex5Bank bank1 = new Ex5Bank();
		// System.out.println(bank1.money()); // private 멤버 접근 불가
		System.out.println(bank1.imsi);		// default 수준 이므로 멤버점근이 가능
		System.out.println(bank1.imsi2);	// public 수준 이므로 멤버 접근 가능
		
		
		
		
		
		
		
		
		
		
		
	}

}

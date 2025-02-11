package Pack4Extends;

public class Ex16DoogMain {

	public static void main(String[] args) {
		// Ex16Dog 객체 생성
	Ex16Dog dog = new Ex16Dog("개");
	dog.print();
	System.out.println(dog.callName());
	
	System.out.println();
	// Ex16HousDog 객체 생성
	Ex16HousDog houseDog = new Ex16HousDog("집개");
	houseDog.print();
	System.out.println(houseDog.callName());
	houseDog.show();	// Ex16HousDog 만의 고유 메소드
	
	System.out.println();
	// Ex16WolfDog 객체 생성
	Ex16WolfDog wolfDog = new Ex16WolfDog("늑대");
	wolfDog.print();
	System.out.println(wolfDog.callName());
	wolfDog.show();	// Ex16WolfDog 만의 고유 메소드
	
	System.out.println("--------------");
	// 같은 타입의 객체 변수 치환 (정상 작동)
	Ex16WolfDog bushdog = wolfDog;	//  의 주소를 치환(타입이 같은 경우 치환성공)
	wolfDog.print();	
	bushdog.print();	
	
	// 업 캐스팅 ( 자식 >> 부모)
	Ex16Dog dog2 = wolfDog;	// wolfDog 의 주소를 치환 
							// (타입이 다른데도 불구하고 치환성공 - 자식의 주소를 부모 객체변수에 주는 경우)
	
	dog2.print();		// 오버라이딩환 메소드만 부모 개체변수명으로 호출 가능
	// dog2.show();		// 자식이 가진 고유 메소드는 부모 객체변수명으로 호출할 수 없다.
	// Ex16WolfDog hidog = dog2;	// 타입리스매치	// 오버라이딩환 메소드만 부모 개체변수명으로 호출 가능
	
	// 다운캐스팅 ( 부모 >> 자식 )
	Ex16WolfDog hidog = (Ex16WolfDog)dog2;	//casting 캐스팅 	
	hidog.print(); // 정상작동
	
	System.out.println("-----------------");
	
	// 부모 클래스 Ex16Dog 객체 생성
	Ex16Dog coyote = new Ex16Dog("코요테");	// 부모 클래스
	coyote.print();
	System.out.println(coyote.callName());
	

	Ex16WolfDog wolfDog2 = new Ex16WolfDog("늑대2"); // Dog의 클래스
	wolfDog2.print();
	wolfDog2.print();
	wolfDog2.show();
	
	coyote = wolfDog2;	// 프로모션)promotion : 자식 객체 주소를 부모 객체변수에 치환
	coyote.print(); 	// 오버라이딩된 메소드는 허용
	// coyote.show();	// 자식 고유 메소드는 호출 불가
	coyote.getName();	// 
	Ex16WolfDog wolfDog3 = null;
	// wolfDog3.show();		//  java.lang.NullPointerException
	wolfDog2 = wolfDog3;	// 타입이 같아서 가능
	// wolfDog3 = houseDog;	// 타입이 달라서 불가능
	// wolfDog3 = coyote;	// 타입이 다르므로 실패. 하지만 부모 타입인 coyote 벼수는 자식의 주소를 기억중.
	wolfDog3 = (Ex16WolfDog)coyote;	//그러므로 casting 을 통해 치환할 수 있다. 
	wolfDog3.print();
	}
	
	

}

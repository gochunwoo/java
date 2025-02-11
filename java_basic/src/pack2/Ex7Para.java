package pack2;

// 매개변수로 기본형 뿐만 아니라 참조형도 가능

class Person{	// 일반적으로 따로이 파일을 작성해야 하지만 편의상 현재 클래스와 같은 곳에 작성함
	//필드 생성
	String name;
	int age;
	
	// 파라미터 매개변수
	public Person(String name, int age) {	// String name: 참조형	int age:기본형
		this.age = age;		// this를 사용하는 이유는 매개변수와 인스턴스랑 이름이 같아서 구분을 하기위해 사용
		this.name = name;	// 변수 이름이 동일할 때 this를 사용하여 인스턴스 변수를 명시적으로 참조
		
	}
}


class PersinServicd {
	public PersinServicd() {
		
	}							// 참조형			  참조형
	public void changeName(Person person, String newName) {
		System.out.println("person 변수 기억 주소 : " + person);
		person.name = newName;
	}
}


//질문할거 메인폴더 하나에 2개의 클래스를 호출 한건가?
public class Ex7Para {	 // 메인 클래스: 프로그램 실행의 시작점
	
	public static void main(String[] args) {  // 1. Person 클래스의 인스턴스 생성
		Person tom = new Person("한국인", 22);	// Person 객체 생성 및 초기화
		System.out.println("변경 전 이름 : " + tom.name + " " + tom);	// 필드 출력
		System.out.println("rom 변수 기억 주소 : " + tom);	// 객체의 메모리 주소 출력
		
		// 2. Person 클래스의 인스턴스 참조 전달
		Person james;
		james = tom;
		System.out.println("james 변수 기억 주소 : " + james);
		
		Person per = tom;	// 또 다른 참조 변수 per 도 같은 객체를 참조
		System.out.println("per 변수 기억 주소 : " + per);
		
		// 3. PersinServicd 클래스의 인스턴스 생성 및 메서드 호출
		PersinServicd servicd = new PersinServicd();
		servicd.changeName(tom, "신나는");	//Person 객체(tom)를 매개변수로 전달하여 이름 변경
		System.out.println("변경 후 이름 : " + tom.name);	// tom 의 name 필드가 변경됨
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

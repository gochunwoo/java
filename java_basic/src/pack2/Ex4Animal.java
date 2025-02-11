package pack2;

// 메소드 오버로딩 (method overloading)
// 클래스 내에 동일 이름의 메소드를 복수로 만듬

public class Ex4Animal {	// 동물이 가져야할 속성(field) 과 행위(method)를 클래스로 설계
	//필드 생성
	private int leg = 4;
	private int age;
	private String name;
	public final static int MIUTH = 1;		// final 은 마지막값 & 대문자
	
	// 생성자
	// 내용이 없는 생성자는 안 적으면 컴파일러가 자동으로 만들어 줌
	public Ex4Animal() {
		System.out.println("내용이 없는 생성자");

	}
	// 생성자 오버로딩	정수1개받음
	public Ex4Animal(int leg) {
		this.leg = leg;
		System.out.println("정수 1개를 받는 생성자");
		
	}
	// 생성자 오버로딩	정수1개 문열1개
	public Ex4Animal(String name,int leg) {
		this.name = name;
		this.leg = leg;
		System.out.println("2개의 매개변수가 있는 생성자");
		
	
	}
	public Ex4Animal(String name,int leg, int age) {
		this.name = name;
		this.leg = leg;
		this.age = age;
		System.out.println("3개의 매개변수가 있는 생성자");
		
		
		
	}
	
	
	// 메소드
	public void display() {
		System.out.println("lag : " + leg + ", age : " + age +", name : " + name);
		
	}

	// 메소드 오버로딩 성립 조건
	// 매개변수의 갯수 , 순서 , 타입이 다르면 됨
	// 결론 : 매개변수의 이름으로 보면안됨 오로지 타입으로 봐야 성립이됨
	public void display(int age) {	// 메소드 오버로딩
		this.age = age;
		System.out.println("lag : " + leg + ", age : " + age +", name : " + name);
	}
	// 메소드 오버로딩 매개변수의 갯수 순서 타입이 달라서 조건 성립
	public void display(String name) {	// 메소드 오버로딩
		System.out.println("lag : " + leg + ", age : " + age +", name : " + name);
		
	}
	public void display(int age , String name) {	// 메소드 오버로딩
		System.out.println("lag : " + leg + ", age : " + age +", name : " + name);
		
		
	}
	public void display(String name , int age  ) {	// 메소드 오버로딩
		System.out.println("lag : " + leg + ", age : " + age +", name : " + name);
		
		
	}
//	 오버로딩안되는경우 타입으로 안보고 매개변수의 이름으로 봐서 오버로딩이안됨
//	public void display(int leg) {	// 메소드 오버로딩 안됨
//		System.out.println("lag : " + leg + ", age : " + age +", name : " + name);
//	}
//	public void display(String name) {	// 메소드 오버로딩 안됨
//		System.out.println("lag : " + leg + ", age : " + age +", name : " + name);
//		
//		
//	}
//	public int display(int leg) {	// 위에서 int age 가 있어서 안됨
//		System.out.println("lag : " + leg + ", age : " + age +", name : " + name);
//	}
	
	
	
}

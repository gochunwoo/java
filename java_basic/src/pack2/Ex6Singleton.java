package pack2;
// 싱글턴이란?
// 객체의 인스턴스가 오직 1개만 생성되는 패턴을 의미
// 메모리절역 , 데이터 공유가 편리

public class Ex6Singleton {
	int kor = 100;
	String name = "tom";
	
	public Ex6Singleton() {
		System.out.println("Ex6Singleton 생성자");
		
	}
	public void kbs() {
	
	}
	// 싱글톤 디자인 패턴
	// 객체가 중복 생성되지 않고, 하나의 인스턴스만 사용되도록 하기 위해 설계된 패턴입니다.
	private static Ex6Singleton singleton = new Ex6Singleton();
	// 스택 메소드는 스택으로 불러올수만 있다.
	
	// 외부에서 인스턴스를 얻을수 있는 메서드 제공
	public static Ex6Singleton getInstance() {
		return singleton;
	}
	
}

package Pack4Extends;

//전자 제품 관련 부모 클래스 abstract(추상)
abstract public class Ex18Jepum { // 전자 제품이 공통으로 가져야할 멤버 선언
	public int volume = 0;
	
	public Ex18Jepum() {
		System.out.println("Jepum 추상 클래스 생성자");
		
	}
	// 추상 메소드 : 자식 클래스가 반드시 구현해야 하는 메소드
	abstract public void volumeControl(); // 추상메소드 { body 가 없음 } 
	
	public void volumeShow() {
		System.err.println("소리 크기 : " + volume);
	}
	
}

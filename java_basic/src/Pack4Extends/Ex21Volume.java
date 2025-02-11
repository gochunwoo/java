package Pack4Extends;

/*
abstract public class Ex21Volume {
	abstract public void volumeUp(int level);
	abstract public void volumeDown(int level);
}
*/

public interface Ex21Volume {  // 인터페이스 : 추상 클래스의 다른 형태
	void volumeUp(int level);
	void volumeDown(int level);
	
	//public void print() {   // 일반 메소드 사용 불가
	//	System.out.println("일반 메소드");
	//}
}
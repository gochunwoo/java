package Pack4Extends;

public class Ex18HandPhone extends Ex18Jepum{
	
@Override
	// 부모의 추상메소드 오버라이딩
	public void volumeControl() {
		System.out.println("핸드폰 제품의 볼륨 변경");
	
	
	}
@Override
	public void volumeShow() {
		// 부모의 일반 메소드로 오버라이딩 선택적이다
		volume = 10;
		System.out.println("볼륨 크기 : " + volume);
	}
}

package Pack4Extends;

public class Ex21Tv implements Ex21Volume{  // 인터페이스는 implements 예약어로 상속을 정의
	private int volLevel;
	
	public Ex21Tv() {
		volLevel = 0;
	}
	
	@Override
	public void volumeUp(int level) {
		volLevel += level;
		System.out.println("Tv 소리 올리면 " + volLevel);
	}
	
	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		System.out.println("Tv 소리 내리면 " + volLevel);
	}
}

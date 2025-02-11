package Pack4Extends;

public class Ex12Father extends Ex12Grandfa {
	
	private final int nai = 50;
	public String gabo = "청자 비슷한 물병";
	private int house = 1;
	
	public Ex12Father() {
		super();	// 부모생성자
		System.out.println("아버지 생성자");
	}
	
	@Override		// 언어테이션-annotation (뭔가를 처리하는 기능)
	// 부모클래스와 주소가 같음
	public int getNai() {
		// 메소드 오버라이딩 : 부모와 똑같은 메소드를 자식에서 만듦.
		//내용은 다르게 적겠지~~같을수도 있다.
		//상속 관계에 있는 상태에서 부모 클래스의 메서드를 호출한 것입니다.
		int imsi = 0;	// 부모와 다른 코드를 적을 수 있다. 재정의.
		return nai;	
	}
	@Override
	public  void say() { // 부모 메서드 가져옴
		String ss = "아버지 말씀 : 풀스택개발자로 ㄱ";
		System.out.println(ss);
	}
	@Override
	public void eat() {
		String aa = "밥은 맛있게...";
		System.out.println(aa);
	}
	
	public int getHouse() {	// 현재클래스의 메소드 
		return house;
	}
	public void showData() { // 현 클래스의 메소드
		String gabo = "맥북";
		System.out.println(gabo);	// 현클래스.부모 둘다찾음
		System.out.println(this.gabo);	// 현클래스 맴버
		System.out.println(super.gabo); // 첨부터 부모
		
		say();
		this.say();
		super.say();
		
	}

}

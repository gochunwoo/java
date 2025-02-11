package Pack4Extends;

abstract public class Ex20Employee {
	private String irum;
	private int nai;
	
	// 생성자 : 이름과 나이 초기화
	public Ex20Employee(String irum, int nai) {
		this.irum = irum;
		this.nai = nai;
	}
	
	// 급여 계산하는 추상 메소드(자식 클래스에서 구현해야 함)
	abstract public double pay();
	
	// 직원 정보 출력하는 추상 메소드 (자식 클래스에서 구현해야 함)
	abstract public void print();
	
	// 기본적인 직원 정보 출력
	public void display() {
		System.out.print("이름:" + irum + ", 나이:" + nai);
	}
}

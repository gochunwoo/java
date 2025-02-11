package pack2;


// 숫자의 제곱을 출력하는 메소드 오버로딩
// 정수를 매개변수로 받는 메소드
// ㅅ리수를 매개변수로 받ㄴ
public class Ex4Exam1 { 
	
	// 필드
	

	// 생성자
	public Ex4Exam1( ) {
		
	}
	
	
	// 정수 제곱용
	public int square(int num) {
		return num * num;
		
		
	}
	public double square(double num) {
		return num * num;
	}
	
	///////////////////	객체 생성	///////////////////////////////
	public static void main(String[] args) {
		
		Ex4Exam1 exam1 = new Ex4Exam1();
		int resturn1 = exam1.square(5);
		System.out.println("resturn : " + resturn1);
		
		
		System.out.println();
		double resturn2 = exam1.square(3.2);
		System.out.println("resturn : " + resturn2);
		

	}

}

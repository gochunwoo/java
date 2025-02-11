package pack2;

public class Ex4Exam2 {
	
	//생성자
	public Ex4Exam2() {
		
	}
	
	public void printAge(String irum, int nai) {
		System.out.println("이름은" + irum + "나이는" + nai);
		
	}
	
	public void printAge(String irum) {
		System.out.println("이름은" + irum+" 나이는알수없습니다");
	}
	
	public void printAge() {
		System.out.println("이름과 나이는 알수없습니다");
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Ex4Exam2 exam2 = new Ex4Exam2();
		exam2.printAge("홍삼");
		exam2.printAge();
		exam2.printAge("홍삼", 5);

	}

}

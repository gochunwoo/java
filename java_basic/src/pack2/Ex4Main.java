package pack2;

public class Ex4Main {

	public static void main(String[] args) {
		// 객체 생성
		Ex4Animal tiger = new Ex4Animal();
		tiger.display();
		tiger.display(3);
		tiger.display("호랑이");
		tiger.display(5,"호랭이");
		tiger.display("호돌이",7);
		
		System.out.println("생성자 오버로딩 연습");
		Ex4Animal dog = new Ex4Animal();
		dog.display();

		Ex4Animal hen = new Ex4Animal(2);
		hen.display();
		System.out.println();
		
		Ex4Animal wolfdog = new Ex4Animal("늑대", 7);
		wolfdog.display();
		System.out.println();
		
		Ex4Animal aa = new Ex4Animal("몰라", 4, 11);
		aa.display();
		
		

	}

}

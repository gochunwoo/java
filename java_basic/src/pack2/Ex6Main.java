package pack2;

import java.net.MulticastSocket;
import java.time.LocalDate;

public class Ex6Main {

	public static void main(String[] args) {
		Ex6Singleton ex1 = new Ex6Singleton();
		Ex6Singleton ex2 = new Ex6Singleton();
		System.out.println(ex1 + " " + ex2);	// 두개의 객체변수(instance) 주소가 다름
		System.out.println(ex1.name + " " + ex2.name);
		ex1.name = "홍길동";
		System.out.println(ex1.name + " " + ex2.name);
		// 객체가 중복 생성되지 않고, 하나의 인스턴스만 사용되도록 하기 위해 설계된 패턴입니다.
		System.out.println("...싱글톤 패턴을 적용...");
		Ex6Singleton my1 = Ex6Singleton.getInstance();
		Ex6Singleton my2 = Ex6Singleton.getInstance();
		System.out.println(my1 + " " + my2);
		my1.name = "한국인";
		System.out.println(my1.name + " " + my2.name);
		System.out.println("===========전문가만든것===========");
		LocalDate localDate1 = LocalDate.now();
		LocalDate localDate2 = LocalDate.now();
		System.out.println(localDate1.hashCode() + " " + localDate2.hashCode());
		System.out.println(localDate1);
		
		
		
		
		
	}

}

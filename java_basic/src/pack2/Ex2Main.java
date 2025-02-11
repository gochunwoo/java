package pack2;

import javax.swing.ProgressMonitor;

import org.w3c.dom.ls.LSProgressEvent;

public class Ex2Main {

	public static void main(String[] args) {
		//  설계도
		Ex2Programmer programmer1 = new Ex2Programmer();
		System.out.println("보유기술 : " + programmer1.spec);
		programmer1.displayData();
		
		programmer1.nickName = "웹전문가";		// public 멤버필드이므로 외부에서 값을 수정
		programmer1.spec = "1종 보통 운전면허";	// default 멤버필드이므로 외부에서 값을 수정
		programmer1.displayData();
		
		// 캡슐화된 멤버를 해당 클래스 밖에서 제어하기 : getter (겟터)
		// programmer1.age;
		int nai = programmer1.getAge();	// 퍼블릭 메소드이므로 접근 가능
		System.err.println("programmer1 객체의 age : " + nai);
		
		programmer1.setAge(33);	// public 메소드 setter 를 이용해 private 필드에 값을전달
		System.out.println("programmer1 객체의 age " + programmer1.getAge());
		programmer1.displayData();
		programmer1.setAgeEx(55, 123);	// .... > 참고로 이런것도 있따 뒤에
		
		System.out.println("static, final 관련---- ");
		System.out.println("motto : " + programmer1.motto);
		System.out.println("motto : " + Ex2Programmer.motto);	// static 멤버는 클래스명, 멤버 형태로 접근
		// programmer1.WEIGHT = 77.8;	// weight 는 final 필드이므로 수정불가
		System.out.println("WEIGHT : " + programmer1.WEIGHT);
		System.out.println("pi : " + Ex2Programmer.pi);
		programmer1.displayData();
		
		
		
		
		System.out.println("\n=======2=======");
		Ex2Programmer programmer2 = new Ex2Programmer();	// 새로운 객체만듬
		programmer2.displayData();
		
		
		
		
		
		System.out.println("\n객체 변수가 참좋나느 주소에 대해(참고)...");
		System.out.println(programmer1 + " " + programmer2);
		// pack2.Ex2Programmer@3d0f8e03 pack2.Ex2Programmer@6366ebe0
		System.out.println(programmer1.toString() + " " + programmer2.toString());
		System.out.println(programmer1.hashCode() + " " + programmer2.hashCode());
		
		
		System.out.println("- -  - 전문가가 만든 클래스 경험 - - -");
		System.out.println(Integer.MAX_VALUE);
		
		
	}
	
}

package pack;

import java.net.MulticastSocket;

public class Test3 {
	public static void main(String[] args) {
		
		// 산술 연산자
		int a = 5;		// (대임연산자)의 기능 : a 변수에 리터럴 5를 기억시킴
		int b = 3;		
		int c = a + b;
		System.out.println(c);
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);		// 몫
		System.out.println(a % b);		// 나머지
		System.out.println(a / (double)b);		// 몫과 나머지
		
		System.out.println();
		//System.out.println(a / 0);	// 0으로못나눔-불능 runtime error(실행오류)
		System.out.println(a / 0.0); 	// Infinity(무한대) 0.0은 완벽한0은아니고 가까운 0
		System.out.println(a % 0.0);	// NAN(not a number) 숫자가 아니라서 숫자로 표현할수 없는 상태
		
		System.out.println("산술 연산자 우선순위" );
		System.out.println(3 + 4 * 5);
		System.out.println((3 + 4) * 5);
		
		System.out.println("문자열 더하기");
		String ss1 = "대한"; //string은 기본형이 아니라 참조형변수임. 사용방법은 기본형 처럼 같다.
		String ss2 = "민국";
		System.out.println(ss1 + ss2); // 이 때는 문자열 더하기
		//System.out.println(ss1 - ss2) 	// -는 없고 +만있다
		System.out.println(ss2 + " " + 2025); 	// 2005 정수는 문자열로 자동 형변환 후 문자열 더하기를 함
		System.out.println(ss2 + " " + 2000 + 25);
		System.out.println(ss2 + " " + (2000 + 25)); // 소괄호를 쳐서 우선순위를 변동
		
		String ss3 = "5" + 6;
		System.out.println("ss3 : " + ss3);
		System.out.println("5" + 6);
		System.out.println(5 + 6);
		System.out.println(Integer.toString(5) + 6);	// ["5" + 6] // Integer.toString 문자열
		System.out.println(Integer.parseInt("5") + 6); 	// Integer.parseInt 문자열을 숫자로봐꿔
		
		System.out.println("누적");
		int no = 1;
		no = no + 1;
		no += 1; // no -=2 , no *=2 , no /=2
		no++;	// 증감 연산자 (후위)	no--;
		++no;	// 증감 연산자 (전위)	
		System.out.println("no : " + no);
		
		System.out.println();
		int imsi = 5;
		int result = ++imsi + 1;
		System.out.println("imsi : " + result);
		System.out.println("result : " + imsi);
		
		int imsi2 = 5;
		int result2 = imsi2++ + 1;
		System.out.println("result2 : " + imsi2);
		System.out.println("imsi2 : " + result2);
		
		System.out.println("부호에 대해");
		int imsi3 = -7;
		System.out.println("imsi3 : " + imsi3);
		System.out.println("imsi3 : " + -imsi3);
		System.out.println("imsi3 : " + (-1 * imsi3));
		int imsi4 = -1* imsi3;
		System.out.println("imsi4 : " + imsi4);
		
		// \n \b \t ... escape 문자
		System.out.println("\n여기까지가 산술연산자" + (char)13 + "밑 기타 \n연습\n\n끝");
		
	}
}

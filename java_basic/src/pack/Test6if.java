package pack;

import java.util.Scanner;

public class Test6if {

	public static void main(String[] args) {
		// 조건 판단문 if
		
		System.out.println("뭔가를 수행 후 if문 만나기");
		int num = 7;

		if(num >= 5) { 					   //참일떄 둘다 실행 거짓일떄 실행안함 대괄호를 침으로 묶음
			System.out.println("크구나");
			System.out.println("진짜로 크네");
		}
		
		System.out.println("계속1");
		
		if(num >= 5) { 	// 조건이 true
			System.out.println("크구나");
			System.out.println("진짜로 크네");
			
		}
		else { //조건이 false
			System.out.println("크지않네");
		}
		
		//다중if
		System.out.println("계속2");
		int jumsu = 70;				// 현재는 70이지만 40만기억하는건 아님
		
		if(jumsu >=70) {	
			if(jumsu >=90) {
				System.out.println("우수");
			}else  {
			System.out.println("보통");
			
			}
		}else {
			if(jumsu >=50) {
				
				System.out.println("저조");
			}else {
				System.out.println("매우 저조");
			}
			
		}
		System.out.println("계속3");
		
		int jumsu2 =40;
		String result = "";
		
		if(jumsu2 >=90) {
			result = "수";
			
		}else if(jumsu2 >=80)	{
				result = "우";
		}else if(jumsu2 >=70)	{
				result = "미";
		}else if(jumsu2 >=60)	{
				result = "양";
		}else {	//if(jumsu2 >=50){
				result = "가";
			}
		System.out.println("평가 결과는 " + result);
		
		
		System.out.println("\n계속4");
		
		int age = 64;
		
		if(8 >= age || age >= 65) {		//8세이하 65세 이상인 경우
			System.out.println("무료");
		}
		if(9 <= age && age < 20) {		//9세이상 20세 미만인 경우
			System.out.println("3000원");
		}
		if(20 <= age && age < 65) {		//20살이상 65세 미만인 경우
			System.out.println("5000원");
		}
		
		// 계속4번을 이런식으로 압축가능 단 읽기 불편해서 좋은코드로 볼수가없음 누구든지 읽기 쉬운 코드로 작성
		int price = 0;
		
		if(9 <= age && age < 20) {				//9세이상 20세 미만인 경우
			price = 3000;
		}else if(20 <= age && age < 65) {		//20살이상 65세 미만인 경우
			price = 5000;
		}else if(8 >= age || age >= 65) {		//8세이하 65세 이상인 경우
			price = 0;
		}
		System.out.println("입장료는 " + price);
		
		
		System.out.println("야구장에 입장하기 : 인증 성공");
		String id = "kbs";
		String password = "ok123";
		
		Scanner sca = new Scanner(System.in);
		System.out.println("id:");
		String inputId = sca.nextLine();
		System.out.println("pwd");
		String inputPwd = sca.nextLine();
		
		//if(inputId == id && inputPwd == password) {	//기본형비교
		if(inputId.equals(id) && inputPwd.equals(password)) {
			System.out.println("인증 성공했으므로 야구를 즐기세요~");
		}else {
			System.out.println("누구셔?");
		}

		
	}
}

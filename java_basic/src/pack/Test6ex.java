package pack;

import java.util.Scanner;

public class Test6ex {

	public static void main(String[] args) {
		// 키보드로 상품명(String sang), 수량(int su) , 단가(int dan)를 받아 아래와 같이 출력
		// 상품명 마우스는 금액:5000원이고 세금은 500원
		// 조건 : 금액(totalAmount) = 수량 * 단가
		// 세금(taxRate)은 금액이 5만원 이상이면 금액의 10%, 3만원 이사이면 금액의 5%
		// 나머지는 3%
		
		
		
		Scanner sca = new Scanner(System.in);
		System.out.print("상품명");
		String Sang = sca.nextLine();		// 문자열을 표시
		System.out.print("단가");
		int dan = sca.nextInt();			// int 숫자를 표시
		System.out.print("수량:");
		int su = sca.nextInt();				
		
		int totalAmount = su * dan;			// 단가 곱하기 수량 는 토탈
		
		double taxRate;		//실수				
		if(50000 <= totalAmount) {
			taxRate = 0.1;			//세금 10프로 줄게
		}else if(30000 <= totalAmount) {
			taxRate = 0.05;			//세금 5프로 줄게
		}else {
			taxRate = 0.03;			//세금 3프로 줄게
		}
		
		int tax = (int)	(totalAmount * taxRate);	//tax = 숫자로표시해야되서int - 토탈(단가 * 수량) * 세금10프로 
		System.out.println("상품명: " + Sang + " " + "금액: " + totalAmount + " " + "세금: " + tax);
		
		
		
		
		
		/*
		Scanner sca = new Scanner(System.in);
		System.out.println("상품명: ");
		String Sang = sca.nextLine();
		System.out.println("단가: ");
		int dan = sca.nextInt();
		System.out.println("수량: ");
		int su = sca.nextInt();
		
		int totalAmount = su * dan;
		
		double taxRate;
		if(50000 <= totalAmount) {				
			taxRate = 0.1;
		}else if(30000 <= totalAmount) {		
			taxRate = 0.05;
		}else {
			taxRate = 0.03;
		}
		
		int tax = (int) (totalAmount * taxRate);
		
		System.out.println("상품명: " + Sang + " " + "금액: " + totalAmount + " " + "세금: " + tax);
		
		*/

	}

}

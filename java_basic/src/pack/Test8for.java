package pack;

public class Test8for {

	public static void main(String[] args) {
		System.out.println("뭔가를 하다가...반복문 만나기");
		
		// 반복문 for 
		int a;
		int hap = 0; //누적 변수명
		for(a=1; a <= 5; a++) { //for(변수초기화; 조건; 증감치){ 반복 내용}
			System.out.print(a + "\t");
			// a = 7; 는 반복문블럭내에서 for 문에 사용중인 변수는 갱신 비권장
			hap = hap + a;
			
		}
				// 숫자를 문자로 변환
		System.out.println("\nfor 탈출 : " + a);
		System.out.println("합은 " + hap);
		
		System.out.println();
		
		for(int i=65; i <=90; i++) { // 숫자를 문자로 변환
			System.out.print((char)i + " " );
			
		}
		System.out.println("\nfor 탈출2");
		
		System.out.println();
		for(int i='A'; i <='Z'; i++) { // 문자를 숫자로 변환
			if(i % 2 == 0)
			System.out.print(i + " ");
			
		}
		System.out.println("\nfor 탈출3");
		
		System.out.println();
		for(int i = 10; i > 1; i -= 2) {
			System.out.print(i + " ");
			
		}
		System.out.println("\nfor 탈출4");
		System.out.println();
		for(int ytn=0, tvn=5; ytn <= 5; ytn++, tvn++) {
			System.out.print(ytn + "," + tvn + " ");
			
		}
		System.out.println("\nfor 탈출5");
		System.out.println();
		int aa = 1;
		for(; aa <= 5; aa++) {
			System.out.print(aa + " ");
			
		}
		
		System.out.println("\nfor 탈출6");
		System.out.println();
		for(int sbs = 1; sbs <= 10; sbs++) {
			if(sbs % 2 == 0) { //짝수만 표시
			System.out.print(sbs + " ");
		}
			if(sbs == 6) break;
		}
		
			System.out.println("\nfor 탈출7");
			System.out.println();
			//다중for............
			for(int m=1; m <= 3; m++) {
				System.out.println("m:" + m);
				for(int n=1; n <=4; n++) {
					System.out.print("n=" + n + " ");
					
				}
				System.out.println();
				
				
			}
			
			System.out.println("\nfor 탈출8");
			System.out.println();
			
			for(char i = 65; i <= 90; i++ ) {
				System.out.print(i + " : ");
				for(char j=i; j <= 'Z'; j++ ) {
					System.out.print(j);
					
				}
				System.out.println();
			}
			
			System.out.println("문제");
			//문1) 구구단 3단 출력
			
			for(int dan=1; dan < 10; dan++) {
				System.out.println("3 * " + dan + " = " + (3 * dan));
			}
			
			System.out.println("문제2");
			//문2 : 2 ~ 9 단 까지 출력
			
			for(int dan=1; dan < 10; dan++) {
				for(int su=1; su < 10; su++) {
					System.out.print(dan + "*" + su + " = " + (dan * su) + " ");
					
				}
				
				System.out.println();
			}
			
			
			
			// 문3 : 1~100 사이의 정수 중 3의 배수이면서 5의 배수를 출력하고 , 건수와  그들의 총합을 출력
			System.out.println("\n문3 총합출력");
			int count = 0;
			int total = 0;
			for(int su = 1; su <= 100; su++) {
				if(su % 3 == 0 && su % 5== 0) { 
					System.out.print(su + " ");
					count += 1; //누적
					total += su; //그수의합
					
				}
			
			}
			System.out.println("건수 : " + count);
			System.out.println("총합 : " + total);
			
			System.out.println("continue, break...");
			
			for(int i=2; i <= 10; i++) {
				if(i == 5 || i == 3) continue; // 자기와 대응되는 for문으로 무조건이동
											   // continue는 현재 반복을건너뛰고 다음반복을진행이라는뜻
					System.out.println(i);
				if( i == 7) break; 
			}
	
			//무한 반복문
			int kk = 0;
			for(;;) {
				kk++;
				System.out.println("kk");
				if(kk == 5) break;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	
		
	}
}

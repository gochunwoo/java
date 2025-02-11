package pack;

public class Test4 {

	public static void main(String[] args) {
		// 관계연산자
		int a =5;
		
		System.out.println(a > 3);	//true
		System.out.println(a <= 3);	//false
		System.out.println(a == 3);	//false
		System.out.println(a != 3);	//true
		
		boolean bb = a > 3;
		System.out.println("bb: "+ bb);
		
		// 논리연산자
		System.out.println();
		int b = 10;
		
		System.out.println(a > 3 && b <= 10); 	// 논리골 (and)
		System.out.println(a >= 3 && b == 5); 
		System.out.println(a >= 6 || b < 10);	//논리함 (or)
		System.out.println(a >= 3 || b < 10);
		System.out.println(a >= 3 && b < 20 || b == 10);
		
		// 연산자의 우선 순위 : () > 산술(*,/ > +,- ) > 관계 > 논리 > 치환
		boolean mbc = 3 + 4 * 2 >= a || 2 * (3 + 1) < b;
		System.out.println(mbc);
		
		
		
		System.out.println("\n시프트(shift) 연산자 : <<, >>, >>>");
		int ii = 8, ij = 0; 
		System.out.println(ii + " " + ij);
		System.out.println("ii : " + ii + " " + Integer.toBinaryString(ii));	//2진수를 원하는 비트만큼 이동
		
		ij = ii << 1;	//좌측으로 1bit 이동, 남은 우측은 0으로 채움
		System.out.println("ij : " + ij + " " + Integer.toBinaryString(ij));
		
		ij = ii >> 2;	//우측으로 2bit 이동, 남은 좌측은 부화와 같은 값으로 채움 , 양수는 0 음수는 1
		System.out.println("ij : " + ij + " " + Integer.toBinaryString(ij));
		
		ij = ii >>> 2;	//우측으로 2bit 이동, 남은 좌측은 부화와 같은 값으로 채움 , 양수는 0 음수는 1
		System.out.println("ij : " + ij + " " + Integer.toBinaryString(ij));
		
		
		
		System.out.println("\n상황 연산자");
		int sbs = 6;
		int result = (sbs > 5)?100:20 + 30;		//(조건)?참일떄처리문:거짓일떄처리문
		System.out.println("result :" + result);
		
		System.out.println();
		int x, y, z;
		x = y = z = 5;
		System.out.println(x + " " + y + " " + z);
	}

}

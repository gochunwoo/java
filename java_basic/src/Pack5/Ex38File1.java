package Pack5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Ex38File1 {

	public static void main(String[] args) throws Exception {
		// (8비트) 1바이트 단위의 입출력
		System.out.println("1바이트 입력:");
		int a = System.in.read();	// 한글 등의 2바이트 문자는 입력불가
		System.out.println("a : " + a + " " + (char)a);
		
		System.out.println("\n문자열 출력");
		OutputStreamWriter os = new OutputStreamWriter(System.out);
//		byte b = 97;
//		os.write(b);
//		os.flush();
		
		// 버퍼를 사용(파일 입출력(i/o) 서능을 항상, 처리 속도가 빨라짐)
		BufferedWriter bw = new BufferedWriter(os, 1024);	// 입출력은 기본이 1024바이트(1kb)단위로 처리됨
		PrintWriter out = new PrintWriter(bw);
		out.print(123);
		out.print("문자열 출력");
		out.close(); // 자원 해제(메모리 반납, GC의 대상)
		bw.close();
		
		System.out.println("파일 단위의 출력");
		File f = new File("c:/work/iotest.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw1 = new BufferedWriter(fw, 1024);
		PrintWriter out1 = new PrintWriter(bw1);
		out1.println(1234);
		out1.println("문자열이 파일로 출력됨");
		out1.print("좋아 여기까지");
		out1.close();
		bw1.close();
		fw.close();
		
		
		
		
		
		
	}

}

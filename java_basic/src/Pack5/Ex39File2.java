package Pack5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Ex39File2 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이:");
		int nai = scanner.nextInt();
		System.out.println("나이는 : " + nai + " 살");
		
		System.out.println("파일 단위의 입력(위기)");
		File f = new File("c:/work/iotest2.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br1 = new BufferedReader(fr);
		while(true) {
			String str = br1.readLine();
			if(str == null) break;
			System.out.println(str);
		}
		
		br1.close();
		fr.close();
		
	}

}

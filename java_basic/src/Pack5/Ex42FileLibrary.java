package Pack5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Ex42FileLibrary {

	public static void main(String[] args) {
		// data.go.kr이 전국 도서관 정보 자료 읽기
		
		try {
			File f = new File("c:/work/전국도서관.csv");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String ss = br.readLine();
			// ss = br.readLine();
			int count = 0;
			
			while(true) {
			if(ss == null || count >= 10) break;
			StringTokenizer tok = new StringTokenizer(ss, ",");
			String s1 = tok.nextToken();
			String s2 = tok.nextToken();
			String s3 = tok.nextToken();
			String s4 = tok.nextToken();
			String s5 = tok.nextToken();
			System.out.println(s1 + " " + s2 + " " + s3 + " " +s4 + " " +s5);
			ss = br.readLine();
			}
			br.close();
			fr.close();
			
		} catch (Exception e) {
			System.out.println("err : " + e );
		}
		
		
		
		
		
		
		
		
		
	}

}

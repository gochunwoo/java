package Pack5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ex45FileBinary {

	public static void main(String[] args) throws Exception {
		// 이진 데이터(Binary data)로 파일 입출력
		Ex45BinaryData data = new Ex45BinaryData();
		
		// 이진 데이터 파일로 저장
		// File f = new File("c:/iotest5.dat");
		File dir = new File("c:/");
		File f = new File(dir, "iotest5.dat");
		FileOutputStream fo = new FileOutputStream(f);
		BufferedOutputStream bo = new BufferedOutputStream(fo, 1024);
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(data);
		
		oo.close(); bo.close(); fo.close();
		System.err.println("파일 저장 성공! 탐색기로 확인합시다");
		
		System.out.println("\n이진 데이터 파일 읽기");
		File f2 = new File("c:/work/iotest5.dat");
		FileInputStream fis = new FileInputStream(f2);
		BufferedInputStream b1 = new BufferedInputStream(fis, 1024);
		ObjectInputStream oi = new ObjectInputStream(b1);
		
		Object obj = oi.readObject();
		Ex45BinaryData data2 = (Ex45BinaryData)obj;
		System.out.println(data2.i);
		System.out.println(data2.d);
		System.out.println(data2.ssi1);
		System.out.println(data2.ssi2);
		
		oi.close(); b1.close(); oi.close();
		
	}
}

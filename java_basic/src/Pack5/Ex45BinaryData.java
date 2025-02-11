package Pack5;

import java.io.Serializable;

public class Ex45BinaryData implements Serializable {
	// 자바직렬화란 자바 시스템 내부에서 사용되는 객체 또는 
	// 데이터를 외부의 자바 시스템에서도 사용할 수 있도록 바이트(byte) 형태로
	// 데이터 변환하는 기술과 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)을 아울러서 이야기한다
	// 객체를 파일에 저장하거나 파일에서 꺼내오기 위해서 또는 객체를 네트워크를 통해 전송하기 위해서는
	// 미리 객체를 직렬화해야한다.네크워크 처리에서 주로사용
	int i = 100;
	double d = 123.4;
	String ssi1 = "good";
	String ssi2 = "오늘은 그묭일";
	
	
}

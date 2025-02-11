package Pack3;

import java.awt.Frame;

public class Ex9FramPoham {
	
	String name = "신기해";
	private Frame frame;	// 외부 클래스를 사용

	
	
	
	public Ex9FramPoham() {	
		frame = new Frame("포함연습용");	// 클래스의 포함관계
//		
//		frame.setSize(500, 300);	// 너비와 높이 지점
//		frame.setLocation(200, 150);
//		frame.setVisible(true);
//		
//		
	}
	
	public void framVisible() {		// 생성자는 초기화 및 전체 윤곽만 적고, 나머지(처리로직)는 별도 메소드로 작성하는 것이 좋음 
		frame.setSize(500, 300);	// 너비와 높이 지점
		frame.setLocation(200, 150);
		frame.setVisible(true);
		
	}
		
		
	public static void main(String[] args) {
		// Ex9FramPoham framPoham = new Ex9FramPoham();
		// new Ex9FramPoham();		// 객체변수가 굳이 필요하지 않음. 생성자에서 모든일이 처리되므로
		
		// framPoham.frameVisible();
		
		new Ex9FramPoham().framVisible();
		
	}

}

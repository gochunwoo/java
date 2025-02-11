package Pack4Extends;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex26FrameAdapter extends WindowAdapter{
	private Frame frame;	// 클래스의 포함관계
	
	public Ex26FrameAdapter() {
		frame = new Frame("어뎁터 사용");
		frame.setSize(422, 200);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		
		frame.addWindowListener(this);
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) { // 원하는 메소드만 오버라이딩
		
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Ex26FrameAdapter();
		
	}

}

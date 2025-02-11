package Pack4Extends;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex30FrameAnonymous extends Frame{
	public Ex30FrameAnonymous() {
		setTitle("내부 무명클래스 사용");
		setSize(400, 300);
		setLocation(200, 200);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {  // 내부 무명 클래스 사용
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//setBackground(new Color(0, 0, 255));
				setBackground(Color.BLUE);
			}
		});
	}
	
	
	public static void main(String[] args) {
		new Ex30FrameAnonymous();
	}

}

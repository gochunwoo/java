package Pack4Extends;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex23FramInterface extends Frame implements WindowListener, MouseListener{
	
	public Ex23FramInterface() {
		super.setTitle("이벤트 처리 창");
		
		setSize(400, 300);;
		setLocation(200, 200);;
		setVisible(true);
		
		// 윈도우 관련 이벤트 처리를 하려면 윈도우 리스너를 Frame 에 장착
		super.addWindowListener(this);
		addMouseListener(this);
	// -------------------------윈도우 리스너---------------
	}
@Override
	public void windowActivated(WindowEvent e) {
		
}
@Override
	public void windowClosed(WindowEvent e) {
		
	}
@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("윈도우 종료 처리 메소드");
		System.exit(0); // 응용 프로그램의 강제 종료
	}
@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
			System.out.println("windowDeiconified");
		}
	@Override
	public void windowIconified(WindowEvent e) {
			System.out.println("windowIconified");
		}
	@Override
	public void windowOpened(WindowEvent e) {
			System.out.println("windowOpened");
		}
	
	// ----------------- 마우스 리스너------------------------------------------
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//System.out.println("mouseClicked 메소드 수행");
		//setBackground(new Color(200, 0, 0));
		//System.out.println((int)(Math.random() * 255));
		int r = (int)(Math.random() * 256); // 0에서 255 사이의 랜덤 값
	    int g = (int)(Math.random() * 256); // 0에서 255 사이의 랜덤 값
	    int b = (int)(Math.random() * 256); // 0에서 255 사이의 랜덤 값
	    setBackground(new Color(r, g, b));
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		new Ex23FramInterface();


	}

}

package Pack4Extends;

import java.awt.Frame;

public class Ex14FramSangsok extends Frame{
	public Ex14FramSangsok() {
		super("상속 연습용");
	}
	

	public void frameVisible() {
		setSize(500, 300);
		setLocation(200, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		
		Ex14FramSangsok frameSangsok = new Ex14FramSangsok();
		frameSangsok.frameVisible();
	}

}

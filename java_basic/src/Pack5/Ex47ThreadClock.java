package Pack5;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;

// 스레드를 이용해 디지털 시계 실행
public class Ex47ThreadClock extends Frame implements Runnable, ActionListener{
	Label lblMessage;
	Thread thread;
	Boolean b= false;
	
	public  Ex47ThreadClock() {
	lblMessage = new Label("show datetime", Label.CENTER);
	add("Center", lblMessage);
		
	Button button = new Button("click");
	add("South", button);
	button.addActionListener(this);
	
		setTitle("스레드 시계");
		setSize(300, 300);
		setLocation(200, 200);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				b = true; 	// 윈도우 종료시 run 메소드의 무한루프를 끝내기 위함
				System.exit(0);
			}
		});
		
		thread = new Thread(this); // 사용자 정의 스레드 생성
			
		  }
	@Override
	public void run() {
		while(true) {
			if(b == true) break;
			showSigan();
			
			// showSigan을 1초에 한번씩 호출할 수 있도록 스레드 1초간 비활성화 시킴
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// showSigan();
		
		if(thread.isAlive()) return;	// 스레드가 활성화된 상태인 경우 메소드 탈출
		thread.start(); // run 호출
	}
	private void showSigan() {
		LocalDate date = LocalDate.now(); 	// singleton 객체 / 한번만 만들어진다
		int y = date.getYear();
		int m = date.getMonthValue();
		int d = date.getDayOfMonth();
		
		LocalTime localTime = LocalTime.now();
		int h = localTime.getHour();
		int mi = localTime.getMinute();
		int s = localTime.getSecond();
		
		String imsi = y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s;
		lblMessage.setText(imsi);
	}
	public static void main(String[] args) {
		new Ex47ThreadClock();	
	}

}

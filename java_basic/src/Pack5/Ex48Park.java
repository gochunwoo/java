package Pack5;

public class Ex48Park extends Thread{		// 은행을 이용하는 박씨 클래스
	@Override
	public void run() {
		Ex48BankMain.hanaBank.saveMoney(5000);	// 스레드를 상속받은 런을 오버라이드
		System.out.println("남편 예금 후 잔고 : " + Ex48BankMain.hanaBank.getMoney());
		
	}
}

package Pack5;

public class Ex48BankMain {
	public static Ex48Bank hanaBank = new Ex48Bank();
	
	public static void main(String[] args) {
		// 스레드 동기화
		// 공유 자원에 Lock을 걸어 하나의 스레드가 공유자원을 사용 중인 경우 다른 스레드는 
		// 공유 자원을 사용하지 못하고 대기상태에 빠뜨릴 수 있다.
		//  synchronized 를 이용(내부적으로 Lock 을 건다)
		System.out.println("원금 : " + hanaBank.getMoney());
		
		Ex48Park park = new Ex48Park();
		park.start();	// 스레드 런메소드 실행 start(); 코드작성해서 부름
		
		Ex48Parkwife wife = new Ex48Parkwife();
		wife.start();	// 스레드 런메소드 실행 start(); 코드작성해서 부름
		
		
		
		
		
		
		
		
	}

}

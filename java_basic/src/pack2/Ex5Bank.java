package pack2;

import java.util.prefs.BackingStoreException;

// package : 성격이 비슷한 클래스들을 특정 패키지(폴더)에 저장해 두고 
// import 를 이용해 클래스의 멤버를 호출할수있다
public class Ex5Bank {
	
	//필드 생성
	private int money = 1000;
	int imsi = 1;
	public int imsi2 = 222;
	//
	public Ex5Bank() {
		
	}
	// 생성자 오버로딩
	public Ex5Bank(int money) {	//	constructor	overloading

	this.money += money;
	
		
		
	}
	// 메소드 오버로딩
	public void dePosit(int amount) {	// 입금
		if (amount > 0 ) money += amount;
	
	}
	
	public void withDraw(int amount) { // 출금
		if((amount > 0) && (money - amount >= 0)) {
			money -= amount;
			
		}else {
			System.out.println("출금액에 문제가 있네요");
		}
	}
	public int getMoney() { //잔금확인		//getter를 사용함으로 필드값(멤버변수) 불러오기
		return money;
		
	}
	
	
	
}

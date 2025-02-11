package Pack4Extends;

public class Ex18JepumMain {

	public static void main(String[] args) {
		// 추상 클래스는 스스로 객체 생성 불가. 자식의 생성자에 의해 객체 생성됨
		
		// Ex18Jepum jepum = new Ex18Jepum();	
		Ex18Jepum jepum = null;
		
		Ex18JepumTv tv = new Ex18JepumTv();
		tv.volumeControl();
		tv.volumeShow();
		
		System.out.println();
		Ex18Radio radio = new Ex18Radio();
		radio.volumeControl();
		radio.volumeShow();
		
		System.out.println();
		Ex18HandPhone handphone = new Ex18HandPhone();
		handphone.volumeControl();
		handphone.volumeShow();
		
		System.out.println("\n=====업캐스팅=====");
		jepum = handphone;
		jepum.volumeControl();
		jepum = radio;
		jepum.volumeControl();
		jepum = handphone;
		jepum.volumeControl();
		
		System.out.println("\n=====1차원 배열====");
		Ex18Jepum j[] = {tv, radio, handphone};
		for(Ex18Jepum jep:j) {
			jep.volumeControl();
		}
	}

}

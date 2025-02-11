package Pack4Extends;

public class Ex21VolumeMain {

	public static void main(String[] args) {
		//Ex21Volume myvolume = new Ex21Volume();  // X 
		Ex21Volume myvolume;	// 인터페이스 타입의 참조 변수 선언
		
		Ex21Radio radio = new Ex21Radio();
		Ex21Tv tv = new Ex21Tv();
		
		radio.volumeUp(6);
		radio.volumeDown(3);
		
		tv.volumeUp(7);
		tv.volumeDown(2);
		
		System.out.println();
		myvolume = radio;
		myvolume.volumeUp(2);
		myvolume = tv;
		myvolume.volumeUp(2);
	}
}

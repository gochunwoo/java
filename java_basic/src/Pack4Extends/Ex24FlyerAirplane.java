package Pack4Extends;

public class Ex24FlyerAirplane implements Ex24Flyer{
	@Override
	public void fly() {
		System.out.println("커다란 엔진소리와 함께 구름속으로 사라짐");
		
	}
	@Override
	public boolean isAnimal() {
		return false;
	}
	
}

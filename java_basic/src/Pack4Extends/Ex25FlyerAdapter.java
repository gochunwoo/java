package Pack4Extends;

// abstract class**는 인터페이스의 메소드를 완전히 구현하지 않고, 
// 자식 클래스가 반드시 구현해야 할 메소드들만 정의할 수 있는 방법을 제공합니다.
abstract class Ex25FlyerAdapter implements Ex24Flyer{
	
	public void fly() {
		
		
	}
		public boolean isAnimal() {
			return false;
		}
}

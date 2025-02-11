package Pack5;

public class Ex49BreadMain {

	public static void main(String[] args) {
		// 스레드 동기화 중 협력관계 처리
		// 스레드 간 협력 작업 중 스레드를 비활성화 wait() 후 다시 활성화notifyAll 상태로 되돌리기 작업
		try {
			Ex49BreadPlate breadPlate = new Ex49BreadPlate();
			
			Ex49BreadMaker Maker = new Ex49BreadMaker(breadPlate);
			Ex49BreadEater Eater = new Ex49BreadEater(breadPlate);
			Maker.setPriority(9);
			Maker.start();
			Eater.start();
		} catch (Exception e) {
		}
	}

}

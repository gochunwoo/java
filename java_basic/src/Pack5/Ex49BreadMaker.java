package Pack5;

public class Ex49BreadMaker extends Thread{
	private Ex49BreadPlate breadPlate;
	
	public Ex49BreadMaker (Ex49BreadPlate breadPlate) {
		this.breadPlate = breadPlate;
	}
	@Override
	public void run() {
		for(int i = 0; i < 30; i++) {
			breadPlate.makeBread();
		}
		
	}
}

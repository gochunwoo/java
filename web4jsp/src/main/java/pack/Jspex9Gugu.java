package pack;

public class Jspex9Gugu {
	// 싱글톤 배턴 코드
	private static Jspex9Gugu gugu = new Jspex9Gugu();
	
	public static Jspex9Gugu getInstance() {
		return gugu;
	}
	
	public Jspex9Gugu() {
		
	}
	
	public int[] computeGugu(int dan){
		int gu[] = new int[9];
		for(int i = 1; i < 10; i++) {
			gu[i-1] = dan * i;
		}
		return gu;
	}
}

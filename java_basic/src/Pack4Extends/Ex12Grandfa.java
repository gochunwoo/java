package Pack4Extends;

public class Ex12Grandfa {
	
	private int nai = 70;
	public String gabo = "상감청자";
	protected String gahun = "착하게 살자";
	
	public Ex12Grandfa() {
		
	}
	public Ex12Grandfa(int nai) {
		this();
		this.nai = nai;
	}
	
	public void say() {
		System.out.println("할아버지 말씀 : 자바에 집중해라");
	}
	
	public void eat() {
		System.out.println("밥은 맛있게 먹어라");
	}
	
	public int getNai() {
		return nai;
	}
	
	
}

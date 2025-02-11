package Pack4Extends;

public class Ex16HousDog extends Ex16Dog{
	private String where = "동물원";
	
	
	public Ex16HousDog(String name) {
		super(name);
		
		
	}
	public void show() {
		System.out.println("어디 사니?" + where + " 에 산다");
		
	}
	public void print() {
		System.out.println(getName() + " : " + where + " 에서 잘지내고있어");
	}
	
	
	
	
	

}


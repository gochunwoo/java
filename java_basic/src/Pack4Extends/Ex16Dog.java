package Pack4Extends;



public class Ex16Dog {
	private String name;
	
	
	public Ex16Dog(String name) {
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}
	public String callName() {
		return "종류 : " + name;
	}
	
	public void print() {
		System.out.println(name + "과 동물들은 지구 상에 산다");
		
	}
}

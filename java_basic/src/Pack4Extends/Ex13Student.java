package Pack4Extends;

public class Ex13Student {
	
	public String name;
	
	public Ex13Student () {
		name = "tom";
	}
	
	@Override
	public String toString() {
		System.out.println("원래 의미 싫어 바꿀꺼야");
		return "이 클래스의 사용지는 " + name;
	}
	
	
	public static void main (String[] args) {
		Ex13Student student = new Ex13Student();
		System.out.println(student);
		System.out.println(student.toString());
		
	}
}



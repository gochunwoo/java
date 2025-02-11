package Pack3;

public class Ex10Person {
	String name;
    int age;
    Ex10Address address; // Address 클래스 포함

    // 생성자 작성 - 매개변수: String name, int age 
    public Ex10Person(String name, int age, String juso) {
		this.name = name;
		this.age = age;
		address = new Ex10Address(juso);
	}

    public void display() {
    	System.out.println("Name: " + name + ", Age: " + age + 
    			", Address: " + address.getStreet());
    }
}

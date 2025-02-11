package Pack4Extends;

public class Ex19AnimalMain {

	public static void main(String[] args) {
	
		Ex19Cow cow = new Ex19Cow();
		System.out.println(cow.name() + " " + cow.action() + "에 " + cow.eat() + " 먹음");
		cow.print();
		
		System.out.println();
		Ex19Lion lion = new Ex19Lion();
		System.out.println(lion.name() + " " + lion.action() + "에 " + lion.eat() + " 먹음");
		lion.eatOther();
		
		System.out.println("\n===업캐스팅===");
		Ex19Animal animal;
		animal = cow;
		System.out.println(animal.name() + " " + animal.action() + "에 " + animal.eat() + " 먹음");
		animal = lion;
		System.out.println(animal.name() + " " + animal.action() + "에 " + animal.eat() + " 먹음");
		
		System.out.println();
		System.out.println(cow instanceof Ex19Cow);
		if(cow instanceof Ex19Cow)
			System.out.println("맞아");
		else
			System.out.println("아니야");
		
		System.out.println(cow instanceof Ex19Animal);
		System.out.println(lion instanceof Ex19Animal);
		
		System.out.println("\n메소드 호출하며 매개변수에 주소 치환 ------- ");
		Ex19AnimalFind animalFind = new Ex19AnimalFind();
		// cow 객체를 find() 메소드로 전달
		animalFind.find(cow);	// 주소를 치환한다는 점에서 animal = cow; 와 같은의미
		System.out.println();
		// lion 객체를 find() 메소드로 전달
		animalFind.find(lion);	// 주소를 치환한다는 점에서 animal = lion; 와 같은의미
		
		
	}

}

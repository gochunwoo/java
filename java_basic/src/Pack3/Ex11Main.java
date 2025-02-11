package Pack3;

public class Ex11Main {

	public static void main(String[] args) {
		// book 객체 생성
		Ex11Book mybook = new Ex11Book("자바 클래스 활용", "박치기");
		
		// 학생 객체 생성
		Ex11Student tom = new Ex11Student("미스터톰", mybook);
		tom.showStudentDetail();
		
	}

}

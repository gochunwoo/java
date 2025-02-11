package pack2;

public class Ex2Programmer {
	public String nickName;	// 초기값이 없으면 참조형이므로 null 이 출력됨
	private int age;	// 초기값이 없으면 0 을 기억, 은닉화된 필드(멤버변수, 전역변수
	//private int age = 0 위에 age; 랑 같은뜻
	String spec = "정보처리 자격증";
	
	public static String motto = "자바에 아름답게 미치자";		// 정적 필드 static(스텍틱)영역에 저장
	// static 사용함으로 객체를 만들필요 없음 static 사용함으로 클래스를
	// 스태틱안으로 불러옴으로 객체를 사용안해도됨
	public static final double WEIGHT = 66.78;		// final 멤버필드는 값 수정 불가	이름은 대문자로만 쓰기 권장
	public static final double pi = 3.15;	// 정적 필드이고 수정불가
		
	
	
		
	public Ex2Programmer () {	// 생성자
		// 생성자는 내용이 없는 경우에 적지 않으면 컴파일러가 내부적으로 만들어 준다
		System.out.println("난 생성자야. 객체 생성시 1회만 호출 가능");
		int number = 20;	// 지역변수(메소드 내에서 선언한 변수는 메소드 내에서만 유호)
		age = number + 5;
		nickName = "에러잡는 귀신";
		
		
	}
	public void displayData() {
		System.out.println("----");
		 String mySpec = responseSpec();	// 메소드가 다른 메소드를 호
		  System.out.println(mySpec);
		 System.out.println("별명은 " + nickName + ", 나이는" + age);
		System.out.println("----");
	}
	private String responseSpec() {
		return "내가 가진 기술은 " + spec;
		
	}
	
	// private 멤버 외부에서 제어하기 위한 메소드 작성 . 캡슐화
	public int getAge() {	// 메소드 이름은 약속. get 멤버변수(첫글짜는 대문자) <== getter ( 겟터 )
		return age;		// age 변수 자체를 반환하는 것이 아니라 age 의 기억된 정수를 반환
	}
	
	public void setAge(int age) { // 메소드 이름은 약속, set 멤버변수(첫글짜는 대문자)
		this.age = age;
	}
	public void setAgeEx(int age, int password) {	//....
		if(password == 123) {
			this.age = age;
			System.out.println("age 수정 성공");
		}else {
			System.out.println("비밀번호가틀리므로 틀리므로age를 수정할수없음");
		}
		
		
		
		
		
		
		
		
	}
	
	
}

package pack2;

public class Ex3Singer {
	//필드
	private String name = "무명 가수";		// private 를 사용함으로 은닉화함 
	private String titleSong = "아 대한민국";
	
	//생성자
	public Ex3Singer(String name, String title) {
		this.name = name;
		name = title;
	}
	
	// 메소드
	public void sing() {
		// String name = "아이유";	// this 를 사용함으로 name 은아이유 를 호출	지역변수
		// System.out.println(this.name + " 의 노래 제목은 " + titleSong);
		System.out.println(name + " 의 노래 제목은 " + titleSong);
		
	}
	
	public void setTitleSong(String titleSong) {
		this.titleSong = titleSong;
	}


	//객체생성
	public static void main(String[] args) {
		// Ex3Singer의 객체를 bts 로 새로만듬
		Ex3Singer bts = new Ex3Singer("Bts","다이너마이트");
		// 메소드 호출
		bts.sing();
		bts.setTitleSong("BTS 만세"); // 메소드 setTitleSong 호출
		bts.sing();
		bts.setTitleSong("bts 화이팅");
		bts.sing();
		
		System.out.println();
		Ex3Singer blackpink = new Ex3Singer("블랙핑크","how you like that");
		blackpink.sing();
		
		
	}
	
}




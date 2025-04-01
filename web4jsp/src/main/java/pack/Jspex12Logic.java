package pack;

public class Jspex12Logic {
private Jspex12form total;
	
	public void setTotal(Jspex12form total) {
		this.total = total;
	}
	public int getResult() {
		return total.getPrc() - total.getDisc();
		
		// 필드명 꼭너어줘야됨 오류 해결
		// 메소드 이름 문제 메소드이름과 다른이름이 같으면안됨
	}
}

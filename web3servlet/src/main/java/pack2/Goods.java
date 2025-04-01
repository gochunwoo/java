package pack2;

// 이 Goods 클래스는 "상품 하나" 를 표현하는 클래스에요
// Goods 클래스의 역할
// 상품의 이름 과 가격 을 저장하는 데이터 저장용 클래스 입니다.
// 예를 들어 사용자가 "미니자동차 5종세트"(가격:25000원)를 장바구니에 담으면
// -> Goods 클래스가 "미니자동차 5종세트" 와 25000 을 저장하는 역할을 해요

public class Goods {	// 장바구니에 담을 상품 정보들
	private String name;
	private int price;
	
	public Goods(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
}

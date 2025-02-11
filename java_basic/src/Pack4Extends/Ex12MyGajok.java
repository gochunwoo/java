package Pack4Extends;

public class Ex12MyGajok {

	public static void main(String[] args) {
		Ex12Grandfa grandfa = new Ex12Grandfa();
		System.out.println("가보 : " + grandfa.gabo);
		System.out.println("가훈 : " + grandfa.gahun);
		grandfa.say();
		System.out.println("할아버지 나이 : " + grandfa.getNai());
		
		System.out.println();
		
		Ex12Grandfa grandfa2 = new Ex12Grandfa(77);
		System.out.println("할아버지 나이 : " + grandfa2.getNai());
		
		System.out.println("---------------------------");
		
		Ex12Father father = new Ex12Father();
		System.out.println("가보 : " + father.gabo);
		System.out.println("가훈 : " + father.gahun);
		father.say();
		System.out.println("아버지 나이 : " + father.getNai());
		father.eat();
		System.out.println("집 : " + father.getHouse());
		father.showData();
		
		System.out.println("-------------me-------------");
		
		Ex12Me me = new Ex12Me();
		System.out.println("가보 : " + me.gabo);
		System.out.println("가훈 : " + me.gahun);
		me.say();
		System.out.println("내 나이 : " + me.getNai());
		me.eat();
		System.out.println("집 : " + me.getHouse());
		me.Biking();
	}	

}

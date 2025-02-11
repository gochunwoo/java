package Pack4Extends;

public class Ex17PolyTaxi extends Ex17PolyCar{
	private int passenger = 2;
	
	public Ex17PolyTaxi() {
		System.out.println("난 Car의 자식인 Taxi 생성자입니다");
	}
	@Override
	public void dispData() {
		String msg = "택 시 안에 몇명이 타고 있니? " + passenger;
		System.out.println(msg);
		
	}

}

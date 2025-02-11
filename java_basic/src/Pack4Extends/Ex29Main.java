package Pack4Extends;

public class Ex29Main {
	public static void main(String[] args) {
		Ex29Saram saram = new Ex29Saram();
		System.out.println(saram.getIrum());
		
		System.out.println();
		Ex29Kildong kildong = new Ex29Kildong();
		Ex29Saram saram2 = kildong.getSaram();
		System.out.println(saram2.getIrum());
	}
}

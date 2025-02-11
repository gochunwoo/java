package Pack5;

import java.util.Scanner;
import java.util.ArrayList;

public class Ex36StuDtoTest2 { // dto / 컬렉션 공부하기
	
	private ArrayList<Ex36StudDto> list = new ArrayList<>();
	private String name;
	private int jumsu, ejumsu, add;
	
	
	public void insertData() {
		while(true) {
			
		Scanner sc = new Scanner(System.in);

		System.out.println("이름");
		String nuam = sc.next();
		
		System.out.println("국어점수");
		int jumsu = sc.nextInt();
		
		System.out.println("영어점수");
		int ejumsu = sc.nextInt();
		
		Ex36StudDto dto = new Ex36StudDto();	// Ex36StudDto 객체생성
		dto.setName(nuam);
		dto.setJumsu(jumsu);
		dto.setJumsu(ejumsu);
		list.add(dto);	// 각 학생 정보 컬렉션에 저장
		
		System.out.println("계속?");
		String b = sc.next();
		if(!b.equals("y")) break;
		
		}
	}
	
	public void showData() {
		int count = 0; // 인원수 출력용
		
		for(int i = 0; i < list.size(); i++) {
			Ex36StudDto dto = list.get(i);
			int tot = dto.getJums() + dto.getEjums();
			System.out.println(dto.getName() + " " + 
							dto.getEjums() + " " + 
							dto.getJums() + " " + tot);
			count += 1;
		}
		System.out.println("응시 인원: " + count);
		System.out.println("응시 인원: " + list.size());

	}
	
	
	public static void main(String[] args) {
		Ex36StuDtoTest2 test2 = new Ex36StuDtoTest2();	// 객체 생성
		test2.insertData();	// Ex36StuDtoTest2 메소드 호출
		test2.showData();	// Ex36StuDtoTest2 메소드 호출
	
	}
}


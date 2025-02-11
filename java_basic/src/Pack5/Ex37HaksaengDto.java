package Pack5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 롬복을 사용해 생성자 겟터 셋터 만들기
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Ex37HaksaengDto {
	private String name;
	private int kor, eng, mat;
	
	/*
	public Ex37HaksaengDto (String name, int kor, int eng, int mat) {
		this.eng = eng;
		this.kor = kor;
		this.mat = mat;
		this.name = name;
	}
	*/

}



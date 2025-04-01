package pack;

import java.util.List;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;

public class MyBatisMain {

	public static void main(String[] args) {
		ProcessDao processDao = ProcessDao.getInstance();
		
		try {
			System.out.println("자료 추가 -------------");
			/*DataDto dataDto = new DataDto();
			dataDto.setCode("9");
			dataDto.setSang("카푸치노");
			dataDto.setSu("20");
			dataDto.setDan("5000");
			processDao.insertData(dataDto);
			*/
			
			System.out.println("전체 자료 출력 -------------");
			List<DataDto> list = processDao.selectDatAll();
			for(DataDto s:list) {
				System.out.println(s.getCode() + " " + s.getSang() + " "  
								 + s.getSu() + " "  + s.getDan());
			}
			
			System.out.println("일부 자료 출력 -------------");
			String code = "1";
			DataDto dto = processDao.selectDataPart(code);
			System.out.println(dto.getCode() + " " + dto.getSang() + " "  
					 + dto.getSu() + " "  + dto.getDan());
			
			System.out.println("업데이트 출력 ------------");
			/*DataDto dataDto = new DataDto();
			dataDto.setCode("9");
			dataDto.setSang("바나나우유");
			dataDto.setSu("10");
			dataDto.setDan("9000");
			processDao.updateData(dataDto);*/
			
			System.out.println("자료 삭제 ------------");
			/*int co = 9;
			boolean b = processDao.deleteData(co);
			if(b) {
				System.out.println("삭제성공");
			}else {
				System.out.println("삭제 실패");
			}*/
			
			
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
  }
}

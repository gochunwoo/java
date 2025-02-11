package Pack5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex38DtoTest4 {
	private ArrayList<Ex38Company> list = new ArrayList<Ex38Company>();

	public int yearsalary(Ex38Company company) { // 근속수당
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		int work = year - company.getYear();
		if (work >= 9) {
			return 1000000;
		} else if (work >= 4) {
			return 450000;
		} else {
			return 150000;
		}
	}

	public int totsalary(Ex38Company company) { // 급여액
		return company.getSalary() + this.yearsalary(company);
	}

	public double deducted(Ex38Company company) { // 공제액
		int totsalary = this.totsalary(company);
		double deduct;

		if (totsalary >= 3000000) {
			deduct = 0.005;
		} else if (totsalary >= 2000000) {
			deduct = 0.003;
		} else {
			deduct = 0.0015;
		}

		return totsalary * deduct;
	}

	public double gsalary(Ex38Company company) { // 수령액
		return this.totsalary(company) - this.deducted(company);
	}

	public void insertData(String[] datas) {
		for (int i = 0; i < datas.length; i++) {
			StringTokenizer tok = new StringTokenizer(datas[i], ",");
			int sabun = Integer.parseInt(tok.nextToken());
			String name = tok.nextToken();
			int salary = Integer.parseInt(tok.nextToken());
			int year = Integer.parseInt(tok.nextToken());

			Ex38Company company = new Ex38Company(sabun, year, salary, name);
			list.add(company);
		}
	}

	public void showData() {
		System.out.println("사번\t이름\t급여액\t공제액\t수령액");

		for (Ex38Company company : list) {
			int totsalary = totsalary(company);
			double deduct = deducted(company);
			double gsalary = gsalary(company);

			System.out.println(
					company.getSabun() + "\t" + company.getName() + "\t" + totsalary + "\t" + deduct + "\t" + gsalary);
		}
	}

	public static void main(String[] args) {
		String[] datas = new String[2];
		datas[0] = "1,강나루,1500000,2005";
		datas[1] = "2,홍길동,1200000,2006";

		Ex38DtoTest4 test4 = new Ex38DtoTest4();
		test4.insertData(datas);
		test4.showData();
	}
}
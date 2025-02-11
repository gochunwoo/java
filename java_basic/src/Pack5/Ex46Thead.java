package Pack5;


	
	// 스레드 : 하나의 프로그램은 하나의 Process 에 해당한다. 이러한 process 를 실제로 실행하기 위한
	// 실행 단위를 Thread 라고 한다
	// Thread 하나는 한 개의 실행을 담당하므로, 결국, 여러 개의 Thread 를 이용하면 여러 개의 작업(task)을 할 수 있다.
	// single thread 는 single tasking, multi thread 는 multi tasking 를 하게 된다
	// 여러 개의 응용 프로그램을 실행하고 싶을 때 또는 네크워크 작업을 효율적으로 운영하려면 스레드 처리는 필수적이다!!!
public class Ex46Thead  implements Runnable{
	public Ex46Thead() { }
	public Ex46Thead (String name) {
		Thread tt = new Thread(this, name);
		tt.start();
	}
	@Override
	public void run() {
		for(int i = 0; i <= 50; i++) {
			System.out.println(i + " > " + Thread.currentThread().getName());
		try {
			Thread.sleep(200); // 1000ms : 1초
		} catch (Exception e) {
			// TODO: handle exception
			}	
		}
		
	}
	
	public static void main(String[] args) { // 기본적으로 모든 프로그램은 main 스레드가 자동 실행됩니다
		try {
//		Ex46Thead my1 = new Ex46Thead();
//		Ex46Thead my2 = new Ex46Thead();
//		my1.run();	// 처음 요청이 모두 처리 되면 
//		my2.run();	// 다음 요청이 처리가 됨
		
		//사용자 정의 스레드를 사용한경우
		Ex46Thead my1 = new Ex46Thead();
		Ex46Thead my2 = new Ex46Thead();
		Thread t1 = new Thread(my1, "하나");
		Thread t2 = new Thread(my2, "둘");
		t1.start();
		t2.start();
		
		t2.setPriority(5); // 스레드 스케줄러에 우선 쉰위를 신청
		t1.join();	// 
		t2.join();	// 상용자 정의 스레드가 종료될대가지 메인 스레드를댁1
		// new Ex46Thead("하나");	// 스레드 스케줄러에 의해 순차적인 처리가 아니라 랜덤하게 용청이 처리됨 
		// new Ex46Thead("둘");
		System.out.println("프로그램 종료");
			
		} catch (Exception e) {
		
		}		
	}

}

package thread;

public class StatePrintThread extends Thread {
	private TargetThread targetThread;



	public StatePrintThread(TargetThread targetThread) {
		this.targetThread = targetThread;
	}


	public void run(){
		while(true) {
			Thread.State state = targetThread.getState();
			System.out.println(state);// 타겟스레드 상태 출력
			if(state == Thread.State.NEW ) {// 객체생성으로 
				targetThread.start(); //쓰레드 실행대기상태로 이동
			}
			if(state == Thread.State.TERMINATED) {//타겟 스레드가 종료 되면 현재 메소드도 종료
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//ends while
	}//end run
	

}

package thread;

public class StatePrintThread extends Thread {
	private TargetThread targetThread;



	public StatePrintThread(TargetThread targetThread) {
		this.targetThread = targetThread;
	}


	public void run(){
		while(true) {
			Thread.State state = targetThread.getState();
			System.out.println(state);// Ÿ�ٽ����� ���� ���
			if(state == Thread.State.NEW ) {// ��ü�������� 
				targetThread.start(); //������ ��������·� �̵�
			}
			if(state == Thread.State.TERMINATED) {//Ÿ�� �����尡 ���� �Ǹ� ���� �޼ҵ嵵 ����
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

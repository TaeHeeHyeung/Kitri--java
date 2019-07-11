import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class AbstractTest1 extends Frame {
	public AbstractTest1(){
		super("Has a Test!!");
		Button b= new Button("@������@");
		setLayout(new FlowLayout());
		add(b);
		setSize(400, 300);
		setLocation(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		//Ŭ������ ��ü �������� �ʰ� �����ϴ� ����� 

		//��� 1. ���� Ŭ���� ����
		// �߻�Ŭ������ �����ڸ� ���� �� ����. �ֳ��ϸ� �߻�޼ҵ�� ������ �޼ҵ尡 �ƴϱ� ������ ��ü������ �Ͽ�
		// �߻� �޼ҵ带 �����ϰԵǸ� �ȵǱ� �����̴�.
		Calendar cal1 = new GregorianCalendar();

		//��� 2. �ڱ� �ڽ��� �����ϴ� static �޼ҵ�
		//�߻� Ŭ������ ��ü���� �� �� ���� ������ static �żҵ忡�� ������ �� �ִ�.
		// static �޼ҵ忡 ��ü�� ��ȯ�ϴ� �޼ҵ尡 �ִ��� Ȯ���غ���.
		Calendar cal2 = Calendar.getInstance();
		
		int y = cal2.get(Calendar.YEAR);
		int mm = cal2.get(Calendar.MONTH);
		int d = cal2.get(Calendar.DATE);
		int h = cal2.get(Calendar.HOUR);
		int am = cal2.get(Calendar.AM_PM);
		int mi = cal2.get(Calendar.MINUTE);
		int s = cal2.get(Calendar.SECOND);

		System.out.println(y+"��"+(mm+1)+"��"+d+"��"+am+" "+h+"��"+mi+"��"+s+"��");

		//��� 3. �ܺ�Ŭ������ ��ü����
		//��ü �����ϱ����� static�� �͸� �� �� �ִ�.
		//Process�� ������ �о�� Runtime�� �Բ� ����϶�����ִ�.
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("calc");

		//��� 4. �ڽ��� �����ڸ� �̿� (Ư���� ���)
		//WindowListener ��� �߻� �޼ҵ带 �� �����ؾ��Ѵ�.
		/*
		WindowListener wlMy= new WindowListener(){
			@Override 
			public void windowDeactivated(WindowEvent e){
				System.exit(0);
			}
			@Override
			public void windowClosing(WindowEvent e){
					System.exit(0);
			}
		};
		*/
		AbstractTest1 at1= new AbstractTest1();

		//WindowsAdapter�� �߻�Ŭ�����̴� ������ �߻�޼ҵ尡 �������� �ʴ´�.
		//�̷� ��� �ϳ��� �޼ҵ常 �����ؼ� Ȱ���ϸ� �ȴ�.
		//WindowsListener�� �������̽�Ŭ�����̴�. WindowsListsner �ȿ� �޼ҵ� ������ �����Ǿ����� �ʴ�.
		//WindowsAdapter���� �ش� ������ �����Ͽ� ��ü�� ����� �� �ִ�.
		WindowListener wl = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			public void windowIconified(WindowEvent e){
				System.out.println("������ȭ!!!!");
			}
		};
		at1.addWindowListener(wl);

	}//end main
}//end class

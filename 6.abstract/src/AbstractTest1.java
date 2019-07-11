import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class AbstractTest1 extends Frame {
	public AbstractTest1(){
		super("Has a Test!!");
		Button b= new Button("@눌러봐@");
		setLayout(new FlowLayout());
		add(b);
		setSize(400, 300);
		setLocation(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		//클래스를 객체 생성하지 않고 생성하는 방법들 

		//방법 1. 하위 클래스 참조
		// 추상클래스는 생성자를 만들 수 없다. 왜냐하면 추상메소드는 구현된 메소드가 아니기 때문에 객체생성을 하여
		// 추상 메소드를 접근하게되면 안되기 때문이다.
		Calendar cal1 = new GregorianCalendar();

		//방법 2. 자기 자신을 리턴하는 static 메소드
		//추상 클래스는 객체생성 할 수 없기 때문에 static 매소드에만 접근할 수 있다.
		// static 메소드에 객체를 반환하는 메소드가 있는지 확인해본다.
		Calendar cal2 = Calendar.getInstance();
		
		int y = cal2.get(Calendar.YEAR);
		int mm = cal2.get(Calendar.MONTH);
		int d = cal2.get(Calendar.DATE);
		int h = cal2.get(Calendar.HOUR);
		int am = cal2.get(Calendar.AM_PM);
		int mi = cal2.get(Calendar.MINUTE);
		int s = cal2.get(Calendar.SECOND);

		System.out.println(y+"년"+(mm+1)+"월"+d+"일"+am+" "+h+"시"+mi+"분"+s+"초");

		//방법 3. 외부클래스로 객체생성
		//객체 생성하기전에 static인 것만 쓸 수 있다.
		//Process의 설명문을 읽어보면 Runtime을 함께 사용하라고나와있다.
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("calc");

		//방법 4. 자신의 생성자를 이용 (특수한 경우)
		//WindowListener 모든 추상 메소드를 다 구현해야한다.
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

		//WindowsAdapter는 추상클래스이다 하지만 추상메소드가 존재하지 않는다.
		//이런 경우 하나의 메소드만 선택해서 활용하면 된다.
		//WindowsListener은 인터페이스클래스이다. WindowsListsner 안에 메소드 내용은 구현되어있지 않다.
		//WindowsAdapter에서 해당 내용을 구현하여 객체를 사용할 수 있다.
		WindowListener wl = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			public void windowIconified(WindowEvent e){
				System.out.println("아이콘화!!!!");
			}
		};
		at1.addWindowListener(wl);

	}//end main
}//end class

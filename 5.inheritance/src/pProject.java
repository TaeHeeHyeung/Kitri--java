import java.awt.*;
import java.awt.event.*;


public class pProject extends Frame {
	pProject(){
		super("������ 5�ʸ��� ���ϴ� ������");
		setLocation(500, 500);
		setSize(400, 300);
		setVisible(true);
		
		WindowListener wl = new WindowAdapter(){
				public void 	windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		addWindowListener(wl);
		/*
		addWindowListener(new WindowAdapter(){
			public void 	windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		*/

	}
	


	public static void main(String[] args) {
		pProject project = new pProject();

	}//end main
}//end class

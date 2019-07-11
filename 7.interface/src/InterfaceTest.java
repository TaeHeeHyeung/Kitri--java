import java.awt.*;
import java.awt.event.*;

public class InterfaceTest extends Frame implements ActionListener
 {
	Button b1= new Button("@������@");
	//Frame f = new Frame();
	//Frame�� ��������ν� f.�� ����� �ʿ䰡 ���� ������ �޸������� ���ص� �ȴ�. => ���� �� ����
	public InterfaceTest(){
		super("interface Test!!!");
		setLayout(new FlowLayout());
		b1.setBackground(new Color(210,255,210));
		add(b1);
		setBackground(new Color(255,210,210));
		setSize(400, 300);
		setLocation(300, 200);
		setVisible(true);

		ActionAdapter aa=	 new ActionAdapter();
		//WindowListener wl = new InterfaceTest();
		addWindowListener(aa);
		//car �Ҷ� new car���� �ʰ� this�� �ߴ�.

	
		b1.addActionListener(this);

	}//end  InterfaceTest class
	
	
	//public void windowDeactivated(WindowEvent e){}
	/*public void windowActivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){System.exit(0);}
	public void windowOpened(WindowEvent e){}*/

	public void actionPerformed(ActionEvent evt){ 
		int r= (int)(Math.random()*256);
		int g= (int)(Math.random()*256);
		int b= (int)(Math.random()*256);
		setBackground(new Color(r,g,b));

	}

	public static void main(String [] args){
		InterfaceTest ift= new InterfaceTest();
	}
	class ActionAdapter extends WindowAdapter{
		public void windowActivated(WindowEvent e){

		}
		public void windowClosed(WindowEvent e){
			//System.exit(0);
		}
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}//end ActionAdapter class

}//end class

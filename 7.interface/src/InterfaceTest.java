import java.awt.*;
import java.awt.event.*;

public class InterfaceTest extends Frame implements ActionListener
 {
	Button b1= new Button("@눌러봐@");
	//Frame f = new Frame();
	//Frame을 상속함으로써 f.을 사용할 필요가 없기 때문에 메모리참조를 안해도 된다. => 성능 상 좋음
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
		//car 할때 new car하지 않고 this를 했다.

	
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

package swingtest;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridBagLayaoutTest extends JFrame {

	GridBagLayout gb= new GridBagLayout();
	JPanel pLabelTxt1 = new JPanel(new BorderLayout(20, 0));
	JPanel pLabelTxt2 = new JPanel(new BorderLayout(20, 0));
	JPanel pC = new JPanel(new GridLayout(4, 1, 10, 20));
		
	public GridBagLayaoutTest()  {
		setLayout(gb);
//		pC.add(pLabelTxt1);
//		pC.add(pLabelTxt2);
		
		gb.addLayoutComponent(pLabelTxt1,GridBagConstraints.PAGE_START);
		gb.addLayoutComponent(pLabelTxt1,GridBagConstraints.PAGE_END);
//		pC.add(pLabelTxt1);
//		pC.add(pLabelTxt2);
		setBounds(300, 300, 500, 300);
		setVisible(true);
		
	}


	public static void main(String[] args) {
		new GridBagLayaoutTest();
		
	}

}

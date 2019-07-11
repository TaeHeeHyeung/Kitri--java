package com.kitiri.awt.design;

import java.awt.*;

public class ColorSelector extends Frame {
	Panel p1 = new Panel(new BorderLayout());
	Panel p2 = new Panel(new BorderLayout());
	Panel p3 = new Panel(new BorderLayout());
	Label lR = new Label("»¡°­");
	Label lG = new Label("ÃÊ·Ï");
	Label lB = new Label("ÆÄ¶û");
	int length = 10;
	Scrollbar sbR = new Scrollbar(Scrollbar.HORIZONTAL, 127, length, 0, 255 + length);
	Scrollbar sbG = new Scrollbar(Scrollbar.HORIZONTAL, 127, length, 0, 255 + length);
	Scrollbar sbB = new Scrollbar(Scrollbar.HORIZONTAL, 127, length, 0, 255 + length);
	
	Button ok = new Button("È®ÀÎ");
	Panel colorP = new Panel();
	Label colorL = new Label();
	Panel p_rl = new Panel(new GridLayout(1, 2));
	Panel p_w = new Panel(new GridLayout(5, 1, 0, 100));
	
	Panel pE = new Panel(new BorderLayout());
	Panel pEC = new Panel(new BorderLayout());
	Panel pES = new Panel(new BorderLayout());
	
	
	
	public ColorSelector() {	
		p_w.add(new Panel());
		p_w.add(p1, BorderLayout.CENTER);
		p_w.add(p2, BorderLayout.CENTER);
		p_w.add(p3, BorderLayout.CENTER);
		p_w.add(new Panel());
		
		
		pE.add(pEC);
		pEC.add(colorP,BorderLayout.CENTER);
		pES.add(colorL,BorderLayout.CENTER);
		pES.add(ok,BorderLayout.EAST);
		pE.add(pEC,BorderLayout.CENTER);
		pE.add(pES,BorderLayout.SOUTH);
		
		
		pEC.add(colorP,BorderLayout.CENTER);
	
	
		
		p1.add(lR, BorderLayout.WEST);
		p1.add(sbR, BorderLayout.CENTER);
		p2.add(lG, BorderLayout.WEST);
		p2.add(sbG, BorderLayout.CENTER);
		p3.add(lB, BorderLayout.WEST);
		p3.add(sbB, BorderLayout.CENTER);

		int r = sbR.getValue();
		int g = sbG.getValue();
		int b = sbB.getValue();
		
		colorP.setBackground(new Color(r,g,b));
		colorL.setText("r= " + r + "g= " + g + "b=" + b);
		
		p_rl.add(p_w);
		p_rl.add(pE);
		add(p_rl);
		setBounds(480, 270, 500, 500);
		setVisible(true);

	}//end ColorSelector



	public static void main(String[] args) {
		new ColorSelector();
	}

}

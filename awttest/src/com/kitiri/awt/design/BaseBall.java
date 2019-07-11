package com.kitiri.awt.design;

import java.awt.*;

public class BaseBall extends Frame {
	
	public static Panel rightPenl(Frame f) {
		Button newG= new Button("새게임");
		Button clear= new Button("지우기");
		Button dap= new Button("정답");
		Button fontC= new Button("글자색");
		Button exit= new Button("종료");
		Panel p_E = new Panel(new GridLayout(5, 1, 0, 10));
		
		p_E.add(newG);
		p_E.add(clear);
		p_E.add(dap);
		p_E.add(fontC);
		p_E.add(exit);
		return p_E;
	}
	public static Panel bottom(Frame f) {
		TextField tf= new TextField();
		Label d = new Label("입력",Label.CENTER);
		Panel p_B = new Panel(new BorderLayout());
		
		p_B.add(d,BorderLayout.WEST);
		p_B.add(tf,BorderLayout.CENTER);
		f.add(p_B);
		return p_B;
	}
	public BaseBall() {
		Panel pC = new Panel(new BorderLayout());
		pC.add(bottom(this),BorderLayout.SOUTH);
		
		TextArea ta= new TextArea();
		pC.add(ta);
		
		add(pC,BorderLayout.CENTER);
		add(rightPenl(this),BorderLayout.EAST);
		
		setBounds(480, 270, 500, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BaseBall();
	}//end main

}

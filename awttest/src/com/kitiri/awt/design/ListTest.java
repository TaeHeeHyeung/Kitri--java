package com.kitiri.awt.design;

import java.awt.*;

public class ListTest extends Frame {

	int width;
	int height;
	public static Panel leftPanel(Frame f) {
		Panel pL = new Panel(new BorderLayout());
		List list = new List(8);
		list.add("Mercury");
		list.add("Venus");
		list.add("Earth");
		list.add("JavaSoft");
		list.add("Mars");
		list.add("Jupiter");
		list.add("Saturn");
		list.add("Uranus");
		list.add("Neptune");
		list.add("Pluto");
		list.setSize(200, 300);
		pL.add(list);
		TextField tfL = new TextField();
		pL.add(list, BorderLayout.CENTER);
		pL.add(tfL, BorderLayout.SOUTH);
		return pL;
	}// end leftP

	public static Panel rightPanel(Frame f) {
		Panel pR = new Panel(new BorderLayout());
		TextArea listR = new TextArea();
		TextField tfR = new TextField();
		pR.add(listR, BorderLayout.CENTER);
		pR.add(tfR, BorderLayout.SOUTH);
		
		return pR;
	}// end rightPanel

	public static Panel centerPanel(Frame f) {
		Panel pC = new Panel(new GridLayout(6, 1,0 ,10));
		Button btR = new Button("▷");
		Button btRAll = new Button("▶");
		Button btL = new Button("◁");
		Button btLALL = new Button("◀");
		Font fC = new Font("굴림", Font.BOLD, 20);
		btR.setFont(fC);
		pC.add(new Label());
		//위에서부터 하나 씩
		
		pC.add(btR);
		pC.add(btRAll);
		pC.add(btL);
		pC.add(btLALL);
		return pC;
	}// end centerpanel

	//배치작업
	public ListTest() {
		setLayout(new GridLayout(1,3,50,10));
		
		add(leftPanel(this));
		add(centerPanel(this));
		add(rightPanel(this));
		
		
		setBounds(480, 270, 1000, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListTest();
	}

}

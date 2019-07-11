package com.kitiri.awt.design;

import java.awt.*;

public class Calculator extends Frame{
	String [] str= {"7","8","9","+",
			 "4","5","6","-",
			 "1","2","3","*",
			 "0","c","=","/"};
	String [][] str2= {{"7","8","9","+"},
			{"4","5","6","-"},
			{"1","2","3","*"},
			{"0","c","=","/"}
	};
	Button[] btn = new Button[16];
	Panel pN = new Panel(new BorderLayout());
	Label numL= new Label("numL",Label.CENTER);
	Panel pS = new Panel(new BorderLayout());
	Panel pC = new Panel(new GridLayout(4,4,10,10));
	Font f = new Font("���",Font.BOLD,10);
	
	public Calculator() {
		
		Dimension di = new Dimension();
		di.height =100;
		di.width =500;
				
		numL.setMinimumSize(di);
		pN.add(numL,BorderLayout.CENTER);
		
		pN.setFont(f);
		Label openL= new Label("openL",Label.CENTER);
		pN.add(openL,BorderLayout.EAST);
		add(pN,BorderLayout.NORTH);
		
		//0 ~ 255 / str.length
		//
		//����
		for(int i=0; i<str.length; i++) {
			btn[i]= new Button(str[i]);
			pC.add(btn[i]);
			btn[i].setBackground(new Color(125,125,125));
		}
		add(pC,BorderLayout.CENTER);
		
		Button exit = new Button("����");
		pS.add(exit,BorderLayout.CENTER);
		add(pS,BorderLayout.SOUTH);
		
		setBounds(480, 270, 200, 300);
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Calculator();
		
	}//end main
}


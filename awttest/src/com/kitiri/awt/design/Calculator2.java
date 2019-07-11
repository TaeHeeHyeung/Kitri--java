package com.kitiri.awt.design;

import java.awt.*;

public class Calculator2 extends Frame{
	String [][] str= {
			{"7","8","9","+"},
			{"4","5","6","-"},
			{"1","2","3","*"},
			{"0","c","=","/"}
	};
	Button[][] btn = new Button[4][4];
	Panel pN = new Panel(new BorderLayout(10,0));
	Panel pS = new Panel(new BorderLayout());
	Panel pC = new Panel(new GridLayout(4,4,10,10));
	Font f = new Font("°íµñ",Font.BOLD,10);
	Label numL= new Label("numL",Label.CENTER);
	Label openL= new Label("openL",Label.CENTER);
	Button exit = new Button("Á¾·á");
	
	public Calculator2() {
		setLayout(new BorderLayout(0,10));
		numL.setBackground(Color.GRAY);
		openL.setBackground(Color.GRAY);
		
		pN.setFont(f);
		pN.add(numL,BorderLayout.CENTER);
		pN.add(openL,BorderLayout.EAST);
		
		add(pN,BorderLayout.NORTH);
		
		int maxColor = 125;
		int color = maxColor/(str.length*2-1);
		for(int i=0; i<str.length; i++) {
			for(int j=0; j<str[i].length; j++) {
				btn[i][j]= new Button(str[i][j]);
				pC.add(btn[i][j]);
				btn[i][j].setBackground(new Color(color *(i+j)+maxColor,0,color*(i+j)+maxColor));
			}	
		}//end for
		
		add(pC,BorderLayout.CENTER);
		pS.add(exit,BorderLayout.CENTER);
		add(pS,BorderLayout.SOUTH);
		
		setBounds(480, 270, 200, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Calculator2();
		
	}//end main
	
}


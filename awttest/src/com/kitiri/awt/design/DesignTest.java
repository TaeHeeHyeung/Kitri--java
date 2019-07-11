package com.kitiri.awt.design;

import java.awt.*;

//ctrl +shift + O
//Window -> Preference -> Java -> CodeStyle -> Organize -> numberOf imports needs for 개수 설정: 최대 임포트 개수가 설정된다.


//1. Frame 상속
//2. 선언부에 필요한 객체 생성.
//3. 배치부에서 design 
//** 작업은 소 >> 대
public class DesignTest extends Frame {
	// 선언부
	// 패널은 디폴트생성자가 있지만 배치부에서 지정해주는게
	Panel pN = new Panel();
	Panel pS = new Panel();

	Label l = new Label("입력", Label.CENTER);
	TextField tf = new TextField();
	Button btn = new Button("전송");

	TextArea ta = new TextArea();

	Choice ch = new Choice();
	Button exit = new Button("종료");

	// 배치부
	public DesignTest() {
		super("Design Test !!!");
		pN.setLayout(new BorderLayout(10,0));//컴포넌트간의 차이만 떨어진다.
		l.setBackground(new Color(210, 210, 150));
		l.setForeground(new Color(255,255,255));
		
		Font f = new Font("굴림", Font.BOLD, 20);//자바가 인식할 수 있는 글꼴
		l.setFont(f);
		tf.setFont(f);
		btn.setFont(f);
		
		setLayout(new BorderLayout(0,10));
		pN.add(l, BorderLayout.WEST);
		pN.add(tf, BorderLayout.CENTER);
		pN.add(btn, BorderLayout.EAST);

		pS.setLayout(new GridLayout(1, 2,20,0));
		ch.add("서울");
		ch.add("경기");
		ch.add("춘천");
		pS.add(ch);
		pS.add(exit);

		add(pN, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(pS, BorderLayout.SOUTH);

		setBounds(300, 200, 300, 500);
		setResizable(false);
//		setLocation(300, 200);
//		setSize(300, 400);
		setVisible(true);// 가장 마지막 줄에 입력
	}

	public static void main(String[] args) {
		// 익명 객체생성 (해당 객체의 매소드를 사용할 일이 없기 때문에)
		new DesignTest();

	}// end main

}// end class

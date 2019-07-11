package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;
//-- 저녁 --
//1. 사과 : 먹었다
//2. 바나나 : 안먹었다.
//3. 딸기 : 안먹었다.
//
//종료 창 닫기 
//
//액션소스 : 8개
//
//체크6 아이템 리스너
//초이스1 
//버튼1 액션 리스너

public class ItemTest extends Frame {
	//private은 해당 클래스의 특징을 외부에서 접근하지 못하게할 때 막는다 
	
	Panel pN = new Panel(new GridLayout(2, 3, 10, 10));
	Panel pS = new Panel(new BorderLayout());
	
	CheckboxGroup cg = new CheckboxGroup();
	
	Button exit = new Button("종료");
	Choice ch = new Choice();
	TextArea ta = new TextArea();
	Checkbox[] checkBoxArr = new Checkbox[3];
	Checkbox mor = new Checkbox("아침", cg, true);
	Checkbox aft = new Checkbox("점심", cg, false);
	Checkbox eve = new Checkbox("저녁", cg, false);
	Checkbox app = new Checkbox("사과", true);
	Checkbox banana = new Checkbox("바나나");
	Checkbox straw = new Checkbox("딸기");
	
	ItemLogic itemLogic;
	
	public ItemTest() {
		super("아이템 테스트");
		// frame의 defaultLayout은 BorderLayout 이다.
		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		pN.add(app);
		pN.add(banana);
		pN.add(straw);

		ch.add("아침");
		ch.add("점심");
		ch.add("저녁");
		pS.add(ch, BorderLayout.CENTER);
		pS.add(exit, BorderLayout.EAST);

		checkBoxArr[0] = new Checkbox("아침");
		checkBoxArr[1] = new Checkbox("점심");
		checkBoxArr[2] = new Checkbox("저녁");
		
		setLayout(new BorderLayout(0, 10));
		add(pN, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(pS, BorderLayout.SOUTH);

		setBounds(480, 270, 500, 500);
		setVisible(true);
		
		itemLogic = new ItemLogic(this); 
		
		exit.addActionListener(itemLogic);
		mor.addItemListener(itemLogic);
		aft.addItemListener(itemLogic);
		eve.addItemListener(itemLogic);
		app.addItemListener(itemLogic);
		banana.addItemListener(itemLogic);
		straw.addItemListener(itemLogic);
		ch.addItemListener(itemLogic);
	}// end ItemTest


	public static void main(String[] args) {
		new ItemTest();
	}
}
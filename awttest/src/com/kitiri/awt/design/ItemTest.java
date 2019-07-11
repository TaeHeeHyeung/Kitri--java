package com.kitiri.awt.design;

import java.awt.*;

public class ItemTest extends Frame {
	Panel pN = new Panel(new GridLayout(2, 3, 10, 10));
	Panel pS = new Panel(new BorderLayout());

	public ItemTest() {
		super("아이템 테스트");
		// frame의 defaultLayout은 BorderLayout 이다.
		CheckboxGroup cg = new CheckboxGroup();
		Checkbox mor = new Checkbox("아침", cg, true);
		Checkbox aft = new Checkbox("점심", cg, false);
		Checkbox eve = new Checkbox("저녁", cg, false);
		
		Checkbox app = new Checkbox("사과",true);
		Checkbox banana = new Checkbox("바나나");
		Checkbox straw = new Checkbox("딸기");

		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		pN.add(app);
		pN.add(banana);
		pN.add(straw);

		Choice ch = new Choice();
		ch.add("아침");
		ch.add("점심");
		ch.add("저녁");
		pS.add(ch, BorderLayout.CENTER);
		pS.add(new Button("종료"), BorderLayout.EAST);

		Checkbox[] checkBoxArr = new Checkbox[3];

		checkBoxArr[0] = new Checkbox("아침");
		checkBoxArr[1] = new Checkbox("점심");
		checkBoxArr[2] = new Checkbox("저녁");
		setLayout(new BorderLayout(0, 10));
		add(pN, BorderLayout.NORTH);
		add(new TextArea(), BorderLayout.CENTER);
		add(pS, BorderLayout.SOUTH);

		setBounds(480, 270, 500, 500);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ItemTest();
	}

}
//pN.add(new Checkbox("아침", cbg, true));
//pN.add(new Checkbox("점심", cbg, false));
//pN.add(new Checkbox("저녁", cbg, false));
//pN.add(new Checkbox("사과", cbg, true));
//pN.add(new Checkbox("바나나", cbg, false));
//pN.add(new Checkbox("딸기", cbg, false));
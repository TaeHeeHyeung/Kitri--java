package com.kitiri.awt.design;

import java.awt.*;

public class ItemTest extends Frame {
	Panel pN = new Panel(new GridLayout(2, 3, 10, 10));
	Panel pS = new Panel(new BorderLayout());

	public ItemTest() {
		super("������ �׽�Ʈ");
		// frame�� defaultLayout�� BorderLayout �̴�.
		CheckboxGroup cg = new CheckboxGroup();
		Checkbox mor = new Checkbox("��ħ", cg, true);
		Checkbox aft = new Checkbox("����", cg, false);
		Checkbox eve = new Checkbox("����", cg, false);
		
		Checkbox app = new Checkbox("���",true);
		Checkbox banana = new Checkbox("�ٳ���");
		Checkbox straw = new Checkbox("����");

		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		pN.add(app);
		pN.add(banana);
		pN.add(straw);

		Choice ch = new Choice();
		ch.add("��ħ");
		ch.add("����");
		ch.add("����");
		pS.add(ch, BorderLayout.CENTER);
		pS.add(new Button("����"), BorderLayout.EAST);

		Checkbox[] checkBoxArr = new Checkbox[3];

		checkBoxArr[0] = new Checkbox("��ħ");
		checkBoxArr[1] = new Checkbox("����");
		checkBoxArr[2] = new Checkbox("����");
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
//pN.add(new Checkbox("��ħ", cbg, true));
//pN.add(new Checkbox("����", cbg, false));
//pN.add(new Checkbox("����", cbg, false));
//pN.add(new Checkbox("���", cbg, true));
//pN.add(new Checkbox("�ٳ���", cbg, false));
//pN.add(new Checkbox("����", cbg, false));
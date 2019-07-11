package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;
//-- ���� --
//1. ��� : �Ծ���
//2. �ٳ��� : �ȸԾ���.
//3. ���� : �ȸԾ���.
//
//���� â �ݱ� 
//
//�׼Ǽҽ� : 8��
//
//üũ6 ������ ������
//���̽�1 
//��ư1 �׼� ������

public class ItemTest extends Frame {
	//private�� �ش� Ŭ������ Ư¡�� �ܺο��� �������� ���ϰ��� �� ���´� 
	
	Panel pN = new Panel(new GridLayout(2, 3, 10, 10));
	Panel pS = new Panel(new BorderLayout());
	
	CheckboxGroup cg = new CheckboxGroup();
	
	Button exit = new Button("����");
	Choice ch = new Choice();
	TextArea ta = new TextArea();
	Checkbox[] checkBoxArr = new Checkbox[3];
	Checkbox mor = new Checkbox("��ħ", cg, true);
	Checkbox aft = new Checkbox("����", cg, false);
	Checkbox eve = new Checkbox("����", cg, false);
	Checkbox app = new Checkbox("���", true);
	Checkbox banana = new Checkbox("�ٳ���");
	Checkbox straw = new Checkbox("����");
	
	ItemLogic itemLogic;
	
	public ItemTest() {
		super("������ �׽�Ʈ");
		// frame�� defaultLayout�� BorderLayout �̴�.
		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		pN.add(app);
		pN.add(banana);
		pN.add(straw);

		ch.add("��ħ");
		ch.add("����");
		ch.add("����");
		pS.add(ch, BorderLayout.CENTER);
		pS.add(exit, BorderLayout.EAST);

		checkBoxArr[0] = new Checkbox("��ħ");
		checkBoxArr[1] = new Checkbox("����");
		checkBoxArr[2] = new Checkbox("����");
		
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
package com.kitiri.awt.design;

import java.awt.*;

//ctrl +shift + O
//Window -> Preference -> Java -> CodeStyle -> Organize -> numberOf imports needs for ���� ����: �ִ� ����Ʈ ������ �����ȴ�.


//1. Frame ���
//2. ����ο� �ʿ��� ��ü ����.
//3. ��ġ�ο��� design 
//** �۾��� �� >> ��
public class DesignTest extends Frame {
	// �����
	// �г��� ����Ʈ�����ڰ� ������ ��ġ�ο��� �������ִ°�
	Panel pN = new Panel();
	Panel pS = new Panel();

	Label l = new Label("�Է�", Label.CENTER);
	TextField tf = new TextField();
	Button btn = new Button("����");

	TextArea ta = new TextArea();

	Choice ch = new Choice();
	Button exit = new Button("����");

	// ��ġ��
	public DesignTest() {
		super("Design Test !!!");
		pN.setLayout(new BorderLayout(10,0));//������Ʈ���� ���̸� ��������.
		l.setBackground(new Color(210, 210, 150));
		l.setForeground(new Color(255,255,255));
		
		Font f = new Font("����", Font.BOLD, 20);//�ڹٰ� �ν��� �� �ִ� �۲�
		l.setFont(f);
		tf.setFont(f);
		btn.setFont(f);
		
		setLayout(new BorderLayout(0,10));
		pN.add(l, BorderLayout.WEST);
		pN.add(tf, BorderLayout.CENTER);
		pN.add(btn, BorderLayout.EAST);

		pS.setLayout(new GridLayout(1, 2,20,0));
		ch.add("����");
		ch.add("���");
		ch.add("��õ");
		pS.add(ch);
		pS.add(exit);

		add(pN, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(pS, BorderLayout.SOUTH);

		setBounds(300, 200, 300, 500);
		setResizable(false);
//		setLocation(300, 200);
//		setSize(300, 400);
		setVisible(true);// ���� ������ �ٿ� �Է�
	}

	public static void main(String[] args) {
		// �͸� ��ü���� (�ش� ��ü�� �żҵ带 ����� ���� ���� ������)
		new DesignTest();

	}// end main

}// end class

package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//����Ʈ R ���߼���
//����
//�о�鼭 ����

public class ListTest extends Frame implements ActionListener {

	int width;
	int height;
	Panel pC = new Panel(new GridLayout(6, 1, 0, 10));
	Font fc = new Font("����", Font.BOLD, 20);

	Panel pL = new Panel(new BorderLayout());
	List listL = new List();
	List listR = new List(0, true);
	Panel pR = new Panel(new BorderLayout());
	
	
	TextField tfR = new TextField();
	TextField tfL = new TextField();
	Button btR = new Button("��");
	Button btRAll = new Button("��");
	Button btL = new Button("��");
	Button btLAll = new Button("��");
	
	public Panel leftPanel(Frame f) {
		listL.setSize(200, 300);
		pL.add(listL);
		pL.add(listL, BorderLayout.CENTER);
		pL.add(tfL, BorderLayout.SOUTH);
		return pL;
	}// end leftP

	public Panel rightPanel(Frame f) {

		pR.add(listR, BorderLayout.CENTER);
		pR.add(tfR, BorderLayout.SOUTH);
		return pR;
	}// end rightPanel

	public Panel centerPanel(Frame f) {

		btR.setFont(fc);
		pC.add(new Label());
		// ���������� �ϳ� ��
		pC.add(btR);
		pC.add(btRAll);
		pC.add(btL);
		pC.add(btLAll);
		return pC;
	}// end centerpanel

	// ��ġ�۾�
	public ListTest() {
		setLayout(new GridLayout(1, 3, 50, 10));

		add(leftPanel(this));
		add(centerPanel(this));
		add(rightPanel(this));

		setBounds(480, 270, 500, 300);
		setVisible(true);
		
		tfL.addActionListener(this);
		tfR.addActionListener(this);
		btR.addActionListener(this);
		btRAll.addActionListener(this);
		btL.addActionListener(this);
		btLAll.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob ==tfL) {
			String tmp =tfL.getText().trim();
			tfL.setText("");
			if(tmp.isEmpty()) {
				return;
			}
			listL.add(tmp);
			tfL.setText("");
		}else if(ob ==tfR) {
			String tmp =tfR.getText().trim();
			tfR.setText("");
			if(tmp.isEmpty()) {
				return;
			}
			listR.add(tmp);
			tfR.setText("");
		}else if(ob ==btL) {
			String tmp = listR.getSelectedItem();
			if(tmp == null) {
				return;
			}
			listL.add(tmp);
			listR.remove(tmp);
			
		}else if(ob ==btLAll) {
			String[] strArr = listR.getSelectedItems();
			if(strArr == null) {
				return;
			}
			int len = strArr.length;
			for (int i = 0; i < len; i++) {
				listL.add(strArr[i]);
				listR.remove(strArr[i]);;
			}
		}else if(ob ==btR) {
			String tmp = listL.getSelectedItem();
			if(tmp == null) {
				return;
			}
			listR.add(tmp);
			listL.remove(tmp);
		}else if(ob ==btRAll) {
			String[] tmp = listL.getItems();
			int len = tmp.length;
			for(int i=0; i<len; i++) {
				listR.add(tmp[i]);
			}
//			for (int i = len-1; i >= 0; i--) {
//				listL.remove(i);
//			}
			listL.removeAll();
			
		}
	}//end actionPerformed

	public static void main(String[] args) {
		new ListTest();
	}
}


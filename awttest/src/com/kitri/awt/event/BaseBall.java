package com.kitri.awt.event;

import java.awt.*;

public class BaseBall extends Frame  {
//	com.kitri.ribrary.member
//	com.kitri.ribrary.admin
	
	Panel p_E = new Panel(new GridLayout(5, 1, 0, 10));
	Panel pC = new Panel(new BorderLayout());
	Panel p_S = new Panel(new BorderLayout());
	// �̺�Ʈ�ҽ� 6��
	Button newG = new Button("������");
	Button clear = new Button("�����");
	Button dap = new Button("����");
	Button fontC = new Button("��Ʈ��");
	Button exit = new Button("����");
	TextField tf = new TextField();
	
	TextArea ta = new TextArea();
	
	BaseBallController baseBallController;
	FontColorChooser fontColorChooser= new FontColorChooser();
	

	public BaseBall() {
		Label d = new Label("�Է�", Label.CENTER);

		p_S.add(d, BorderLayout.WEST);
		p_S.add(tf, BorderLayout.CENTER);
		pC.add(p_S, BorderLayout.SOUTH);
//		ta.setFont(new Font(name, Font.BOLD, 10));
		ta.setEditable(false);
//		ta.setEnabled(false);
		pC.add(ta);

		add(pC, BorderLayout.CENTER);
		p_E.add(newG);
		p_E.add(clear);
		p_E.add(dap);
		p_E.add(fontC);
		p_E.add(exit);
		add(p_E, BorderLayout.EAST);

		setBounds(480, 270, 500, 500);
		setVisible(true);

		baseBallController = new BaseBallController(this);		
		
		
		//BaseBall â �̺�Ʈ ���
		newG.addActionListener(baseBallController);
		clear.addActionListener(baseBallController);
		dap.addActionListener(baseBallController);
		fontC.addActionListener(baseBallController);
		exit.addActionListener(baseBallController);
		tf.addActionListener(baseBallController);

		//FontColorChooserâ �̺�Ʈ ���
		fontColorChooser.sbR.addAdjustmentListener(baseBallController);
		fontColorChooser.sbG.addAdjustmentListener(baseBallController);
		fontColorChooser.sbB.addAdjustmentListener(baseBallController);
		fontColorChooser.ok.addActionListener(baseBallController);
		
		fontColorChooser.addWindowListener(baseBallController);
		this.addWindowListener(baseBallController);
		
		
	}



	public static void main(String[] args) {
		new BaseBall();
	}// end main

}

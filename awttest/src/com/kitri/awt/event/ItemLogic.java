package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

public class ItemLogic implements ItemListener, ActionListener {
	ItemTest itemTest;
	
	public ItemLogic(ItemTest itemTest) {
		super();
		this.itemTest= itemTest;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// �̺�Ʈ�ҽ��� ���̽����
		Object ob = e.getSource();
		// �̷������ �ּҰ� �񱳰� �´�.
		if (ob == itemTest.ch) {
			String str = itemTest.ch.getSelectedItem();
			if (str.equals("��ħ")) {
				itemTest.mor.setState(true);
			} else if (str.equals("����")) {
				itemTest.aft.setState(true);
			} else {
				itemTest.eve.setState(true);
			}
		}

		// üũ�ڽ�
		Checkbox sel = itemTest.cg.getSelectedCheckbox();
		String selStr = sel.getLabel();
		itemTest.ta.setText("---" + selStr + "---");
		itemTest.ta.append("\n1. ��� " + eat(itemTest.app.getState()));
		itemTest.ta.append("\n2. �ٳ��� " + eat(itemTest.banana.getState()));
		itemTest.ta.append("\n3. ���� " + eat(itemTest.straw.getState()));
		itemTest.ch.select(selStr);
	}// end itemStateChanged
	private String eat(boolean flag) {
		return flag ? "�Ծ����ϴ�." : "�ȸԾ����ϴ�.";
	}

}

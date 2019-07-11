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
		// 이벤트소스가 초이스라면
		Object ob = e.getSource();
		// 이런경우라면 주소값 비교가 맞다.
		if (ob == itemTest.ch) {
			String str = itemTest.ch.getSelectedItem();
			if (str.equals("아침")) {
				itemTest.mor.setState(true);
			} else if (str.equals("점심")) {
				itemTest.aft.setState(true);
			} else {
				itemTest.eve.setState(true);
			}
		}

		// 체크박스
		Checkbox sel = itemTest.cg.getSelectedCheckbox();
		String selStr = sel.getLabel();
		itemTest.ta.setText("---" + selStr + "---");
		itemTest.ta.append("\n1. 사과 " + eat(itemTest.app.getState()));
		itemTest.ta.append("\n2. 바나나 " + eat(itemTest.banana.getState()));
		itemTest.ta.append("\n3. 딸기 " + eat(itemTest.straw.getState()));
		itemTest.ch.select(selStr);
	}// end itemStateChanged
	private String eat(boolean flag) {
		return flag ? "먹었습니다." : "안먹었습니다.";
	}

}

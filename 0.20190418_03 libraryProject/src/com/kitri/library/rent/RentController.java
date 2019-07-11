package com.kitri.library.rent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RentController implements ActionListener {
	Rent rent;
	RentService rentService;

	public RentController(Rent rent) {
		this.rent = rent;
		rentService = new RentService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == rent.bt_bookISBN) {
			rentService.checkAbleRent();
		} else if (obj == rent.bt_rent) {
			rentService.rentProcess();
		} else if (obj == rent.bt_cancel) {
			rentService.close();
		} else if (obj == rent.bt_choice) {
			rentService.addTable();
		}
	}

}

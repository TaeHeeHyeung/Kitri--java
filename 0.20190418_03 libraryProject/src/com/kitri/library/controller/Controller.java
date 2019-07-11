package com.kitri.library.controller;

import java.awt.Color;
import java.awt.event.*;
import java.util.List;

import javax.swing.JOptionPane;

import com.kitri.library.db.MenagerDao;
import com.kitri.library.db.MenagerDto;
import com.kitri.library.main.login.LoginFailedDialog;
import com.kitri.library.main.start.StartTest;

public class Controller {

	private StartTest uiManager;
	private Service service;
	// Main pMain;
	LoginFailedDialog loginFailedDialog = new LoginFailedDialog();

	public Controller(StartTest mUiManager) {
		this.uiManager = mUiManager;
		// pMain= mUiManager.pMain;
		service = new Service(uiManager);

	}

	public Service getService() {
		return service;
	}

	
}

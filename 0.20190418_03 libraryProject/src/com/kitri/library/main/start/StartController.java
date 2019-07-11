package com.kitri.library.main.start;

import java.awt.Color;
import java.awt.event.*;

import com.kitri.library.main.main.MainTest;

public class StartController {
	public StartTest pStartManager;
	public StartService service;
//	public Login pLogin;
	public MainTest pMain;
	
	
	public StartController(StartTest startManager) {
		super();
		this.pStartManager = startManager;
		this.pMain = startManager.pMainTest;
		
		this.service = new StartService(this);
	}

}

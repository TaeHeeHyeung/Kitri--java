package com.kitri.test6;

public class TVProgram {
	private String title;
	private String broadcase; 
	public TVProgram(String title, String broadcase) {
		super();
		this.title = title;
		this.broadcase = broadcase;
	}

	@Override
	public String toString() {
		return  title + " ("+broadcase + ")\n";
	}
	
}

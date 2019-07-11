package com.kitri.test6;

public class Drama extends TVProgram {

	private String director;
	private String actor;
	private String actress;

	public Drama(String title, String broadcase, String director, String actor, String actress) {
		super(title, broadcase);		
		this.director = director;
		this.actor = actor;
		this.actress = actress;
	}

	public Drama(String director, String actor, String actress) {
		super("","");
		this.director = director;
		this.actor = actor;
		this.actress = actress;
	}

	@Override
	public String toString() {
		String str = "";
		if (!director.trim().equals("")) {
			str += "\t - 감독 : " + director + "\n";
		}
		if (!actor.trim().equals("")) {
			str += "\t - 남자배우 : " + actor + "\n";
		}
		if (!actress.trim().equals("")) {
			str += "\t - 여자배우 : " + actress + "\n";
		}
		return super.toString() + str;
	}

}

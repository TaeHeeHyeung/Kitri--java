package com.kitri.array;
// Dto : Data Transfer Object
// Db에 insert같은거 할 때 사용
// Vo : Value Object
// Bean :	
//1번 투수, 2 포수, 1루수, 2루수, 3루수, 유격수 , 외야수(좌익수, 중견수, 우익수)
	//1~9
	//지명타자 0
	//총 10명
	
	//타율, 방어율 
	//린드블럼은 방어율 (투수니까)
public class PlayerDto {
	private int number; //pk
	private String name;
	private int position;
	private double grade;
	private static final String[] POSITION_STR= {"지명타자", "투수", "포수", "1루수", "2루수", "3루수" ,"유격수", "좌익수", "중견수", "우익수" };
	


	public int register() {
		return number;
	}

	public PlayerDto(int number, String name, int position, double grade) {
		super();
		this.number = number;
		this.name = name;
		this.position = position;
		this.grade = grade;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {

		String pStr = POSITION_STR[position];
		String gStr = "타율";
		if(position == 1) {
			gStr = "방어율";
		}
		return "PlayerDto [등번호=" + number + ",\t 선수명=" + name + 
				",\t 포지션=" + pStr + ",\t "+((position !=1)?"타율":"방어율")+ "=" + grade + "]";
	}
	
}//end PlayerDto





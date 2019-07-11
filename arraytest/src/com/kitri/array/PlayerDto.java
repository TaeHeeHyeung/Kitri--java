package com.kitri.array;
// Dto : Data Transfer Object
// Db�� insert������ �� �� ���
// Vo : Value Object
// Bean :	
//1�� ����, 2 ����, 1���, 2���, 3���, ���ݼ� , �ܾ߼�(���ͼ�, �߰߼�, ���ͼ�)
	//1~9
	//����Ÿ�� 0
	//�� 10��
	
	//Ÿ��, ����� 
	//������� ����� (�����ϱ�)
public class PlayerDto {
	private int number; //pk
	private String name;
	private int position;
	private double grade;
	private static final String[] POSITION_STR= {"����Ÿ��", "����", "����", "1���", "2���", "3���" ,"���ݼ�", "���ͼ�", "�߰߼�", "���ͼ�" };
	


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
		String gStr = "Ÿ��";
		if(position == 1) {
			gStr = "�����";
		}
		return "PlayerDto [���ȣ=" + number + ",\t ������=" + name + 
				",\t ������=" + pStr + ",\t "+((position !=1)?"Ÿ��":"�����")+ "=" + grade + "]";
	}
	
}//end PlayerDto





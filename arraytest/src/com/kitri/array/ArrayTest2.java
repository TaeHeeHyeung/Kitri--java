package com.kitri.array;

public class ArrayTest2 {
	public static void main(String[] args) {
		Car car[] = new Car[6];
		car[0] = new Car("Cupe", "����", "����");
		car[1] = new Car("�Ÿ", "������", "���");
		car[2] = new Car("K5", "���", "�Ｚ");
		car[3] = new Car("�ƹݶ�", "����", "����");
		car[4] = new Car("�Ͼ��", "��ѱ��", "���");
		car[5] = new Car("��Ÿ��", "������", "����");
		
		for(int i=0; i<car.length; i++) {
			System.out.println(i+1+"��°����: "+car[i].toString());
		}
		
		String name ="�Ͼ��";
//		String name ="QM5";
		boolean isExsist= false;
		//�Ȱ��� �̸��� �ڵ����� ���ٶ�� �����Ͽ�.
		for(int i=0; i<car.length; i++) {
			if(car[i].getCarName().equals(name)  ) {
				System.out.println(car[i].getColor()+" "+name +"�� "+(i+1)+"��°�� �ֽ��ϴ�.");
				isExsist= true;
				break; //�������� ���� ���� (���� �迭�� ���̰� ��� ���ɿ� ū ������ ��ĥ �� ���ִ�.
			}
		}//end for
		if(isExsist==false) {
			System.out.println("QM5�� �����ϴ�.");	
		}
		
		
		//�� Ǯ�� ��ü�� ������ ������.
		Car c= null;
		int count=0;
		//�Ȱ��� �̸��� �ڵ����� ���ٶ�� �����Ͽ�.
		for(int i=0; i<car.length; i++) {
			if(car[i].getCarName().equals(name)  ) {
				c= car[i];
				count = i+1;
				isExsist= true;
				break; //�������� ���� ���� (���� �迭�� ���̰� ��� ���ɿ� ū ������ ��ĥ �� �ִ�.)
			}
		}//end for
		if(c != null) {
			System.out.println("QM5�� �����ϴ�.");	
		}else {
			System.out.println(c.getColor()+" "+name +"�� "+(count)+"��°�� �ֽ��ϴ�.");
		}
		
	}//end main


}


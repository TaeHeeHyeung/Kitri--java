package com.kitri.test;
import com.kitri.car.Car;
import com.taehee.Calcurator;

public class CarUser {
	
	public static void main(String[] args) {
		Calcurator calcurator =new Calcurator();
		Car car = new Car("�Ÿ", "������", "����");
		System.out.println("�̸� :"+ car.getName());
		System.out.println("���� :"+ car.getColor());
		System.out.println("������ :"+ car.getMaker());
		System.out.println(car);
		calcurator.plus(1, 2);
	}

}

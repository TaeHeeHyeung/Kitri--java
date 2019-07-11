package com.kitri.test;
import com.kitri.car.Car;
import com.taehee.Calcurator;

public class CarUser {
	
	public static void main(String[] args) {
		Calcurator calcurator =new Calcurator();
		Car car = new Car("쏘나타", "검정색", "현대");
		System.out.println("이름 :"+ car.getName());
		System.out.println("색상 :"+ car.getColor());
		System.out.println("제조사 :"+ car.getMaker());
		System.out.println(car);
		calcurator.plus(1, 2);
	}

}

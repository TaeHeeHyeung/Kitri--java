/*
1. ���
	�⺻���(basicPrice)
		�Ϲ�: 3800
		�ɾ�: 5000
	��� ��(totalPrice):
	��� (price)
	�Ϲ� : 100/km
	�ɾ� : 150/km

2. ��� ���(calcPrice())
3. 	�ɾ����� :0��~ 6��
*/
import java.util.*;
public class Taxi extends Car{
	int basicPrice; 
	int totalPrice;
	int price;
	int hour;

	public Taxi(){
		super();
		basicPrice= 3800;
	}

	public Taxi(String carName, String color,String maker){ 
		super(carName, color, maker);
		basicPrice= 3800;
	}


	//����� ������ �� ��� ���� ����
	void initPrice(){
		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
	}

	int calcPrice(int km){
		if(hour >0 && hour <6){
			//�ɾ߿��
			basicPrice = 5000;
			price = km * 150+basicPrice;
			totalPrice+= price;
		}else{
			//�Ϲݿ��
			basicPrice = 3800;
			price = km * 100+basicPrice;
			totalPrice+= price;
		}
		return price;
	}


}//end class

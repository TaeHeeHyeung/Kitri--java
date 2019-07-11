/*
1. 요금
	기본요금(basicPrice)
		일반: 3800
		심야: 5000
	요금 합(totalPrice):
	요금 (price)
	일반 : 100/km
	심야 : 150/km

2. 요금 계산(calcPrice())
3. 	심야할증 :0시~ 6시
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


	//계산을 시작할 때 요금 기준 설정
	void initPrice(){
		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
	}

	int calcPrice(int km){
		if(hour >0 && hour <6){
			//심야요금
			basicPrice = 5000;
			price = km * 150+basicPrice;
			totalPrice+= price;
		}else{
			//일반요금
			basicPrice = 3800;
			price = km * 100+basicPrice;
			totalPrice+= price;
		}
		return price;
	}


}//end class

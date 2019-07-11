/*
1. 반지름 : radius
2.	넓이 calcArea()
	둘레 calcRound()
*/

public class Circle {
	int radius;
	final double PI = Math.PI;
	Circle(){
		this(4);
	}
	Circle(int radius){
		this.radius= radius;
	}
	public double calcArea(){
		return PI*Math.power(radius,2);
	}
	public double calcRound(){
		return 2*PI*radius;
	}
	public String info(){
		return "반지름이 "+radius+"인 원의 넓이는"+ calcArea()+"이고 둘레는"+ calcRound()+"입니다.";
	}
}//end class

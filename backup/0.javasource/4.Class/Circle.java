/*
1. ������ : radius
2.	���� calcArea()
	�ѷ� calcRound()
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
		return "�������� "+radius+"�� ���� ���̴�"+ calcArea()+"�̰� �ѷ���"+ calcRound()+"�Դϴ�.";
	}
}//end class

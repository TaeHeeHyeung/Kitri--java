/*
1.	���� width(4), ���� height(3)
2.	���� calcArea()
	�ѷ� calcRound()
*/

public class Rect {
	int width;
	int height;
	Rect(){
		this(4,3);
	}
	Rect(int width ,int height){
		this.width = width;
		this.height = height;
	}
	int calcArea( ){
		return width*height;
	}
	int calcRound(){
		return 2*(width+height);
	}
	String info(){
		return "���ΰ� "+width+"�̰� ���ΰ� "+height+"�� �簢���� ���̴�"+calcArea()+"�̰� �ѷ��� "+calcRound()+"�Դϴ�.";
	}
}//end class

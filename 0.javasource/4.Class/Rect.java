/*
1.	가로 width(4), 세로 height(3)
2.	넓이 calcArea()
	둘레 calcRound()
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
		return "가로가 "+width+"이고 세로가 "+height+"인 사각형의 넓이는"+calcArea()+"이고 둘레는 "+calcRound()+"입니다.";
	}
}//end class

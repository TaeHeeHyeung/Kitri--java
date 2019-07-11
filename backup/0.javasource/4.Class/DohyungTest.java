/*
1. 가로, 세로
*/

public class DohyungTest {
	public static void main(String[] args) {
		//default 4,3
		//가로가 4이고 세로가 3인 사각형의 넓이는12이고 둘레는 14입니다.
		Rect r1= new Rect();
		System.out.println(r1.info());


		Rect r2 = new Rect(5,5);//입력 지정
		System.out.println(r2.info());
		//가로가 w이고 세로가 h인 사각형의 넓이는 x이고 둘레는 x입니다.

		Circle c1=new Circle();
		System.out.println(c1.info());
		//반지름이 4인 원의 넓이는48.xxx이고 둘레는 24.xxx입니다.

		Circle c2=new Circle(5);
		System.out.println(c2.info());
		//반지름이 r인 원의 넓이는.xxx이고 둘레는 .xxx입니다.


		
	}//end main
}//end class

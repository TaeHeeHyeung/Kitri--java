public class DohyungTest {
	public static void main(String[] args) {
		Rect r1 = new Rect(4,5);
		System.out.println(	"가로가"+r1.width+"세로가"+r1.height+"인 사각형의 넓이는"+
		r1.getArea()+"이고 둘레는"+r1.getRound()) ;
	
		Circle c1 = new Circle(4);
		System.out.println(	"반지름이"+c1.r+"인 사각형의 넓이는"+
		c1.getArea()+"이고 둘레는"+c1.getRound()) ;


//		Dohyung d1 = new Rect(3,4);
		//에러
		//System.out.println(	"가로가"+d2.width+"세로가"+d2.height+"인 사각형의 넓이는"+
		//d2.getArea()+"이고 둘레는"+d2.getRound()) ;
		//정상작동
//		System.out.println(	"도형의 넓이는"+d1.getArea()+"이고 둘레는"+d1.getRound()) ;
		// 부모 클래스로 자식 클래스가 할당한 메모리를 참조하도록 하면
		// 부모 클래스의 추상 메소드는 자식클래스에서 재정의하면서 자식클래스의 메소드를 참조하게된다.
		// 그렇기에 부모 클래스로 참조하여 추상 메소드를 호출해도 에러가 나지 않는다.
		// 추상메소드가 아닌 일반 상속도 오버라이드되면 오버라이드 된 내용이 호출된다.

//		Rect r2 = (Rect) d1;

		//실행에러
//		Circle c2 = (Circle) d1;




	}//end main
}//end class

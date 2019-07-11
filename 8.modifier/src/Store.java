public class Store {
	public static void main(String[] args) {
		
		PointCard p1 = new PointCard("박미래");
		PointCard p2 = new PointCard("황선혜");
		int point;
		point = p1.visit();
		point = p2.visit();
		p1.infoPoint();
		p2.infoPoint();
		point =p2.visit();
		p2.infoPoint();
		System.out.println("-------------------------------------------------");
		System.out.println("객체생성하기전에"+Guest.cnt);
		Guest g1= new Guest("박미래");
		Guest g2= new Guest("황선혜");
		int count =0;
		count = g1.visit();
		g1.infoVisit();
		System.out.println(	Guest.cnt+"번째 접근");
		count = g2.visit();
		g2.infoVisit();
		System.out.println(	Guest.cnt+"번째 접근");
		//static 값이 변해도 다른 매개변수에 영향을 미치지 않을 때 사용한다.
		//static 매소드에서 non-static 변수를 호출할 수 없다.(static의 영역이 다르기 때문에
		
	}//end main	
}//end class


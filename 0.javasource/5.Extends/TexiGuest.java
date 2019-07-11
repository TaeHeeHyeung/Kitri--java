

public class TexiGuest {
	public static void main(String[] args) {
		Taxi t1= new Taxi() ;
		System.out.println( t1.info() +" 요금"+t1.basicPrice);

		Taxi t2= new Taxi("K5", "감홍색", "기아") ;
		System.out.println( t2.info() );

		int km = 20;
		t2.initPrice();
		System.out.println(t2.info()+ "를 타고 구디에서 강남까지 "+ km + "km이동!!!");
		int price = t2.calcPrice(km);
		System.out.println("요금"+price+"원");
		System.out.println("누적 수입"+t2.totalPrice+"원");

		km = 20;
		System.out.println(t2.info()+ "를 타고 강남에서 구디까지 "+ km + "km이동!!!");
				t2.initPrice();
		price = t2.calcPrice(km);
		System.out.println("요금"+price+"원");

		System.out.println("누적 수입"+t2.totalPrice+"원");
	}//end main
}//end class

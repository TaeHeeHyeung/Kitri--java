

public class TexiGuest {
	public static void main(String[] args) {
		Taxi t1= new Taxi() ;
		System.out.println( t1.info() +" ���"+t1.basicPrice);

		Taxi t2= new Taxi("K5", "��ȫ��", "���") ;
		System.out.println( t2.info() );

		int km = 20;
		t2.initPrice();
		System.out.println(t2.info()+ "�� Ÿ�� ���𿡼� �������� "+ km + "km�̵�!!!");
		int price = t2.calcPrice(km);
		System.out.println("���"+price+"��");
		System.out.println("���� ����"+t2.totalPrice+"��");

		km = 20;
		System.out.println(t2.info()+ "�� Ÿ�� �������� ������� "+ km + "km�̵�!!!");
				t2.initPrice();
		price = t2.calcPrice(km);
		System.out.println("���"+price+"��");

		System.out.println("���� ����"+t2.totalPrice+"��");
	}//end main
}//end class

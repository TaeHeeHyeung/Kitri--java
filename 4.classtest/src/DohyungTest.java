/*
1. ����, ����
*/

public class DohyungTest {
	public static void main(String[] args) {
		//default 4,3
		//���ΰ� 4�̰� ���ΰ� 3�� �簢���� ���̴�12�̰� �ѷ��� 14�Դϴ�.
		Rect r1= new Rect();
		System.out.println(r1.info());


		Rect r2 = new Rect(5,5);//�Է� ����
		System.out.println(r2.info());
		//���ΰ� w�̰� ���ΰ� h�� �簢���� ���̴� x�̰� �ѷ��� x�Դϴ�.

		Circle c1=new Circle();
		System.out.println(c1.info());
		//�������� 4�� ���� ���̴�48.xxx�̰� �ѷ��� 24.xxx�Դϴ�.

		Circle c2=new Circle(5);
		System.out.println(c2.info());
		//�������� r�� ���� ���̴�.xxx�̰� �ѷ��� .xxx�Դϴ�.


		
	}//end main
}//end class

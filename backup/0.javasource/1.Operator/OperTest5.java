public class OperTest5 {
	public static void main(String[] args) {
		int x = 0;
		System.out.println("1. x = " + x);

		x = 10;
		System.out.println("2. x = " + x);

		x += 5; // x= x+5
		System.out.println("3. x = " + x);

		x -= 5; // x= x-5
		System.out.println("4. x = " + x);

		x *= 5; // x= x*5
		System.out.println("5. x = " + x);

		x /= 5; // x= x/5
		System.out.println("6. x = " + x);

		x = 10;
		//x �� ���� 1 ������Ű�� ���
		x++;
		++x;
		x+=1;
		x = x+1;
		
		int z = 0 / 10;
		//���� ���� (�������� ��)
		//int z = 10 / 0;

	}
}

public class OperTest1 
{
	public static void main(String[] args) 
	{
		int x= 10;
		System.out.println(x);
		System.out.println(x++);
		System.out.println(--x);
		System.out.println(x++);
		System.out.println(++x);
		System.out.println(x--);
		System.out.println(--x);
		System.out.println(x++);
		System.out.println(x);
		
		char c= 'a';
		System.out.println("c == "+c);
		System.out.println("c == " + (int)c);


		int i48 =48;
		System.out.println("c == " + (char)i48);



		//������ ����: ���� ��������� ū ��������� �����ؼ�
		//c = y;
		//System.out.println("c ==" + c );

		//�ڵ�����ȯ
		int y =c;
		System.out.println("c == " + (char)i48);

		//��������ȯ
		c = (char)y;
		System.out.println("c ==" + c );

		//true�� 0�̳� 1�� �ƴϴ�.
		//������ ���� : ������������ ū �������� ���������� true�� �ƽ�Ű�ڵ尪�� �ƴ϶� ������ �Ұ����ϴ�
		//					Ÿ�԰����� �������ĸ� �ڵ�����ȯ ����
		//boolean b = true; 
		//int z = b;

		int z =30;
		double d =z;
		//z = d; //error 
		z = (int) d;
		// ����ȯ 
		// 1. ���� Ÿ���ΰ�?
		// 2. ��������� ����Ѱ�?


	}
}

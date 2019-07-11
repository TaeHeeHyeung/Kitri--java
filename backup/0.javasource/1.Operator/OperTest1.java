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



		//컴파일 에러: 작은 저장공간에 큰 저장공간을 저장해서
		//c = y;
		//System.out.println("c ==" + c );

		//자동형변환
		int y =c;
		System.out.println("c == " + (char)i48);

		//강제형변환
		c = (char)y;
		System.out.println("c ==" + c );

		//true는 0이나 1이 아니다.
		//컴파일 에러 : 작은공간에서 큰 공간으로 저장하지만 true는 아스키코드값이 아니라 저장이 불가능하다
		//					타입공간이 같은형식만 자동형변환 가능
		//boolean b = true; 
		//int z = b;

		int z =30;
		double d =z;
		//z = d; //error 
		z = (int) d;
		// 형변환 
		// 1. 같은 타입인가?
		// 2. 저장공간이 충분한가?


	}
}

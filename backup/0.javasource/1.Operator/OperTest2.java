public class OperTest2 
{
	public static void main(String[] args) 
	{
		int num1 = 13;
		int num2 = 5;
		int num3 = num1 + num2;
		System.out.println(num1 + "+" + num2 + "=" + num3);
		System.out.println(num1 + "+" + num2 + "=" + (num1 + num2) ); //¼ıÀÚ µ¡¼À
	    System.out.println(num1 + "+" + num2 + "=" + num1 + num2 ); // ¹®ÀÚ µ¡¼À
		//System.out.println(num1 + "+" + num2 + "=" + num1 - num2 ); //¿À·ù

		//°ö¼À ³ª´°¼À ³ª¸ÓÁö´Â +º¸´Ù ¸ÕÀú ½ÇÇà
		num3 = num1 * num2;
		System.out.println(num1 + "*" + num2 + "=" + num3);  
		System.out.println(num1 + "*" + num2 + "=" +  num1 * num2); 

		num3 = num1 / num2;
		System.out.println(num1 + "/" + num2 + "=" + num3);  
		System.out.println(num1 + "/" + num2 + "=" +  num1 / num2); 

		num3 = num1 % num2;
		System.out.println(num1 + "%" + num2 + "=" +  num3); 
		System.out.println(num1 + "%" + num2 + "=" +  num1 % num2); 
	}
}

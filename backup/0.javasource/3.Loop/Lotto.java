public class Lotto {
	public static void main(String[] args) {
		int num1, num2, num3;
		num1 = (int) (Math.random()*3 + 1); // 1~3
		num2= -1;
		num3= -1;
		do{
			num2 = (int) (Math.random()*3 + 1); // 1~3
		}while(num2==num1);
		do{
			num3 = (int) (Math.random()*3 + 1); // 1~3
		}while(num3==num1 || num3==num2);
		System.out.println("금주의 당첨 번호: "+num1+" "+num2+" "+num3);

	}//end main
}//end class

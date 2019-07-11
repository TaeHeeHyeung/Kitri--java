/*
1 - 3 까지의 (서로 다른) 난수 3개 발생.
*/

public class WhileLotto {
	public static void main(String[] args) {
		int num1, num2, num3;

		num1 = (int) (Math.random()*3 + 1); // 1~3
		num2= -1;
		num3= -1;
		while(true){
			num2 = (int) (Math.random()*3 + 1); // 1~3
			if(num2!=num1){
				break;
			}
		}
		while(true){
			num3 = (int) (Math.random()*3 + 1); // 1~3
			if(num3!=num1 && num3!=num2){
				break;
			}
		}
		System.out.println("금주의 당첨 번호: "+num1+" "+num2+" "+num3);
		//비효율적 코드 
			num1 = (int) (Math.random()*3 + 1); 
			num2=  (int) (Math.random()*3 + 1);
			num3 = (int) (Math.random()*3 + 1); 
		while(true){
			num1 = (int) (Math.random()*3 + 1); 
			num2=  (int) (Math.random()*3 + 1);
			num3 = (int) (Math.random()*3 + 1); 
			if(num3!=num1 && num3!=num2 && num1!=num2){
				break;
			}
		}//end while
		System.out.println("금주의 당첨 번호: "+num1+" "+num2+" "+num3);
	}//end main
}

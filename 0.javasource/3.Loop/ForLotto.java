/*
1 - 3 까지의 (서로 다른) 난수 3개 발생.
*/

public class ForLotto {
	public static void main(String[] args) {
//		int num1, num2, num3;
//효율적 코드
		int num1 = (int) (Math.random()*3 + 1); // 1~3
		int num2 = -1;
		int num3 = -1;
		if(num1 ==1){
			num2=(int) (Math.random()*2 + 2); // 2~3
			if( num2 ==2){
				num3=3;
			}else{
				num3=2;
			}
		}else if(num1==3){
			num2=(int) (Math.random()*2 + 1); // 1~2
			if( num2 ==1){
				num3=2;
			}else{
				num3=1;
			}
		}else if(num1==2){
			num2=(int) (Math.random()*2 + 1); // 1~2
			if(num2 ==1){
				num3= 3;
			}else{
				num3 =1;
				num2= 3;
			}
		}
//비효율적 코드, 다른 값이 동시에 다 안나오면 각 수마다 랜덤함수가 다 실행된다.
		System.out.println("금주의 당첨 번호: "+num1+" "+num2+" "+num3);
		num1 = (int) (Math.random()*3 + 1); // 1~3
		num2= -1;
		num3= -1;
		for(;;){
			num2 = (int) (Math.random()*3 + 1); // 1~3
			if(num2!=num1){
				break;
			}
		}
		for(;;){
			num3 = (int) (Math.random()*3 + 1); // 1~3
			if(num3!=num1 && num3!=num2){
				break;
			}
		}
		System.out.println("금주의 당첨 번호: "+num1+" "+num2+" "+num3);
		for(;;){
			num1 = (int) (Math.random()*3 + 1); 
			num2=  (int) (Math.random()*3 + 1);
			num3 = (int) (Math.random()*3 + 1); 
			if(num3!=num1 && num3!=num2 && num1!=num2){
				break;
			}
		}
		System.out.println("금주의 당첨 번호: "+num1+" "+num2+" "+num3);
	}//end main
}

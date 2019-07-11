public class WhileTest1 {
	public static void main(String[] args) {
		System.out.println("1~10까지 출력");
		int i=0;
		while(i++< 10){
			System.out.println(i);
		}
		
		//횟수는 정해져있지 않고 조건만 있는 문제
		System.out.println("1~10까지 수 중 난수 발생");
		boolean flag= true;
		int count = 1;
		while( flag){
			int number =(int)(Math.random()*11);
			if(number!=0){
				count++;
				System.out.println("number == " +number+" count "+count);
			}else{
				flag= false;
			}
		}//end while flag
		System.out.println("0 이"+count+"번 째 발생하였다");

	}//end main
}//end main class

public class WhileTest1 {
	public static void main(String[] args) {
		System.out.println("1~10���� ���");
		int i=0;
		while(i++< 10){
			System.out.println(i);
		}
		
		//Ƚ���� ���������� �ʰ� ���Ǹ� �ִ� ����
		System.out.println("1~10���� �� �� ���� �߻�");
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
		System.out.println("0 ��"+count+"�� ° �߻��Ͽ���");

	}//end main
}//end main class

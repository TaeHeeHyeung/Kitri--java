public class  forTest1{
	public static void main(String[] args) {
		System.out.println("1~10 ���� ���");
		for(int i=1;i <11; i++){
			System.out.print(i+" \t");
		}

		System.out.println("1~10���� (Ȧ����)");
		for(int i=1;i <11; i++){
			if(i%2==1){
				System.out.print(i+" ");	
			}
		}
		//���������ڸ� Ȱ���� �ݺ��� Ƚ�� ���̱�
		for(int i=1;i <11; i+=2){
			System.out.print(i+" ");	
		}

		//i�� ����ó������ ���� ����ϴ°Ͱ� �ڿ� ����ϴ°��� ���̰� �ִ�.
		System.out.println();
		System.out.println("1~100���� (10�� ���� �� �ٲ�)");
		for(int i=1;i <=100; i++){
			System.out.print(i+" ");	
			if(i%10==0 ){
				System.out.println(" ");	
			}
		}


		System.out.println("���α׷� ����");
	}//end main
}

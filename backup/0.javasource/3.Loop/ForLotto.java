/*
1 - 3 ������ (���� �ٸ�) ���� 3�� �߻�.
*/

public class ForLotto {
	public static void main(String[] args) {
//		int num1, num2, num3;
//ȿ���� �ڵ�
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
//��ȿ���� �ڵ�, �ٸ� ���� ���ÿ� �� �ȳ����� �� ������ �����Լ��� �� ����ȴ�.
		System.out.println("������ ��÷ ��ȣ: "+num1+" "+num2+" "+num3);
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
		System.out.println("������ ��÷ ��ȣ: "+num1+" "+num2+" "+num3);
		for(;;){
			num1 = (int) (Math.random()*3 + 1); 
			num2=  (int) (Math.random()*3 + 1);
			num3 = (int) (Math.random()*3 + 1); 
			if(num3!=num1 && num3!=num2 && num1!=num2){
				break;
			}
		}
		System.out.println("������ ��÷ ��ȣ: "+num1+" "+num2+" "+num3);
	}//end main
}

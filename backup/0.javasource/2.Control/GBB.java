/**
 ���� ���� �� ����.
 1. 0 (����)  1 (����) 2 (��)
 2. ��ǻ�� : ���� (0, 1, 2)
 3. ��� logic �̱�, ��, ���
 4. ��� ���
 ��: �� 2, ��: ���� 1	    ���: �̰��.
 ��: �� 2, ��: ��	   2		���: ����.
 ��: �� 2, ��: ���� 0		���: ����.
 
 ��� 3������ 33.3...%�� �����ϴ�.
 �̷� ��� ��Ģ�� �����Ѵ�.
*/


public class GBB {
	public static void main(String[] args) {
		int my = 1;
		//(int) (Math.random()*3)
		int com = 2;
		if(my == com){
			System.out.println("com: "+com+ " my: "+my+" ����.");
		}else if(my == 0 && com == 2){
			System.out.println("com: "+com+ " my: "+my+" �̰��.");
		}else if(my == 2 && com == 0){
			System.out.println("com: "+com+ " my: "+my+" ����.");
		}else if( my > com ){
			System.out.println("com: "+com+ " my: "+my+" �̰��.");
		}else {
			System.out.println("com: "+com+ " my: "+my+" ����.");
		}
// �� ������ ����Ű��
		if(my == com){
			System.out.println("com: "+com+ " my: "+ my +" ����.");
		}else if(my > com  &&  (my != 2 || com !=0) || (my == 0 && com ==2) ) {
 			System.out.println("com: "+com+ " my: "+ my +" �̰��.");
		}else  {
 			System.out.println("com: "+com+ " my: "+ my +" ����.");
		}
// �� Ǯ�� my - com ��� ���� ���� ���ԵǾ���. �̸� ����� ��ȯ �� ��Ģ�� ã�´�.
		String result;	
		if(my==com ){
			result ="����";
		}else if((my-com+3) % 3==1 ){ //3�����ϱ� ��� 2�� ���ص� ������
			result ="�̰��.";
		}else{
 			result ="����.";
		}
		//�ʱ�ȭ �������
		String myStr="";
		switch(my){
			case 0: myStr= "����";
				break;
			case 1: myStr= "����";
				break;
			case 2: myStr= "��";
				break;
		}
		//�ʱ�ȭ �������
		String comStr="";
		switch(com){
			case 0: comStr= "����";
				break;
			case 1: comStr= "����";
				break;
			case 2: comStr= "��";
				break;
		}
 		System.out.println("�� "+ myStr+ " �� "+comStr +" ��� "+result);
	}//main
}

//java SE  : developer edition
//	   EE  : serverSide edition 
//	   ME : micro edition (������� ���� ���� �Ƚ�)





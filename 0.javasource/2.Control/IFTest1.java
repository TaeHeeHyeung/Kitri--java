public class  IFTest1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 70;
		if(x >y){
			System.out.println("x�� ũ�� ");
		}


		int jumin = 2;
		if(jumin%2 ==0){
			System.out.println("�����Դϴ�.");
		}
		if(jumin%2 ==1){
			System.out.println("�����Դϴ�.");
		}

		String gender = (jumin%2==1)? "����" :"����";
		System.out.println(gender+ "�Դϴ�.");


		//������ Ư���� Ȱ���� ���� ��� ���
		gender ="����";
		if(jumin%2 ==0){
			gender ="����";
		}
		System.out.println(gender+ "�Դϴ�.");


		System.out.println("���α׷� ����˴ϴ�.");
	}
}

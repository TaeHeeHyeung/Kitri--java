public class SwitchTest1 {
	public static void main(String[] args) {
		int num = 3;
		switch(num){
			case 1: System.out.println("1�Դϴ�.");
					break;
			case 2: System.out.println("2�Դϴ�.");
					break;
			case 3: System.out.println("3�Դϴ�.");
					break;
			default : System.out.println("123�Դϴ�.");
					break;
		}
		System.out.println("���α׷� ����");

		char c= 'a';
		switch(c){
			case 97: System.out.println("�ƽ�Ű�ڵ�'a'�Դϴ�.");break;
			case 98: System.out.println("�ƽ�Ű�ڵ�'b'�Դϴ�.");break;
		}

		//jdk 7�̻���������� switch�� �ȿ��� ���ڿ� �� ��밡��.
		String str= "java";
		switch(str){
			case "oracle": System.out.println("oracle");break;
			case "java": System.out.println("java");break;
			case "jsp": System.out.println("jsp");break;
			default : System.out.println("���ξƴմϴ�.");
		}


	}//end main
}

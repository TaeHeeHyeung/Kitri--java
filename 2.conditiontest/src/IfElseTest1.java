public class IfElseTest1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 11;
		/*
		if(x>y){
			System.out.println( x+ "�� "+ y+ "���� ũ��");
		}else{
			System.out.println( x+ "�� "+ y+ "���� �۴�");
		}
		*/
		// ���� ���� ��쵵 �ֱ� ������ �ΰ����� ���� ��������Ѵ�.
		String comp= "ũ��";
		if(x<y){
			comp ="�۴�";
		}else{
			comp ="����";
		}

		System.out.println( x+ "�� "+ y+ "����" +comp);
///////////////////////////////////////////////////////////////////////////
// ũ�� �۴� => ���� �� �� �����
// ���� =>�����
// ���ٸ� ���� ���ִ°� ���ɻ� ����.
		if(x==y){
			comp ="����";
		}else{
			if(x>y){
				comp ="ũ��";
			}
			else{
				comp ="�۴�";
			}
		}
		System.out.println( x+ "�� "+ y+ "����" +comp);


		System.out.println("���α׷� ����!!!!");
	}
}

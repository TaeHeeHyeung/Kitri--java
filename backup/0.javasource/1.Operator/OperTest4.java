public class OperTest4 {
	public static void main(String[] args) {
		int jumin = 2;
		String gender =(jumin %2==0) ?"����": "����" ;
		System.out.println("�ֹι�ȣ�� "+jumin+"�� ����� "+ gender+ "�Դϴ�");

		// ������ 80�̻��̸� �հ�, 80�̸��̸� ���հ�
		// �׷��Ƿ� ����� ������ xx�̹Ƿ� xx�Դϴ�.
		int score = 80;
		int myScore= 100;
		String pass = (myScore >= score) ? "�հ�" :"���հ�";

		System.out.println("������" +score+" �̻��̸� �հ�"+ score+"�̸��̸� ���հ�");
		System.out.println("�׷��Ƿ� ����� ������ "+myScore +"�̹Ƿ� "+ pass+ "�Դϴ�.");

		score = 70;
	}
}


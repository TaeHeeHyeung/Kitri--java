public class Store {
	public static void main(String[] args) {
		
		PointCard p1 = new PointCard("�ڹ̷�");
		PointCard p2 = new PointCard("Ȳ����");
		int point;
		point = p1.visit();
		point = p2.visit();
		p1.infoPoint();
		p2.infoPoint();
		point =p2.visit();
		p2.infoPoint();
		System.out.println("-------------------------------------------------");
		System.out.println("��ü�����ϱ�����"+Guest.cnt);
		Guest g1= new Guest("�ڹ̷�");
		Guest g2= new Guest("Ȳ����");
		int count =0;
		count = g1.visit();
		g1.infoVisit();
		System.out.println(	Guest.cnt+"��° ����");
		count = g2.visit();
		g2.infoVisit();
		System.out.println(	Guest.cnt+"��° ����");
		//static ���� ���ص� �ٸ� �Ű������� ������ ��ġ�� ���� �� ����Ѵ�.
		//static �żҵ忡�� non-static ������ ȣ���� �� ����.(static�� ������ �ٸ��� ������
		
	}//end main	
}//end class


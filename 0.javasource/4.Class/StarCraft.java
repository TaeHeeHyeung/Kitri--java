public class StarCraft {
	public static void main(String[] args){
		Marine my = new Marine();
		Marine com = new Marine();

		System.out.println("�� ü��: "+my.getHp()+" �� ü��: "+com.getHp());
		//�� ü��: 100 �� ü��: 100

		int count = 2;
		System.out.println("���� ���� "+count+"ȸ ����!!!!");
		com.attacked(my.attack(count));
		System.out.println("�� ü��: "+my.getHp()+" �� ü��: "+com.getHp());
		//�� ü��: 100 �� ü��: 80

		count = 4;
		System.out.println("���� ���� "+count+"ȸ ����!!!!");
		my.attacked(com.attack(count));
		System.out.println("�� ü��: "+my.getHp()+" �� ü��: "+com.getHp());
		//�� ü��: 60 �� ü��: 80

		//��� ����
		System.out.println(my.modeChange());
		System.out.println("�� ü��: "+my.getHp()+" �� ü��: "+com.getHp());
		//�� ü��: 35 �� ü��: 80

		count = 3;
		System.out.println("���� ���� "+count+"ȸ ����!!!!");
		com.attacked(my.attack(count));
		//�� ü��: 35 �� ü��: 35
		System.out.println("�� ü��: "+my.getHp()+" �� ü��: "+com.getHp());


		System.out.println(com.modeChange());
		//���: ��带 ���� �Ұ�!!!
		//�� ü��: 35 �� ü��: 35

		count = 3;
		System.out.println("���� ���� "+count+"ȸ ����!!!!");
		com.attacked(my.attack(count));
		System.out.println("�� ü��: "+my.getHp()+" �� ü��: "+ com.getHp());
		//�� ü��: 35 �� ü��: die


	}
}//end class

/*
ü�� ,���ݷ�, ���

���� ���
 �����Ѵ�.
 ��带 Ų��

�� ������ ü�� +num �ø���.
ü���� �ø��� ���
�������κ��� �Ű����� num�� �޾Ƽ� 
�� ������ ü���� 10 �ø���.

*/
public class Marine {
	int hp;
	int power;
	int mode;
	Marine(int hp, int power, int mode){
		this.hp= hp;
		this.power= power;
		this.mode= mode;
	}

	public void hpUp( int num ){
		this.hp = this.hp+num;
	}
	
	//�ٸ� ������ ü���� num ���ҽ��Ѷ�
	//�Ű����� Marine other, int num
	//�żҵ�� attack
	//���ϰ� ����

	public void attack(Marine other, int num){
		other.hp -= num
	}

}//end class

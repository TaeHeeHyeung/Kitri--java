/*
hp: ü�� 100
power: ���ݷ� 10
mode: 0 �Ϲݸ�� 1 ���ݸ��
		ü�� 25 ���� ���ݷ�5����
		40 �����϶� ��� ���� �Ұ�
*/
public class Marine1 {
	int hp;
	int power;
	int mode;

	Marine1(){
		this(100,10,0);

	}
	Marine1(int hp, int power,int mode){
		this.hp = hp;
		this.power = power;
		this.mode= mode;
	}

	

	//for������ atkCnt�� ���ص��ȴ�.
	public void attack(Marine1 enemy,int atkCnt){
		enemy.hp -= (this.power*atkCnt);
	}

	public String modeChange(){
		if(mode == 0 && hp > 40){
			hp -= 25;
			power +=5;
			mode = 1;
				return "��� ����";
		}else{
				return "��� ���� �Ұ�!!!!";
		}
	}

	public String info(){
		return "ü��"+hp+"���ݷ�"+power+"������"+mode;
	}

	//�̷� ��� ���׿����ڸ� �������
	public String getHp(){
			if(this.hp <= 0){
			return "die";
		}
		return hp+"";
	}
	//�̰�ó��
	public String getStatus(){
		return (hp<0)? "die" :hp+"";
	}

}//end class

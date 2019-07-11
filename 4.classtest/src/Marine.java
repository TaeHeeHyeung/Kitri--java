/*
hp: ü�� 100
power: ���ݷ� 10
mode: 0 �Ϲݸ�� 1 ���ݸ��
		ü�� 25 ���� ���ݷ�5����
		40 �����϶� ��� ���� �Ұ�
*/


public class Marine {
	int hp;
	int power;
	int mode;

	Marine(){
		this(100,10,0);
	}
	Marine(int hp, int power,int mode){
		this.hp = hp;
		this.power = power;
		this.mode= mode;
	}

	public String getHp(){
			if(this.hp <= 0){
			return "die";
		}
		return hp+"";
	}

	public void attacked(int power){
		this.hp -= power;
	}

	public int attack(int atkCnt){
		return this.power*atkCnt;
	}

	public String modeChange(){
		if(mode == 0 &&hp > 40){
			hp -= 25;
			power +=5;
			mode = 1;
		}else{
				return "��� ���� �Ұ�!!!!";
		}
		return "��� ����";
	}
	public String info(){
		return "ü��"+hp+"���ݷ�"+power+"������"+mode;
	}
	
	



}//end class

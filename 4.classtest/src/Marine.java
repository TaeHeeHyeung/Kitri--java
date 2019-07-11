/*
hp: 체력 100
power: 공격력 10
mode: 0 일반모드 1 공격모드
		체력 25 감소 공격력5증가
		40 이하일때 모드 변경 불가
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
				return "모드 변경 불가!!!!";
		}
		return "모드 변경";
	}
	public String info(){
		return "체력"+hp+"공격력"+power+"모드상태"+mode;
	}
	
	



}//end class

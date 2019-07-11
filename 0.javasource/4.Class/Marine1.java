/*
hp: 체력 100
power: 공격력 10
mode: 0 일반모드 1 공격모드
		체력 25 감소 공격력5증가
		40 이하일때 모드 변경 불가
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

	

	//for문보다 atkCnt를 곱해도된다.
	public void attack(Marine1 enemy,int atkCnt){
		enemy.hp -= (this.power*atkCnt);
	}

	public String modeChange(){
		if(mode == 0 && hp > 40){
			hp -= 25;
			power +=5;
			mode = 1;
				return "모드 변경";
		}else{
				return "모드 변경 불가!!!!";
		}
	}

	public String info(){
		return "체력"+hp+"공격력"+power+"모드상태"+mode;
	}

	//이런 경우 삼항연산자를 사용하자
	public String getHp(){
			if(this.hp <= 0){
			return "die";
		}
		return hp+"";
	}
	//이것처럼
	public String getStatus(){
		return (hp<0)? "die" :hp+"";
	}

}//end class

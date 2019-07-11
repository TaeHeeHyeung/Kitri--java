/*
체력 ,공격력, 모드

마린 기능
 공격한다.
 모드를 킨다

내 마린의 체력 +num 올린다.
체력을 올리는 기능
메인으로부터 매개변수 num을 받아서 
내 마린의 체력을 10 올린다.

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
	
	//다른 마린의 체력을 num 감소시켜라
	//매개변수 Marine other, int num
	//매소드명 attack
	//리턴값 없음

	public void attack(Marine other, int num){
		other.hp -= num
	}

}//end class

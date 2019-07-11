public class StarCraft {
	public static void main(String[] args){
		Marine my = new Marine();
		Marine com = new Marine();

		System.out.println("내 체력: "+my.getHp()+" 적 체력: "+com.getHp());
		//내 체력: 100 적 체력: 100

		int count = 2;
		System.out.println("내가 적을 "+count+"회 공격!!!!");
		com.attacked(my.attack(count));
		System.out.println("내 체력: "+my.getHp()+" 적 체력: "+com.getHp());
		//내 체력: 100 적 체력: 80

		count = 4;
		System.out.println("적이 나를 "+count+"회 공격!!!!");
		my.attacked(com.attack(count));
		System.out.println("내 체력: "+my.getHp()+" 적 체력: "+com.getHp());
		//내 체력: 60 적 체력: 80

		//모드 변경
		System.out.println(my.modeChange());
		System.out.println("내 체력: "+my.getHp()+" 적 체력: "+com.getHp());
		//내 체력: 35 적 체력: 80

		count = 3;
		System.out.println("내가 적을 "+count+"회 공격!!!!");
		com.attacked(my.attack(count));
		//내 체력: 35 적 체력: 35
		System.out.println("내 체력: "+my.getHp()+" 적 체력: "+com.getHp());


		System.out.println(com.modeChange());
		//경고: 모드를 변경 불가!!!
		//내 체력: 35 적 체력: 35

		count = 3;
		System.out.println("내가 적을 "+count+"회 공격!!!!");
		com.attacked(my.attack(count));
		System.out.println("내 체력: "+my.getHp()+" 적 체력: "+ com.getHp());
		//내 체력: 35 적 체력: die


	}
}//end class

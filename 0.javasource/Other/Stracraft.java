/*
내 마린
컴퓨터 마린
*/

public class Stracraft {
	public static void main(String[] args) {
		Marine my= new Marine(100,10,0);
		Marine com= new Marine(100,10,0);

		System.out.println(my.hp );
		my.hpUp(10);
		System.out.println(my.hp );
		
		
	}//end main
}//end class

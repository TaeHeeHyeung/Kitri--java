public class IfElseTest1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 11;
		/*
		if(x>y){
			System.out.println( x+ "는 "+ y+ "보다 크다");
		}else{
			System.out.println( x+ "는 "+ y+ "보다 작다");
		}
		*/
		// 값이 같은 경우도 있기 때문에 두가지의 경우로 나누어야한다.
		String comp= "크다";
		if(x<y){
			comp ="작다";
		}else{
			comp ="같다";
		}

		System.out.println( x+ "는 "+ y+ "보다" +comp);
///////////////////////////////////////////////////////////////////////////
// 크다 작다 => 범위 비교 후 동등비교
// 같다 =>동등비교
// 같다를 먼저 써주는게 성능상 좋다.
		if(x==y){
			comp ="같다";
		}else{
			if(x>y){
				comp ="크다";
			}
			else{
				comp ="작다";
			}
		}
		System.out.println( x+ "는 "+ y+ "보다" +comp);


		System.out.println("프로그램 종료!!!!");
	}
}

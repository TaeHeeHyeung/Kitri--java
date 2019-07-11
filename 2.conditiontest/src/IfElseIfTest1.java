public class IfElseIfTest1 {
	public static void main(String[] args) {
		int x=10;
		int y=15;

		String comp;
		if( x==y){
			comp= "같다";
		}else if(x>y){
			comp = "크다";
		}else {
			comp = "작다";
		}
		System.out.println( x+ "는 "+ y+ "보다" +comp);



	}
}

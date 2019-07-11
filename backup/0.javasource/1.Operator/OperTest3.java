public class OperTest3 {
	public static void main(String[] args){
		int x =10;
		int y =15;
		int z =20;
		System.out.println(x + ">"+ y+":"+ (x > y));
		System.out.println(x + "=="+ y+"/2:"+ (x == z/2));

		System.out.println(x<y && y>z); // true , false  --> false
		System.out.println(x<y || y>z); // true , false -> true

	}//end main
}//end Oper

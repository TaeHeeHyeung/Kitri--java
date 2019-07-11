public class SwitchTest1 {
	public static void main(String[] args) {
		int num = 3;
		switch(num){
			case 1: System.out.println("1입니다.");
					break;
			case 2: System.out.println("2입니다.");
					break;
			case 3: System.out.println("3입니다.");
					break;
			default : System.out.println("123입니다.");
					break;
		}
		System.out.println("프로그램 종료");

		char c= 'a';
		switch(c){
			case 97: System.out.println("아스키코드'a'입니다.");break;
			case 98: System.out.println("아스키코드'b'입니다.");break;
		}

		//jdk 7이상버전에서는 switch문 안에서 문자열 비교 사용가능.
		String str= "java";
		switch(str){
			case "oracle": System.out.println("oracle");break;
			case "java": System.out.println("java");break;
			case "jsp": System.out.println("jsp");break;
			default : System.out.println("전부아닙니다.");
		}


	}//end main
}

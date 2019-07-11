public class SwitchTest2 {
	public static void main(String[] args) {

		// 조건이 많은 경우는 if문을 사용하고 
		// 간단한 경우 case를 사용하자
		int score = 99;
		String grade =" ";
		int div= score/10;
		switch (div){
			case 9: case 10:grade="A";break;
			case 8: grade="B";break;
			case 7: grade="C";break;
			case 6: grade="D";break;
			default: grade="F";break;
		}

		int mode= score%10;
		if(mode >5 && score>60 || score ==100){
			grade += "+";
		}

		System.out.println(grade);
	}
}

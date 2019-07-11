public class OperTest4 {
	public static void main(String[] args) {
		int jumin = 2;
		String gender =(jumin %2==0) ?"남자": "여자" ;
		System.out.println("주민번호가 "+jumin+"인 당신은 "+ gender+ "입니다");

		// 점수가 80이상이면 합격, 80미만이면 불합격
		// 그러므로 당신의 점수는 xx이므로 xx입니다.
		int score = 80;
		int myScore= 100;
		String pass = (myScore >= score) ? "합격" :"불합격";

		System.out.println("점수가" +score+" 이상이면 합격"+ score+"미만이면 불합격");
		System.out.println("그러므로 당신의 점수는 "+myScore +"이므로 "+ pass+ "입니다.");

		score = 70;
	}
}


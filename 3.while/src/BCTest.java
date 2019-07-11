public class BCTest {
	// 메인은 버츄얼머신이 호출한다.
	public static void main(String[] args) {
		int count = 0;
		while (count < 10) {
			count++;
			int number = (int) (Math.random() * 10);
			if (number == 0) {
				System.out.println("number 가 0이 나왔습니다. 프로그램을 종료합니다.");
				break;
			}
			System.out.println("number == " + number);
		} // end while

		count = 0;
		while (count < 10) {
			count++;
			int number = (int) (Math.random() * 10);
			if (number == 0) {
				System.out.println("number 가 0이 나왔습니다. 프로그램을 종료합니다.");
				continue;
			}
			System.out.println("number == " + number);
		} // end while

	}// end main
}// end class

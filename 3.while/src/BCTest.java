public class BCTest {
	// ������ �����ӽ��� ȣ���Ѵ�.
	public static void main(String[] args) {
		int count = 0;
		while (count < 10) {
			count++;
			int number = (int) (Math.random() * 10);
			if (number == 0) {
				System.out.println("number �� 0�� ���Խ��ϴ�. ���α׷��� �����մϴ�.");
				break;
			}
			System.out.println("number == " + number);
		} // end while

		count = 0;
		while (count < 10) {
			count++;
			int number = (int) (Math.random() * 10);
			if (number == 0) {
				System.out.println("number �� 0�� ���Խ��ϴ�. ���α׷��� �����մϴ�.");
				continue;
			}
			System.out.println("number == " + number);
		} // end while

	}// end main
}// end class

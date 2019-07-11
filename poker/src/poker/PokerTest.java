package poker;

//출력

// comCard : Space 1, ? ,? / Diamond 4, ?, ? / Clover 5, ?, ?
// myCard : Space 1, Space 4, Diamond 5
// 오픈시킬 카드를 선택하세요. (1 2 3)
// myCard : (Space 1), Space 4, Diamond 5

public class PokerTest {

	public static void main(String[] args) {
		Deck deck = new Deck();
		User user = new User();
		User com = new User();

		for (int i = 0; i < 3; i++) {
			user.setCard(deck.getCard());
			com.setCard(deck.getCard());
		}

		System.out.println(user.toString());
		System.out.println(com.toString());

	}// end main

}

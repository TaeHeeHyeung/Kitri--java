package poker;

public class User {
	private Card[] cards = new Card[10];
	private int cardCount = 0;

	public void setCard(Card card) {
		cards[cardCount++] = card;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < cardCount; i++) {
			str += cards[i].toString()+"\t";
		}
		return str;
	}// end toString

}

package poker;

public class Deck {
	

	public int[] shapesCount = new int[4];
	public int[] cardCount = new int[11];

	Card cards[] = new Card[52];
	int cardNum =52;
	// 4444 //모양개수
	// 4 4 4 4 4 4... 4 4 4 //숫자 개수
	public Deck() {
		for (int i = 0; i < shapesCount.length; i++) {
			shapesCount[i] = 4;
		}
		for (int i = 0; i < cardCount.length; i++) {
			cardCount[i] = 4;
		}
	}// end Deck()

	public Card getCard() {
		int shape = -1;
		int number = -1;
		
		if(cardNum <=0) {
			return null;
		}
		while (true) {
			int rSI = (int) (Math.random() * shapesCount.length) ;
			if (shapesCount[rSI] != 0) {
				shape = rSI;
				shapesCount[rSI]--;
				break;
			}
		}
		while(true) {
			int cI = (int) (Math.random() * cardCount.length) ;
			if (cardCount[cI] != 0) {
				number = cI;
				cardCount[cI]--;
				break;
			}
		}
		cardNum--;
		return new Card(shape, number);
	}// end shuple

}

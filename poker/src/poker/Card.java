package poker;

import java.util.Arrays;

public class Card {
	// 스 다 하 클
	public final static String[] SHAPES = { "SPACE", "DIA", "HART", "CLOVER" };
	// 1 A 11 J 12 Q 13K
	public final static int[] CARD_INDEX = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	int shape;
	int number;
	boolean cardStatusOpen;

	public Card(int shape, int number) {
		this.number = number;
		this.shape = shape;
	}

	@Override
	public String toString() {
		String str ="";
		String shape =SHAPES[this.shape];
		if(cardStatusOpen) {
			str += "[ "+number+" "+shape+" ]";	
		}else {
			str += number+" "+shape;
		}
		return str;
	}

}

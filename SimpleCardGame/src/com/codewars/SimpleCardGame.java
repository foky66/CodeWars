package com.codewars;

import java.util.HashMap;
import java.util.Map;

public class SimpleCardGame {
	public static void main(String[] args) {
		new SimpleCardGame().run();
	}

	public void run() {
		System.out.println(winner(new String[] { "T" }, new String[] { "T" }));
	}

	public String winner(String[] deckSteve, String[] deckJosh) {
		String[] cards = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A" };
		int steveScore = 0, joshScore = 0;
		Map<String, Integer> deck = new HashMap<String, Integer>();
		for (int value = 0; value < cards.length; value++) {
			deck.put(cards[value], value + 2);
		}
		for (int round = 0; round < deckSteve.length; round++) {
			if (deck.get(deckSteve[round]) < deck.get(deckJosh[round])) {
				joshScore++;
			} else if (deck.get(deckSteve[round]) == deck.get(deckJosh[round])) {
				continue;
			} else {
				steveScore++;
			}
		}
		if(joshScore == steveScore)return "Tie";
		return joshScore > steveScore ? String.format("Josh wins %d to %d", joshScore, steveScore) : String.format("Steve wins %d to %d", steveScore, joshScore);
	}
}

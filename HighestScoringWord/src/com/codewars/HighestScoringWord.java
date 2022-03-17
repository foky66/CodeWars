package com.codewars;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HighestScoringWord {
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(high("what time are we climbing up to the volcano"));
		long end = System.nanoTime();
		long exec = (end - start) / 10000 ;
		System.out.printf("Futási idő : %d%n" , exec);
		long start2 = System.nanoTime();
		System.out.println(high2("what time are we climbing up to the volcano"));
		long end2 = System.nanoTime();
		long exec2 = (end2 - start2) / 10000;
		System.out.println("Futási idő : " + exec2);
	}

	public static String high(String s) {
		String highScoreWord = "";
		Map<Character, Integer> lettersScore = createLetterScore();
		int wordScore = 0, bestScore = 0;
		for (String word : s.split(" ")) {
			for (int i = 0; i < word.length(); i++) {
				wordScore += lettersScore.get(word.charAt(i));
			}
			if (bestScore < wordScore) {
				bestScore = wordScore;
				highScoreWord = word;
			}
			wordScore = 0;
		}
		return highScoreWord;
	}

	private static Map<Character, Integer> createLetterScore() {
		Map<Character, Integer> lettersScore = new HashMap<Character, Integer>();
		for (int i = 0, ch = 97, value = 1; i < 26; i++, ch++, value++) {
			lettersScore.put((char) ch, value);
		}
		return lettersScore;
	}
	
	public static String high2(String s) {
	    return Arrays.stream(s.split(" "))
	                .max(Comparator.comparingInt(
	                        a -> a.chars().map(i -> i - 96).sum()
	                )).get(); 
	  }
}

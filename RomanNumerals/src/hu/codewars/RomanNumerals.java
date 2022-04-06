package hu.codewars;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanNumerals {
	private static final List<Integer> DECIMAL = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
	private static final List<String> ROMAN = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV",
			"I");

	public static void main(String[] args) {
		System.out.println(toRoman(4));
		System.out.println(fromRoman("IX"));
	}

	public static String toRoman(int n) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < DECIMAL.size(); i++) {
			while (n >= DECIMAL.get(i)) {
				n -= DECIMAL.get(i);
				out.append(ROMAN.get(i));
			}
		}
		return out.toString();
	}

	public static int fromRoman(String romanNumeral) {
		Map<String, Integer> values = new HashMap<String, Integer>();
		for (int i = 0; i < DECIMAL.size(); i++) {
			values.put(ROMAN.get(i), DECIMAL.get(i));
		}
		int out = 0;
		String[] array = romanNumeral.split("");
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1 && values.get(array[i]) < values.get(array[i + 1])) {
				out += values.get(array[i + 1]) - values.get(array[i]);
				i++;
			} else {
				out += values.get(array[i]);
			}

		}
		return out;
	}

}

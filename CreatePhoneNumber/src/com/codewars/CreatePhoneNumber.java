package com.codewars;

import java.util.Arrays;

public class CreatePhoneNumber {
	
	public static void main(String[] args) {
		System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));;
	}
	
	public static String createPhoneNumber(int[] numbers) {
	    String rawNumber = Arrays.toString(numbers).replaceAll("\\D", "");
	    return String.format("(%s) %s-%s", rawNumber.substring(0,3),rawNumber.substring(3,6),rawNumber.substring(6,rawNumber.length()));
	  }

}

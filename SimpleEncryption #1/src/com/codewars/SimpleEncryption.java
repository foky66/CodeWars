package com.codewars;

public class SimpleEncryption {
	public static void main(String[] args) {
		System.out.println(encrypt("This is a test!", 2));
		System.out.println(decrypt("s eT ashi tist!", 2));
	}

	public static String encrypt(final String text, final int n) {
		String even = "", odd = "";
		if (n == 0 || text == null || n < 0)
			return text;
		for (int i = 0; i < text.length(); i++) {
			if (i % 2 == 0)
				even += text.charAt(i);
			else
				odd += text.charAt(i);
		}
		return n == 1 ? odd + even : encrypt(odd + even, n - 1);
	}

	public static String decrypt(final String encryptedText, final int n) {
		String decrypted = "";
		if (n == 0 || encryptedText == null || n < 0)
			return encryptedText;
		final int step = encryptedText.length() / 2;
		for (int i = 0; i < step; i++) {
			decrypted += encryptedText.charAt(step + i);
			decrypted += encryptedText.charAt(i);
		}
		if (encryptedText.length() % 2 == 1)
			decrypted += encryptedText.charAt(encryptedText.length() - 1);
		return n == 1 ? decrypted : decrypt(decrypted, n - 1);
	}

}

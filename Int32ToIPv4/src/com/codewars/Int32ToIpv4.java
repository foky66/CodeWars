package com.codewars;

public class Int32ToIpv4 {
	public static void main(String[] args) {
		System.out.println(longToIP(2154959208L));
	}
	
	public static String longToIP(long ip) {
			String binary = decimalToBinary(ip);
			if(binary.length() < 32) {
				binary = "0".repeat(32-binary.length()) + binary;
			}
			String address = "";
			for(int i = 0; i<32;i=i+8) {
				address+=binaryToDecimal(binary.substring(i, i+8)) + ".";
			}
			return  address.substring(0, address.length()-1);
		}
	
	
	
	private static  String decimalToBinary(long number) {
		return Long.toBinaryString(number);
	}
	private static long binaryToDecimal(String binary) {
		return Long.parseLong(binary,2);
	}

}

package com.test.lld.dsaquestion;

public class Test {

	/*
	 * 
	 * You have given a string =”This is ram”, you need to find all 
	 * those letters that are missing in the string out of 
	 * all 26 a-z letters present in alphabets
	 */
	
	public static void main(String[] args) {
		
		String s = "This is ram";
		
		s = s.toLowerCase();
		
		int [] hashMap = new int[26];
		
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == ' ')
				continue;
			
			hashMap[s.charAt(i) - 'a']++;
		}
		
		System.out.println("missing characters are : ");
		
		for(int i = 0; i < 26; i++)
		{
			if(hashMap[i] == 0 )
				System.out.print((char)(i + 'a') + " ");
		}
	}
}

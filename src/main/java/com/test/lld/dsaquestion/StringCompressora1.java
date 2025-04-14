package com.test.lld.dsaquestion;


public class StringCompressora1 {

    public static String compress(String str) {
        if (str == null || str.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                sb.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        // Append the last character and its count
        sb.append(str.charAt(str.length() - 1)).append(count);

        return sb.toString();
    }

    public static void main(String[] args) {
//        String input = "aaabbbbbccccdaa";
    	
    	String input = "aabaacaada";
        System.out.println(compress(input)); // Output: a3b5c4d1a2
    }
}

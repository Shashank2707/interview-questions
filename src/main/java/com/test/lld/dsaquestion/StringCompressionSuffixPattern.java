package com.test.lld.dsaquestion;

//Java code to implement the above approach 

import java.util.*;

/**
 * Given a string ” A B A B C A B A B C D”, you have to compress it into 
 * the following format: A B * C * D. Here, till A B * of the output, 
 * A B repeats twice, but till A B * C *, A B A B C repeats twice
 * 
 * */

public class StringCompressionSuffixPattern {

    public static String compress(String str) {
        Stack<String> suffixes = new Stack<>();
        int len = str.length();

        while (len > 1) {
            int mid = len / 2;
            int i = 0, j = mid;

            // Compare characters from beginning and mid
            while (j < len && str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            }

            // If match found
            if (i == mid) {
                suffixes.push(str.substring(j));  // Save the unmatched suffix
                str = str.substring(0, mid);      // Keep the repeating part
                len = mid;                        // Update new length
            } else {
                len = mid - 1; // Shrink the mid to check for shorter pattern
            }
        }

        // Append suffixes with '*' separator
        while (!suffixes.isEmpty()) {
            str += "*" + suffixes.pop();
        }

        return str;
    }

    public static void main(String[] args) {
    	
    	/*
    	 * find the longest repeating prefix in the string that occurs consecutively. 
    	 * I iteratively compared the first half of the string with the second half. 
    	 * If they matched, I identified it as a repeatable pattern and saved the remaining 
    	 * suffix to a stack. I then continued the process recursively on the matched pattern. 
    	 * This ensured we captured the deepest repeating structure. Once the base pattern was identified, 
    	 * I appended all the saved suffixes back with a * delimiter to show compressed repetition. 
    	 * The time complexity in the worst case is O(n²), and the space complexity is proportional
    	 * to the number of suffix segments stored. This approach mimics how a compression engine might 
    	 * recursively break down patterns in strings.
    	 * 
    	 * */
    	
        String input = "ABABCABABCD";
        System.out.println(compress(input));  // Output: ABAB*C*D
    }
}








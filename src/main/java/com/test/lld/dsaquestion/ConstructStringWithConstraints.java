package com.test.lld.dsaquestion;

public class ConstructStringWithConstraints {
	
	/**
	 * 
	 * Construct a string with given constraints:
	 * 		
	 * 		input: abcd
	 * 		const: 123
	 * 
	 * 		o/p: abbcccd
	 * 
	 * 		input: abcde
	 * 		const: 4
	 * 		o/p: aaaabcde
	 * 
	 * 
	 * 		also decode in the same manner
	 * 		eg: i/p: aabbbccccd const:2341 o/p: abcd
	 */
	
	 public static void main(String[] args) {
	        // Test cases for encoding
	        System.out.println("Encoded: " + encodeString("abcd", "123"));      // Expected: abbcccd
	        System.out.println("Encoded: " + encodeString("abcde", "4"));       
	        System.out.println("Encoded: " + encodeString("abcd", "4321"));    
	        System.out.println("Encoded: " + encodeString("ab", "23"));        
	        System.out.println("Encoded: " + encodeString("abbcccd", "123")); 
	        System.out.println("Encoded: " + encodeString("abcd", "4444"));     

	        // Test cases for decoding
	        System.out.println("Decoded: " + decodeString("abbcccd", "123"));      
	        System.out.println("Decoded: " + decodeString("aaaabcde", "4"));     
	        System.out.println("Decoded: " + decodeString("aaaabbbccd", "4321"));
	        System.out.println("Decoded: " + decodeString("aabbb", "23"));          
	        System.out.println("Decoded: " + decodeString("abbbbbcccd", "123"));     
	        System.out.println("Decoded: " + decodeString("aaaabbbbccccdddd", "4444"));      
	    }

	    // Method to encode the input string based on the constraint
	    public static String encodeString(String input, String constraint) {
	        StringBuilder encoded = new StringBuilder();
	        int constraintLength = constraint.length();

	        for (int i = 0; i < input.length(); i++) {
	            char currentChar = input.charAt(i);
	           
	            int repeatCount = 1;
	            if(i < constraintLength)
	            	repeatCount = (int) (constraint.charAt(i) - '0');
	            	
	            // Append character 'repeatCount' times
	            encoded.append(String.valueOf(currentChar).repeat(repeatCount));
	        }

	        return encoded.toString();
	    }

	    // Method to decode the encoded string based on the constraint
	    public static String decodeString(String encoded, String constraint) {
	        StringBuilder decoded = new StringBuilder();
	        int index = 0;
	        
	        for (int i = 0; i < constraint.length(); i++) {
	            int repeatCount = (int) (constraint.charAt(i) - '0'); // Get the repeat count from the constraint
	            
	            if (index < encoded.length()) {
	                decoded.append(encoded.charAt(index)); // Append the character once
	                index += repeatCount; // Move the index by the repeat count
	            }
	        }
	        
	        // Handle remaining characters if encoded is longer
	        while (index < encoded.length()) {
	            decoded.append(encoded.charAt(index));
	            index++;
	        }
	        
	        return decoded.toString();
	    }
}

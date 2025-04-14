package com.test.lld.dsaquestion;

import java.util.*;

/**
 * you are given 2 int arrays.
 * A=[1,   2,   1]
 * B=[2,   3,   3]
 * 
 * so fractions are: 1/2, 2/3,  1/3
 * A is numerator, B is denominator.
 * so fractions are: 1/2, 2/3, 1/3
 * 
 * find all pairs that sum upto 1.
 * 
 * example:  here we have 2/3 + 1/3 = 1 so count = 1
 * 
 * return 1
 * 
 * return modulo 10^ +7 since input can be large
 */

public class FractionPairsThatSumToOne {

    static final int MOD = (int)1e9 + 7;

    public static int countFractions(int[] A, int[] B) {
        int n = A.length;
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = A[i];
            int den = B[i];

            int gcd = gcd(num, den);
            num /= gcd;
            den /= gcd;

            // Complement numerator and denominator
            int compNum = den - num;
            int compDen = den;

            int gcd2 = gcd(compNum, compDen);
            compNum /= gcd2;
            compDen /= gcd2;

            String key = num + "/" + den;
            String compKey = compNum + "/" + compDen;

            if (map.containsKey(compKey)) {
                count = (count + map.get(compKey)) % MOD;
            }

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }

    // GCD function
    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Test the function
    public static void main(String[] args) {
    	
    	/*
    	 *  For every fraction a/b, I calculate the complement needed to make the 
    	 *  sum equal to 1 — that is, (b - a)/b. I reduce both the original fraction 
    	 *  and its complement using GCD to ensure we’re comparing equivalent forms (like 2/4 and 1/2).
    	 *  
    	 *  I use a hash map to keep track of how many times each reduced 
    	 *  fraction has appeared. As I iterate through the array, 
    	 *  if the complement of the current fraction already exists in the map,
    	 *  I add its count to my result. Finally, I update the map with the current fraction.
    	 *  
    	 *  This allows me to count all valid pairs efficiently in linear 
    	 *  time using hashing, without having to compare every pair.
    	 *  
    	 *  TC : O(n · logK), where K is the max numerator or denominator (because of gcd).
    	 *  SC : O(n) for the map.
    	 * 
    	 * */
    	
        int[] A = {1, 2, 1};
        int[] B = {2, 3, 3};
        System.out.println(countFractions(A, B)); // Output: 1
    }
}


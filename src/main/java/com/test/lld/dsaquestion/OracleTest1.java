package com.test.lld.dsaquestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OracleTest1 {

	public static int getMinimumCoverage(int[] sections) {
        Set<Integer> uniqueProducts = new HashSet<>();
        for (int product : sections) {
            uniqueProducts.add(product);
        }
        int totalUnique = uniqueProducts.size();

        Map<Integer, Integer> windowCounts = new HashMap<>();
        int left = 0, minLen = Integer.MAX_VALUE, count = 0;

        for (int right = 0; right < sections.length; right++) {
            windowCounts.put(sections[right], windowCounts.getOrDefault(sections[right], 0) + 1);
            if (windowCounts.get(sections[right]) == 1) {
                count++;
            }

            while (count == totalUnique) {
                minLen = Math.min(minLen, right - left + 1);
                windowCounts.put(sections[left], windowCounts.get(sections[left]) - 1);
                if (windowCounts.get(sections[left]) == 0) {
                    count--;
                }
                left++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        int[] sections = {1,2,3,4,1,5,2,3};  // Example input
        System.out.println(getMinimumCoverage(sections)); // Output: Expected minimum length
    }
}

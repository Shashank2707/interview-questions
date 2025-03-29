package com.test.lld.dsaquestion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateElementUsingStreams {

	/**
	 *  find duplicate element using streams
	 * 
	 * */
	public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 3, 7, 8, 1);

        // Finding duplicates using Streams
        Set<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Keep only duplicates
                .map(Map.Entry::getKey) // Extract duplicate elements
                .collect(Collectors.toSet());

        System.out.println("Duplicate elements: " + duplicates);
        
        System.out.println(numbers.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting())));
    }
}

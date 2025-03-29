package com.test.lld.dsaquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighestAverage {

	public static void main(String[] args) {
        String[][] input = {
            {"Bob", "87"}, {"Mike", "35"}, {"Bob", "52"},
            {"Jason", "35"}, {"Mike", "55"}, {"Jessica", "99"},
            {"Shashank", "99"}
        };

        System.out.println(highestAverage(input)); // Output: 99
    }

	static int highestAverage(String[][] scores) {
	
		/*
		 * Method 1 : Using two hashmaps
		 * 
		 * TC : O(n) SC : O(2*n) == O(n)
		 * 
		 * I can take two hashmap of type string, integer one will store the name, frequency
		 * of appearing name and another map will store the name and the total marks of it.
		 * 
		 * To find max average we can iterate on total marks and get the total marks/ frequency
		 * you will get average then maintain max of it
		 * */
		
		return solve1(scores);
	}
	
	static int solve1(String [][] scores)
	{
		if(scores == null || scores.length == 0)
			return -1;
			
			Map<String, Integer> noOfSubjects = new HashMap<>();
			Map<String, Integer> totalMarks = new HashMap<>();
			
			for(int i = 0; i<scores.length; i++) {
				noOfSubjects.put(scores[i][0], noOfSubjects.getOrDefault(scores[i][0], 0)+1);
				totalMarks.put(scores[i][0], totalMarks.getOrDefault(scores[i][0], 0)+Integer.parseInt(scores[i][1]));
			}
			
			System.out.println("noOfSubjects is : ");
			
			for(Map.Entry<String, Integer> entry : noOfSubjects.entrySet())
			{
				System.out.println(entry.getKey() + "-->" + entry.getValue());
			}
			
			System.out.println("totalMarks is : ");
			
			for(Map.Entry<String, Integer> entry : totalMarks.entrySet())
			{
				System.out.println(entry.getKey() + "-->" + entry.getValue());
			}
			
			int maxMarks = 0;
			List<String> names = new ArrayList<>();
			for(String student: totalMarks.keySet()) {
				int max = totalMarks.get(student)/noOfSubjects.get(student);
				
				if(max > maxMarks)
				{
					names.clear();
					maxMarks = max;
				}
				
				if(max == maxMarks)
				{
					names.add(student);
				}
			}
			
			System.out.println("Student having best average is : " + names+ " with marks : " + maxMarks);
			System.out.println("i is : " + names + " and j is : " + maxMarks);
			return maxMarks;
	}
}

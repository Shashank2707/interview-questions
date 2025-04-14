package com.test.lld.dsaquestion;

import java.util.Arrays;
import java.util.HashMap;

public class OracleTest {

	public static void main(String[] args) {
		// there is 
		//[5,2,3] target element is 8 --> 0,2
		
		int [] nums = {9,5,2,3};
		
		int target = 8;
		
		int [] ans = solve2(nums,target); 
		
		 Arrays.stream(ans)
         .forEach(e -> System.out.println(e));
	}
	
	static int [] solve(int [] nums, int target)
	{
		int n = nums.length;
		int [] ans = new int[2];
		ans[0] = ans[1] = -1;
		
		for(int i = 0; i < n; i++)
		{
			for(int j = i + 1; j < n; j++)
			{
				if(nums[i] + nums[j] == target)
				{
					ans[0] = i;
					ans[1] = j;
					
					return ans;
				}

			}
		}
		return ans;
	}
	
	static int [] solve2(int [] nums, int target)
	{
		int [] ans = new int [2];
		ans[0] = ans[1] = -1;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++)
		{
			int curr = nums[i];
			int find = target - curr;
			
			if(map.containsKey(find))
			{
				ans[0] = map.get(find);
				ans[1] = i;
			}
			map.put(nums[i],i);
		}
		return ans;
	}
}

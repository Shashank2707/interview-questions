package com.test.lld.dsaquestion;

import java.util.Arrays;


/*
 * 
 * Initialize a variable diff as infinite (Diff is used to store the difference between pair and sum). 
 * We need to find the minimum diff.
 * Initialize two index variables left and right in the given array nums.
 * 
 * (a) Initialize first to the leftmost index in nums: left = 0
 * (b) Initialize second the rightmost index in nums: right = nums.length -1
 * 		Soft the Array nums
 * 
 * 	Loop while left <= right
 * (a) sum = nums[left] + nums[right]
 * (b) If abs( sum - target) < diff then update diff and result
 * (c) If (sum > target ) then right--
 * (d) Else left++
 * Print the result.
 * */


public class FindClosestPairArray {
	
	
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-1};
		
		int [] ans = findClosestPairArray(nums, 4);
		System.out.println(ans[0] + " " + ans[1]);
	}
	
	public static int[] findClosestPairArray(int[] nums, int target) {
			Arrays.sort(nums);
			int left = 0;
			int right = nums.length-1;
			int[] result = {-1,-1};
			int diff = Integer.MAX_VALUE;
			
			while ( left < right ) {
				int sum = nums[left] + nums[right];
				if(Math.abs(sum - target) < diff) {
					diff = Math.abs(sum - target);
					result[0] = nums[left];
					result[1] = nums[right];
				}
				if(sum > target) {
					right --;
				}else {
					left ++;
				}
			}
			return result;
		}
}


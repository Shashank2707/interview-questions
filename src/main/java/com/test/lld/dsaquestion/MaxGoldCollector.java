package com.test.lld.dsaquestion;

import java.util.Arrays;

public class MaxGoldCollector {
	
	
	/**
	 * A 2D array 'arr' was given with m rows and n columns. arr[i][j] 
	 * represents the amount of gold present in the cell. I needed 
	 * to find the maximum gold that can be collected while going 
	 * from the bottom-left cell (arr[m-1][0]) to the top-right cell (arr[0][n-1]).
	 * 
	 * We can only travel in the top and the right direction.
	 * 
	 * Input:
	 * [[0,0,0,0,5]]
	 * [[0,1,1,1,0]]
	 * [[2,0,0,0,0]]
	 * 
	 * Output = 10
	 */

    public static void main(String[] args) {
        int[][] arr = {
            {0, 0, 0, 0, 5},
            {0, 1, 1, 1, 0},
            {2, 0, 0, 0, 0}
        };
        
        
        //recursion
        System.out.println(maxGoldRecursive(arr));
        
        //memoization (top-down)
        System.out.println(maxGoldMemo(arr));
        
        //memoization bottom up
        System.out.println("Max Gold: " + getMaxGold3(arr));
    }
    
    /*Method 1 : Using recursion */
    public static int maxGoldRecursive(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return collect(grid, m - 1, 0);
    }
    /* Method 1 : Helper */
    private static int collect(int[][] grid, int i, int j) {
        if (i < 0 || j >= grid[0].length) return 0;

        int up = collect(grid, i - 1, j);
        int right = collect(grid, i, j + 1);

        return grid[i][j] + Math.max(up, right);
    }
    
    
    
    
    /* Method 2 : Using DP memoization*/
    public static int maxGoldMemo(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return collect(grid, m - 1, 0, dp);
    }
    /*Method 2 : Helper*/
    private static int collect(int[][] grid, int i, int j, int[][] dp) {
        if (i < 0 || j >= grid[0].length) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int up = collect(grid, i - 1, j, dp);
        int right = collect(grid, i, j + 1, dp);

        return dp[i][j] = grid[i][j] + Math.max(up, right);
    }

    
    
    /* Method 3 : Using Tabulation */
    public static int getMaxGold3(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        // dp[i][j] stores max gold from (i,j) to (0,n-1)
        int[][] dp = new int[m][n];

        // Traverse from bottom-left to top-right
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {

                int fromDown = (i + 1 < m) ? dp[i + 1][j] : 0;
                int fromLeft = (j - 1 >= 0) ? dp[i][j - 1] : 0;

                // Since we move up and right, we check max of
                // (coming from below) and (coming from left)
                dp[i][j] = arr[i][j] + Math.max(fromDown, fromLeft);
            }
        }

        return dp[0][n - 1]; // Max gold collected at top-right
    }
    
}

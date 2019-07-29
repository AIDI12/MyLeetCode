package Leetcode;

import java.util.Arrays;
/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * @author AD
 *
 */
public class IntegerBreak {
    public int integerBreak(int n) {
    	return breakInteger(n);
    }

	private int breakInteger(int n) {
		int[] memo = new int[n];
		Arrays.fill(memo, -1);
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i-1; j++) {
				memo[i] = Math.max(memo[i], Math.max(j * i-j, j * memo[i-j]));
			}
			
		}
		return memo[n];
	}
	//基于2,3乘积最大的动态规划解法，因为 2和3是唯一两个拆分之后数字乘积比本身还要小的数字。解法通俗易懂，时间复杂度O(n)
	public int integerBreak1(int n) {
	        int[] dp = new int[58];
	        dp[1] = 1; // n =2
	        dp[2] = 2; // n =3
	        dp[3] = 4; // n =4 2*2
	        dp[4] = 6; // n =5 2*3
	        dp[5] = 9; // n =6 3*3
	        //依次推广到 3*3*"2" .....
	        for (int i = 6; i<n; i++) {
	            dp[i] = Math.max(2 * dp[i-2], 3 * dp[i-3]);
	        }
	        
	        return dp[n-1];
	    }
}

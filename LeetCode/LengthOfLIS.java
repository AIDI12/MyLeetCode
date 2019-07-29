package Leetcode;

import java.util.Arrays;
/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * @author AD
 *
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if ( nums.length == 0) {
			return 0;
		}
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        
        for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					memo[i] = Math.max(memo[i], 1 + memo[j]);
				}
			}
		}
        int res = 1;
        for (int i = 0; i < memo.length; i++) {
			res = Math.max(res, memo[i]);
		}
    	return res;
    }
}

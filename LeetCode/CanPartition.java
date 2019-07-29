package Leetcode;

import java.util.Arrays;
/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @author AD
 *
 */
public class CanPartition {
	private int[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
        if (sum%2 != 0) {
			return false;
		}
    	memo = new int[nums.length][sum/2 + 1];
    	for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < sum/2 + 1; j++) {
				memo[i][j] = -1;
			}
		}
        
        return tryPartition(nums, nums.length - 1, sum/2);
    }
    //使用nums[0...index],是否可以填充容量为sum的背包
	private boolean tryPartition(int[] nums, int index, int sum) {
		if (sum == 0) {
			return true;
		}
		if (sum < 0 || index < 0) {
			return false;
		}
		if (memo[index][sum] != -1) {
			return memo[index][sum] == 1;
		}
		memo[index][sum] =  (tryPartition(nums, index-1, sum) || 
				tryPartition(nums, index-1, sum-nums[index])) ? 1 : 0;
		return memo[index][sum] == 1;
	}
	
	public boolean canPartition2(int[] nums) {
		int sum = 0;
        for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
        if (sum%2 != 0) {
			return false;
		}
        int n = nums.length;
        int C = sum/2;
        //判断能不能填入背包
        boolean[] memo = new boolean[C+1];
        Arrays.fill(memo, false);
        //考虑第一个nums能不能填满背包？
        for (int i = 0; i <= C; i++) {
			memo[i] = (nums[0] == i);
		}
        
        for (int i = 1; i < n; i++) {
			for (int j = C; j >= nums[i]; j--) {
				memo[j] = memo[j] || memo[j - nums[i]];
			}
		}
        return memo[C];
        
        
	}
}

package Leetcode;
/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * @author AD
 *
 */
public class MinSubArrayLen {
	public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;
        
        while(l < nums.length){
        	if (r+1 < nums.length && sum < s) {
				sum += nums[++r];
			}else {
				sum -= nums[l++];
			}
        	if (sum >= s) {
				res = Math.min(res, r-l+1);
			}
        }
        if (res == nums.length+1) {
			return 0;
		}
		return res;
    }
}

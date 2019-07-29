package Leetcode;

import java.util.Arrays;
/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @author AD
 *
 */
public class ClimbStairs {
	private int[] memo;
    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
    	return getClimbStairs(n);
    }

	private int getClimbStairs(int n) {
		
		memo[0] = 1;
		memo[1] = 2;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		
		return (int) memo[n];
	}

}

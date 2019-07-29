package Leetcode;

import java.util.Arrays;
/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，
 * 都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * @author AD
 *
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int gi = 0;
        int si = 0;
        Arrays.sort(g);
        Arrays.sort(s);
    	//每次用最小的饼干满足胃口最小的孩子
        while(gi < g.length && si < s.length) {
        	if (s[si] >= g[gi]) {
				gi++;
			}
        	si++;
        }
    	return gi;
    }
}

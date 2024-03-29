package Leetcode;

import java.util.HashSet;
import java.util.Set;
/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * @author AD
 *
 */
public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
    }
}

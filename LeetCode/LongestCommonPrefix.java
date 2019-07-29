package Leetcode;
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * @author AD
 *
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		//判空
		if (strs.length == 0) return "";
		//第一个字符串
		String prefix = strs[0];
		//循环遍历字符串
		for (int i = 1; i < strs.length; i++)
			//返回prefix第一次出现的索引
			while (strs[i].indexOf(prefix) != 0) {
			    //从0到字符串倒数第二个位置，缩减字符串
		       prefix = prefix.substring(0, prefix.length() - 1);	      
		       if (prefix.isEmpty()) return "";
		       }        
		return prefix;
    }
}

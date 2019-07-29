package Leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * @author AD
 *
 */
public class LetterCombinations {
	private final String[] letterMap = {
		" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"	
	};
	private List<String> res = new ArrayList<>();
	
	public List<String> letterCombinations(String digits) {
        
        if (digits.length() == 0) {
			return res;
		}
        
        findCombinatinons(digits, 0, "");
		return res;
		
    }
	//递归
	private void findCombinatinons(String digits, int index, String s) {
		if (index == digits.length()) {
			res.add(s);
			return;
		}
		char c = digits.charAt(index);
		String letter = letterMap[c - '0'];
		for (int i = 0; i < letter.length(); i++) {
			findCombinatinons(digits, index + 1, s + letter.charAt(i));
		}
		return;
		
	}
}

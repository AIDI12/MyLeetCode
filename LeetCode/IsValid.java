package Leetcode;

import java.util.HashMap;
import java.util.Stack;
/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * @author AD
 *
 */
public class IsValid {
	//栈
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' ||s.charAt(i) == '{' ||s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			}else {
				if (stack.size() == 0) {
					return false;
				}
				char c = stack.pop();
				char match;
				if (s.charAt(i) == ')') {
					match = '(';
				}else if (s.charAt(i) == '}') {
					match = '{';
				}else {
					match = '[';
				}
				if (c != match) {
					return false;
				}
			}
		}
    	if (stack.size() != 0) {
			return false;
		}
		return true;
    }
    //时间复杂度不好
    public boolean isValid2(String s) {
		int length = 0;
		do {
			length = s.length();
			s = s.replace("()", "").replace("{}", "").replace("[]", "");
		} while (length != s.length());
    	return s.length() == 0;
    
    }
}

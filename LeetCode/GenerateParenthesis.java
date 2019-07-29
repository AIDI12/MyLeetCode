package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * @author AD
 *
 */
public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		//递归
        generate(res, "", 0, 0, n);
        
        return res;
    }
    //left统计“(”的个数，right统计“)”的个数
    public void generate(List<String> res , String ans, int left, int right, int n){
        //递归基
        if(left > n || right > n) return;
        
        if(left == n && right == n)  res.add(ans);
 
        if(left >= right){
        	//new一个新的String对象
            String ans1 = new String(ans);
            
            generate(res, ans+"(", left+1, right, n);
            generate(res, ans1+")", left, right+1, n);
            
        }
    }
    public static void main(String[] args) {
		GenerateParenthesis g = new GenerateParenthesis();
    	List<String> res = g.generateParenthesis(3);
    	for (String string : res) {
			System.out.println(string);
		}
	}
}

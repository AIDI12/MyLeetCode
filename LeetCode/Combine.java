package Leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @author AD
 *
 */
public class Combine {
	
	public List<List<Integer>> combine3(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n, k, res, list, 1);
        return res;
    }
    public void helper(int n, int k, List<List<Integer>> res, List<Integer> list, int start){
        if(list.size() == k){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = start; i <= n; i++){
            list.add(i);
            helper(n, k, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    
	private List<List<Integer>> res = new ArrayList<>();
	
	public List<List<Integer>> combine(int n, int k) {
        
		if (n <= 0 || k <= 0 || k > n) {
			return res;
		}
		
		List<Integer> c = new ArrayList<>();
		generateCombine(n, k, 1, c);
		
		return res;
    }
	private void generateCombine(int n, int k, int start, List<Integer> c) {
		if (c.size() == k) {
			res.add(c);
			return;
		}
		
		for (int i = start; i <= n; i++) {
			c.add(i);
			generateCombine(n, k, i + 1, c);
			c.remove(c.size() - 1);
		}
		return;
	}
	
	 public List<List<Integer>> combine2(int n, int k) {
	        List<List<Integer>> res = new ArrayList<>();
	        dfs(res, n, k, new ArrayList<>());
	        return res;
	    }

	    private void dfs(List<List<Integer>> res, int n, int k, ArrayList<Integer> path) {
	        if (n < 0) return;
	        if (k < 0) return;
	        if (k == 0) {
	            res.add(new ArrayList<>(path));
	            return;
	        }
	        path.add(n);
	        dfs(res, n - 1, k - 1, path);
	        path.remove(path.size() - 1);
	        dfs(res, n - 1, k, path);
	    }
}

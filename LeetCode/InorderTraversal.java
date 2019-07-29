package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 左 根 右
 * @author AD
 *
 */
public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode cur = root;
    	if (root == null) {
			return res;
		}
    	while(cur != null || !stack.isEmpty()) {
    		//先将以根节点为始的左节点加入stack
    		if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}else {
				//保存左子树左节点的value
				cur = stack.pop();
				res.add(cur.val);
				//左子树的右节点
				cur = cur.right;
			}
    	}
    	return res; 
    	
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		
		List<Integer> res = inorderTraversal(a);
		for (Integer integer : res) {
			System.out.println(integer);
		}
	}
}


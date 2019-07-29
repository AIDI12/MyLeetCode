package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * 根 左 右
 * @author AD
 *
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	Stack<TreeNode> stack = new Stack<>();
    	stack.push(root);
    	if (root == null) {
			return res;
		}
    	while(!stack.isEmpty()) {
    		//pop出根节点
    		TreeNode cur = stack.pop();
    		//添加根节点value
    		res.add(cur.val);
    		//如果有右子节点，加入stack
    		if (cur.right != null) {
				stack.push(cur.right);
			}
    		//如果有左子节点，加入stack
    		if (cur.left != null) {
				stack.push(cur.left);
			}
    	}
    	return res; 
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * @author AD
 *
 */
public class LevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
	    if(root == null)
	        return new ArrayList<>();
	    List<List<Integer>> res = new ArrayList<>();
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    while(!queue.isEmpty()){
	        int count = queue.size();
	        List<Integer> list = new ArrayList<Integer>();
	        while(count > 0){
	            TreeNode node = queue.poll();
	            list.add(node.val);
	            if(node.left != null)
	                queue.add(node.left);
	            if(node.right != null)
	                queue.add(node.right);
	            count--;
	        }
	        res.add(list);
	    }
	    return res;
	}
}

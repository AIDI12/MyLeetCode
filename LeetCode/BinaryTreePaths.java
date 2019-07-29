package Leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * @author AD
 *
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
        String s = "";
        paths(root, list, s);
        return list;
    }
	
    private void paths(TreeNode root, List<String> list, String s){
        if(root == null){
            return;
        }
        s += root.val + " ";
        if(root.left == null && root.right == null){
            list.add(s.trim().replace(" ", "->"));
        }
        
        if(root.left != null){
            paths(root.left, list, s);
        }
        if(root.right != null){
            paths(root.right, list, s);
        }
    }
    
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root==null) {
        	return list;
        	}
        paths1(root, list, String.valueOf(root.val));
        return list;
    }
    public List<String> paths1(TreeNode node, List<String> lists, String s){
        String st ;
        if(node.left==null&&node.right==null){
            lists.add(s);
        }
        if(node.left!=null){
            st = s+"->"+node.left.val;
            paths(node.left,lists,st);
        }
        if(node.right!=null){
            st =s+"->"+node.right.val;
            paths(node.right,lists,st);
        }
        return lists;
    }
}

package Leetcode;
/**
 * 翻转一棵二叉树。
 * @author AD
 *
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
			return null;
		}
        invertTree(root.left);
        invertTree(root.right);
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
    	return root;
    }
}

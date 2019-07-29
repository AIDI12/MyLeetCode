package Leetcode;
/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * @author AD
 *
 */
public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
	    return isMirror(root, root);
	}

	public boolean isMirror(TreeNode t1, TreeNode t2) {
	    if (t1 == null && t2 == null) return true;
	    if (t1 == null || t2 == null) return false;
	    return (t1.val == t2.val)
	        && isMirror(t1.right, t2.left)
	        && isMirror(t1.left, t2.right);
	}
}

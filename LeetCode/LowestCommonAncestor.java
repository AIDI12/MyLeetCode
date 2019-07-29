package Leetcode;
/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * @author AD
 *
 */
public class LowestCommonAncestor {
    //递归
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
			return null;
		}
        if (q.val > root.val && p.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
        if (q.val < root.val && p.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
    	return root;
    }
	//非递归
	public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
			return null;
		}
        while(root != null) {
        	if (q.val > root.val && p.val > root.val) {
				root = root.right;
			}else if (q.val < root.val && p.val < root.val) {
				root = root.left;
			}else {
				return root;
			}
        }
		return root;
    }
}

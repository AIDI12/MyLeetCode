package Leetcode;
/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @author AD
 *
 */
public class LowestCommonAncestor_1 {
	//递归
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//递归基
		if (root == null || root == q || root == p) {
			return root;
		}
		//在左子树找p、q节点
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		//在右子树找p、q节点
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		//如果左子树没有，则说明在右子树
		if (left == null) {
			return right;
		//如果右子树没有，则说明在左子树
		}else if (right == null) {
			return left;
		//如果都有，则说明root为公共祖先
		}else {
			return root;
		}
    }
}

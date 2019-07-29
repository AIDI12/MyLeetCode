package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 	*假设一个二叉搜索树具有如下特征：
    *节点的左子树只包含小于当前节点的数。
    *节点的右子树只包含大于当前节点的数。
    *所有左子树和右子树自身必须也是二叉搜索树。

 * @author AD
 *
 */
public class isValidBST {
	//中序遍历
	public boolean isValidBST_1(TreeNode root) {
        if(root==null) return true;
        List<Integer> list=new ArrayList<>();
        inOrder(root,list);        
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1) )   return false;
        }
        return true; 
    }   
    void inOrder(TreeNode root,List<Integer> list){
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    //递归   失败
    public boolean isValidBST_2(TreeNode root) {
    	return isVaild(root, null, null);
    }
	private boolean isVaild(TreeNode root, Integer max, Integer min) {
		if (root == null)  return true;
		if (min != null && root.val <= min) return false;
		if (max != null && root.val >= max) return false;
		return isVaild(root.left, min, root.val) && isVaild(root.right, root.val, max);
	}
}

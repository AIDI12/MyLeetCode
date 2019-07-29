package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * 左 右 根
 * @author AD
 *
 */
public class PostorderTraversal {
	
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        fun(root,list);
        return list;
    }
    public void fun(TreeNode root,List<Integer> list){
        if(root == null)
            return;
        //递归左子树，直至最左的一个子节点
        fun(root.left,list);
        fun(root.right,list);
        
        list.add(root.val);
        }

	
	//д��(2)
	public List<Integer> postorderTraversal2(TreeNode root) {//�ǵݹ�д��
	    List<Integer> res = new ArrayList<Integer>();
	    if(root == null)
	        return res;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode pre = null;
	    stack.push(root);
	    while(!stack.isEmpty()){
	        TreeNode curr = stack.peek();            
	        if((curr.left == null && curr.right == null) ||
	           (pre != null && (pre == curr.left || pre == curr.right))){ 
	                        //�����ǰ��������ӽڵ�Ϊ�ջ���һ�����ʵĽ��Ϊ��ǰ�����ӽڵ�ʱ����ǰ����ջ
	            res.add(curr.val);
	            pre = curr;
	            stack.pop();
	        }else{
	            if(curr.right != null) stack.push(curr.right); //�Ƚ��ҽ��ѹջ
	            if(curr.left != null) stack.push(curr.left);   //�ٽ�������ջ
	        }            
	    }
	    return res;        
	}
	
	
	//����(3)
	public List<Integer> postorderTraversal3(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	    if(root == null)
	        return res;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	    while(!stack.isEmpty()){
	        TreeNode node = stack.pop();
	        if(node.left != null) stack.push(node.left);//�ʹ�ͳ���������һ�����Ƚ�������ջ
	        if(node.right != null) stack.push(node.right);//���ҽ����ջ
	        res.add(0,node.val);                        //������ӽ��ֵ
	    }     
	    return res;
	}
}

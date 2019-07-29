package Leetcode;
/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * @author AD
 *
 */
public class AddTwoNumbers {
	//递归版
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //判空
		if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        //头节点
        ListNode l3 = new ListNode((l1.val + l2.val) % 10);
        //进位
        if(l1.val + l2.val >= 10){
            l3.next = addTwoNumbers(addTwoNumbers(l1.next, l2.next), new ListNode(1));
        }else{
        	//不进位
            l3.next = addTwoNumbers(l1.next, l2.next);
        }
        return l3;
    }
	//非递归版
	public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        //标志是否需要进位，默认不需要
        boolean flag = false;
        ListNode sumNodeHead = new ListNode(0);
        ListNode current = sumNodeHead;
        while(l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            //求和
            int temp = l1Val + l2Val;
            if(flag) {
                //进位
                temp = temp +1;
            }
            if(temp >=10) {
                flag = true;
                ListNode node =new ListNode(temp%10);
                current.next = node;
                current = node;
            
            }else{
                // 不需要进位
                flag = false;
                ListNode node =new ListNode(temp);
                current.next = node;
                current = node;
            }
            //向后移动一位
            l1 =l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        ////99+1 最后一个数字进位后在其后面连接1节点。
        if(flag) {
             ListNode finalNode = new ListNode(1);
             current.next = finalNode;
        }
        return sumNodeHead.next;
    }
}

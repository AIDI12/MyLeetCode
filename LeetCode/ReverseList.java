package Leetcode;
/**
 * 反转一个单链表。
 * @author AD
 *
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
        	//每次保存cur的next节点
        	ListNode next = cur.next;
        	
        	cur.next = pre;
        	pre = cur;
        	cur = next;
        }
		return pre;
    }
	
	// 递归的逆转链表
    public ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

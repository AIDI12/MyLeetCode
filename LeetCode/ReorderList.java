package Leetcode;

import java.util.LinkedList;

/**
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * @author AD
 *
 */
public class ReorderList {
	public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //1、寻找中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //2、反转后半部分
        ListNode cur2 = reverseList(slow.next);
        //将原链表截断
        slow.next = null;
        ListNode cur1 = head;
        //3、合并两个链表
        while (cur2 != null) {
            ListNode next2 = cur2.next;
            ListNode next1 = cur1.next;
            cur2.next = cur1.next;
            cur1.next = cur2;
            cur2 = next2;
            cur1 = next1;
        }        
    }
	
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
	//双端队列版
	public void reorderList_2(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        //将链表加入队列
        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }
        //依次弹出
        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = null;
        }
    }
}

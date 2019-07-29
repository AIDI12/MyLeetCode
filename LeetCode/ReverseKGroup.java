package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * @author AD
 *
 */
public class ReverseKGroup {
	/*
	 * 用栈,我们把k个数压入栈中,然后弹出来的顺序就是翻转的!
		这里要注意几个问题
		第一,剩下的链表个数够不够k个(因为不够k个不用翻转);
		第二,已经翻转的部分要与剩下链表连接起来
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		//声明一个栈
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        //虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
        	//记录压入栈的节点数
            int count = 0;
            ListNode tmp = head;
            //将K个节点压入栈
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            //如果剩余节点不足K个
            if (count != k) {
                p.next = head;
                break;
            }
            //弹出反转
            while (!stack.isEmpty()){
                p.next = stack.pollLast();
                p = p.next;
            }
            //连接链表
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }
	//尾插法，依次把当前节点插入到K节点后面
	public ListNode reverseKGroup_2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (true) {
            int count = 0;
            while (tail != null && count != k) {
                count++;
                tail = tail.next;
            }
            if (tail == null) break;
            ListNode head1 = pre.next;
            while (pre.next != tail) {
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            pre = head1;
            tail = head1;
        }
        return dummy.next;
    }
	//递归
	public ListNode reverseKGroup_3(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count != 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }
}

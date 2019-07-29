package Leetcode;
/**
 * 给定一个链表，判断链表中是否有环。
 */
import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    //判重
	public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while(head != null) {
        	if (nodeSet.contains(head)) {
				return true;
			}else {
				nodeSet.add(head);
			}
        	head = head.next;
        }
		return false;
    }
	//快慢指针
	public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
			return false;
		}
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
        	if (fast == null || fast.next == null) {
				return false;
			}
        	slow = slow.next;
        	fast = fast.next.next;
        }
		return true;
    }
}

package Leetcode;

public class DeleteDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
            return head;
        }
		ListNode cur = head;
		while(cur != null) {
			if (cur.next == null) {
				break;
			}
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			}else {
				cur = cur.next;
			}
		}
		return cur;
    }
	
	
	public ListNode deleteDuplicates_2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) head = head.next;
        return head;
    }
}

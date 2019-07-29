package Leetcode;
/**
 * 合并 k 个排序链表，返回合并后的排序链表。
 * @author AD
 *
 */
public class MergeKLists {
	//分治法
	public ListNode mergeKLists(ListNode[] lists) {
		//判空
		if (lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		if (lists.length == 2) {
			return mergeTwoLists(lists[0], lists[1]);
		}
		//分治
		int mid = lists.length/2;
		ListNode[] l1 = new ListNode[mid];
		for (int i = 0; i < mid; i++) {
			l1[i] = lists[i];
		}
		ListNode[] l2 = new ListNode[lists.length - mid];
		for (int i = mid, j = 0; i < lists.length; i++, j++) {
			l2[j] = lists[i];
		}
		return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while (l1 != null && l2 != null){
        	//比较
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        //那个链表空了，将另外的链表全部加到合并链表尾部
        if (l1 == null) p.next = l2;
        if (l2 == null) p.next = l1;
        return dummy.next;
    }
}

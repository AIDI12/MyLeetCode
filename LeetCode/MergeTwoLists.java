package Leetcode;
/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * @author AD
 *
 */
public class MergeTwoLists {
	//每次选两个链表头结点最小的,比如:我们生活中,有两个已经按照高矮排好的队伍,我们如何把变成一个队伍!
	//当然,每次选两个队伍排头的,比较他们的高矮!组成新的的队伍.
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
	//递归版
	public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
	}
}

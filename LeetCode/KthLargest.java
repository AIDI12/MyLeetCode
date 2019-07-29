package Leetcode;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。
 * @author AD
 *
 */
public class KthLargest {
	//最小堆
	final PriorityQueue<Integer> q ;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        for(int i: nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        if(q.size() < k) {
            q.offer(val);
            
        }
        else if(q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}

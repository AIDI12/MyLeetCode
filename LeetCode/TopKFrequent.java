package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * @author AD
 *
 */
public class TopKFrequent {
	public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			}else {
				map.put(i, map.get(i) + 1);
			}
		}
        PriorityQueue<Element> queue = new PriorityQueue<Element>();
        List<Integer> res = new ArrayList();
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        	queue.add(new Element(entry.getKey(), entry.getValue()));
		}
		for (int i = 0; i < k; i++) {
			res.add(queue.remove().getKey());
			System.out.println(queue.remove().getKey());
		}
		
        return res;
    }
	
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3,4,5};
		List list = topKFrequent(nums, 2);
		
	}
}
class Element implements Comparable<Element>{
	 
	private Integer key;
	private Integer count;
	public Element(int key, int count) {
		
		this.key = key;
		this.count = count;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public int compareTo(Element o) {
		return o.count.compareTo(this.count);
	}
}

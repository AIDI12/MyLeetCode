package Leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @author AD
 *
 */
public class Intersection {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record = new HashSet<>();
        Set<Integer> res1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
			record.add(nums1[i]);
		}
        for (int i = 0; i < nums2.length; i++) {
			if (record.contains(nums2[i])) {
				res1.add(nums2[i]);
			}
		}
        if (res1.isEmpty()) {
            return new int[0];
        }

        int[] res2 = new int[res1.size()];
        Iterator<Integer> iterator = res1.iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            res2[idx++] = iterator.next();
        }

        return res2;
    }
}

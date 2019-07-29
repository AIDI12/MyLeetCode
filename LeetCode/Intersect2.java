package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @author AD
 *
 */
public class Intersect2 {
	public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            if(!map.containsKey(num)){
                map.put(num, 1);
            } else{
                map.put(num, map.get(num) + 1);
            }
        }
    
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }
      
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
		
    }
}

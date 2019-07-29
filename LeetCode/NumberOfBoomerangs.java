package Leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
找到所有回旋镖的数量。
 * @author AD
 *
 */
public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int result = 0;
        Map<Integer, Integer> map;
        for (int i = 0; i < points.length; i++) {
        	map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j){
                    int distance = getDistance(points[i], points[j]);
                    map.put(distance,  map.getOrDefault(distance, 0) + 1);
                }
            }
            result += getCountByPoint(map);
        }
        
        return result;
    }


    private int getDistance(int[] pointA, int[] pointB){
        int x = pointA[0] - pointB[0];
        int y = pointA[1] - pointB[1];
        return x * x + y * y;
    }

   
    private int getCountByPoint(Map<Integer, Integer> map){
        int result = 0;
        for (Integer value : map.values()) {
            
                result += value * (value - 1);
            
        }
        return  result;
    }
}

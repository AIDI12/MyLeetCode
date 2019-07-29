package Leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
 * @author AD
 *
 */
public class FourSumCount2 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> record = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				sum = C[i] + D[j];
				record.put(sum, record.getOrDefault(sum, 0)+1);
			}
		}
        
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sum = A[i] + B[j];
                if (record.containsKey(-sum)){
                    result += record.get(-sum);
                }
            }
        }

        return result;
    }
}

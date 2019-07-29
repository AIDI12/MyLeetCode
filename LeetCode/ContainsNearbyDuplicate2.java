package Leetcode;
/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * @author AD
 *
 */
public class ContainsNearbyDuplicate2 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums.length==1 ){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i < nums.length-1){
            j=i+1;
            while(j<nums.length&&j-i<=k){
            if(nums[i]==nums[j]){
                return true;
            	}
             	j++;
            }
             i++;
        }
        return false;
		
    }
}

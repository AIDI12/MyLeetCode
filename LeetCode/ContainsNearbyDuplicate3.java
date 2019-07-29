package Leetcode;
/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * @author AD
 *
 */
public class ContainsNearbyDuplicate3 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums.length==1 ){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i < nums.length-1){
            j=i+1;
            while(j<nums.length&& j-i<=k){
            	long l1 = nums[i];
            	long l2 = nums[j];
            if(Math.abs(l1 - l2) <= t){
                return true;
            	}
             	j++;
            }
             i++;
        }
        return false;
    }
}

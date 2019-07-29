package Leetcode;
/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * @author AD
 *
 */
public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
		int index = 0;
        if (nums.length>0){
            nums[index] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[index]){
                    nums[++index] = nums[i];
                    //System.out.println(index);
                }
            }
            index++;
        }
        //System.out.println(index);
        return index;
    }
	public static void main(String[] args) {
		int[] nums = {1,1,2,2};
		System.out.println(removeDuplicates(nums));
		
	}
}

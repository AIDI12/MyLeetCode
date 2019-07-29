package Leetcode;
/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * @author AD
 *
 */
public class SortColors {
	//桶排序
	public  void sortColors(int[] nums) {
        int[] count = {0,0,0};
        
        for (int i = 0; i < nums.length; i++) {
			count[nums[i]]++;
				
		}
        int index = 0;
        for (int i = 0; i < count[0]; i++) {
			nums[index++]=0;
		}
        for (int i = 0; i < count[1]; i++) {
			nums[index++]=1;
		}
        for (int i = 0; i < count[2]; i++) {
			nums[index++]=2;
		}
    }
}

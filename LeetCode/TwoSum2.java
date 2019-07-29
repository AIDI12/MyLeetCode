package Leetcode;
/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * @author AD
 *
 */
public class TwoSum2 {
	public int[] twoSum(int[] numbers, int target) {
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 1; j < numbers.length; j++) {
				if (numbers[i]+numbers[j] == target) {
					  return new int[] {i+1,j+1};
				}
			}
		}
		return null;   
    }
	public int[] twoSum2(int[] numbers, int target) {
		
		for (int i = 0; i < numbers.length; i++) {
			int low = i;
			int high = numbers.length-1;
			while(low <= high) {
				int mid = (low+high)/2;
				int midVal = numbers[mid];
				int num = target - numbers[i];
				if (num == midVal && i != mid) {
					return new int[] {i+1, mid+1};
				}else if (num > midVal) {
					low = mid + 1;
				}else if (num < midVal) {
					high = mid - 1;
				}else {
					low = mid + 1;
				}
			}
		}
		return null;   
    }
	public int[] twoSum3(int[] numbers, int target) {
		int l = 0;
		int r = numbers.length -1;
		while(l < r) {
			if (numbers[l] + numbers[r] == target) {
				return new int[] {l+1, r+1};
			}else if (numbers[l] + numbers[r] > target) {
				r--;
			}else {
				l++;
			}
		}
		return null;   
    }
	
}

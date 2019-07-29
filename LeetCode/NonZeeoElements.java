package Leetcode;

import java.util.Vector;

public class NonZeeoElements {
	public static void moveZeroes(int[] nums) {
		// nums �У�[0,k)��Ԫ��Ϊ�� 0 Ԫ��
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				if (i != j) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j++] = temp;
				} else {
					j++;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}
	
}

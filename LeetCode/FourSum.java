package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * @author AD
 *
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		//数组排序
        Arrays.sort(nums);
        //保存结果
        List<List<Integer>> list=new ArrayList();
        //左右指针
        int left, right, len = nums.length;
        for(int i = 0; i < nums.length-3; i++){
            //去重
            if(i > 0 && nums[i] == nums[i-1]) continue;
            //一轮直接淘汰不符合的，这一步是提高效率的关键
            //4数最大值和最小值
            int minf1 = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            int maxf1 = nums[i] + nums[len-1] + nums[len-2] + nums[len-3];
            //如果最大值小于target，最小值大于target，不满足，跳过
            if(target < minf1 || target > maxf1){
                continue;
            }
            //循环遍历
            for(int j=i+1;j<nums.length-2;j++){
                //去重
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                //转化为三数之和
                int temp = target - nums[i] - nums[j];
                //从j+1到len-1 找和为temp的两个数
                left=j+1;right=len-1;
                int count=1000000;
                while (left < right){
                    //去重,count保存上一个nums[left]的值
                    if(nums[left] == count){
                      left ++;   
                      continue;
                    }
                        
                    int s = temp - nums[left] - nums[right];
                    //保存结果
                    if(s==0){
                        List<Integer> a = new ArrayList();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[left]);
                        a.add(nums[right]);
                            
                        count = nums[left];
                        left++;
                        right--;
                        list.add(a);
                    }else if (s > 0){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return list;
    }
}

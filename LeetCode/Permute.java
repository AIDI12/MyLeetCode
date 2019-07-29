package Leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * @author AD
 *
 */
public class Permute {
	
	private List<List<Integer>> res = new ArrayList<>();
	
	
	public List<List<Integer>> permute(int[] nums) {
		
        if (nums.length == 0) {
			return res;
		}
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < used.length; i++) {
			used[i] = false;
		}
        List<Integer> p = new ArrayList<>();
        generatePermute(nums, 0, p, used);   
        
		return res;
    }
	
	private void generatePermute(int[] nums, int index, List<Integer> p, boolean[] used) {
		if (index == nums.length) {
			res.add(new ArrayList<>(p));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {

			if (!used[i] ) {
				p.add(nums[i]);
				used[i] = true;
				generatePermute(nums, index + 1, p, used);
				p.remove(p.size() - 1);
				used[i] = false;
			}
		}
		return;
	} 
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		
		Permute permute = new Permute();
		List<List<Integer>> res = permute.permute(nums);
		for (List<Integer> list : res) {
			System.out.println(list.size());
		}
	}
	
	
	
	public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        find(list,nums, 0, nums.length - 1);
        return list;
    }
    public List<Integer> set(int[] nums){
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        return list;
    }
    public void swap(int[] nums,int L,int R){
        int tmp=nums[L];
        nums[L]=nums[R];
        nums[R]=tmp;
        return;
    }
     public void find(List<List<Integer>> list,int[] nums,int L,int R){
        if(L==R){//只有一位的时候，直接set
            list.add(set(nums));
        }else{
            for (int i = L; i <= R; i++) {
                swap(nums,L, i);//将第i个数放到第一位固定，然后去排后面的，这样就不用使用hash表来保存使用了多少数字，以及哪些数字没有使用了
                int[] nums_tmp=nums.clone();
                find(list,nums_tmp, L + 1, R);
            }
        }
         return;
     }
}

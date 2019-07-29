package Leetcode;
/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * @author AD
 *
 */
public class FindMedianSortedArrays {
	
	public double findMedianSortedArrays(int[] A, int[] B) {
		//数组长度
        int m = A.length;
        int n = B.length;
        //确保m <= n
        //此时A数组中位数的取值为0~m，B数组中位数的取值为（m + n + 1）/2 - i
        if (m > n) {
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        //两个指针
        //halfLen为全局中位数点
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        
        while (iMin <= iMax) {
        	//A数组中位数
            int i = (iMin + iMax) / 2;
            //B数组中位数
            int j = halfLen - i;
            //不满足B[j-1] <= A[i]
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; //i is to small
            }//不满足A[i-1] <= B[j]
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                //中位数在B数组上
                if (i == 0) { maxLeft = B[j-1]; }
                //中位数在A数组上
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                //奇数
                if ( (m + n) % 2 == 1 ) { return maxLeft; }
                //偶数
                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}

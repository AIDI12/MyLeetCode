package Leetcode;
/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @author AD
 *
 */
public class Reverse {
	public int reverse(int x) {
		//保存反转结果
		int rev = 0;
        while (x != 0) {
        	//每次弹出个位的数
            int pop = x % 10;
            //删除个位数
            x /= 10;
            /**
             * 溢出判断
             * 如果结果大于int最大值或当前反转结果等于最大值/10，弹出个位数大于最大值%10
             * 如果结果小于int最小值或当前反转结果等于最小值/10，弹出个位数小于最小值%10
             */
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) return 0;
            //每次把个位数进位
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

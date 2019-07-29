package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 回溯法
 * @author AD
 *
 */
public class SolveNQueens {
	public List<List<String>> solveNQueens(int n) {
        //递归函数本身是从上往下执行的，所以不需要保存第几行的数据
        boolean[] row = new boolean[n];//用于保存哪一列已经放置了棋子
        boolean[] left = new boolean[2*n-1];//用于保存哪一左斜排已经放置了棋子
        boolean[] right = new boolean[2*n-1];//用于保存哪一右斜排已经放置了棋子
        int[] num = new int[n];
        List<List<String>> list = new ArrayList<List<String>>();
        //递归
        find(list, 0, row, left, right, n, num);
        return list;
       
    }
    //c代表当前处理第几行，num记录了在第几行的第几个位置放了棋子
    public void find(List<List<String>> list, int c, boolean[] row, boolean[] left, boolean[] right, int n, int[] num){
        if(c==n){//递归基
            List<String> now = new ArrayList();
            //绘制棋盘
            for(int i=0; i<n; i++){
                StringBuffer sb = new StringBuffer();
                for(int j=0; j<n; j++){
                    if(j != num[i]){
                        sb.append('.');
                    }else{
                        sb.append('Q');
                    }
                }
                now.add(sb.toString());
            }
            list.add(now);
            return;
        }
        
        for(int k=0; k<n; k++){
        	//c为横坐标，k为纵坐标
        	//row[k] = false && 左对角线为false && 右对角线为false
        	
            if(!row[k] && !left[c+k] && !right[n-1-(c-k)]){
            	//c代表当前处理第几行，num记录了在第几行的第几个位置放了棋子
                num[c] = k;//num不用回溯，因为在找到了解的前提下，num里的值肯定被重置过一遍了，回溯后num[c] 被覆盖了
                //在(c,k)放置棋子
                row[k] = true;
                //左对角线置为true
                left[c+k] = true;
                //右对角线置为true
                right[n-1-c+k] = true;//置位，表示以及被占用
                //递归
                find(list,c+1,row,left,right,n,num);
                //回溯
                row[k] = false;
                left[c+k] = false;
                right[n-1-c+k] = false;//回溯
            }
        }
        return;
    }
    
    public List<List<String>> solveNQueens_2(int n) {
    	List<List<String>> list = new ArrayList<List<String>>();
    	//保存每一行的皇后放置的位置
    	int[] row = new int[n];
    	//放置皇后
    	
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
			
			}
		}
    	
    	
    	return list;
    }
    //检查皇后位置是否合法
    private class Queen {
    	private int x;
    	private int y;
    	
		public Queen(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
    }
}

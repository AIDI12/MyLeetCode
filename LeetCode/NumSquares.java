package Leetcode;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * @author AD
 *
 */
public class NumSquares {
	public static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int step = 1;
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int cur = queue.remove();
                for (int j = 1; ; j++) {
                    int next = cur + j * j;
                    if (next > n) {
                        break;
                    } 
                    if (next == n) {
                        return step;
                    }
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        throw new IllegalArgumentException("No Solution");
    }
	public static void main(String[] args) {
		int n = 12;
		int step = numSquares(n);
		System.out.println(step);
	}
}

package Leetcode;
/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * @author AD
 *
 */
public class NumIslands {
	
	private int[][] d = {{-1, 0}, {0,1}, {1, 0}, {0, -1}};
	
	public int numIslands(char[][] grid) {
		int res = 0;
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
			return 0;
		}
        boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = false;
			}
		}
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					res = res + 1;
					isLand(grid, i, j, visited);
				}
			}
		}
		return res;
    }
	private void isLand(char[][] grid, int startX, int startY, boolean[][] visited) {
	
		visited[startX][startY] = true;
		
		for (int i = 0; i < 4; i++) {
			int newX = startX + d[i][0];
			int newY = startY + d[i][1];
			if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && 
					grid[newX][newY] == 1 && !visited[newX][newY]) {
				isLand(grid, newX, newY, visited);
			}
		}
		return;
	}
	public static void main(String[] args) {
		char[][] grid = {{1, 1, 1, 1, 0},
						{1, 1, 0, 1, 0},
						{1, 1, 0, 0, 0},
						{0, 0, 1, 0, 1}};
		
		NumIslands numIslands = new NumIslands();
		int res = numIslands.numIslands(grid);
		System.out.println(res);
	}
}


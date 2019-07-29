package Leetcode;
/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * @author AD
 *
 */
public class Exist {
    private int[][] d = {{-1, 0}, {0,1}, {1, 0}, {0, -1}};
	
	
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;
		
		if (word.length() == 0)
			return true;
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				
				visited[i][j] = false;
			}
		}
		
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (searchWord(board, word, i, j, 0, visited)) {
					return true;
				}
			}
		}

		return false;
	}
	
	private boolean searchWord(char[][] board, String word, int startX, int startY, int index, boolean[][] visited) {
		//递归基
		if (index == word.length() - 1) {
			return board[startX][startY] == word.charAt(index);
		}
		if (board[startX][startY] == word.charAt(index)) {
			visited[startX][startY] = true;
			//四个方向搜索
			for (int i = 0; i < 4; i++) {
				int newX = startX + d[i][0];
				int newY = startY + d[i][1];
				//判断元素是否使用过 并且与需匹配字符是否相等
				if ( newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length &&
						!visited[newX][newY]) {
					if(searchWord(board, word, newX, newY, index + 1, visited)){
						return true;
					}
				}
			}
			visited[startX][startY] = false;
		}
		
		return false;
	}

	
	public static void main(String[] args) {
		char[][] board = new char[][]{{'A','A'}};
		String s = "AAA";
		System.out.println(s);
		Exist exist = new Exist();
		System.out.println(exist.exist(board, s));
	}
}

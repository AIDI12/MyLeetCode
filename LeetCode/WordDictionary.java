package Leetcode;

import java.util.TreeMap;
/**
 * 设计一个支持以下两种操作的数据结构：
*void addWord(word)
*bool search(word)
*search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * @author AD
 *
 */
public class WordDictionary {
	// 节点类
	private class Node {
		public boolean isWord;
		public TreeMap<Character, Node> next;

		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<>();
		}

		public Node() {
			this(false);
		}
	}
	private Node root;
	/** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {

        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        //如果单词不存在
        if(!cur.isWord){
            cur.isWord = true;
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        //递归
    	return match(root, word, 0);
    }
    private boolean match(Node node, String word, int index) {
    	if (index == word.length()) {
			return node.isWord;
		}
    	char c = word.charAt(index);
    	if (c != '.') {
			if (node.next.get(c) == null) {
				return false;
			}
			return match(node.next.get(c), word, index + 1);
		}else {
			for (char nextChar : node.next.keySet()) {
				if (match(node.next.get(nextChar), word, index + 1)) {
					return true;
				}
			}
			return false;
		}
    }
}

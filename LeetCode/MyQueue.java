package Leetcode;

import java.util.Stack;
/**
 * 使用栈实现队列的下列操作：

    push(x) -- 将一个元素放入队列的尾部。
    pop() -- 从队列首部移除元素。
    peek() -- 返回队列首部的元素。
    empty() -- 返回队列是否为空。

 * @author AD
 *
 */
public class MyQueue {
	//使用两个栈来实现
	private Stack<Integer> mainStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        mainStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        mainStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> tempStack = new Stack<>();
        while(!mainStack.empty()){
            tempStack.push(mainStack.pop());
        }
        int result = tempStack.pop();
        while(!tempStack.empty()){
            mainStack.push(tempStack.pop());
        }
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        Stack<Integer> tempStack = new Stack<>();
        while(!mainStack.empty()){
            tempStack.push(mainStack.pop());
        }
        int result = tempStack.pop();
        tempStack.push(result);
        while(!tempStack.empty()){
            mainStack.push(tempStack.pop());
        }
        return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mainStack.empty();
    }
}

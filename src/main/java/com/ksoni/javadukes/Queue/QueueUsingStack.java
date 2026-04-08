package com.ksoni.javadukes.Queue;

import java.util.Stack;

public class QueueUsingStack {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    public static void main(String[] args) {


    }

    /** Push element X to the back of queue. */
    static void push(int X) {
        stack1.push(X);
    }

    /** Removes the element from in front of queue and returns that element. */
    static int pop() {

        if(!stack2.empty()) {
            return stack2.pop();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    /** Get the front element of the queue. */
    static int peek() {
        if(!stack2.empty()) {
           return stack2.peek();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    /** Returns whether the queue is empty. */
    static boolean empty() {
        return stack1.empty() && stack2.empty();
    }


}

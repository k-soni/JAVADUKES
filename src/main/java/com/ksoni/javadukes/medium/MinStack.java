package com.ksoni.javadukes.medium;

import java.util.ArrayList;

public class MinStack {
    ArrayList<Integer> numStack = new ArrayList<Integer>();
    ArrayList<Integer> minStack = new ArrayList<Integer>();
    int minNum = Integer.MAX_VALUE;
    public static void main(final String[] args) {
    }

    public void push(int x) {
        numStack.add(x);
        if(minStack.isEmpty() || x <= minStack.get(minStack.size() - 1)) {
            minStack.add(x);
        }
    }

    public void pop() {
        int removedNum = numStack.remove(numStack.size() - 1);
        if(removedNum == minStack.get(minStack.size() - 1)) {
            minStack.remove(minStack.size() - 1);
        }
    }

    public int top() {
        if(numStack.size() == 0) {
            return -1;
        }
        return numStack.get(numStack.size() - 1);
    }

    public int getMin() {
        if(minStack.size() == 0) {
            return -1;
        }
        return minStack.get(minStack.size() - 1);
    }
}

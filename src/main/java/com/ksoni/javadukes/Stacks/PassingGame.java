package com.ksoni.javadukes.Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class PassingGame {
    public static void main(String[] args) {

    }

    public int solve(int A, int B, ArrayList<Integer> C) {
        Stack<Integer> stack = new Stack<>();
        stack.push(B);

        for (int i = 0; i < A; i++) {
            int playerId = C.get(i);
            if(playerId != 0) {
                stack.push(playerId);
            } else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        return stack.peek();
    }

}

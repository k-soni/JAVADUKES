package com.ksoni.javadukes.Stacks;

import java.util.List;
import java.util.Stack;

public class DoubleCharacterTrouble {
    public static void main(String[] args) {
        DoubleCharacterTrouble doubleCharacterTrouble = new DoubleCharacterTrouble();
        doubleCharacterTrouble.solve("abccbc");
    }

    public String solve(String A) {
        String res = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(A.charAt(i));
            } else {
                Character topVal = stack.peek();
                if(topVal == A.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(A.charAt(i));
                }
            }
        }

        StringBuilder res1 = new StringBuilder();
        while(!stack.isEmpty()) {
            res1.append(stack.pop());
        }
        res1.reverse();
        return res1.toString();
    }
}

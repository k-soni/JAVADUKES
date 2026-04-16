package com.ksoni.javadukes.Stacks;

import java.util.Stack;

public class BalancedParenthis {
    public static void main(String[] args) {

    }

    public int solve(String A) {
        Stack<String> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            Character ele = A.charAt(i);

            if(ele.toString().equals("}") || ele.toString().equals(")") || ele.toString().equals("]")) {
                if(stack.isEmpty()) {
                    result = 0;
                    return result;
                } else {
                    if(ele.toString().equals("}") && stack.peek().equals("{")) {
                        stack.pop();
                    } else if(ele.toString().equals(")") && stack.peek().equals("(")) {
                        stack.pop();
                    } else if(ele.toString().equals("]") && stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        result = 0;
                        return result;
                    }
                }
            } else {
                stack.push(ele.toString());
            }

        }

        return stack.empty() ? 1 : result;
    }
}

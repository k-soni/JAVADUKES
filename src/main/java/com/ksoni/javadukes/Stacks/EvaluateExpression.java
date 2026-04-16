package com.ksoni.javadukes.Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {

    }

    public int evalRPN(ArrayList<String> A) {
        if(A.size() == 1) {
            return Integer.parseInt(A.get(0));
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            if(A.get(i).equals("+") || A.get(i).equals("-") || A.get(i).equals("*") || A.get(i).equals("/")) {
                if(stack.size() >=2) {
                    int y =stack.pop();
                    int x = stack.pop();
                    String operator = A.get(i);
                    int res = 0;
                    if(operator.equals("+")) {
                        res = x+y;
                    } else  if(operator.equals("-")) {
                        res = x-y;
                    }else  if(operator.equals("*")) {
                        res = x*y;
                    } else {
                        res = x/y;
                    }

                    stack.push(res);
                    result = res;
                } else {
                    result = 0;
                    return result;
                }
            } else {
                stack.push(Integer.parseInt(A.get(i)));
            }
        }
        return result;
    }
}

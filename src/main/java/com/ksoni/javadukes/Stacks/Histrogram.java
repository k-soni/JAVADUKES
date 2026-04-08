package com.ksoni.javadukes.Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Histrogram {

    public static void main(String[] args) {
        Histrogram histrogram = new Histrogram();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(69,47,84,7,70,73,4,73,70,54,2,35,32,53,99,41,90,53,55,6,1,95,63,63,74,12,32,89,69,71,17,49,9,40,10,56));
        histrogram.largestRectangleArea(input);
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        int count = 0;
        if(A.size() == 1) {
            return A.get(0);
        }

        Stack<Integer> stack = new Stack<>();
        int[] smallestNumberLeftSide = new int[A.size()];

        for (int i = 0; i < A.size(); i++) {
            // pop biggest element
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                smallestNumberLeftSide[i] = -1;
            } else {
                smallestNumberLeftSide[i] = stack.peek();
            }

            stack.push(i);

        }

        int[] smallerNumberRightSide = new int[A.size()];
        stack = new Stack<>();

        for (int i = A.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                smallerNumberRightSide[i] = A.size();
            } else {
                smallerNumberRightSide[i] = stack.peek();
            }

            stack.push(i);
        }

        for (int i = 0; i < A.size(); i++) {
            int width = smallerNumberRightSide[i] - smallestNumberLeftSide[i] -1;
            count = Math.max(count, A.get(i)*width);
        }

        System.out.println(count);
        return count;
    }


}



package com.ksoni.javadukes.Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearstSmallerElement {
    public static void main(String[] args) {
        NearstSmallerElement nearstSmallerElement = new NearstSmallerElement();
        nearstSmallerElement.prevSmaller(new ArrayList<>(Arrays.asList(39,27,11,4,24,32,32,1)));
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.size(); i++) {

            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                arrayList.add(-1);
            } else {
                arrayList.add(stack.peek());
            }
            stack.push(i);
        }

        return arrayList;
    }

}

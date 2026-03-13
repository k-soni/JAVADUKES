package com.ksoni.javadukes.medium;

import java.util.Stack;

// We can use a stack to find the next greater element.

// Push the first element in the stack.
// Pick rest of the elements one by one and follow the following steps in loop
// Mark the current element as next.
// If stack is not empty, compare top element of stack with next.
// If next is greater than the top element, Pop element from stack. Next is the next greater element for the popped element.
// Keep popping from the stack while the popped element is smaller than next. Next becomes the next greater element for all such popped elements.
// Finally, push the next in the stack.
// After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
// Time Complexity:- O(N)

public class NextGreater {
    public static void main(final String[] args) {
        NextGreater nextGreater = new NextGreater();
        int[] A = { 4, 5, 2, 10 };
        nextGreater.nextGreater2(A);
    }

    public Integer[] nextGreater(int[] A) {
        Stack<Integer> numStack = new Stack<>();
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length - 1; i++) {

            if (!numStack.isEmpty()) {
                System.out.println("stack not empty " + i);
                if (A[i] > numStack.peek()) {
                    while (!numStack.isEmpty()) {
                        numStack.pop();
                    }
                    numStack.push(A[i]);
                    ans[i] = A[i];
                } else {
                    System.out.println("stack not empty current is less " + i);
                    boolean greaterFound = false;
                    for (int j = i + 1; j < ans.length; j++) {
                        if (A[j] > A[i]) {
                            greaterFound = true;
                            numStack.push(A[j]);
                            ans[i] = A[j];
                            break;
                        }
                    }
                    if (!greaterFound) {
                        ans[i] = -1;
                    }
                }
            } else {
                System.out.println("stack empty " + i);
                boolean greaterFound = false;
                for (int j = i + 1; j < ans.length; j++) {
                    if (A[j] > A[i]) {
                        greaterFound = true;
                        numStack.push(A[j]);
                        ans[i] = A[j];
                        break;
                    }
                }
                if (!greaterFound) {
                    ans[i] = -1;
                }
            }
        }
        ans[ans.length - 1] = -1;

        Integer[] b = new Integer[ans.length];
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
            b[i] = ans[i];
        }
        return b;
    }

    public int[] nextGreater2(int[] A) {
        Stack<Integer> iStack = new Stack<>();
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (!iStack.isEmpty()) {

                if (A[i] > A[iStack.peek()]) {
                    System.out.println("stack size "+ iStack.size() + " - value " + iStack.peek());
                    for (int j = 0; j < iStack.size(); j++) {
                        if (A[i] > A[iStack.peek()]) {
                            ans[iStack.pop()] = A[i];
                        }
                    }
                    iStack.add(i);
                } else {
                    if(A[i] == A[iStack.peek()]) {
                        ans[i] = -1;
                    } else {
                        iStack.add(i);
                    }
                }
            } else {
                iStack.add(i);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
        return ans;
    }
}

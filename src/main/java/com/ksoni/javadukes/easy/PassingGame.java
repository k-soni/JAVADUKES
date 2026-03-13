package com.ksoni.javadukes.easy;

import java.util.Stack;

public class PassingGame {
    public static void main(final String[] args) {
        PassingGame pGame = new PassingGame();
        int A = 10;
        int B = 23;
        int[] C = { 86, 63, 60, 0, 47, 0, 99, 9, 0, 0 };
        int ans = pGame.passingGame(A, B, C);
        System.out.print(ans);
    }

    public int passingGame(int A, int B, int[] C) {
        Stack<Integer> playerStack = new Stack<Integer>();
        playerStack.push(B);
        System.out.println(playerStack.size());
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 0 && playerStack.size() > 1) {
                playerStack.pop();
            } else {
                playerStack.push(C[i]);
            }
        }
        return playerStack.peek();
    }
}

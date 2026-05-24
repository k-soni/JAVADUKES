package com.ksoni.javadukes.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;



public class ConnectRopes {
    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) {
            priorityQueue.add(A.get(i));
        }

        int count = 0;

        while (priorityQueue.size() > 1) {

            int x = priorityQueue.poll();
            int y = priorityQueue.poll();

            count = count + x + y;
            priorityQueue.add(x + y);
        }

        return count;


    }
}

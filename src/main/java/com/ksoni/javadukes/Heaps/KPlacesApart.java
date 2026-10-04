package com.ksoni.javadukes.Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KPlacesApart {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= B; i++) {
            pq.add(A.get(i));
        }
        int idx = 0;
        for (int i = B+1; i < A.size(); i++) {
            int curr = pq.poll();
            A.set(idx, curr);
            idx++;
            pq.offer(A.get(i));
        }

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            A.set(idx, curr);
            idx++;
        }
        return A;
    }
}

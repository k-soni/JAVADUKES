package com.ksoni.javadukes.Heaps;

public class BuildAHeap {

    public static void main(String[] args) {
        BuildAHeap buildHeap = new BuildAHeap();
        int[] ans = buildHeap.buildHeap(new int[]{10, 10, 8, 2, 9, 8, 7, 7, 10, 9});

        for (int num: ans) {
            System.out.println(num);
        }
    }

    public int[] buildHeap(int[] A) {
        // code here
        int n = A.length;
        int nonleafnode = n/2 -1;

        for (int i = nonleafnode; i >= 0; i--) {
            System.out.println(i);
            heapify(A,i);
        }

        return A;

    }

    public void heapify(int[] A, int i) {

        while ( 2 * i + 1 < A.length ||  2 * i + 2 < A.length) {
          int lc = 2 * i + 1;
          int rc = 2 * i + 2;
            int min = Math.min(A[i], A[lc]);
            if(rc < A.length) {
                min = Math.min(min, A[rc]);
            }
            if(min == A[i]) {
                break;
            } else if(min == A[lc]) {
                swap(A,i,lc);
                i = lc;
            } else {
                swap(A,i,rc);
                i = rc;
            }
        }
    }


    public void swap(int [] heap1, int parentIndex, int index) {
        int temp = heap1[parentIndex];
        heap1[parentIndex] = heap1[index];
        heap1[index] = temp;
    }
}

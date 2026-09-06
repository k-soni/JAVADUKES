package com.ksoni.javadukes.Heaps;

public class BuildAHeap {

    public static void main(String[] args) {
        BuildAHeap buildHeap = new BuildAHeap();
        int[] ans = buildHeap.buildHeap(new int[]{7,3,5,1,6,8,10,2,13,14,-2});
        for (int num: ans) {
            System.out.print(num + " ");
        }
        int[] result = buildHeap.extractMin(ans);
        System.out.println();
        for (int num: result) {
            System.out.print(num + " ");
        }
    }

    public int[] buildHeap(int[] A) {
        // code here
        int n = A.length;
        int nonleafnode = n/2 -1;

        for (int i = nonleafnode; i >= 0; i--) {

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

    public int[] extractMin(int[] heap) {
        swap(heap,0, heap.length - 1);
        int[] latestHeap = deleteLastElementFromheap(heap);
        heapify(latestHeap,0);
        return latestHeap;
    }

    public int[] deleteLastElementFromheap(int[] heap) {
        int[] heap2 = new int[heap.length - 1];
        for (int i = 0; i < heap2.length; i++) {
            heap2[i] = heap[i];
        }
        return heap2;
    }
}

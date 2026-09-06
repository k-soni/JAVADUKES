package com.ksoni.javadukes.Heaps;

public class BuildHeap2 {
    public static void main(String[] args) {

    }

    public int[] buildHeap(int[] A){
        int n = A.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(A, i);
        }
        return A;
    }

    public void heapify(int[] A, int idx) {
        while ( 2 * idx + 1 < A.length) {
            int lc = 2 * idx + 1;
            int rc = 2 * idx + 2;

            int min = Math.min(A[idx], A[lc]);
            if( 2 * idx + 2 < A.length) {
                min = Math.min(min, A[rc]);
            }

            if(min == A[idx]) {
                break;
            } else if( min == A[lc]) {
                swap(A, idx, lc);
                idx = lc;
            } else  {
                swap(A, idx, rc);
                idx = rc;
            }
        }
    }

    public void swap(int[] A, int pidx, int cidx) {
        int temp = A[pidx];
        A[pidx] = A[cidx];
        A[cidx] = temp;
    }

}

/**
 * Problem Description
 *
 * Given an array A of N integers, convert that array into a min heap and return the array.
 *
 * NOTE: A min heap is a binary tree where every node has a value less than or equal to its children.
 *
 *
 *
 * Problem Constraints
 *
 * 1 ≤ N ≤ 105
 *
 * 0 ≤ A[i] ≤ 109
 *
 *
 *
 * Input Format
 *
 * First and only argument of input contains a single integer array A of length N.
 *
 *
 *
 * Output Format
 *
 * Return the reordered array A such that it forms a min heap.
 *
 *
 *
 * Example Input
 *
 * Input:
 *
 * A = [5, 13, -2, 11, 27, 31, 0, 19]
 *
 *
 * Example Output
 *
 * Output:
 *
 * A = [-2, 5, 0, 13, 11, 19, 27, 31]
 * */
package com.ksoni.javadukes.medium;

import com.ksoni.javadukes.medium.RainWater.RainWaterTrap;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {
    public static void main(final String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3));
        NextPermutation nextPermutation = new NextPermutation();
        ArrayList<Integer> result = nextPermutation.nextPermutation(A);
        // print array
        for (int num : result) {
            System.out.print(num + " ");
        }
    }


    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n = A.size();

        // step 1
        int index = -1;
        for (int i = A.size() - 2; i >= 0; i--) {
            if(A.get(i) < A.get(i+1)) {
                index = i;
                break;
            }
        }

        // step 2: If no break point, reverse the whole array
        if(index == -1) {
            reverse(A, 0, n-1);
            return A;
        }

        // step 3: Find next greater element from right
        for (int i = n-1; i > index; i--) {
            if(A.get(i) > A.get(index)) {
                swap(A,i,index);
                break;
            }
        }

        // reverse
        reverse(A, index+1, n-1);
        return A;
    }

    private void reverse(ArrayList<Integer> A, int start, int end) {
        while (start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }


    private void swap(ArrayList<Integer> A, int i,int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j,temp);
    }

}

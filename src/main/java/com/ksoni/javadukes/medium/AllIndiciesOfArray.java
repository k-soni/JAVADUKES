package com.ksoni.javadukes.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class AllIndiciesOfArray {
    public static void main(final String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,1,2,3));
        AllIndiciesOfArray solution = new AllIndiciesOfArray();
        ArrayList<Integer> output = solution.allIndicies(arr, 1);
        for (int num: output) {
            System.out.println(num);
        }
    }

    public ArrayList<Integer> allIndicies(ArrayList<Integer> A, int B) {
        ArrayList<Integer> output = new ArrayList<>();
        findIndicesRecursive(0, output, A, B);
        return output;
    }

    public void findIndicesRecursive(int index, ArrayList<Integer> output, ArrayList<Integer> input, int B) {
        if(index == input.size()) {
            return;
        }
        if(input.get(index) == B) {
            output.add(index);
        }
        findIndicesRecursive(index+1, output, input, B);
    }
}

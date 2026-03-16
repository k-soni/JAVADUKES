package com.ksoni.javadukes.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class FrequencyArray {
    public static void main(final String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10,9,8));

        FrequencyArray test = new FrequencyArray();
        ArrayList<Integer> res = test.sortArray(arr);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public ArrayList<Integer> createFrequencyArray(ArrayList<Integer> arr) {
        System.out.println("createFrequencyArray");
        // get the max value
        int max = 0;
        int min = 0;
        for (int num: arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        ArrayList<Integer> frequencyArr = new ArrayList<>();

        // set default value till max number

        for (int i = 0; i <= max; i++) {
            frequencyArr.add(0);
        }

        for (int i = 0; i < arr.size(); i++) {

            int value = arr.get(i);
            frequencyArr.set(value, frequencyArr.get(value) + 1);
        }
        return frequencyArr;
    }

    public ArrayList<Integer> sortArray(ArrayList<Integer> arr) {
        ArrayList<Integer> frequencyArr = createFrequencyArray(arr);
        ArrayList<Integer> sortedArr = new ArrayList<>();
//        int max = 0;
//        for (int num: arr) {
//            max = Math.max(max,num);
//        }
//        for (int i = 0; i < max; i++) {
//            sortedArr.add(0);
//        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < frequencyArr.get(arr.get(i)); j++) {
                sortedArr.add(i);
            }
        }
        return sortedArr;
    }

}

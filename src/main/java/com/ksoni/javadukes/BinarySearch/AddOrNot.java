package com.ksoni.javadukes.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddOrNot {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3,1,2,2,1));
        int B = 3;

        AddOrNot addOrNot = new AddOrNot();
        addOrNot.solution(input, B);
    }

    public ArrayList<Integer> solution(ArrayList<Integer> arr, int B) {
        //sort
        Collections.sort(arr);

        int[] prefixSum = getPrefixSum(arr);
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            // search space
            int minPossibleOccurance = 1;
            int maxPossibleOccurance = i+1;
            int occurance = 1;
            System.out.println("i "+i);
            while (minPossibleOccurance <= maxPossibleOccurance) {
                /*
                 *  mid means how many operation are required
                 *   [1,2,4,04,06,08]
                 *   [1,3,7,11,17,25] prefix sum
                 *   how many operations are required to make four elements equal to six
                 *   l = 1, r = 5, mid = 3 (l+r/2)
                 *     mid means how many operations are required to make mid elements equal to current element
                 * */
                int mid = minPossibleOccurance + (maxPossibleOccurance - minPossibleOccurance)/2;

                System.out.println("mid "+mid);
                System.out.println("i-mid "+(i-mid));
                int index = Math.max(i - mid, 0);
                int operations = (arr.get(i) * mid) - prefixSum[i] + prefixSum[index];

                System.out.println("operations "+ operations);
                if(operations <= B) {
                    System.out.println("minPossibleOccurance");
                    occurance = mid;
                    minPossibleOccurance = mid + 1;
                } else {
                    System.out.println("maxPossibleOccurance");
                    maxPossibleOccurance = mid - 1;
                }
            }
            if(res.isEmpty()) {
                res.add(arr.get(i));
                res.add(occurance);
            } else if(occurance > res.get(1)) {
                res.add(arr.get(i));
                res.add(occurance);
            }






            //

        }
        System.out.println("res[0] "+ res.get(0));
        System.out.println("res[1] "+ res.get(1));
        return res;

    }

    public int[] getPrefixSum(ArrayList<Integer> arr) {
        int[] prefixSum = new int[arr.size()];
        for (int i = 1; i < arr.size(); i++) {
            prefixSum[i] = prefixSum[i-1] + arr.get(i);
        }

        return prefixSum;

    }
}

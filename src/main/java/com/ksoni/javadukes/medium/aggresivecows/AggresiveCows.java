package com.ksoni.javadukes.medium.aggresivecows;

import java.util.ArrayList;
import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int B = 3;
        AggresiveCows aggresiveCows = new AggresiveCows();
        int result = aggresiveCows.solution(A, B);
        System.out.println(result);
    }

    /**
     * A is
     * */
    public int solution(ArrayList<Integer> stallLocations, int numberofCows) {
        int mindistance = 1;
        int maxDistance = stallLocations.get(stallLocations.size()-1) - stallLocations.get(0);
        int ans = 0;



        while (mindistance < maxDistance) {
            int mid = mindistance + (maxDistance - mindistance)/2;
            boolean isPossible = findMaxMindistanceBetweenCows(stallLocations, mid, numberofCows);

            if(isPossible) {
                ans = mid;
                maxDistance = mid +1;
            } else {
                mindistance = mid-1;
            }

        }

        return ans;
    }


    public boolean findMaxMindistanceBetweenCows(ArrayList<Integer> A, int mid, int numberOfCows) {
        int distance = A.get(0);
        int cows = 1;
        for (int i = 1; i < A.size(); i++) {
            if(A.get(i) - distance >= mid) {
                cows++;
                distance = A.get(i);
            }
        }
        return cows >= numberOfCows;
    }

}

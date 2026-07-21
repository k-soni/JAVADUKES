package com.ksoni.javadukes.Intervals;

import com.ksoni.javadukes.SubArray.MaxSubArraySum;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {1,4}, {5,6}, {6,8}, {7,10}, {8,9},{12,14}};
        int[][] intervals2 = {{1,10}, {2,3}, {4,5}, {9,12}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] ans = mergeIntervals.mergeIntervals(intervals2);

}

    public int[][] mergeIntervals(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        int s1 = intervals[0][0];
        int e1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int s2 = currentInterval[0];
            int e2 = currentInterval[1];

            if(e1 >= s2) {
                s1 = Math.min(s1,s2);
                e1 = Math.max(e1,e2);
            } else {
                ans.add(new int[]{s1,e1});
                s1 = s2;
                e1 = e2;
            }
        }

        // Add the last interval
        ans.add(new int[]{s1, e1});
        // Convert List<int[]> to int[][]
        return ans.toArray(new int[ans.size()][]);
    }

}

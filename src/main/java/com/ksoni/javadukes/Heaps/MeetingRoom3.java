package com.ksoni.javadukes.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom3 {

    public static void main(String[] args) {
        MeetingRoom3 meetingRoom3 = new MeetingRoom3();

    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        MeetingIntervals[] meetingIntervals = new MeetingIntervals[A];
        for (int i = 0; i < B.size(); i++) {
            MeetingIntervals meetingIntervals1 = new MeetingIntervals(B.get(i).get(0), B.get(i).get(1));
            meetingIntervals[i] = meetingIntervals1;
        }

        Arrays.sort(meetingIntervals, new Comparator<MeetingIntervals>() {
            @Override
            public int compare(MeetingIntervals o1, MeetingIntervals o2) {
                return o1.startUnit - o2.startUnit;
            }
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(meetingIntervals[0].endUnit);

        for (int i = 1; i < meetingIntervals.length; i++) {
            if(meetingIntervals[i].startUnit >= priorityQueue.peek()) {
                priorityQueue.poll();
            }
            priorityQueue.offer(meetingIntervals[i].endUnit);
        }

        return priorityQueue.size();

    }

    class MeetingIntervals {
        int startUnit;
        int endUnit;

        public MeetingIntervals(int startUnit, int endUnit) {
            this.startUnit = startUnit;
            this.endUnit = endUnit;
        }
    }
}

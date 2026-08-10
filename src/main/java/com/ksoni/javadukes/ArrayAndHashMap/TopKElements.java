package com.ksoni.javadukes.ArrayAndHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElements {
    public static void main(String[] args) {
        TopKElements elements = new TopKElements();
        elements.solve(new int[]{1,2, 2, 1, 1, 2, 3, 4}, 3);
    }

    public int[] solve(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());

        int[] finalAns = new int[target];

        for (int i = 0; i < target; i++) {
            finalAns[i] = list.get(i).getValue();
        }

        return finalAns;
    }


}

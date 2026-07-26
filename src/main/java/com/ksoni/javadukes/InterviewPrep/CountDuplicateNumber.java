package com.ksoni.javadukes.InterviewPrep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicateNumber {
    public static void main(String[] args) {
        List<Integer> input = List.of(1,2,3,2,4,3,5,5,6,3,2,1);
        // output
        // 1 -> 2
        // 2 -> 3...
        //.....

        CountDuplicateNumber countDuplicateNumber = new CountDuplicateNumber();
        countDuplicateNumber.countDuplicatesUsingJava8(input);
    }

    public void countDuplicatesUsingJava8(List<Integer> input) {

        Map<Integer, Long> frequency =
                input.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));

        frequency.forEach((key, value) ->
                System.out.println(key + " -> " + value));

    }


    public void countDuplicationNumber(List<Integer> input) {
        Map<Integer, Long> frequeny = input.stream().collect(
               Collectors.groupingBy(
                       Function.identity(),
                       Collectors.counting()
               )
        );



        frequeny.forEach((k,v) -> System.out.println(k + " ->" +v));
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();

        for (int i = 0; i < input.size(); i++) {
            hashMap.put(input.get(i), hashMap.getOrDefault(input.get(i), 0) + 1);
        }

        // incorrect approach

//        for (int i = 0; i < hashMap.size(); i++) {
//            System.out.println("key: "+ input.get(i) + " value: "+ hashMap.get(input.get(i)));
//        }


        // iterate over map entries
           for (Map.Entry<Integer,Integer> entry: hashMap.entrySet()) {
               System.out.println(" Key : "+ entry.getKey() + " Value : "+ entry.getValue());
           }


    }
}

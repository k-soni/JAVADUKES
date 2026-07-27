package com.ksoni.javadukes.twopointers;

import java.util.HashSet;
import java.util.Set;

public class LongestStringSubString {
    public static void main(String[] args) {
        LongestStringSubString longestStringSubString = new LongestStringSubString();
        longestStringSubString.solve("abcdefabcbbcaefgxyzbcaef");
    }

    public String solve(String str) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLen = 0;
        int start = 0;

        for (int right = 0; right < str.length(); right++) {

            // left postion handling
            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }
            // add char to set
            set.add(str.charAt(right));

            // handling max length
            if(right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                start = left;
            }

        }
        System.out.println(str.substring(start, start + maxLen));
        return str.substring(start, start + maxLen);

    }
}

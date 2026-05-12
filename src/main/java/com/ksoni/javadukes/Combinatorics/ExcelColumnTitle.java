package com.ksoni.javadukes.Combinatorics;

import java.util.HashMap;

public class ExcelColumnTitle {
    public static void main(String[] args) {
        ExcelColumnTitle excelColumnTitle = new ExcelColumnTitle();
        excelColumnTitle.getColumntitle(28);
    }

    public String getColumntitle(int A) {
        String ans = "";
        while (A > 0) {
            int rem = A%26;
            A = A/26;

            if(rem == 0) {
                rem = 26;
                A = A - 1;
            }

            Character ch = (char) (rem -1 + 'A');
            ans = ch + ans;
        }

        System.out.println(ans);
        return ans;

    }


}

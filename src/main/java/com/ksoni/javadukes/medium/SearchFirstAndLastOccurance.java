package com.ksoni.javadukes.medium;

import java.util.ArrayList;
import java.util.List;

public class SearchFirstAndLastOccurance {
    public static void main(final String[] args){

    }

    public ArrayList<Integer> searchForOccurance(final List<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();

          if(A.size() == 1 && A.get(0) == B) {
            res.set(0,0);res.set(0,0);
            return res;
        }


        int l = 0;
        int r = A.size() - 1;
        int leftOccurance = 0;
        while(l<r){
            int mid = l + (r-l)/2;
            if(A.get(mid) == B) {
                leftOccurance = mid;
                r = mid - l;
            } else if(A.get(mid) > B) {
                 r = mid - l;
            } else {
                l = mid + 1;
            }
        }

        l = 0;
        r = A.size()-1;
        int rightOccurance = 0;
        while(l<r){
            int mid = l + (r-l)/2;
            if(A.get(mid) == B) {
                rightOccurance = mid;
                l = mid + l;
            } else if(A.get(mid) > B) {
                 r = mid - l;
            } else {
                l = mid + 1;
            }
        }
        res.add(leftOccurance);
        res.add(rightOccurance);
        return res;
    }
}

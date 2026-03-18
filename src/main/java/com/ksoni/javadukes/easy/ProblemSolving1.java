package com.ksoni.javadukes.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class ProblemSolving1 {

    public static void main(final String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2,4,1,3,2));
        ProblemSolving1 problemSolving1 = new ProblemSolving1();
        problemSolving1.rangeReverseArray1(A,3);
    }

    public int countOfElements(int[] A) {
        int count = 0;
        for (int idx = 0; idx < A.length; idx++) {
            int i = 0;
            int j = A.length;

            while (i <= j) {
                if(A[i] > A[idx] || A[j] > A[idx]) {
                    count +=1;
                    break;
                }
                i++;j--;
            }

        }
        return count;
    }

    public int linearSearchMultiOccurance(ArrayList<Integer> A, int B) {
        int count = 0;
        for (int num: A) {
            if(num == B) {
                count++;
            }
        }
        return count;
    }

    public int countFactorsBF(int A) {
        int count = 0;
        for (int i = 1; i <= A; i++) {
            if(A%i == 0) {
                count++;
            }
        }
        System.out.println("Count factor of "+A+" is "+count);
        return count;
    }

    public int countFactorsOPT(int A) {
        int count = 0;
        for (int i = 1; i * i <= A; i++) {
            if(A % i == 0) {
                if(i == A/i) {
                    count = count + 1;
                } else {
                    count = count + 2;
                }
            }
        }
        System.out.println("Count factor of "+A+" is "+count);
        return count;
    }

    public int goodPair(ArrayList<Integer> A, int B) {
        int ans = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i+1; j < A.size(); j++) {
                if(A.get(i) + A.get(j) == B) {
                    ans = 1;
                    return ans;
                }
            }
        }
        System.out.println("Good pair "+ans);
        return ans;
    }

    public int maxMinSum(ArrayList<Integer> A) {
        int min = A.get(0);
        int max = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            if(A.get(i) < min) {
                min = A.get(i);
            }
            if(A.get(i) > max) {
                max = A.get(i);
            }
        }
        System.out.println("Min Max Sum "+min + max);
        return min + max;
    }

    public ArrayList<Integer> arrayRotation(ArrayList<Integer> A, int B) {

        int temp = A.get(A.size() - 1);

        for (int t = A.size()-1; t > 0; t--) {
                A.set(t, A.get(t-1));
        }
        A.set(0,temp);
        return A;
    }

    public void rangeReverseArray1(ArrayList<Integer> A, int K) {
        rangeReverseArray(A, 0, A.size() -1);
        rangeReverseArray(A, 0, K-1);
        rangeReverseArray(A, K, A.size()-1);
        for (int num: A) {
            System.out.println(num);
        }
    }



    public ArrayList<Integer> rangeReverseArray(ArrayList<Integer> A, int B,int C) {
        int start = B;
        int end = C;
        while (start <= end) {
            int temp = A.get(start);
            A.set(start, A.get(end));
            A.set(end,temp);
            start++;
            end--;
        }

        return A;
    }

    public int timeToEquality(ArrayList<Integer> A) {
        int peakElement = 0;
        int count = 0;
        for (int num: A) {
            peakElement = Math.max(peakElement,num);
        }

        for (int num: A) {
            count += peakElement - num;
        }
        System.out.println(count);
        return  count;
    }

    public int secondLargest(ArrayList<Integer> A) {
        int firstLargest = A.get(0);
        int secondLargest = -1;

        for (int num: A) {
            if(num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if(num > secondLargest && num != firstLargest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }





}

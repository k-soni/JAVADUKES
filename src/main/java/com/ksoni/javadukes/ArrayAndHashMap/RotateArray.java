package com.ksoni.javadukes.ArrayAndHashMap;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] res = rotateArray.solve(new int[]{1,2,3,4,5,6,7},3);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    
    public int[] solve(int[] A, int target) {

        target = target % A.length;

        rotate(A, 0, A.length -1);
        rotate(A,0, target -1);
        rotate(A, target, A.length -1);
        return A;
    }
    
    private void rotate(int[] A, int start, int end) {
        while (start<end) {
            int temp = A[start];
             A[start] = A[end];
             A[end] = temp;
             start++;
             end--;
        }
    }
}

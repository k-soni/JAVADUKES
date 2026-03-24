package com.ksoni.javadukes;

import java.util.List;

public class PrintArrayElements<T, U> {

    public void printArray(T[] list) {
         for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + " ");
        }
    }
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
    }
}
package com.tyler.lesson02;

public class ReverseArray {
    private static int[] reverseArray = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        for (int i = 0; i < reverseArray.length; i++) {
            System.out.print("| " + reverseArray[i] + " ");
        }
        System.out.println("|");

        for (int i = 0; i < reverseArray.length / 2; i++) {
            int rightPointer = reverseArray.length - i - 1;
            int temp = reverseArray[i];
            reverseArray[i] = reverseArray[rightPointer];
            reverseArray[rightPointer] = temp;
        }

        for (int i = 0; i < reverseArray.length; i++) {
            System.out.print("| " + reverseArray[i] + " ");
        }
        System.out.println("|");
    }
}

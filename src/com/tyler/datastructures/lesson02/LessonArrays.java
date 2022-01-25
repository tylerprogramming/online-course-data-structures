package com.tyler.datastructures.lesson02;

public class LessonArrays {
    private static int[] randomNumbers = new int[10];

    public static void main(String args[]) {
        int[] highScores = {423, 82, 131, 99, 1, 999, 555, 29};

        System.out.println(highScores[0]);
        System.out.println(highScores[1]);
        System.out.println(highScores[5]);

        String[] stringArray = new String[5];
        boolean[] booleanArray = new boolean[2];

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random() * 10 + 1);
        }

        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print("| " + randomNumbers[i] + " ");
        }
        System.out.println("|");

//        System.out.println(randomNumbers[-10]);
    }
}

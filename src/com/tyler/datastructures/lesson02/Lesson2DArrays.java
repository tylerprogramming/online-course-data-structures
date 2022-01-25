package com.tyler.datastructures.lesson02;

public class Lesson2DArrays {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10 + 1);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("| " + matrix[i][j] + " ");
            }
            System.out.println("|");
        }

        int[][] highScores = {
                {565, 1001, 922},
                {318, 584, 773},
                {385, 139, 901},
                {300, 195, 55}
        };

        System.out.println(highScores[3][1]);

        for (int i = 0; i < highScores.length; i++) {
            for (int j = 0; j < highScores[i].length; j++) {
                System.out.print("| " + highScores[i][j] + " ");
            }
            System.out.println("|");
        }
    }
}

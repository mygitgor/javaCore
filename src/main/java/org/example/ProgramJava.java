package org.example;

import java.util.Arrays;
import java.util.Random;

public class ProgramJava {
    public static void main(String[] args) {
//        int[][] matrix = new int[3][6];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j]+", ");
//            }
//            System.out.println();
//        }





    }

    public static final Random random = new Random();
    public static int random(int min,int max){
        return random.nextInt(max - min) + min;
    }



}

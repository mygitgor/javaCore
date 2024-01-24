package org.example.javaDevelopmentKit.homework6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;



public class Program {
    public static void main(String[] args) {
         MontyHall montyHall = new MontyHall(3);
         int totalTests = 1000;
         Map<Integer, Boolean> results = new HashMap<>();
         for (int i = 1; i <= totalTests; i++) {
            boolean win = montyHall.playMontyHall();
            results.put(i, win);
         }

         int wins = (int) results.values().stream().filter(Boolean::valueOf).count();
         int losses = totalTests - wins;

         System.out.println("Победы: " + wins);
         System.out.println("Поражения: " + losses);

    }


}

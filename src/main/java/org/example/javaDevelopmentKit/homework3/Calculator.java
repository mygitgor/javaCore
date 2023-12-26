package org.example.javaDevelopmentKit.homework3;

import java.util.List;

public class Calculator {
    public static <T extends Number> Double sum(T num1, T num2) {
      return num1.doubleValue() + num2.doubleValue();
    }
    public static <T extends Number> Double subtract(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public static <T extends Number> Double multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number> Double divider(T num1, T num2) {
        if(num2.doubleValue()==0){
            throw new ArithmeticException("нелзя делить на ноль");
        }
        return num1.doubleValue() / num2.doubleValue();
    }
    public static <T> boolean compareArrays(T[] array1, T[] array2){
        if (array1.length != array2.length){
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if(!array1[i].equals(array2[i])){
                return false;
            }
        }
        return true;
    }

}

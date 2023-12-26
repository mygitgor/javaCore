package org.example.javaDevelopmentKit.homework3;

import java.util.ArrayList;
import java.util.List;

import static org.example.javaDevelopmentKit.homework3.Calculator.*;

public class ProgramJava {
    public static void main(String[] args) {
        Double result = sum(2.5, 3.5);
        System.out.println(result);

        Double result2 = divider(2,5);
        System.out.println(result2);

        Integer[] list1 = {1,2,3};
        Integer[] list2 = {1,2,3};
        System.out.println(compareArrays(list2,list1));

        String[] list3 = {"1","2","3"};
        String[] list4 = {"1","2","3"};
        System.out.println(compareArrays(list3,list4));

        TuoNumbers<Integer,Double> tuoNumbers = new TuoNumbers<>(1,1.2);
        System.out.println(tuoNumbers);

        TuoNumbers<Float,String> tuoNumbers1 = new TuoNumbers<>(1.2f,"odin.dva");
        System.out.println(tuoNumbers1);
    }



}

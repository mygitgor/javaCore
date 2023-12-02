package org.example.homework3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;



public class ProgramJava {

    private static final Random random = new Random();
    private static final int CHAR_BOUND_L = 70;
    private static final int CHAR_BOUND_H = 90;
    private static final String TO_SEARCH = "GeekBrains";
    public static void main(String[] args) throws IOException {
        System.out.println(generateSymbol(14));

        writeContent("myfile1.txt", 20,TO_SEARCH);
        writeContent("myfile2.txt", 20,TO_SEARCH);

        concatenate("myfile1.txt","myfile2.txt","concate.txt");

        System.out.println(searchInFill("myfile1.txt", TO_SEARCH));
        System.out.println(searchInFill("myfile2.txt", TO_SEARCH));
    }

    static String generateSymbol(int count){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < count; i++) {
            stringBuilder.append((char)random(CHAR_BOUND_L,CHAR_BOUND_H));
        }
        return stringBuilder.toString();
    }

    static void writeContent(String filename, int count) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)){
            fileOutputStream.write(generateSymbol(count).getBytes(StandardCharsets.UTF_8));
        }
    }


    static void writeContent(String filename, int count, String toSearch) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)){
            fileOutputStream.write(generateSymbol(count).getBytes(StandardCharsets.UTF_8));
            if(random.nextInt(2) == 0){
                fileOutputStream.write(toSearch.getBytes(StandardCharsets.UTF_8));
                fileOutputStream.write(generateSymbol(count).getBytes(StandardCharsets.UTF_8));
            }
        }

    }

    static boolean searchInFill(String fileName, String search) throws IOException{
        int c;
        byte[] searchData = search.getBytes();
        int counter = 0;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while ((c = fileInputStream.read()) != -1){
                if (c == searchData[counter]){
                    counter++;
                }
                else {
                    counter = 0;
                    if (c == searchData[counter])
                        counter++;
                }
                if (counter == searchData.length){
                    return true;
                }
            }
            return  false;
        }
    }


    static void concatenate(String fileIn1, String fileIn2, String out)throws IOException{
        try (FileOutputStream fileOutputStream = new FileOutputStream(out)){
            int c;
            try (FileInputStream fileInputStream = new FileInputStream(fileIn1)){
                while ((c = fileInputStream.read()) != -1){
                    fileOutputStream.write(c);
                }
            }

            try (FileInputStream fileInputStream = new FileInputStream(fileIn2)){
                while ((c = fileInputStream.read()) != -1){
                    fileOutputStream.write(c);
                }
            }
        }
    }
    private static int random(int min, int max){
        return random.nextInt(max - min) + min;
    }


}

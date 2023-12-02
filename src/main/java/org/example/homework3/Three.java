package org.example.homework3;

import java.io.File;

public class Three {
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("ㆹ");
            indent += "   ";
        }else {
            System.out.print("├");
            indent += "⎟  ";
        }
        System.out.println(file.getName());
        File[] files = file.listFiles();
        if(files == null)
            return;

        int subdir = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()){
                subdir++;
            }
        }

        int subdirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()){
                print(files[i],indent,subdir == ++subdirCounter);
            }
        }
    }
}

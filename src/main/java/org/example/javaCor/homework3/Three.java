package org.example.javaCor.homework3;

import java.io.File;
import java.io.IOException;

import static org.example.javaCor.homework3.ProgramJava.writeContent;

public class Three {
    private static java.nio.file.Files Files;

    public static void main(String[] args) throws IOException {

        File sourcePath = new File("/home/mohito/IdeaProjects/oop/src");
        File out = new File("./backup");
        print(new File("."), "", true);
        //backupFiles(out, sourcePath);
      
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

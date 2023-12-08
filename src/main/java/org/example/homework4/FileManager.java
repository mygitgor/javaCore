package org.example.homework4;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;


public class FileManager {
    private String currentFolder;
    private String root;

    public FileManager(String currentFolder){
        this.currentFolder = currentFolder;
        this.root = currentFolder;
    }

    public void listOfSize(boolean withSize){
        File currentFolderAsFile = new File(currentFolder);
        //получили все файлы текушей директори.
        File[] files = currentFolderAsFile.listFiles();
        //перебираен все файли текушей директори
        for (File file : files){
            if (file.isDirectory()){
                if (withSize){
                    System.out.println(file.getName() + "/ " + file.length());
                }
                else {
                    System.out.println(file.getName()+ "/ ");
                }

            }else {
                if (withSize){
                    System.out.print(file.getName() + " " + file.length());
                }else {
                    System.out.print(file.getName());
                }
                System.out.println();
            }

        }
    }


    public void copyFile(String sourceFileName, String destFileName) {
        File source = new File(currentFolder + "/" + sourceFileName);
        File dest = new File(currentFolder + "/"+ destFileName);
        try {
            Files.copy(source.toPath(),dest.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void createFile(String fileNme) {
        File file = new File(currentFolder + "/"+fileNme);
        try{
            file.createNewFile();
        }catch (IOException e){
            System.out.println("не могу создать файл");
        }

    }

    public void fileContent(String fileName) {
        File file = new File(currentFolder+"/"+ fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void changeDirectory(String folderName) {
        if (folderName.equals("/")){
            this.currentFolder = root;
        } else if (folderName.equals("..")) {
            int startLastFolderPosition = this.currentFolder.lastIndexOf("/");
            this.currentFolder = this.currentFolder.substring(0,startLastFolderPosition);
        }else{
            this.currentFolder = this.currentFolder + "/"+ folderName;
        }
    }
}

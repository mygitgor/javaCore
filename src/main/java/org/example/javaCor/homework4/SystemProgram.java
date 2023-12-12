package org.example.javaCor.homework4;

import java.util.Scanner;

public class SystemProgram {
    FileManager fileManager = new FileManager("/home/mohito/IdeaProjects/oop");
    Scanner scanner = new Scanner(System.in);
    public void systemProgramManager(String input) {
        while (!input.equals(Command.EXIT)){
            String token[] = input.split(" ");
            String command = token[0];
            switch (command) {
                case Command.LIST_OF_FILES:
                    fileManager.listOfSize(false);
                    break;
                case Command.LIST_OF_FILES_WITH_SIZE:
                    fileManager.listOfSize(true);
                    break;
                case Command.COPY_FILE:
                    String sourceFileName = token[1];
                    String destFileName = token[2];
                    fileManager.copyFile(sourceFileName, destFileName);
                    break;
                case Command.CREATE_FILE:
                    String fileNme = token[1];
                    fileManager.createFile(fileNme);
                    break;
                case Command.FILE_CONTENT:
                    String fileName = token[1];
                    fileManager.fileContent(fileName);
                    break;
                case Command.CHANGE_DIRECTORY:
                    String folderName = token[1];
                    fileManager.changeDirectory(folderName);
                    break;

            }
            input = scanner.nextLine();
        }
    }
}

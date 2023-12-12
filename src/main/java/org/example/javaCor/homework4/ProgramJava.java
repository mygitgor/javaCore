package org.example.javaCor.homework4;

import java.util.Scanner;

public class ProgramJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        SystemProgram systemProgram = new SystemProgram();
        systemProgram.systemProgramManager(input);
    }
}

package org.example.homework2;

import org.example.homework2.ProgramExeptions.IllegalArgument;

import java.util.Scanner;

public class UserAccountSystem {
    AccountManager accountManager = new AccountManager();

    /**
     * Этот код предоставляет простую консольную интерактивность для регистрации и входа в систему.
     */
    public void userAccountSystem() throws IllegalArgument {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Регистрация");
            System.out.println("2. Вход в систему");
            System.out.println("3. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя пользователя: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Введите фамилия пользователя: ");
                    String regUserSurname = scanner.nextLine();
                    System.out.print("Введите щет пользователя: ");
                    double regUserCheck = scanner.nextInt();
                    System.out.println("Введите пороль пользователя: ");
                    String regUserPassword = scanner.nextLine();
                    System.out.println("account created next to adding...");
                    accountManager.registerUser(regUsername,regUserSurname,regUserCheck,regUserPassword);
                    System.out.println("account added");
                    break;
                case 2:
                    System.out.print("Введите имя пользователя: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String loginPassword = scanner.nextLine();
                    Account loggedInUser = accountManager.loginUser(loginUsername, loginPassword);
                    break;
                case 3:
                    System.out.println("Выход из системы.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите 1, 2 или 3.");

            }
        }

    }

}


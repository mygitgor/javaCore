package org.example.javaCor.homework2;

import org.example.javaCor.homework2.ProgramExeptions.IllegalArgument;
import org.example.javaCor.homework2.ProgramExeptions.NullPointerException;

import java.util.Scanner;

public class UserAccountSystem {
    AccountManager accountManager = new AccountManager();

    /**
     * Этот код предоставляет простую консольную интерактивность для регистрации и входа в систему.
     */
    public void userAccountSystem() throws IllegalArgument, NullPointerException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Регистрация Account");
            System.out.println("2. Вход в систему");
            System.out.println("3. Регистрация Debit Account");
            System.out.println("4. Регистрация Credit Account");
            System.out.println("5. Выход");
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
                    System.out.print("Введите пороль пользователя: ");
                    String regUserPassword = String.valueOf(scanner.nextInt());
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
                    System.out.print("Введите имя пользователя: ");
                    String regUsername1 = scanner.nextLine();
                    System.out.print("Введите фамилия пользователя: ");
                    String regUserSurname1 = scanner.nextLine();
                    System.out.print("Введите щет пользователя: ");
                    double regUserCheck1 = scanner.nextInt();
                    System.out.print("Введите пороль пользователя: ");
                    String regUserPassword1 = String.valueOf(scanner.nextInt());
                    System.out.println("account created next to adding...");
                    accountManager.registerUserDebit(regUsername1,regUserSurname1,regUserCheck1,regUserPassword1);
                    System.out.println("account added");
                    break;
                case 4:
                    System.out.print("Введите имя пользователя: ");
                    String regUsername2 = scanner.nextLine();
                    System.out.print("Введите фамилия пользователя: ");
                    String regUserSurname2 = scanner.nextLine();
                    System.out.print("Введите щет пользователя: ");
                    double regUserCheck2 = scanner.nextInt();
                    System.out.print("Введите пороль пользователя: ");
                    String regUserPassword2 = String.valueOf(scanner.nextInt());
                    System.out.println("account created next to adding...");
                    accountManager.registerUserCredit(regUsername2,regUserSurname2,regUserCheck2,regUserPassword2);
                    System.out.println("account added");
                    break;
                case 5:
                    System.out.println("Выход из системы.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите 1, 2 или 3.");

            }
        }

    }

}


package org.example.homework2;

import org.example.homework2.ProgramExeptions.IllegalArgument;

import java.util.Scanner;

public class UserAccountSystem {
    private AccountManager accountManager;

    public AccountManager getAccountManager() {
        return accountManager;
    }

    Scanner scanner = new Scanner(System.in);
    public void userAccountSystem() throws IllegalArgument {
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
                    Account account1 = Account.createAccount(null, null, 0, 0.0);
                    account1.setName(regUsername);
                    System.out.print("Введите фамилия пользователя: ");
                    String regUserSurname = scanner.nextLine();
                    account1.setSurname(regUserSurname);
                    System.out.print("Введите телефон пользователя: ");
                    int regUserPhone = scanner.nextInt();
                    account1.setPhone(regUserPhone);
                    System.out.print("Введите щет пользователя: ");
                    double regUserCheck = scanner.nextInt();
                    account1.setCheck(regUserCheck);
                    accountManager.addAccount(account1);
                    break;
                case 2:
                    System.out.print("Введите имя пользователя: ");
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


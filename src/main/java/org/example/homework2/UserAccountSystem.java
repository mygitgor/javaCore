package org.example.homework2;

import org.example.homework2.ProgramExeptions.IllegalArgument;

import java.util.Scanner;

public class UserAccountSystem {
    private AccountManager accountManager = AccountManager.getAccountManager();

    public static UserAccountSystem getAccountSystem(){
        return new UserAccountSystem();
    }
    Scanner scanner = new Scanner(System.in);

    /**
     * Этот код предоставляет простую консольную интерактивность для регистрации и входа в систему.
     */
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
                    Account account1 = Account.createAccount(null, null, 0, 0.0,null);
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
                    System.out.print("Введите пороль пользователя: ");
                    String regUserPassword = scanner.nextLine();
                    account1.setPassword(regUserPassword);
                    System.out.println("account created next to adding...");
                    accountManager.addAccount(account1);
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


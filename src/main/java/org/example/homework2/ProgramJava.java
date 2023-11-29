package org.example.homework2;

import org.example.homework2.ProgramExeptions.IllegalArgument;

public class ProgramJava {
    public static void main(String[] args) throws IllegalArgument {
        CreateAccount account = CreateAccount.createAccount("User1","figaro",1234,100);
        CreateAccount account1 = CreateAccount.createAccount("User1","figaro",1234,152.0);
        account.deposit(200);
        account1.deposit(300);
        System.out.println(account);
        System.out.println(account1);





        /**
         * 1. Создать программу управления банковским счетом (Account).
         *
         * Программа должна позволять пользователю вводить начальный баланс счета, сумму д>
         *
         * Попытка создать счет с отрицательным начальным балансом должна вызывать исключе>
         * Попытка внести депозит с отрицательной суммой должна вызывать исключение Illega>
         * Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать>
         *
         * Продемонстрируйте работу вашего приложения:
         * Программа должна обрабатывать все исключения с помощью конструкции try-catch, в>
         *
         * 2*.
         * Создать несколько типов счетов, унаследованных от Account, например: CreditAcci>
         * Создать класс (Transaction), позволяющий проводить транзакции между счетами (пе>
         *
         * Класс Transaction должен возбуждать исключение в случае неудачной попытки перев>
         *
         * Продемонстрируйте работу вашего приложения:
         */


    }
}

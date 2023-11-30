package org.example.homework2;

import org.example.homework2.ProgramExeptions.IllegalArgument;

public class ProgramJava {
    public static void main(String[] args) throws IllegalArgument {
        /**
         * 1. Создать программу управления банковским счетом (Account).
         *  Программа должна позволять пользователю вводить начальный баланс счета, сумму д>
         *  Попытка создать счет с отрицательным начальным балансом должна вызывать исключе>
         *  Попытка внести депозит с отрицательной суммой должна вызывать исключение Illega>
         *  Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать>
         */

        Account account = Account.createAccount("User1","figaro",1234,100);
        Account account1 = Account.createAccount("User2","figaro",1234,152.0);
        account.deposit(200);
        account.takeFromBalance(250);
        account1.deposit(300);
        account1.takeFromBalance(450);
        System.out.println(account);
        System.out.println(account1);

//-----------------------------------------------------------------------------------------------------------------
        /**
         * 2*.
         *          * Создать несколько типов счетов, унаследованных от Account, например: CreditAcci>
         *          * Создать класс (Transaction), позволяющий проводить транзакции между счетами (пе>
         *          *
         *          * Класс Transaction должен возбуждать исключение в случае неудачной попытки перев>
         */
        AccountManager manager = AccountManager.getAccountManager();
        Account account2 = Account.createAccount("Debut User2","figaro",1234,100);
        Account account3 = Account.createAccount("Credit User3","figaro",1234,100);
        manager.addAccount(account2);
        manager.addAccount(account3);
        manager.addAccount(account);
        manager.addAccount(account1);
        Transaction transaction = Transaction.getTransaction();
        transaction.transfer(account2,account3,50);
        System.out.println(account2);
        System.out.println(account3);

    }
}

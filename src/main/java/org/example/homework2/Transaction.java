package org.example.homework2;

import org.example.homework2.ProgramExeptions.IllegalArgument;

public class Transaction {
    private Account account;
    public void transfer(Account from, Account to, double amount) throws IllegalArgument {
        from.takeFromBalance(amount);
        to.deposit(amount);
    }
    public static Transaction getTransaction(){
        return new Transaction();
    }

}

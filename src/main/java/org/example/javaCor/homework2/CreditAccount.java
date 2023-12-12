package org.example.javaCor.homework2;

import org.example.javaCor.homework2.ProgramExeptions.IllegalArgument;

public class CreditAccount extends Account{
    private Transaction transaction;
    private CreditAccount(String name, String surname, double check,String password) throws IllegalArgument {
        super(name, surname,  check,password);
    }
}

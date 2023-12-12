package org.example.javaCor.homework2;

import org.example.javaCor.homework2.ProgramExeptions.IllegalArgument;

public class DebitAccount extends Account{
    private  Transaction transaction;
    DebitAccount(String name, String surname, double check, String password) throws IllegalArgument {
        super(name, surname, check,password);
    }

}

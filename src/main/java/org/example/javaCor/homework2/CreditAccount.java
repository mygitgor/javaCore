package org.example.javaCor.homework2;

import org.example.javaCor.homework2.ProgramExeptions.IllegalArgument;
import org.example.javaCor.homework2.ProgramExeptions.NullPointerException;

public class CreditAccount extends Account{
    private Transaction transaction;
    private CreditAccount(String name, String surname, double check,String password) throws IllegalArgument, NullPointerException {
        super(name, surname,  check,password);
        if(!isValidAccount(name,surname,password))throw new NullPointerException("Нельзя создать аккоунт без заполнени полей",0);
    }

}

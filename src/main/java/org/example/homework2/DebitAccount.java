package org.example.homework2;

public class DebitAccount extends Account{
    private  Transaction transaction;
    private DebitAccount(String name, String surname, int phone, double check) {
        super(name, surname, phone, check);
    }

}

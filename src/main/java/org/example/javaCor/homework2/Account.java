package org.example.javaCor.homework2;

import org.example.javaCor.homework2.ProgramExeptions.IllegalArgument;

public class Account extends BaseAccount {


    /**
     * ***Попытка создать счет с отрицательным начальным балансом должна вызывать исключен>
     *
     * ***Попытка внести депозит с отрицательной суммой должна вызывать исключение Illega
     *
     * ***Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать
     */
//region peremenni;
    private double check; //счет


//region constructor;

    public Account(String name, String surname, double check, String password) throws IllegalArgument {
        super(name, surname, password);
        if(check < 0.0) {
            throw new IllegalArgument("Нельзя создать отрицательны счет! %d",check);
        }else {
            this.check = check;
        }
    }

//region method;
    public Account createAccount(String name, String surname, double check,String password) throws IllegalArgument {
        if(check < 0.0) {
            throw new IllegalArgument("Нельзя создать отрицательны счет! ",check);
        }else {
            return new Account(name, surname, check,password);
        }
    }

    public void deposit(double amount) throws IllegalArgument {
        if(amount < 0.0){
            throw new IllegalArgument("ваш депозит должна бить положительным :",amount);
        }else {
            check += amount;
        }
    }

    public void takeFromBalance(double amount) throws IllegalArgument {
        if(check - amount < 0) {
            throw new IllegalArgument("нелзя снять болше чем текущий баланс :", amount);
        }else {
            check -= amount;
        }
    }

    public boolean checkPassword(String inputPassword) {
        return getPassword().equals(inputPassword);
    }

//region toString;
    @Override
    public String toString() {
        return super.toString() + ", Check: " + getCheck();
    }

//region geter && seter;
    public double getCheck() {
        return check;
    }
    public void setCheck(double check) {this.check = check;}

}

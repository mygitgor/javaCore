package org.example.homework2;

import org.example.homework2.ProgramExeptions.IllegalArgument;

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

    protected Account(String name, String surname, int phone, double check) {
        super(name, surname, phone);
            this.check = check;
    }

//region method;
    public static Account createAccount(String name, String surname, int phone, double check) throws IllegalArgument {
        if(check < 0.0) {
            throw new IllegalArgument("Нельзя создать отрицательны счет!",check);
        }else {
            return new Account(name, surname, phone, check);
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

    @Override
    public void setName(String name) {super.setName(name);}

    @Override
    public void setSurname(String surname) {super.setSurname(surname);}

    @Override
    public void setPhone(int phone) {super.setPhone(phone);}
}

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
    private String password;

//region constructor;

    protected Account(String name, String surname, int phone, double check,String password) {
        super(name, surname, phone);
            this.check = check;
            this.password = password;
    }

//region method;
    public static Account createAccount(String name, String surname, int phone, double check,String password) throws IllegalArgument {
        if(check < 0.0) {
            throw new IllegalArgument("Нельзя создать отрицательны счет!",check);
        }else {
            return new Account(name, surname, phone, check,password);
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
        return password.equals(inputPassword);
    }

//region toString;
    @Override
    public String toString() {
        return super.toString() + ", Check: " + getCheck()+ "Password: "+getPassword();
    }

//region geter && seter;
    public double getCheck() {
        return check;
    }
    public void setCheck(double check) {this.check = check;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    @Override
    public void setName(String name) {super.setName(name);}

    @Override
    public void setSurname(String surname) {super.setSurname(surname);}

    @Override
    public void setPhone(int phone) {super.setPhone(phone);}
}

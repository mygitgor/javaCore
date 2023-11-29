package org.example.homework2;

import org.example.homework2.ProgramExeptions.IllegalArgument;

public class CreateAccount extends Account{
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
    private CreateAccount(String name, String surname,int phone, double check) {
        super(name, surname, phone);
            this.check = check;
    }

//region method;
    public static CreateAccount createAccount(String name, String surname,int phone, double check) throws IllegalArgument {
        if(check < 0.0) {
            throw new IllegalArgument("Нельзя создать отрицательны счет!",check);
        }else {
            return new CreateAccount(name, surname, phone, check);
        }
    }

    public void deposit(double deposit) throws IllegalArgument {
        if(deposit < 0.0){
            throw new IllegalArgument("ваш депозит должна бить положительным :",deposit);
        }else {
            check += deposit;
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
}

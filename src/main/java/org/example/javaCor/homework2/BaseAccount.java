package org.example.javaCor.homework2;

import org.example.javaCor.homework2.ProgramExeptions.NullPointerException;

import static org.example.javaCor.homework2.Account.isValidAccount;

public class BaseAccount {
//region peremenni;
    private String name;
    private String surname;
    private String password;



    //region constructor;
    public BaseAccount(String name, String surname, String password) throws NullPointerException {
        if (!isValidAccount(name,surname,password)) {
            throw new NullPointerException("Нельзя создать без заполнени всех полей!", 0.0);
        } else {
            this.name = name;
            this.surname = surname;
            this.password = password;
        }
    }

//region method;



//region toString;
    @Override
    public String toString() {
        return "name:"+ getName() + ", surname:"+getSurname()+ ", Password:"+getPassword();
    }

//region geter && seter;
    public String getName() {return name;}

    public String getSurname() {return surname;}

    public void setName(String name) {this.name = name;}

    public void setSurname(String surname) {this.surname = surname;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}

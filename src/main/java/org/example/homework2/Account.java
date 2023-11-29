package org.example.homework2;

import org.example.homework2.ProgramExeptions.IllegalArgument;

public class Account {
//region peremenni;
    private String name;
    private String surname;
    private int phone;

//region constructor;
    public Account(String name, String surname, int phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

//region method;



//region toString;
    @Override
    public String toString() {
        return "name:"+ getName() + ", surname:"+getSurname()+ ", phone:"+getPhone();
    }

//region geter && seter;
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public int getPhone() {return phone;}

    public void setPhone(int phone) {this.phone = phone;}




}

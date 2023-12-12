package org.example.javaCor.homework2;

public class BaseAccount {
//region peremenni;
    private String name;
    private String surname;
    private String password;



    //region constructor;
    public BaseAccount(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
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

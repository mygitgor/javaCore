package org.example.homework2;

import org.example.homework2.ProgramExeptions.IllegalArgument;

import java.util.*;

public class AccountManager {
    //Compositor variant
    AccountManager manager;
    public Map<String,Account> accountList;
    public AccountManager(){
        this.accountList = new HashMap<>();
    }

    public void addAccount(Account account, String name){
        accountList.put(name,account);
    }
    public void deleteAccount(Account account,String name){
        accountList.remove(name,account);
    }

    public void registerUser(String username, String usersurname,double chack,String password) throws IllegalArgument {
        if (!accountList.containsKey(username)){
            Account account = new Account(username,usersurname,chack,password);
            accountList.put(username,account);
            System.out.printf("Регистрация успешна. %s\n",username);
        }
        else {
            System.out.printf("Пользователь с таким именем %s уже существует.",username);
        }
    }

    public Account loginUser(String usrName, String password){
        Account account = accountList.get(usrName);
        if (account != null && account.checkPassword(password)){
            System.out.printf("Вход в систему успешен. %s",usrName);
            return account;
        }
        else{
            System.out.println("Неверное имя пользователя или пароль.");
            return null;
        }
    }


}

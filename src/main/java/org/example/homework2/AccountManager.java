package org.example.homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountManager {
    //Compositor variant
    private Map<String,Account> accountList = new HashMap<>();
    private AccountManager(){}
    public static AccountManager getAccountManager(){
        return new AccountManager();
    }
    public void addAccount(Account account){
        accountList.put(account.getName(), account);
    }
    public void deleteAccount(Account account){
        accountList.remove(account.getName(),account);
    }
    public Account loginUser(String usrName, String password){
        Account userAccount = accountList.get(usrName);
        if (userAccount != null && userAccount.checkPassword(password)){
            System.out.println("Вход в систему успешен.");
            return userAccount;
        }
        else {
            System.out.println("Неверное имя пользователя или пароль.");
            return null;
        }
    }



}

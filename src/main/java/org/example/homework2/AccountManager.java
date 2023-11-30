package org.example.homework2;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    //Compositor variant
    private List<Account> accountList = new ArrayList<>();
    private AccountManager(){}
    public static AccountManager getAccountManager(){
        return new AccountManager();
    }
    public void addAccount(Account account){
        accountList.add(account);
    }

    public void deleteAccount(Account account){
        accountList.remove(account);
    }

}

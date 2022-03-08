package com.Demo.SpringAOP.DAO;



import com.Demo.SpringAOP.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account theAccount,boolean flag)
    {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {

        System.out.println(getClass() + ": doWork()");
        return false;
    }
}

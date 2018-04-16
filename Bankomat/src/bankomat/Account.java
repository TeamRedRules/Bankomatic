/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankomat;

import java.sql.SQLException;
import javafx.beans.property.SimpleDoubleProperty;





/**
 * třída account se stará o obsluhu bankomatu - převod peněz, změna hesla, vložení peněz atd.
 *
 * @author skolniPC
 */
public class Account {
    
    private double balance;
    private String passw;
    private String accountNumber;
    private Login login ;
    
    

    public Account(double balance, String passw, String accountNumber) {
        this.balance = balance;
        this.passw = passw;
        this.accountNumber = accountNumber;
        
        System.out.println("acc vytvořen");
    }

    public   String getPsw()
    {
        return this.passw;
    }
    
    public String getAcc()
    {
        
        return this.accountNumber;
    }
    
    public double getBalance()
    {
        return this.balance;
    }
    
    public Boolean setBalance(double balance)
    {
        this.balance = balance;
        return true;
    }
    
    public void setPsw(String psw) throws SQLException
    {
        
        this.passw= psw;
        System.out.println(this.passw);
        this.update(this);
    }
    
    public double sendMoney(Double money,String acc) throws SQLException
    {
       
       System.out.println(acc + " TOIHLE JE ACC");
       Account reciever =login.foundAcc(acc);
      
       if (reciever == null)
       {
           System.out.println("error");
       }
       else
       {
        reciever.setBalance(reciever.getBalance()+money);
        this.balance = (this.balance -money);
        this.update(reciever);
        this.update(this);
       }
       return this.balance;
       
    }
    
    public void setLogin(Login login)
    {
    
        this.login = login;
    }
    
    public void update(Account acc) throws SQLException
    {
        this.login.updateDB(acc);

    }
    
    public double withdrawMoney(Double ammount) throws SQLException {
        this.balance -= ammount;
        this.update(this);
        return this.balance;
        
       
    }
    
    
   

    @Override
    public String toString() {
        return "Account{" + "balance=" + balance + ", passw=" + passw + ", accountNumber=" + accountNumber + '}';
    }

    
   
    
    
    
}

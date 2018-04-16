/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankomat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * class login se stará o přihlášení do účtů
 * @author skolniPC
 */
public class Login {
    
     private ArrayList<Account> accountList;
     private Account account;
     private Connection conn;
     private final DB db;
     int i =0;
     ResultSet rs;
     int countAcc;
    
     
     
     public Login() throws SQLException
     {
         db = new DB();
         conn = db.DbConnector();
          rs =conn.createStatement().executeQuery("SELECT * FROM Account ");
          while(rs.next())
         {
             i +=1;
         }
         this.accountList = new ArrayList(i);
         rs=conn.createStatement().executeQuery("SELECT * FROM Account ");
         while(rs.next())
         {
             System.out.println("list jede");
            this.accountList.add(new Account(rs.getInt(3),rs.getString(4),rs.getString(2)));
            System.out.println(this.accountList);
         }
     }
     
     
     public Boolean logIn(String  psw, String accNumber) throws SQLException
     {
        countAcc =0;
        rs=conn.createStatement().executeQuery("SELECT * FROM Account ");
        while(rs.next())
        {
            System.out.println(countAcc);
            System.out.println(rs.getString(2) + rs.getString(4));
             if(rs.getString(2).equals(accNumber)&& rs.getString(4).equals(psw)){
                 this.account = this.accountList.get(countAcc);
                 this.account.setLogin(this);
                 System.out.println(this.account);
                 return true;
             }
             else
                countAcc+=1;
        }
        return false;
     }
     
     public  Account foundAcc(String accNumber)
     {
         for (int i=0;i< this.accountList.size();i++)
         {
             
             System.out.println(this.accountList.get(i).getAcc() + accNumber);
             
             if(this.accountList.get(i).getAcc().equals(accNumber))
             {
                 System.out.println(this.accountList.get(i).getAcc());
                System.out.println("FOUND ACC");
                return this.accountList.get(i); 
             }  
         }
     return null;
     }
    
     public void updateDB(Account acc) throws SQLException
     {
         String sql = "UPDATE Account SET balance = ?,  psw = ? WHERE accNumber='"+acc.getAcc() + "' ";
         PreparedStatement st = this.conn.prepareStatement(sql);
         st.setInt(1, (int) acc.getBalance());
         st.setString(2, acc.getPsw());
         st.execute();
         System.out.println();
         System.out.println("jede");
         
         
     
     }
     
     public Account getAcc()
     {
         return account;
     }
     
    
}



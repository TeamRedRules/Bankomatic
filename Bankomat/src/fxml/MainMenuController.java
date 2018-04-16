/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import bankomat.Account;
import bankomat.Login;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author skolniPC
 */
public class MainMenuController extends HomeController implements Initializable {

   
    @FXML Label labelBalance;
    @FXML JFXTextField inputWithdrawMoney;
    @FXML JFXTextField inputMoney,inputAccountNumber,newPsw;
    private Account account;
 
    private Login login;
     
    
   
  
    public void setLogins(Login login)
    {
        this.login = login;
        System.out.println("login jede");
        
    }
    
    public void setAcc()     
    {
        this.account = login.getAcc();
        this.setStats();
        
    }
    
    public void setStats()
    {
        this.labelBalance.setText( String.valueOf(this.account.getBalance()));
    }
    
    @FXML
    private void sendMoney() throws SQLException
    {
        if (this.account.getBalance() == 0 ||Double.valueOf(this.inputMoney.getText()) > this.account.getBalance())
            System.out.println("Neni dostatek penez");
        else
        {
             this.labelBalance.setText(String.valueOf(this.account.sendMoney(Double.valueOf(this.inputMoney.getText()), String.valueOf(this.inputAccountNumber.getText()))));
             
             System.out.println("succesfull");
        }
    }
    
    @FXML
    private void withdrawMoney() throws SQLException
    {
        if((Double.valueOf(this.inputWithdrawMoney.getText()) > this.account.getBalance()))
        {System.out.println("nedostatek peněz");
        
        }
        else
            this.labelBalance.setText(String.valueOf(this.account.withdrawMoney(Double.valueOf(this.inputWithdrawMoney.getText()))));

    }
    
    @FXML 
    private void changePsw() throws SQLException
    {
        this.account.setPsw(this.newPsw.getText());
        
    }
    
    
    
    
   
 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        System.out.println("pojede");
   
         
      
    }    
    
}

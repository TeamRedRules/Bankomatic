/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import bankomat.Account;
import bankomat.Bankomat;
import bankomat.Login;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author skolniPC
 */
public class HomeController implements Initializable {
    double initialX,initialY;
    AnchorPane x;
    @FXML private ImageView exit;
    private Scene menuScene; 
    @FXML private Stage primaryStage;
    private Login loginObj;
    @FXML private  JFXTextField inputAcc;
    @FXML private JFXPasswordField inputPsw;
    @FXML private  Label labelError;
    public Account account;
    private MainMenuController main;

    
    
    
    @FXML
    public void mousePressed(MouseEvent evt)
    {
        initialX=evt.getSceneX();
        initialY= evt.getSceneY();
    }
    @FXML
    private void moveWindow(MouseEvent  evt)        
    {
        x=(AnchorPane) evt.getSource();
        x.getScene().getWindow().setX(evt.getScreenX()-initialX);
        x.getScene().getWindow().setY(evt.getScreenY()-initialY); 

    }
    
    
    
    @FXML
    private void close(MouseEvent evt)
    {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    
    
    }
    
    @FXML
    public void changeScene(MouseEvent event) throws SQLException
    {
       if(loginObj.logIn(this.inputPsw.getText(),this.inputAcc.getText()))
        {    
                  primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
                  primaryStage.setScene(this.menuScene);
                  this.account = loginObj.getAcc();  
                  System.out.println("init");
                  this.main.setAcc();
            
                  
                 
                 
        }
        else
            this.labelError.setText("špatné heslo nebo číslo účtu");
    }
    
    
  
    public void setLogin(Login login)
    {
        this.loginObj = login;
    }
    
    public void setScene(Scene main)
    {
        this.menuScene = main;
    }
    
    public void setController(MainMenuController main)
    {
        this.main = main;
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    

       
    }    
    
}

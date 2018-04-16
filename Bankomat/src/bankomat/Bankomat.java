/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankomat;

import fxml.HomeController;
import fxml.MainMenuController;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author skolniPC
 */
public class Bankomat extends Application {
    
    private FXMLLoader homeFXML;
    private FXMLLoader main;
    private MainMenuController menu;
    private HomeController home;
   
    
    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
       
        Login login = new Login();
        homeFXML = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
        Parent firstPane = homeFXML.load();
        Scene homeScene = new Scene(firstPane);

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(homeScene);
        primaryStage.show();
       
        
        main = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        Parent pane = main.load();
        menu = (MainMenuController) main.getController();
        
        
        Scene mainScene = new Scene(pane);
        
        
        
    
       
       home = (HomeController) homeFXML.getController();
        
        home.setLogin(login);
        menu.setLogins(login);
        home.setController(menu);
       
        home.setScene(mainScene);
       
       
       
       
       
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

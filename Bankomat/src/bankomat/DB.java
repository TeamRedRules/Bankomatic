/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankomat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author skolniPC
 */
public class DB {
    
    public static Connection DbConnector()
{
    try {
        Connection connection = null;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:AccountDB.db");
        return connection;
    }catch(ClassNotFoundException | SQLException e){
        System.out.println(e);
    
    }
    return null;
    
}

   

    
}

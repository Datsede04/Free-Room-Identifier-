/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author KIMOK
 */
public class database {
public Connection con;    
  
/* 
In this part we How we create connection between the database and ths java fx 
program that we are aboit to creat
*/    
    public Connection connnect() {
        //database property 
        String url = "jdbc:mysql://localhost:3306/first1";
        String name = "root";
        String pass = "dabdulkerim@123";
    try {
        Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection(url,name,pass);
        return con;
    } catch (SQLException ex) {
        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
    }

     return con;  
    }
}

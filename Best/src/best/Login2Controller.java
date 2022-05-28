/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KIMOK
 */
public class Login2Controller implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField secrate_answer;
    @FXML
    private Button login2;
    @FXML
    private Button login;
    @FXML
    private Button forgote;

    Connection con;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        secrate_answer.setVisible(false);
        login2.setVisible(false);
    }    

    @FXML
    private void login_action(ActionEvent event) {
          if(event.getSource()==login){
  
         try{
               database c=new database();
               con=c.connnect();
            
            String name1,pass1;
            Statement Stem=con.createStatement();
            String s="select * from admin";
            ResultSet rs=Stem.executeQuery(s);

                name1=username.getText();
                pass1=password.getText();
            if(rs.next()){
                
                if(rs.getString("username").equals(name1)){

                    if(rs.getString("password").equals(pass1)){
                      
                      try {
                          
           Parent scondparent;  
           scondparent =(AnchorPane) FXMLLoader.load(getClass().getResource("account.fxml"));
         
           Scene newScene;
           newScene=new Scene(scondparent);
           
           Stage mainWindow;
           mainWindow=(Stage)anchorpane.getScene().getWindow();
           mainWindow.setScene(newScene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
               }else{
                      username.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID, new CornerRadii(2.5),BorderStroke.MEDIUM)));
                      password.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,new CornerRadii(2.5),BorderStroke.MEDIUM)));

                    }  
                 
                }else{
                    username.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID, new CornerRadii(2.5),BorderStroke.MEDIUM)));
                    password.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,new CornerRadii(2.5),BorderStroke.MEDIUM)));


                }
            
            }

        }catch(SQLException err){
            System.out.println(err); 
            /*
            use alert to show the error*/
        }
    }    
    else if(event.getSource()==forgote)
    {
        secrate_answer.setVisible(true);
        login2.setVisible(true); 
        login.setDisable(true);
    }
    else if(event.getSource()==login2)
    {
        
          try{
               database c=new database();
               con=c.connnect();
            
            String code;
            Statement Stem=con.createStatement();
            String s="select * from admin";
            ResultSet rs=Stem.executeQuery(s);

                code=secrate_answer.getText();
                           if(rs.next()){
                
if(rs.getString("backup").equals(code)){
                    
   try {
                          
           Parent scondparent;  
           scondparent =(AnchorPane) FXMLLoader.load(getClass().getResource("account.fxml"));
         
           Scene newScene;
           newScene=new Scene(scondparent);
           
           Stage mainWindow;
           mainWindow=(Stage)anchorpane.getScene().getWindow();
           mainWindow.setScene(newScene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
               }else{
                    username.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,new CornerRadii(2.5),BorderStroke.MEDIUM)));
                    password.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,new CornerRadii(2.5),BorderStroke.MEDIUM)));

                    }  
                 
                }else{
                    username.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,new CornerRadii(2.5),BorderStroke.MEDIUM)));
                    password.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,new CornerRadii(2.5),BorderStroke.MEDIUM)));
}
            
            }catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
            use alert to show the error*/
       }
    }

    @FXML
    private void goto_home(MouseEvent event) {
          try {
            Parent scondparent;  
           scondparent =(AnchorPane) FXMLLoader.load(getClass().getResource("admin.fxml"));
         
           Scene newScene;
           newScene=new Scene(scondparent);
           
           Stage mainWindow;
           mainWindow=(Stage)anchorpane.getScene().getWindow();
           mainWindow.setScene(newScene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


package best;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KIMOK
 */
public class AccountController implements Initializable {
    Connection con;

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField secrate_answer;
    @FXML
    private Button save;
    @FXML
    private Button clear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save_action(ActionEvent event) {
       String name=username.getText();
       String pass=password.getText();
       String ans= secrate_answer.getText();
       
       if(name.length()<5){
               Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Username must be More than 5 character ");
                alert.show();
                return;
           }
        if(pass.length()<10){
        
            Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Password must be More than 10 character ");
                alert.show();
                return;
        
          }
       if(ans.length()<7){
         Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Yor answer must be More than 7 character ");
                alert.show();
                return;
       }
       theQurery("update admin set username='"+name+"',password='"+pass+"',backup='"+ans+"' where id="+1);
         
    }

    @FXML
    private void clear_action(ActionEvent event) {
        username.setText("");
        password.setText("");
        secrate_answer.setText("");
    }

    private void theQurery(String query) {
       
      try {
            
                    database a=new database();
                    con=a.connnect();
                    Statement s = con.createStatement();
                    s.executeUpdate(query);
              
                 Alert alert=new Alert(Alert.AlertType.INFORMATION); 
                alert.setHeaderText(null);
                alert.setContentText("Succesuly changed ");
                alert.show();
                return;   
        }catch (SQLException err) {
      
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText(""+err);      
                alert.show();
                return;
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

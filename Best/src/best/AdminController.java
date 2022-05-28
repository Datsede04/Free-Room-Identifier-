
package best;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminController implements Initializable {
Connection con;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Button insert;
    @FXML
    private Button edit;
    @FXML
    private Button account;
    @FXML
    private Button aboutus;
    @FXML
    private Button new_semistor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void setonaction(ActionEvent event) {
        if(event.getSource()==insert){
                try {
            Parent scondparent;  
           scondparent =(AnchorPane) FXMLLoader.load(getClass().getResource("insert.fxml"));
         
           Scene newScene;
           newScene=new Scene(scondparent);
           
           Stage mainWindow;
           mainWindow=(Stage)anchorpane.getScene().getWindow();
           mainWindow.setScene(newScene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else if(event.getSource()==edit)
        { try {
            Parent scondparent;  
           scondparent =(AnchorPane) FXMLLoader.load(getClass().getResource("edit.fxml"));
         
           Scene newScene;
           newScene=new Scene(scondparent);
           
           Stage mainWindow;
           mainWindow=(Stage)anchorpane.getScene().getWindow();
           mainWindow.setScene(newScene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else if(event.getSource()==account)
        { try {
            Parent scondparent;  
           scondparent =(AnchorPane) FXMLLoader.load(getClass().getResource("login2.fxml"));
         
           Scene newScene;
           newScene=new Scene(scondparent);
           
           Stage mainWindow;
           mainWindow=(Stage)anchorpane.getScene().getWindow();
           mainWindow.setScene(newScene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       else if(event.getSource()==aboutus)
        { try {
            Parent scondparent;  
           scondparent =(AnchorPane) FXMLLoader.load(getClass().getResource("aboutus.fxml"));
         
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

    @FXML
    private void goto_home(MouseEvent event) {
     try {
            Parent scondparent;  
           scondparent =(AnchorPane) FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
         
           Scene newScene;
           newScene=new Scene(scondparent);
           
           Stage mainWindow;
           mainWindow=(Stage)anchorpane.getScene().getWindow();
           mainWindow.setScene(newScene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
private void theQurery(String query) {
       
      try {
            
                    database a=new database();
                    con=a.connnect();
                    Statement s = con.createStatement();
                    s.executeUpdate(query);
            
        }catch (SQLException err) {
      
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText(""+err);      
                alert.show();
                return;
       }
     }  

    @FXML
    private void new_semistor(ActionEvent event) {

           Alert alert=new Alert(Alert.AlertType.CONFIRMATION); 
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete all the records and start from scrach?");
                Optional<ButtonType> result=alert.showAndWait();
                if(result.isPresent() && (result.get())==ButtonType.OK){
                         theQurery("delete from table1 where block is not null and room is not null and course_type is not null");
                }
    }
    
    
}

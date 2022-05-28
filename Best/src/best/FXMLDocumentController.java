/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author KIMOK
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button user;
    @FXML
    private Button admin;
    @FXML
    private AnchorPane anchorpane;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setonaction(ActionEvent event) {

        if(event.getSource()==user){
                   try {
            Parent scondparent;  
           scondparent =(AnchorPane) FXMLLoader.load(getClass().getResource("useraccount.fxml"));
         
           Scene newScene;
           newScene=new Scene(scondparent);
           
           Stage mainWindow;
           mainWindow=(Stage)anchorpane.getScene().getWindow();
           mainWindow.setScene(newScene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }    
      
        }
    
        else if(event.getSource()==admin){
       /*  go to admin page */
             try {
           Parent scondparent;  
           scondparent =(AnchorPane) FXMLLoader.load(getClass().getResource("login.fxml"));
         
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
    private void exit(MouseEvent event) {
           Alert alert=new Alert(Alert.AlertType.CONFIRMATION); 
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to close the program?");
                Optional<ButtonType> result=alert.showAndWait();
                if(result.isPresent() && (result.get())==ButtonType.OK){
                System.exit(0);
                }
               
   
    }

    @FXML
    private void close_on(MouseEvent event) {
    }
    
/*   private void fadetransition(){
   FadeTransition fadetransition=new FadeTransition();
   
   fadetransition.setDuration(Duration.seconds(2));
   fadetransition.setNode(anchorpane);
   fadetransition.setFromValue(1);
   fadetransition.setToValue(0);
   fadetransition.setOnFinished(new EventHandler<ActionEvent>() {
       @Override
       public void handle(ActionEvent event) {
              loadsecond(); }});
   
   fadetransition.play();
   }*/
  
   
  
 
    
}

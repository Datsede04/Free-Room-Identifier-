/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KIMOK
 */
public class AboutusController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TextArea textarea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
       StringBuilder text = new StringBuilder();
       text.append("This Free room Identifier app is design to identify the time  and the day in which" +
                "rooms are free or occupied .\nSo the student can use the room for their Purpose(study ,team work and so on)  ");
        text.append("\nDeveloper:	Dawud Abdulkerim & Adem Mohamed \n");
        text.append(" Version:2.0\n Special Thanks to Mr.Biruk");
        textarea.setText(text.toString());
        textarea.setFont(Font.font("Times New Roman"));
        textarea.setEditable(false);
      
      
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best;

import au.com.bytecode.opencsv.CSVReader;
import com.jfoenix.validation.NumberValidator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.DIGIT0;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author KIMOK
 */
public class InsertController implements Initializable {
Connection con;
static int level_counter;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Button imp_excel;
    @FXML
    private TextField block;
    @FXML
    private TextField room;
    @FXML
    private TextField department;
    @FXML
    private ComboBox<?> level;
    @FXML
    private ComboBox<?> student_type;
    @FXML
    private ComboBox<?> course_type;
    @FXML
    private Label mondat_sat;
    @FXML
    private Label tusday_sun;
    @FXML
    private Label wedensday;
    @FXML
    private Label thursday;
    @FXML
    private Label friday;
    @FXML
    private TextField m2;
    @FXML
    private TextField m3;
    @FXML
    private TextField m5;
    @FXML
    private TextField m4;
    @FXML
    private TextField m6;
    @FXML
    private TextField m7;
    @FXML
    private TextField m1;
    @FXML
    private TextField tu2;
    @FXML
    private TextField tu3;
    @FXML
    private TextField tu5;
    @FXML
    private TextField tu4;
    @FXML
    private TextField tu6;
    @FXML
    private TextField tu7;
    @FXML
    private TextField tu1;
    @FXML
    private TextField w2;
    @FXML
    private TextField w3;
    @FXML
    private TextField w5;
    @FXML
    private TextField w4;
    @FXML
    private TextField w6;
    @FXML
    private TextField w7;
    @FXML
    private TextField w1;
    @FXML
    private TextField th2;
    @FXML
    private TextField th3;
    @FXML
    private TextField th5;
    @FXML
    private TextField th4;
    @FXML
    private TextField th6;
    @FXML
    private TextField th7;
    @FXML
    private TextField th1;
    @FXML
    private TextField f2;
    @FXML
    private TextField f3;
    @FXML
    private TextField f5;
    @FXML
    private TextField f4;
    @FXML
    private TextField f6;
    @FXML
    private TextField f7;
    @FXML
    private TextField f1;
    @FXML
    private ComboBox<?> year;
    final ObservableList type=FXCollections.observableArrayList("Bsc","Msc","Phd");
    final ObservableList leve=FXCollections.observableArrayList("1st year","2nd year","3rd year","4th year","5th year","6th year","7th year");
    final ObservableList semis=FXCollections.observableArrayList("1st","2nd","3rd");
    final ObservableList years=FXCollections.observableArrayList("2020","2021","2022","2023");
    final ObservableList coursetype=FXCollections.observableArrayList("Regular","Night","Weekend");
    @FXML
    private Button save;
    @FXML
    private TextField section;
    @FXML
    private Label saturday;
    @FXML
    private Label sunday;
    @FXML
    private TextField sa2;
    @FXML
    private TextField sa3;
    @FXML
    private TextField sa5;
    @FXML
    private TextField sa4;
    @FXML
    private TextField sa6;
    @FXML
    private TextField sa7;
    @FXML
    private TextField sa1;
    @FXML
    private TextField s2;
    @FXML
    private TextField s3;
    @FXML
    private TextField s5;
    @FXML
    private TextField s4;
    @FXML
    private TextField s6;
    @FXML
    private TextField s7;
    @FXML
    private TextField s1;
    @FXML
    private ComboBox<?> semistor;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        /* Initalizing the comboboxs*/
         
        save.setVisible(false);
        level.setItems(leve);
        year.setItems(years);
        semistor.setItems(semis);
        student_type.setItems(type);
        course_type.setItems(coursetype);
        
    
       mondat_sat.setVisible(false);
        tusday_sun.setVisible(false);
         wedensday.setVisible(false); 
          thursday.setVisible(false);
           friday.setVisible(false);
           saturday.setVisible(false);
           sunday.setVisible(false);
           
         m1.setVisible(false);
         m2.setVisible(false);
         m3.setVisible(false);
         m4.setVisible(false);
         m5.setVisible(false);
         m6.setVisible(false);
         m7.setVisible(false);
        
          tu1.setVisible(false);
         tu2.setVisible(false);
         tu3.setVisible(false);
         tu4.setVisible(false);
         tu5.setVisible(false);
         tu6.setVisible(false);
         tu7.setVisible(false);
           
         w1.setVisible(false);
         w2.setVisible(false);
         w3.setVisible(false);
         w4.setVisible(false);
         w5.setVisible(false);
         w6.setVisible(false);
         w7.setVisible(false);

         th1.setVisible(false);
         th2.setVisible(false);
         th3.setVisible(false);
         th4.setVisible(false);
         th5.setVisible(false);
         th6.setVisible(false);
         th7.setVisible(false);
         
         f1.setVisible(false);
         f2.setVisible(false);
         f3.setVisible(false);
         f4.setVisible(false);
         f5.setVisible(false);
         f6.setVisible(false);
         f7.setVisible(false);
         
         sa1.setVisible(false);
         sa2.setVisible(false);
         sa3.setVisible(false);
         sa4.setVisible(false);
         sa5.setVisible(false);
         sa6.setVisible(false);
         sa7.setVisible(false);
         
         s1.setVisible(false);
         s2.setVisible(false);
         s3.setVisible(false);
         s4.setVisible(false);
         s5.setVisible(false);
         s6.setVisible(false);
         s7.setVisible(false);
           
         imp_excel.setVisible(false);
    }    

    @FXML
    private void setonaction(ActionEvent event) {
    
    if(event.getSource()==save){
        
        try{    int bi,ri,semis=0;
                String b=block.getText();
                String r=room.getText();
                String d=department.getText().trim();    
                String course=(String) course_type.getValue();   
                String y=(String)year.getValue();
                String ty=(String)student_type.getValue();
                String le=(String)level.getValue();
                String se=(String)semistor.getValue();
                String sect=section.getText().trim();
                
        if(b.equalsIgnoreCase(""))
              {
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Block can't be empty");
                alert.show();
               return; 
      
        }else{
              try{ 
                
                bi=Integer.parseInt(b);
               if(bi<0){
                block.setText("");
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Block can't be Negative Number");
                alert.show();
               return; 
                  }
            }catch(NumberFormatException ex){
               
               block.setText("");
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Block Must be Number");
                alert.show();
               return; 
               }
              
        } 
        
        if(r.equalsIgnoreCase(""))
              {
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Room can't be empty");
                alert.show();
               return; 
              }else{
          try{ 
                
                ri=Integer.parseInt(r);
            if(ri<0){
                room.setText("");
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Room can't be Negative Number");
                alert.show();
               return; 
                  }
            }catch(NumberFormatException ex){
              room.setText("");
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Room Must be Number");
                alert.show();
               return; 
               }
              
        }  
       
        if(d.equalsIgnoreCase(""))
              {
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Department can't be empty");
                alert.show();
               return; 
         }else{
            for(int i=0;i<d.length();i++){
            if(!Character.isLetter(d.charAt(i)))
               {
                department.setText(""); 
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Department Must be Letter");
                alert.show();
               return;
               
                }
            }
        }        
        if(sect.length()>1) {
                section.setText("");
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Section can't be more than one letter");
                alert.show();
               return; 
          }
       
         if(sect.length()==0) {
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Section can't be empty");
                alert.show();
               return; 
              }
         else if(!Character.isLetter(sect.charAt(0)))
               {
                section.setText(""); 
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Section Must be Letter");
                alert.show();
               return;
               
                } 
        if(y==null){
        
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Year Must be selected");
                alert.show();
               return; 
        }
      
        if(le==null){
        
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Level Must be selected");
                alert.show();
               return; 
        }
        
         if(se==null){
        
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Semistor Must be selected");
                alert.show();
               return; 
        }
       
           if(ty==null){
        
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Sudent Type Must be selected");
                alert.show();
               return; 
        }
           
        if(course=="Night" || course=="night"){
            String N;
             int x,z;
        
         try{
               database c=new database();
               con=c.connnect();
           
            Statement Stem=con.createStatement();
            String s="select * from table1 ";
            ResultSet rs=Stem.executeQuery(s);
             while(rs.next()){
               N=rs.getString("course_type");
               x=rs.getInt("block");
               z=rs.getInt("room");
          if((bi==x)&&(ri==z)&&(N.equalsIgnoreCase("weekend")))
              {  
              
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("The Room Is already Registored");
                alert.show();
               return;
               }
             }
          
         }catch(SQLException err){
                    Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText(""+err);
                alert.show();
               return;
         }
        }
            
            
        if(course=="Weekend" || course=="weekend"){
            String N;
             int x,z;
        
         try{
               database c=new database();
               con=c.connnect();
           
            Statement Stem=con.createStatement();
            String s="select * from table1 ";
            ResultSet rs=Stem.executeQuery(s);
             while(rs.next()){
               N=rs.getString("course_type");
               x=rs.getInt("block");
               z=rs.getInt("room");
              if((bi==x)&&(ri==z)&&(N.equalsIgnoreCase("night")))
              {   
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("The Room Is already Registored");
                alert.show();
               return;
               }
             }
          
         }catch(SQLException err){
                    Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText(""+err);
                alert.show();
               return;
         }
        }    
         
        if(true){
            String N;
             int x,z;
        
         try{
               database c=new database();
               con=c.connnect();
           
               Statement Stem=con.createStatement();
               String s="select * from table1 ";
               ResultSet rs=Stem.executeQuery(s);
               
             while(rs.next()){
               N=rs.getString("course_type");
               x=rs.getInt("block");
               z=rs.getInt("room");
              if((bi==x)&&(ri==z)&&(N.equalsIgnoreCase(course)))
              {   
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("The Room Is already Registored ");
                alert.show();
               return;
               }
             }
          
         }catch(SQLException err){
                    Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText(""+err);
                alert.show();
               return;
         }
        }          
        
           if(le.equalsIgnoreCase("1st year"))
                 {level_counter=1;}
         if(le.equalsIgnoreCase("2nd year")){
             level_counter=2;
           }
         if(le.equalsIgnoreCase("3rd year"))
                 {level_counter=3;}
         if(le.equalsIgnoreCase("4th year"))
                 {level_counter=4;}
         if(le.equalsIgnoreCase("5th year")){
         level_counter=5;}
         if(le.equalsIgnoreCase("6th year"))
         {level_counter=6;}
         if(le.equalsIgnoreCase("7th year")){
             level_counter=7;
         }
         if(se.equalsIgnoreCase("1st")){
         semis=1;
         }else if(se.equalsIgnoreCase("2nd")){
         semis=2;
         }
         else if(se.equalsIgnoreCase("3rd")){
         semis=3;
         }
           
         if(course.equalsIgnoreCase("regular"))
         { 
             
     theQurery("insert into table1(block,room,department,course_type,section,level,year,semistor,"
               + "student_type) values ('"+bi+"','"+ri+"','"+d+"','"+course+"','"+sect+"','"+level_counter+"','"+
             y+"','"+semis+"','"+ty+"')");
     
     theQurery("insert into table2(block,room,course_type,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13"
             + ",p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35) "
             + "values('"+bi+"','"+ri+"','"+course+"','"+m1.getText().trim()+"','"+m2.getText().trim()+"','"+m3.getText().trim()+"','"+m4.getText().trim()+"'"
             + ",'"+m5.getText().trim()+"','"+m6.getText().trim()+"','"+m7.getText().trim()+"','"+tu1.getText().trim()+"','"+tu2.getText().trim()+"','"+tu3.getText().trim()+"'"
             + ",'"+tu4.getText().trim()+"','"+tu5.getText().trim()+"','"+tu6.getText().trim()+"','"+tu7.getText().trim()+"','"+w1.getText().trim()+"'"
             + ",'"+w2.getText().trim()+"','"+w3.getText().trim()+"','"+w4.getText().trim()+"','"+w5.getText().trim()+"','"+w6.getText().trim()+"',"
             + "'"+w7.getText().trim()+"','"+th1.getText().trim()+"','"+th2.getText().trim()+"','"+th3.getText().trim()+"',"
             + "'"+th4.getText().trim()+"','"+th5.getText().trim()+"','"+th6.getText().trim()+"','"+th7.getText().trim()+"','"+f1.getText().trim()+"','"+f2.getText().trim()+"',"
             + "'"+f3.getText().trim()+"','"+f4.getText().trim()+"','"+f5.getText().trim()+"','"+f6.getText().trim()+"','"+f7.getText().trim()+"')"); 
          
     Alert alert=new Alert(Alert.AlertType.INFORMATION); 
                alert.setHeaderText(null);
                alert.setContentText("Saved");
                alert.show();
     
         }
         else if(course.equalsIgnoreCase("night")){
         
           theQurery("insert into table1(block,room,department,course_type,section,level,year,semistor,"
               + "student_type) values ('"+bi+"','"+ri+"','"+d+"','"+course+"','"+sect+"','"+level_counter+"','"+
             y+"','"+ semis+"','"+ty+"')");
     
     theQurery("insert into table3(block,room,course_type,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13"
             + ",p14,p15,p16,p17,p18) "
             + "values('"+bi+"','"+ri+"','"+course+"','"+m1.getText().trim()+"','"+m2.getText().trim()+"','"+tu1.getText().trim()+
             "','"+tu2.getText().trim()+"','"+w1.getText().trim()+"','"+w2.getText().trim()+"','"+th1.getText().trim()+"','"+th2.getText().trim()+
             "','"+f1.getText().trim()+"','"+f2.getText().trim()+ "','"+sa1.getText().trim()+"','"+sa2.getText().trim()+ "','"+sa3.getText().trim()
             +"','"+sa4.getText().trim()+"','"+s1.getText().trim()+"','"+s2.getText().trim().trim()+ "','"+s3.getText().trim()+"','"+s4.getText().trim()+"')"); 
            
     Alert alert=new Alert(Alert.AlertType.INFORMATION); 
                alert.setHeaderText(null);
                alert.setContentText("Saved");
                alert.show();            
         }
         
         else if(course.equalsIgnoreCase("weekend")){
         
           theQurery("insert into table1(block,room,department,course_type,section,level,year,semistor,"
               + "student_type) values ('"+bi+"','"+ri+"','"+d+"','"+course+"','"+sect+"','"+level_counter+"','"+
             y+"','"+semis+"','"+ty+"')");
     
     theQurery("insert into table4(block,room,course_type,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13"
             + ",p14) "
             + "values('"+bi+"','"+ri+"','"+course+"','"+m1.getText().trim()+"','"+m2.getText().trim()+"','"+m3.getText().trim()+
             "','"+m4.getText().trim().trim()+"','"+m5.getText().trim()+"','"+m6.getText().trim()+"','"+m7.getText().trim()+"','"+tu1.getText().trim()+
             "','"+tu2.getText().trim()+"','"+tu3.getText().trim()+ "','"+tu4.getText().trim()+"','"+tu5.getText().trim()+ "','"+tu6.getText().trim()
             +"','"+tu7.getText().trim()+"')"); 
              
                 Alert alert=new Alert(Alert.AlertType.CONFIRMATION); 
                alert.setHeaderText(null);
                alert.setContentText("Saved");
                alert.show();
          
         }
         
        }catch(Exception e){             
              Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText(""+e);
                alert.show();
               return; 
        }
         

        }
    if(event.getSource()==imp_excel)
    {  String course=(String) course_type.getValue(); 
      TableView table;
       FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
         File file = fileChooser.showOpenDialog(anchorpane.getScene().getWindow());
          String path = file.getAbsolutePath();
                     
        try(CSVReader csvReader = new CSVReader(new FileReader(path))){
            String[] nextLine;
            int line = 0;
         
            if((nextLine = csvReader.readNext())!=null){
                System.out.println("\n" + nextLine[0] + "\n");
              if(course=="Weekend"){
                if(nextLine.length == 2){
                    sa1.setText(nextLine[0]);
                    s1.setText(nextLine[1]);
                    if((nextLine = csvReader.readNext()) != null){
                        sa2.setText(nextLine[0]);
                        s2.setText(nextLine[1]);
                        if((nextLine = csvReader.readNext()) != null){
                            sa3.setText(nextLine[0]);
                            s3.setText(nextLine[1]);
                            if((nextLine = csvReader.readNext()) != null){
                                sa4.setText(nextLine[0]);
                                s4.setText(nextLine[1]);
                                if((nextLine = csvReader.readNext()) != null){
                                    sa5.setText(nextLine[0]);
                                    s5.setText(nextLine[1]);
                                    if((nextLine = csvReader.readNext()) != null){
                                        sa6.setText(nextLine[0]);
                                        s6.setText(nextLine[1]);
                                        if((nextLine = csvReader.readNext()) != null){
                                            sa7.setText(nextLine[0]);
                                            s7.setText(nextLine[1]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        Alert alert=new Alert(Alert.AlertType.ERROR); 
                        alert.setHeaderText(null);
                        alert.setContentText("File alignment not supported!");      
                        alert.show();
                        return; 
                   }
                }else if(nextLine.length == 5){
                    if(course=="Regular"){
                    m1.setText(nextLine[0]);
                    tu1.setText(nextLine[1]);
                    w1.setText(nextLine[2]);
                    th1.setText(nextLine[3]);
                    f1.setText(nextLine[4]);
                   
                    if((nextLine = csvReader.readNext()) != null){
                        m2.setText(nextLine[0]);
                        tu2.setText(nextLine[1]);
                        w2.setText(nextLine[2]);
                        th2.setText(nextLine[3]);
                        f2.setText(nextLine[4]);
                        if((nextLine = csvReader.readNext()) != null){
                            m3.setText(nextLine[0]);
                            tu3.setText(nextLine[1]);
                            w3.setText(nextLine[2]);
                            th3.setText(nextLine[3]);
                            f3.setText(nextLine[4]);
                            if((nextLine = csvReader.readNext()) != null){
                                m4.setText(nextLine[0]);
                                tu4.setText(nextLine[1]);
                                w4.setText(nextLine[2]);
                                th4.setText(nextLine[3]);
                                f4.setText(nextLine[4]);
                                if((nextLine = csvReader.readNext()) != null){
                                    m5.setText(nextLine[0]);
                                    tu5.setText(nextLine[1]);
                                    w5.setText(nextLine[2]);
                                    th5.setText(nextLine[3]);
                                    f5.setText(nextLine[4]);
                                    if((nextLine = csvReader.readNext()) != null){
                                        m6.setText(nextLine[0]);
                                        tu6.setText(nextLine[1]);
                                        w6.setText(nextLine[2]);
                                        th6.setText(nextLine[3]);
                                        f6.setText(nextLine[4]);
                                        if((nextLine = csvReader.readNext()) != null){
                                            m7.setText(nextLine[0]);
                                            tu7.setText(nextLine[1]);
                                            w7.setText(nextLine[2]);
                                            th7.setText(nextLine[3]);
                                            f7.setText(nextLine[4]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        Alert alert=new Alert(Alert.AlertType.ERROR); 
                        alert.setHeaderText(null);
                        alert.setContentText("File alignment not supported!");      
                        alert.show();
                        return; 
                   }
                    }else if(nextLine.length == 7){
                       if(course=="Night"){
                        if((nextLine = csvReader.readNext()) != null){
                            m1.setText(nextLine[0]);
                            tu1.setText(nextLine[1]);
                            w1.setText(nextLine[2]);
                            th1.setText(nextLine[3]);
                            f1.setText(nextLine[4]);
                            sa1.setText(nextLine[5]);
                            s1.setText(nextLine[6]);
                            if((nextLine = csvReader.readNext()) != null){
                                m2.setText(nextLine[0]);
                                tu2.setText(nextLine[1]);
                                w2.setText(nextLine[2]);
                                th2.setText(nextLine[3]);
                                f2.setText(nextLine[4]);
                                sa2.setText(nextLine[5]);
                                s2.setText(nextLine[6]);
                                if((nextLine = csvReader.readNext()) != null){
                                    sa3.setText(nextLine[5]);
                                    s3.setText(nextLine[6]);
                                    if((nextLine = csvReader.readNext()) != null){
                                        sa4.setText(nextLine[5]);
                                        s4.setText(nextLine[6]);
                                        }
                                    }
                                }
                            }
                        }else{
                        Alert alert=new Alert(Alert.AlertType.ERROR); 
                        alert.setHeaderText(null);
                        alert.setContentText("File alignment not supported!");      
                        alert.show();
                        return; 
                   }
                    }else{
                        Alert alert=new Alert(Alert.AlertType.ERROR); 
                        alert.setHeaderText(null);
                        alert.setContentText("File alignment not supported!");      
                        alert.show();
                        return; 
                   }
            }
      
     }  catch (FileNotFoundException ex) {
            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    }
   @FXML
    private void course_type_combo(ActionEvent event) {

       String a=(String) course_type.getValue();
       save.setVisible(true);
       imp_excel.setVisible(true);
        
if(a.equalsIgnoreCase("Regular")) {
        
        clear();        
        mondat_sat.setText("Monday");
        tusday_sun.setText("Tusday"); 
        mondat_sat.setVisible(true);
        tusday_sun.setVisible(true);
        wedensday.setVisible(true); 
        thursday.setVisible(true);
        friday.setVisible(true);
        saturday.setVisible(false);
        sunday.setVisible(false);
        
         m1.setVisible(true);
         m2.setVisible(true);
         m3.setVisible(true);
         m4.setVisible(true);
         m5.setVisible(true);
         m6.setVisible(true);
         m7.setVisible(true);
        
      
        
         tu1.setVisible(true);
         tu2.setVisible(true);
         tu3.setVisible(true);
         tu4.setVisible(true);
         tu5.setVisible(true);
         tu6.setVisible(true);
         tu7.setVisible(true);
        
      
         
          w1.setVisible(true);
         w2.setVisible(true);
         w3.setVisible(true);
         w4.setVisible(true);
         w5.setVisible(true);
         w6.setVisible(true);
         w7.setVisible(true);

   
       
         
         th1.setVisible(true);
         th2.setVisible(true);
         th3.setVisible(true);
         th4.setVisible(true);
         th5.setVisible(true);
         th6.setVisible(true);
         th7.setVisible(true);
         
         f1.setVisible(true);
         f2.setVisible(true);
         f3.setVisible(true);
         f4.setVisible(true);
         f5.setVisible(true);
         f6.setVisible(true);
         f7.setVisible(true);
            
         sa1.setVisible(false);
         sa2.setVisible(false);
         sa3.setVisible(false);
         sa4.setVisible(false);
         sa5.setVisible(false);
         sa6.setVisible(false);
         sa7.setVisible(false);
         
         s1.setVisible(false);
         s2.setVisible(false);
         s3.setVisible(false);
         s4.setVisible(false);
         s5.setVisible(false);
         s6.setVisible(false);
         s7.setVisible(false);
         
         
        }
    else if(a.equalsIgnoreCase("Night")){
     
        clear();
       mondat_sat.setText("Monday");
       tusday_sun.setText("Tusday");
       mondat_sat.setVisible(true);
       tusday_sun.setVisible(true);
       wedensday.setVisible(true); 
       thursday.setVisible(true);
       friday.setVisible(true);
        saturday.setVisible(true);
        sunday.setVisible(true);
       
         m1.setVisible(true);
         m2.setVisible(true);
         m3.setVisible(false);
         m4.setVisible(false);
         m5.setVisible(false);
         m6.setVisible(false);
         m7.setVisible(false);
        
         tu1.setVisible(true);
         tu2.setVisible(true);
         tu3.setVisible(false);
         tu4.setVisible(false);
         tu5.setVisible(false);
         tu6.setVisible(false);
         tu7.setVisible(false);
           
          w1.setVisible(true);
         w2.setVisible(true);
         w3.setVisible(false);
         w4.setVisible(false);
         w5.setVisible(false);
         w6.setVisible(false);
         w7.setVisible(false);

         th1.setVisible(true);
         th2.setVisible(true);
         th3.setVisible(false);
         th4.setVisible(false);
         th5.setVisible(false);
         th6.setVisible(false);
         th7.setVisible(false);
         
         f1.setVisible(true);
         f2.setVisible(true);
         f3.setVisible(false);
         f4.setVisible(false);
         f5.setVisible(false);
         f6.setVisible(false);
         f7.setVisible(false);

         sa1.setVisible(true);
         sa2.setVisible(true);
         sa3.setVisible(true);
         sa4.setVisible(true);
         
         sa5.setVisible(false);
         sa6.setVisible(false);
         sa7.setVisible(false);
         
         s1.setVisible(true);
         s2.setVisible(true);
         s3.setVisible(true);
         s4.setVisible(true);
         s5.setVisible(false);
         s6.setVisible(false);
         s7.setVisible(false);
         
        }
   
    else if(a.equalsIgnoreCase("Weekend"))
            {       
       clear();
       mondat_sat.setText("Saturday");
       tusday_sun.setText("Sunday");
       mondat_sat.setVisible(true);
       tusday_sun.setVisible(true);
       wedensday.setVisible(false); 
       thursday.setVisible(false);
       friday.setVisible(false);
       saturday.setVisible(false);
       sunday.setVisible(false);
       
         m1.setVisible(true);
         m2.setVisible(true);
         m3.setVisible(true);
         m4.setVisible(true);
         m5.setVisible(true);
         m6.setVisible(true);
         m7.setVisible(true);
        
         tu1.setVisible(true);
         tu2.setVisible(true);
         tu3.setVisible(true);
         tu4.setVisible(true);
         tu5.setVisible(true);
         tu6.setVisible(true);
         tu7.setVisible(true);
           
         w1.setVisible(false);
         w2.setVisible(false);
         w3.setVisible(false);
         w4.setVisible(false);
         w5.setVisible(false);
         w6.setVisible(false);
         w7.setVisible(false);

         th1.setVisible(false);
         th2.setVisible(false);
         th3.setVisible(false);
         th4.setVisible(false);
         th5.setVisible(false);
         th6.setVisible(false);
         th7.setVisible(false);
         
         f1.setVisible(false);
         f2.setVisible(false);
         f3.setVisible(false);
         f4.setVisible(false);
         f5.setVisible(false);
         f6.setVisible(false);
         f7.setVisible(false);    
        
         sa1.setVisible(false);
         sa2.setVisible(false);
         sa3.setVisible(false);
         sa4.setVisible(false);
         sa5.setVisible(false);
         sa6.setVisible(false);
         sa7.setVisible(false);   
            
         s1.setVisible(false);
         s2.setVisible(false);
         s3.setVisible(false);
         s4.setVisible(false);
         s5.setVisible(false);
         s6.setVisible(false);
         s7.setVisible(false);  }
    
    }

    @FXML
    private void validate(KeyEvent event) {
         TextField tf=new TextField();
        
        if(event.getSource()==m1){
            tf=m1;
        }
        else if(event.getSource()==m2){
            tf=m2;
        }
        else if(event.getSource()==m3){
            tf=m3;
        }
        else if(event.getSource()==m4){
            tf=m4;
        }
        else if(event.getSource()==m5){
            tf=m5;
        }
        else if(event.getSource()==m6){
            tf=m6;
        }
        else if(event.getSource()==m7){
            tf=m7;
        }
        else if(event.getSource()==tu1){
            tf=tu1;
        }
        else if(event.getSource()==tu2){
            tf=tu2;
        }
        else if(event.getSource()==tu3){
            tf=tu3;
        }
        else if(event.getSource()==tu4){
            tf=tu4;
        }
        else if(event.getSource()==tu5){
            tf=tu5;
        }
        else if(event.getSource()==tu6){
            tf=tu6;
        }
        else if(event.getSource()==tu7){
            tf=tu7;
        }
        else if(event.getSource()==w1){
            tf=w1;
        }
        else if(event.getSource()==w2){
            tf=w2;
        }
        else if(event.getSource()==w3){
            tf=w3;
        }
        else if(event.getSource()==w4){
            tf=w4;
        }
        else if(event.getSource()==w5){
            tf=w5;
        }
        else if(event.getSource()==w6){
            tf=w6;
        }
        else if(event.getSource()==w7){
            tf=w7;
        }
        else if(event.getSource()==th1){
            tf=th1;
        }
        else if(event.getSource()==th2){
            tf=th2;
        }
        else if(event.getSource()==th3){
            tf=th3;
        }
        else if(event.getSource()==th4){
            tf=th4;
        }
        else if(event.getSource()==th5){
            tf=th5;
        }
        else if(event.getSource()==th6){
            tf=th6;
        }
        else if(event.getSource()==th7){
            tf=th7;
        }else if(event.getSource()==f1){
            tf=f1;
        }
        else if(event.getSource()==f2){
            tf=f2;
        }
        else if(event.getSource()==f3){
            tf=f3;
        }
        else if(event.getSource()==f4){
            tf=f4;
        }
        else if(event.getSource()==f5){
            tf=f5;
        }
        else if(event.getSource()==f6){
            tf=f6;
        }
        else if(event.getSource()==f7){
            tf=f7;
        }
        else if(event.getSource()==sa1){
            tf=sa1;
        }
        else if(event.getSource()==sa2){
            tf=sa2;
        }
        else if(event.getSource()==sa3){
            tf=sa3;
        }
        else if(event.getSource()==sa4){
            tf=sa4;
        }
        else if(event.getSource()==sa5){
            tf=sa5;
        }
        else if(event.getSource()==sa6){
            tf=sa6;
        }
        else if(event.getSource()==sa7){
            tf=sa7;
        }
        else if(event.getSource()==s1){
            tf=s1;
        }
        else if(event.getSource()==s2){
            tf=s2;
        }
        else if(event.getSource()==s3){
            tf=s3;
        }
        else if(event.getSource()==s4){
            tf=s4;
        }
        else if(event.getSource()==s5){
            tf=s5;
        }
        else if(event.getSource()==s6){
            tf=s6;
        }
        else {
            tf=s7;
        }
        tf.setTextFormatter(new TextFormatter<String>(change -> {
            final int oldLength = change.getControlText().length();
            int newLength = change.getControlNewText().length();
            if(newLength < oldLength) return change;
            if(newLength == 11) return null;
            change.setCaretPosition(newLength);
            change.setAnchor(newLength);
            return change;
        }));
    }
    private void clear(){
                        m1.setText("");
                         m2.setText("");
                          m3.setText("");
                           m4.setText("");
                            m5.setText("");
                             m6.setText("");
                              m7.setText("");

                        tu1.setText("");
                         tu2.setText("");
                          tu3.setText("");
                           tu4.setText("");
                            tu5.setText("");
                             tu6.setText("");
                              tu7.setText("");

                        w1.setText("");
                         w2.setText("");
                          w3.setText("");
                           w4.setText("");
                            w5.setText("");
                             w6.setText("");
                              w7.setText("");         

                        th1.setText("");
                         th2.setText("");
                          th3.setText("");
                           th4.setText("");
                            th5.setText("");
                             th6.setText("");
                              th7.setText("");

                        f1.setText("");
                         f2.setText("");
                          f3.setText("");
                           f4.setText("");
                            f5.setText("");
                             f6.setText("");
                              f7.setText("");
             
                        sa1.setText("");
                         sa2.setText("");
                          sa3.setText("");
                           sa4.setText("");
                            sa5.setText("");
                             sa6.setText("");
                              sa7.setText("");       
  
                        s1.setText("");
                         s2.setText("");
                          s3.setText("");
                           s4.setText("");
                            s5.setText("");
                             s6.setText("");
                              s7.setText("");                      
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
    private void home(MouseEvent event) {
     
        try{
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
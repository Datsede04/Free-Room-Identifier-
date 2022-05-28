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
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KIMOK
 */
public class EditController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private ComboBox<?> combo2;
    @FXML
    private ComboBox<?> combo3;
    @FXML
    private ComboBox<?> combo4;
    @FXML
    private ComboBox<?> combo5;
    @FXML
    private ComboBox<?> combo1;
    @FXML
    private TextField m1;
    @FXML
    private TextField m2;
    @FXML
    private TextField m3;
    @FXML
    private TextField m4;
    @FXML
    private TextField m5;
    @FXML
    private TextField m6;
    @FXML
    private TextField m7;
    @FXML
    private TextField tu1;
    @FXML
    private TextField tu2;
    @FXML
    private TextField tu3;
    @FXML
    private TextField tu4;
    @FXML
    private TextField tu5;
    @FXML
    private TextField tu6;
    @FXML
    private TextField tu7;
    @FXML
    private TextField w1;
    @FXML
    private TextField w2;
    @FXML
    private TextField w3;
    @FXML
    private TextField w4;
    @FXML
    private TextField w5;
    @FXML
    private TextField w6;
    @FXML
    private TextField w7;
    @FXML
    private TextField th1;
    @FXML
    private TextField th2;
    @FXML
    private TextField th3;
    @FXML
    private TextField th4;
    @FXML
    private TextField th5;
    @FXML
    private TextField th6;
    @FXML
    private TextField th7;
    @FXML
    private TextField f1;
    @FXML
    private TextField f2;
    @FXML
    private TextField f3;
    @FXML
    private TextField f4;
    @FXML
    private TextField f5;
    @FXML
    private TextField f6;
    @FXML
    private TextField f7;
    @FXML
    private TextField sa1;
    @FXML
    private TextField sa2;
    @FXML
    private TextField sa3;
    @FXML
    private TextField sa4;
    @FXML
    private TextField sa5;
    @FXML
    private TextField sa6;
    @FXML
    private TextField sa7;
    @FXML
    private TextField s1;
    @FXML
    private TextField s2;
    @FXML
    private TextField s3;
    @FXML
    private TextField s4;
    @FXML
    private TextField s5;
    @FXML
    private TextField s6;
    @FXML
    private TextField s7;
    @FXML
    private Button save;
   Connection con;
    final ObservableList com1=FXCollections.observableArrayList();
    final ObservableList com2=FXCollections.observableArrayList();
    final ObservableList com3=FXCollections.observableArrayList();
    final ObservableList com4=FXCollections.observableArrayList();
    final ObservableList com5=FXCollections.observableArrayList();
    @FXML
    private Label mlabel;
    @FXML
    private Label tulabel;
    @FXML
    private Label wlabel;
    @FXML
    private Label thlabel;
    @FXML
    private Label flabel;
    @FXML
    private Label salabel;
    @FXML
    private Label slabel;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     combo1.setPromptText("Department");
     combo2.setPromptText("Type");
     combo3.setPromptText("Section");
     combo4.setPromptText("Level");
     combo5.setPromptText("Program");
     
     combo1.setItems(com1);
     combo2.setItems(com2);
     combo3.setItems(com3);        
     combo4.setItems(com4);
     combo5.setItems(com5);
     
     mlabel.setText("Monday");
     tulabel.setText("Tusday");
     wlabel.setText("Wednsday");
     thlabel.setText("Thursday");
     flabel.setText("Friday");
     salabel.setText("Saturday");
     slabel.setText("Sunday");
      try{
                
          
            database c=new database();
            con=c.connnect();
                       
            Statement s = con.createStatement();
            String sql = "select distinct department from table1";
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                        
            com1.add(rs.getString("department"));             
   
            }
       }catch(SQLException err){
           Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("at the combo1"+err);
                alert.show();
               return;
          }
    }    

    @FXML
    private void combo_action2(ActionEvent event) {
     try{    
         com3.removeAll(com3);        
            database c=new database();
            con=c.connnect();
          
            String d1=(String) combo1.getValue();
            String d2=(String) combo2.getValue();        
            Statement s = con.createStatement();
     
            StringBuilder sqlo=new StringBuilder("select distinct section from table1 ");
            sqlo.append("where ");
            sqlo.append("department='");
            sqlo.append(d1);
            sqlo.append("' and");
            sqlo.append(" course_type='");
            sqlo.append(d2);
            sqlo.append("'");
      
            String sql =  sqlo.toString();                  
            ResultSet rs = s.executeQuery(sql);
              System.out.println(sql);
                  
              while(rs.next()){
                   System.out.println(sql);
            
                  com3.add(rs.getString("section"));             
                    
                   }
             }catch(SQLException err){
              
                 Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("at the combo2 department & section"+err);
                alert.show();
               return;
               
          }  
    }

    @FXML
    private void combo_Action3(ActionEvent event) {
      com4.removeAll(com4); 
            try{
                
                          
            String d1=(String) combo1.getValue();
            String d2=(String) combo2.getValue(); 
            String d3=(String) combo3.getValue();
          
            database c=new database();
            con=c.connnect();
                       
            Statement s = con.createStatement();
            StringBuilder sqlo=new StringBuilder("select distinct level from table1 ");
            sqlo.append("where ");
            sqlo.append("department='");
            sqlo.append(d1);
            sqlo.append("' and");
            sqlo.append(" course_type='");
            sqlo.append(d2);
            sqlo.append("'");
            sqlo.append(" and section='");
            sqlo.append(d3);
            sqlo.append("'");
           
              
      
            String sql =sqlo.toString();
            ResultSet rs = s.executeQuery(sql);
            
              while(rs.next()){
                         { 
                             com4.add(rs.getString("level"));             
                         }
                   }
             }catch(SQLException err){
               Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("at the combo3 department & section"+err);
                alert.show();
               return;
          }   
        
    }

    @FXML
    private void combo4_action(ActionEvent event) {
      
         com5.removeAll(com5);
         String d1=(String) combo1.getValue();
         String d2=(String) combo2.getValue();
         String d3=(String) combo3.getValue();
         String d4=(String) combo4.getValue();       
       
       try{
                
            
            database c=new database();
            con=c.connnect();
            Statement s = con.createStatement();
      
            StringBuilder sqlo=new StringBuilder("select distinct student_type from table1 ");
            sqlo.append("where ");
            sqlo.append("department='");
            sqlo.append(d1);
            sqlo.append("' and");
            sqlo.append(" course_type='");
            sqlo.append(d2);
            sqlo.append("'");
            sqlo.append(" and section='");
            sqlo.append(d3);
            sqlo.append("'");
            sqlo.append(" and level='");
            sqlo.append(d4);
            sqlo.append("'");
           
      String sql = sqlo.toString();
      ResultSet rs = s.executeQuery(sql);
            
              while(rs.next()){
                      
                       { com5.add(rs.getString("student_type"));             
                       }
                   }
             }catch(SQLException err){
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("at the combo4 department & section"+err);
                alert.show();
               return;
          }  
    }

    @FXML
    private void combo_action5(ActionEvent event) {
       visible(); 
       clear();
String r="Regular",n="Night",w="Weekend";

       System.out.println("From combo5 Action");
    try{
        
      database c=new database();
      con=c.connnect();
   
      String d1=(String) combo1.getValue();         
      String d2=(String) combo2.getValue();         
      String d3=(String) combo3.getValue();         
      String d4=(String) combo4.getValue();         
      String d5=(String) combo5.getValue();         
      
        
   if(r.equalsIgnoreCase(d2)){  
       
           StringBuilder sqlo=new StringBuilder("select * from table2 inner join table1 on table2.block=table1.block and table2.room=table1.room and table2.course_type=table1.course_type ");
            sqlo.append("where ");
            sqlo.append("table1.department='");
            sqlo.append(d1);
            sqlo.append("' and");
            sqlo.append(" table1.course_type='");
            sqlo.append(d2);
            sqlo.append("'");
            sqlo.append(" and table1.section='");
            sqlo.append(d3);
            sqlo.append("'");
            sqlo.append(" and table1.level='");
            sqlo.append(d4);
            sqlo.append("' and table1.student_type='");
            sqlo.append(d5);
            sqlo.append("'");
      
      Statement s = con.createStatement();   
      String sql = sqlo.toString();
      ResultSet rs = s.executeQuery(sql);
         
              if(rs.next())
                       { System.out.println("from the regular");
                         m1.setText(rs.getString("p1"));
                         m2.setText(rs.getString("p2"));
                         m3.setText(rs.getString("p3"));
                         m4.setText(rs.getString("p4"));
                         m5.setText(rs.getString("p5"));
                         m6.setText(rs.getString("p6"));
                         m7.setText(rs.getString("p7"));
                              
                         tu1.setText(rs.getString("p8"));
                         tu2.setText(rs.getString("p9"));
                         tu3.setText(rs.getString("p10"));
                         tu4.setText(rs.getString("p11"));
                         tu5.setText(rs.getString("p12"));
                         tu6.setText(rs.getString("p13"));
                         tu7.setText(rs.getString("p14"));
                         
                         w1.setText(rs.getString("p15"));  
                         w2.setText(rs.getString("p16"));  
                         w3.setText(rs.getString("p17"));  
                         w4.setText(rs.getString("p18"));  
                         w5.setText(rs.getString("p19"));  
                         w6.setText(rs.getString("p20"));  
                         w7.setText(rs.getString("p21"));   
                         
                         th1.setText(rs.getString("p22"));  
                         th2.setText(rs.getString("p23"));  
                         th3.setText(rs.getString("p24"));  
                         th4.setText(rs.getString("p25"));  
                         th5.setText(rs.getString("p26"));  
                         th6.setText(rs.getString("p27"));  
                         th7.setText(rs.getString("p28"));  
                         
                         f1.setText(rs.getString("p29"));
                         f2.setText(rs.getString("p30"));
                         f3.setText(rs.getString("p31"));
                         f4.setText(rs.getString("p32"));
                         f5.setText(rs.getString("p33"));
                         f6.setText(rs.getString("p34"));
                         f7.setText(rs.getString("p35"));
                         
                       }         
       }else if(n.equalsIgnoreCase(d2)){
             
            StringBuilder sqlo=new StringBuilder("select * from table3 join table1 on table3.block=table1.block and table1.room=table3.room and table1.course_type=table3.course_type ");
            sqlo.append("where ");
            sqlo.append("table1.department='");
            sqlo.append(d1);
            sqlo.append("' and");
            sqlo.append(" table1.course_type='");
            sqlo.append(d2);
            sqlo.append("'");
            sqlo.append(" and table1.section='");
            sqlo.append(d3);
            sqlo.append("'");
            sqlo.append(" and table1.level='");
            sqlo.append(d4);
            sqlo.append("' and table1.student_type='");
            sqlo.append(d5);
            sqlo.append("'");
                  
            Statement s = con.createStatement();   
      String sql = sqlo.toString();
      ResultSet rs = s.executeQuery(sql);
            
              if(rs.next())
                       {
                         
                         m1.setText(rs.getString("p1"));
                         m2.setText(rs.getString("p2"));
                                                   
                         tu1.setText(rs.getString("p3"));
                         tu2.setText(rs.getString("p4"));
                                               
                         w1.setText(rs.getString("p5"));  
                         w2.setText(rs.getString("p6"));  
                         
                         th1.setText(rs.getString("p7"));  
                         th2.setText(rs.getString("p8"));  
                         
                         f1.setText(rs.getString("p9"));
                         f2.setText(rs.getString("p10"));
                        
                         sa1.setText(rs.getString("p11"));
                         sa2.setText(rs.getString("p12"));
                         sa3.setText(rs.getString("p13"));
                         sa4.setText(rs.getString("p14"));
                         
                         s1.setText(rs.getString("p15"));
                         s2.setText(rs.getString("p16"));
                         s3.setText(rs.getString("p17"));
                         s4.setText(rs.getString("p18"));
                       } 
            }else if(w.equalsIgnoreCase(d2)){
                   System.out.println("From combo5 Action  weekend");
              
            StringBuilder sqlo=new StringBuilder("select * from table4 join table1 on table4.block=table1.block and table1.room=table4.room and table1.course_type=table4.course_type ");
            sqlo.append("where ");
            sqlo.append("table1.department='");
            sqlo.append(d1);
            sqlo.append("' and");
            sqlo.append(" table1.course_type='");
            sqlo.append(d2);
            sqlo.append("'");
            sqlo.append(" and table1.section='");
            sqlo.append(d3);
            sqlo.append("'");
            sqlo.append(" and table1.level='");
            sqlo.append(d4);
            sqlo.append("' and table1.student_type='");
            sqlo.append(d5);
            sqlo.append("'");
                  
            Statement s = con.createStatement();   
      String sql = sqlo.toString();
      ResultSet rs = s.executeQuery(sql);
            
              if(rs.next())
                       {
                      
                         m1.setText(rs.getString("p1"));
                         m2.setText(rs.getString("p2"));
                         m3.setText(rs.getString("p3"));
                         m4.setText(rs.getString("p4"));
                         m5.setText(rs.getString("p5"));
                         m6.setText(rs.getString("p6"));
                         m7.setText(rs.getString("p7"));
                                                                             
                         tu1.setText(rs.getString("p8"));
                         tu2.setText(rs.getString("p9"));
                         tu3.setText(rs.getString("p10"));
                         tu4.setText(rs.getString("p11"));
                         tu5.setText(rs.getString("p12"));
                         tu6.setText(rs.getString("p13"));
                         tu7.setText(rs.getString("p14"));
                          
                        
                       } 
            
            }
             }catch(SQLException err){
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("at the combo4 department & section"+err);
                alert.show();
               return;
          }   
    }

    @FXML
    private void combo_action1(ActionEvent event) {
    String dep=(String) combo1.getValue();     
            try{
                
            com2.removeAll(com2);
            database c=new database();
            con=c.connnect();
                       
            Statement s = con.createStatement();
            StringBuilder sqlo=new StringBuilder("select distinct course_type from table1 ");
            sqlo.append("where ");
            sqlo.append("department='");
            sqlo.append(dep);
            sqlo.append("'");
            
            String sql = sqlo.toString();
            ResultSet rs = s.executeQuery(sql);
            
              while(rs.next()){
                         
                     com2.add(rs.getString("course_type"));             
                    
                   }
             }catch(SQLException err){
                 Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("at the combo1Time and block"+err);
                alert.show();
               return;
          }   
    }

    @FXML
    private void save_action(ActionEvent event) {
       
                String c1=(String) combo1.getValue();    
                String c2=(String) combo2.getValue();   
                String c3=(String) combo3.getValue();
                String c4=(String) combo4.getValue();
                String c5=(String) combo5.getValue();
               int  block=0,room=0;
              String course="";  
        if(c1==null)
              {
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Department must be selected");
                alert.show();
               return; 
      
        }
        
        if(c2==null)
              {
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Course type Must be selected");
                alert.show();
               return; 
              }
   if(c3==null)
              {
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Section must be selected");
                alert.show();
               return; 
         }
                
        if(c4==null) {
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Level must be selected");
                alert.show();
               return; 
          }
       
         if(c5==null) {
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Program Must be selected");
                alert.show();
               return; 
         }  
        try{  database c=new database();
            con=c.connnect();
                       
            Statement s = con.createStatement();
            StringBuilder sqlo=new StringBuilder("select block,room,course_type from table1 ");
            sqlo.append("where ");
            sqlo.append("department='");
            sqlo.append(c1);
            sqlo.append("' and course_type='");
            sqlo.append(c2);
            sqlo.append("' and section='");
            sqlo.append(c3);
            sqlo.append("' and level='");
            sqlo.append(c4);
            sqlo.append("' and student_type='");
            sqlo.append(c5);
            sqlo.append("'");
                        
            String sql = sqlo.toString();
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
             block=rs.getInt("block");
             room=rs.getInt("room");
             course=rs.getString("course_type");
            }
        }catch(SQLException e){
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("befor the query"+e);
                alert.show();
               return;      
        }
        if("Regular".equalsIgnoreCase(c2))
        {
            theQurery("update table2 set "
             + "p1='"+m1.getText().trim()+"',p2='"+m2.getText().trim()+"',p3='"+m3.getText().trim()+"',p4='"+m4.getText().trim()+"'"
             + ",p5='"+m5.getText().trim()+"',p6='"+m6.getText().trim()+"',p7='"+m7.getText().trim()+"',p8='"+tu1.getText().trim()+"',p9='"+tu2.getText().trim()+"',p10='"+tu3.getText().trim()+"'"
             + ",p11='"+tu4.getText().trim()+"',p12='"+tu5.getText().trim()+"',p13='"+tu6.getText().trim()+"',p14='"+tu7.getText().trim()+"',p15='"+w1.getText().trim()+"'"
             + ",p16='"+w2.getText().trim()+"',p17='"+w3.getText().trim()+"',p18='"+w4.getText().trim()+"',p19='"+w5.getText().trim()+"',p20='"+w6.getText().trim()+"',"
                     + "p21='"+w7.getText().trim()+"',p22='"+th1.getText().trim()+"',p23='"+th2.getText().trim()+"',p24='"+th3.getText().trim()+"',p25="
             + "'"+th4.getText().trim()+"',p26='"+th5.getText().trim()+"',p27='"+th6.getText().trim()+"',p28='"+th7.getText().trim()+"',p29='"+f1.getText().trim()+"',p30='"+f2.getText().trim()+
                 "',p31='"+f3.getText().trim()+"',p32='"+f4.getText().trim()+"',p33='"+f5.getText().trim()+"',p34='"+f6.getText().trim()+"',p35='"+f7.getText().trim()+"' where"
               + " block="+block+" and room="+room+" and course_type='"+course+"'");
             Alert alert=new Alert(Alert.AlertType.INFORMATION); 
                alert.setHeaderText(null);
                alert.setContentText("Regular period has been updated");
                alert.show();
               return; 
        }
        else if("Night".equalsIgnoreCase(c2)){
        theQurery("update table3 set "
             + "p1='"+m1.getText().trim()+"',p2='"+m2.getText().trim()+"',p3='"+tu1.getText().trim()+"',p4='"+tu2.getText().trim()
                +"',p5='"+w1.getText().trim()+"',p6='"+w2.getText().trim()+"',p7='"+th1.getText().trim()+"',p8='"+th2.getText().trim()
                +"',p9='"+f1.getText().trim()+"',p10='"+f2.getText().trim()+"',p11='"+sa1.getText().trim()+"',p12='"+sa2.getText().trim()
                +"',p13='"+sa3.getText().trim()+"',p14='"+sa4.getText().trim()+"',p15='"+s1.getText().trim()+"',p16='"+s2.getText().trim()
                +"',p17='"+s3.getText().trim()+"',p18='"+s4.getText().trim()+"' where"
               + " block="+block+" and room="+room+" and course_type='"+course+"'"); 
               Alert alert=new Alert(Alert.AlertType.INFORMATION); 
                alert.setHeaderText(null);
                alert.setContentText("Night period has been updated");
                alert.show();
               return;         
        }
        else if("Weekend".equalsIgnoreCase(c2)){
             theQurery("update table4 set "
             + "p1='"+m1.getText().trim()+"',p2='"+m2.getText().trim()+"',p3='"+m3.getText().trim()+"',p4='"+m4.getText().trim()+"'"
             + ",p5='"+m5.getText().trim()+"',p6='"+m6.getText().trim()+"',p7='"+m7.getText().trim()+"',p8='"+tu1.getText().trim()+"',p9='"+tu2.getText().trim()+"',p10='"+tu3.getText().trim()+"'"
             + ",p11='"+tu4.getText().trim()+"',p12='"+tu5.getText().trim()+"',p13='"+tu6.getText().trim()+"',p14='"+tu7.getText().trim()+"' where block="+block+" and room="+room+" and course_type='"+course+"'"); 
             
         Alert alert=new Alert(Alert.AlertType.INFORMATION); 
                alert.setHeaderText(null);
                alert.setContentText("Weekend Progrma has been updated");
                alert.show();
               return; 
        }     
        
    }
    private void visible(){
        String a=(String)combo2.getValue();   
if(a.equalsIgnoreCase("Regular")) {
        
        clear();        
        mlabel.setText("Monday");
        tulabel.setText("Tusday"); 
        mlabel.setVisible(true);
        tulabel.setVisible(true);
        wlabel.setVisible(true); 
        thlabel.setVisible(true);
        flabel.setVisible(true);
        salabel.setVisible(false);
        slabel.setVisible(false);
        
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
       mlabel.setText("Monday");
       tulabel.setText("Tusday");
       mlabel.setVisible(true);
       tulabel.setVisible(true);
       wlabel.setVisible(true); 
       thlabel.setVisible(true);
       flabel.setVisible(true);
        salabel.setVisible(true);
        slabel.setVisible(true);
       
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
       mlabel.setText("Saturday");
       tulabel.setText("Sunday");
       mlabel.setVisible(true);
       tulabel.setVisible(true);
       wlabel.setVisible(false); 
       thlabel.setVisible(false);
       flabel.setVisible(false);
       salabel.setVisible(false);
       slabel.setVisible(false);
       
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
         s7.setVisible(false);
            }
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
  /*      if(event.getSource()=m1){
        m1.setTextFormatter(new TextFormatter<String>(change ->{
        
        final int oldlength =event.
        
        });
    */}
/*private String valid(TextField qw){
String string="";
qw.setTextFormatter(new TextFormatter<String>(change)->{

change.setText(change);

});
return string;}
    
}*/

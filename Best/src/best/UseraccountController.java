/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year;
import javafx.print.PrinterJob;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
public class UseraccountController implements Initializable {
Connection con;
    @FXML
    private Button search;
    @FXML
    private ComboBox<?> by_combo;
    @FXML
    private TextArea textarea;
    @FXML
    private Button print;
    @FXML
    private AnchorPane anchorpane;

    final ObservableList search_by=FXCollections.observableArrayList("Block & Room","Time & Block","department & section");
    final ObservableList com1=FXCollections.observableArrayList();
    final ObservableList com2=FXCollections.observableArrayList();
    final ObservableList com3=FXCollections.observableArrayList();
    final ObservableList com4=FXCollections.observableArrayList();
    final ObservableList com5=FXCollections.observableArrayList();
    final ObservableList Time=FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<?> combo1;
    @FXML
    private ComboBox<?> combo2;
    @FXML
    private ComboBox<?> combo3;
    @FXML
    private ComboBox<?> combo4;
    @FXML
    private ComboBox<?> combo5;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        print.setVisible(false);
        textarea.setVisible(true);
        textarea.setEditable(false);
        textarea.setFont(new Font("Consolas",13));
               
        combo1.setVisible(true);
        combo2.setVisible(true);
        combo3.setVisible(false);
        combo4.setVisible(false);
        combo5.setVisible(false);

        combo1.setItems(com1);
        combo2.setItems(com2);
        combo3.setItems(com3);
        combo4.setItems(com4);
        combo5.setItems(com5);
        by_combo.setItems(search_by);   
        
       try{        
           database c=new database();
               con=c.connnect();
               
            Statement s = con.createStatement();
            String sql = "select distinct block from table1";
            ResultSet rs = s.executeQuery(sql);
         
            while(rs.next()){
                        
            com1.add(rs.getInt("block")); 
            }
            
            
            
          }catch(SQLException err){
       //Alter Statement
       }
     
      
    }    


    @FXML
    private void search_action(ActionEvent event) {
         String a=(String) by_combo.getValue();
         print.setVisible(true);
         
        if(a=="Block & Room"|| a==null){
        
            if(combo1.getValue()==null||combo2.getValue()==null){
              Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Both Block and Room Must be Selected");
                alert.show();
               return; 
            }
            
        }
        if(a=="Time & Block"){
             if(combo1.getValue()==null||combo2.getValue()==null || combo3.getValue()==null){
             
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("All Must be Selected ");
                alert.show();
                return; 
             }
        }
        if(a=="department & section")
        {   if(combo1.getValue()==null||combo2.getValue()==null || combo3.getValue()==null ||combo4.getValue()==null||combo5.getValue()==null){
             
                Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("All Must be Selected ");
                alert.show();
                return; 
             }
        }
       
                Calendar calendar =new GregorianCalendar();

                int day=calendar.get(Calendar.DAY_OF_MONTH);
                int mon=calendar.get(Calendar.MONTH);
                int year=calendar.get(Calendar.YEAR);
                int sec=calendar.get(Calendar.SECOND);
                int min=calendar.get(Calendar.MINUTE);
                int hour=calendar.get(Calendar.HOUR);
       
        if(a=="Block & Room"|| a==null){ 
        try{
             database c=new database();
               con=c.connnect();
           
           int block=(Integer) combo1.getValue();
           int room=(Integer) combo2.getValue();
        
           String[] A=new String[35];
           String[] B=new String[18];
           String[] C=new String[14];
        for(int i=0;i<35;i++){
           A[i]="Free    "; 
           }
        for(int i=0;i<18;i++){
           B[i]="Free    "; 
           }
        for(int i=0;i<14;i++){
           C[i]="Free    "; 
           }    
            Statement s = con.createStatement();
            String sql = "select * from table2 where block='"+ block +"'and room="+room;                    
            ResultSet rs = s.executeQuery(sql);
        
           if(rs.next()){
                System.out.println("From table2 selction");
       
             if(rs.getString("p1").equalsIgnoreCase("")||rs.getString("p1").equalsIgnoreCase("lab")||rs.getString("p1").equalsIgnoreCase(null))
               A[0]="Free    ";
             else A[0]="Occupied";
           
              if(rs.getString("p2").equalsIgnoreCase("")||rs.getString("p2").equalsIgnoreCase("lab")||rs.getString("p2").equalsIgnoreCase(null))
               A[1]="Free    ";
             else A[1]="Occupied";
           
            if(rs.getString("p3").equalsIgnoreCase("")||rs.getString("p3").equalsIgnoreCase("lab")||rs.getString("p3").equalsIgnoreCase(null))
               A[2]="Free    ";
             else A[2]="Occupied";
            
            if(rs.getString("p4").equalsIgnoreCase("")||rs.getString("p4").equalsIgnoreCase("lab")||rs.getString("p4").equalsIgnoreCase(null))
               A[3]="Free    ";
             else A[3]="Occupied";
            
             if(rs.getString("p5").equalsIgnoreCase("")||rs.getString("p5").equalsIgnoreCase("lab")||rs.getString("p5").equalsIgnoreCase(null))
               A[4]="Free    ";
             else A[4]="Occupied";
           
            if(rs.getString("p6").equalsIgnoreCase("")||rs.getString("p6").equalsIgnoreCase("lab")||rs.getString("p6").equalsIgnoreCase(null))
               A[5]="Free    ";
             else A[5]="Occupied";
           
            if(rs.getString("p7").equalsIgnoreCase("")||rs.getString("p7").equalsIgnoreCase("lab")||rs.getString("p7").equalsIgnoreCase(null))
               A[6]="Free    ";
             else A[6]="Occupied";
           
           if(rs.getString("p8").equalsIgnoreCase("")||rs.getString("p8").equalsIgnoreCase("lab")||rs.getString("p8").equalsIgnoreCase(null))
               A[7]="Free    ";
             else A[7]="Occupied";
           
            if(rs.getString("p9").equalsIgnoreCase("")||rs.getString("p9").equalsIgnoreCase("lab")||rs.getString("p9").equalsIgnoreCase(null))
               A[8]="Free    ";
             else A[8]="Occupied";
           
            if(rs.getString("p10").equalsIgnoreCase("")||rs.getString("p10").equalsIgnoreCase("lab")||rs.getString("p10").equalsIgnoreCase(null))
               A[9]="Free    ";
             else A[9]="Occupied";
           
             if(rs.getString("p11").equalsIgnoreCase("")||rs.getString("p11").equalsIgnoreCase("lab")||rs.getString("p11").equalsIgnoreCase(null))
               A[10]="Free    ";
             else A[10]="Occupied";
           
              if(rs.getString("p12").equalsIgnoreCase("")||rs.getString("p12").equalsIgnoreCase("lab")||rs.getString("p12").equalsIgnoreCase(null))
               A[11]="Free    ";
             else A[11]="Occupied";
           
               if(rs.getString("p13").equalsIgnoreCase("")||rs.getString("p13").equalsIgnoreCase("lab")||rs.getString("p13").equalsIgnoreCase(null))
               A[12]="Free    ";
             else A[12]="Occupied";
           
             if(rs.getString("p14").equalsIgnoreCase("")||rs.getString("p14").equalsIgnoreCase("lab")||rs.getString("p14").equalsIgnoreCase(null))
               A[13]="Free    ";
             else A[13]="Occupied";
           
             if(rs.getString("p15").equalsIgnoreCase("")||rs.getString("p15").equalsIgnoreCase("lab")||rs.getString("p15").equalsIgnoreCase(null))
               A[14]="Free    ";
             else A[14]="Occupied";
           
              if(rs.getString("p16").equalsIgnoreCase("")||rs.getString("p16").equalsIgnoreCase("lab")||rs.getString("p16").equalsIgnoreCase(null))
               A[15]="Free    ";
             else A[15]="Occupied";
           
             if(rs.getString("p17").equalsIgnoreCase("")||rs.getString("p17").equalsIgnoreCase("lab")||rs.getString("p17").equalsIgnoreCase(null))
               A[16]="Free    ";
             else A[16]="Occupied";
             
            if(rs.getString("p18").equalsIgnoreCase("")||rs.getString("p18").equalsIgnoreCase("lab")||rs.getString("p18").equalsIgnoreCase(null))
               A[17]="Free    ";
             else A[17]="Occupied";
             
            if(rs.getString("p19").equalsIgnoreCase("")||rs.getString("p19").equalsIgnoreCase("lab")||rs.getString("p19").equalsIgnoreCase(null))
               A[18]="Free    ";
             else A[18]="Occupied";
            
           if(rs.getString("p20").equalsIgnoreCase("")||rs.getString("p20").equalsIgnoreCase("lab")||rs.getString("p20").equalsIgnoreCase(null))
               A[19]="Free    ";
             else A[19]="Occupied";
              
           if(rs.getString("p21").equalsIgnoreCase("")||rs.getString("p21").equalsIgnoreCase("lab")||rs.getString("p21").equalsIgnoreCase(null))
               A[20]="Free    ";
             else A[20]="Occupied";
           
          if(rs.getString("p22").equalsIgnoreCase("")||rs.getString("p22").equalsIgnoreCase("lab")||rs.getString("p22").equalsIgnoreCase(null))
               A[21]="Free    ";
             else A[21]="Occupied";
             
          if(rs.getString("p23").equalsIgnoreCase("")||rs.getString("p23").equalsIgnoreCase("lab")||rs.getString("p23").equalsIgnoreCase(null))
               A[22]="Free    ";
             else A[22]="Occupied";
          
           if(rs.getString("p24").equalsIgnoreCase("")||rs.getString("p24").equalsIgnoreCase("lab")||rs.getString("p24").equalsIgnoreCase(null))
               A[23]="Free    ";
             else A[23]="Occupied";
           
           if(rs.getString("p25").equalsIgnoreCase("")||rs.getString("p25").equalsIgnoreCase("lab")||rs.getString("p25").equalsIgnoreCase(null))
               A[24]="Free    ";
             else A[24]="Occupied";
             
           if(rs.getString("p26").equalsIgnoreCase("")||rs.getString("p26").equalsIgnoreCase("lab")||rs.getString("p26").equalsIgnoreCase(null))
               A[25]="Free    ";
             else A[25]="Occupied";
           
            if(rs.getString("p27").equalsIgnoreCase("")||rs.getString("p27").equalsIgnoreCase("lab")||rs.getString("p27").equalsIgnoreCase(null))
               A[26]="Free    ";
             else A[26]="Occupied";
           
            if(rs.getString("p28").equalsIgnoreCase("")||rs.getString("p28").equalsIgnoreCase("lab")||rs.getString("p28").equalsIgnoreCase(null))
               A[27]="Free    ";
             else A[27]="Occupied";
            
            if(rs.getString("p29").equalsIgnoreCase("")||rs.getString("p29").equalsIgnoreCase("lab")||rs.getString("p29").equalsIgnoreCase(null))
               A[28]="Free    ";
             else A[28]="Occupied";
           
             if(rs.getString("p30").equalsIgnoreCase("")||rs.getString("p30").equalsIgnoreCase("lab")||rs.getString("p30").equalsIgnoreCase(null))
               A[29]="Free    ";
             else A[29]="Occupied";
           
             if(rs.getString("p31").equalsIgnoreCase("")||rs.getString("p31").equalsIgnoreCase("lab")||rs.getString("p31").equalsIgnoreCase(null))
               A[30]="Free    ";
             else A[30]="Occupied";
             
             if(rs.getString("p32").equalsIgnoreCase("")||rs.getString("p32").equalsIgnoreCase("lab")||rs.getString("p32").equalsIgnoreCase(null))
               A[31]="Free    ";
             else A[31]="Occupied";
            
            if(rs.getString("p33").equalsIgnoreCase("")||rs.getString("p33").equalsIgnoreCase("lab")||rs.getString("p33").equalsIgnoreCase(null))
               A[32]="Free    ";
             else A[32]="Occupied";
           
             if(rs.getString("p34").equalsIgnoreCase("")||rs.getString("p34").equalsIgnoreCase("lab")||rs.getString("p34").equalsIgnoreCase(null))
               A[33]="Free    ";
             else A[33]="Occupied";
           
            if(rs.getString("p35").equalsIgnoreCase("")||rs.getString("p35").equalsIgnoreCase("lab")||rs.getString("p35").equalsIgnoreCase(null))
               A[34]="Free    ";
             else A[34]="Occupied";
           
           }
        
            Statement s2 = con.createStatement();
            String sql2 = "select * from table3 where block='"+ block +"'and room="+room;                    
            ResultSet rs2 = s.executeQuery(sql2);
        
              if(rs2.next()){
               System.out.println("From table3 selction");
       
            if(rs2.getString("p1").equalsIgnoreCase("")||rs2.getString("p1").equalsIgnoreCase("lab")||rs2.getString("p1").equalsIgnoreCase(null))
               B[0]="Free    ";
             else B[0]="Occupied";
           
              if(rs2.getString("p2").equalsIgnoreCase("")||rs2.getString("p2").equalsIgnoreCase("lab")||rs2.getString("p2").equalsIgnoreCase(null))
               B[1]="Free    ";
             else B[1]="Occupied";
           
            if(rs2.getString("p3").equalsIgnoreCase("")||rs2.getString("p3").equalsIgnoreCase("lab")||rs2.getString("p3").equalsIgnoreCase(null))
               B[2]="Free    ";
             else B[2]="Occupied";
            
            if(rs2.getString("p4").equalsIgnoreCase("")||rs2.getString("p4").equalsIgnoreCase("lab")||rs2.getString("p4").equalsIgnoreCase(null))
               B[3]="Free    ";
             else B[3]="Occupied";
            
             if(rs2.getString("p5").equalsIgnoreCase("")||rs2.getString("p5").equalsIgnoreCase("lab")||rs2.getString("p5").equalsIgnoreCase(null))
               B[4]="Free    ";
             else B[4]="Occupied";
           
            if(rs2.getString("p6").equalsIgnoreCase("")||rs2.getString("p6").equalsIgnoreCase("lab")||rs2.getString("p6").equalsIgnoreCase(null))
               B[5]="Free    ";
             else B[5]="Occupied";
           
            if(rs2.getString("p7").equalsIgnoreCase("")||rs2.getString("p7").equalsIgnoreCase("lab")||rs2.getString("p7").equalsIgnoreCase(null))
               B[6]="Free    ";
             else B[6]="Occupied";
           
           if(rs2.getString("p8").equalsIgnoreCase("")||rs2.getString("p8").equalsIgnoreCase("lab")||rs2.getString("p8").equalsIgnoreCase(null))
               B[7]="Free    ";
             else B[7]="Occupied";
           
            if(rs2.getString("p9").equalsIgnoreCase("")||rs2.getString("p9").equalsIgnoreCase("lab")||rs2.getString("p9").equalsIgnoreCase(null))
               B[8]="Free    ";
             else B[8]="Occupied";
           
            if(rs2.getString("p10").equalsIgnoreCase("")||rs2.getString("p10").equalsIgnoreCase("lab")||rs2.getString("p10").equalsIgnoreCase(null))
               B[9]="Free    ";
             else B[9]="Occupied";
           
             if(rs2.getString("p11").equalsIgnoreCase("")||rs2.getString("p11").equalsIgnoreCase("lab")||rs2.getString("p11").equalsIgnoreCase(null))
               B[10]="Free    ";
             else B[10]="Occupied";
           
              if(rs2.getString("p12").equalsIgnoreCase("")||rs2.getString("p12").equalsIgnoreCase("lab")||rs2.getString("p12").equalsIgnoreCase(null))
               B[11]="Free    ";
             else B[11]="Occupied";
           
             if(rs2.getString("p13").equalsIgnoreCase("")||rs2.getString("p13").equalsIgnoreCase("lab")||rs2.getString("p13").equalsIgnoreCase(null))
               B[12]="Free    ";
             else B[12]="Occupied";
           
             if(rs2.getString("p14").equalsIgnoreCase("")||rs2.getString("p14").equalsIgnoreCase("lab")||rs2.getString("p14").equalsIgnoreCase(null))
               B[13]="Free    ";
             else B[13]="Occupied";
           
             if(rs2.getString("p15").equalsIgnoreCase("")||rs2.getString("p15").equalsIgnoreCase("lab")||rs2.getString("p15").equalsIgnoreCase(null))
               B[14]="Free    ";
             else B[14]="Occupied";
           
              if(rs2.getString("p16").equalsIgnoreCase("")||rs2.getString("p16").equalsIgnoreCase("lab")||rs2.getString("p16").equalsIgnoreCase(null))
               B[15]="Free    ";
             else B[15]="Occupied";
           
             if(rs2.getString("p17").equalsIgnoreCase("")||rs2.getString("p17").equalsIgnoreCase("lab")||rs2.getString("p17").equalsIgnoreCase(null))
               B[16]="Free    ";
             else B[16]="Occupied";
             
            if(rs2.getString("p18").equalsIgnoreCase("")||rs2.getString("p18").equalsIgnoreCase("lab")||rs2.getString("p18").equalsIgnoreCase(null))
               B[17]="Free    ";
             else B[17]="Occupied";
          
             for(int i=0;i<14;i++){
              C[i]=""; 
              }      
              
              }
           
            Statement s3 = con.createStatement();
            String sql3 = "select * from table4 where block='"+ block +"'and room="+room;                    
            ResultSet rs3 = s3.executeQuery(sql3);
        
           if(rs3.next()){
        System.out.println("From table4 selction");
              if(rs3.getString("p1").equalsIgnoreCase("")||rs3.getString("p1").equalsIgnoreCase("lab")||rs3.getString("p1").equalsIgnoreCase(null))
               C[0]="Free    ";
             else C[0]="Occupied";
           
              if(rs3.getString("p2").equalsIgnoreCase("")||rs3.getString("p2").equalsIgnoreCase("lab")||rs3.getString("p2").equalsIgnoreCase(null))
               C[1]="Free    ";
             else C[1]="Occupied";
           
            if(rs3.getString("p3").equalsIgnoreCase("")||rs3.getString("p3").equalsIgnoreCase("lab")||rs3.getString("p3").equalsIgnoreCase(null))
               C[2]="Free    ";
             else C[2]="Occupied";
            
            if(rs3.getString("p4").equalsIgnoreCase("")||rs3.getString("p4").equalsIgnoreCase("lab")||rs3.getString("p4").equalsIgnoreCase(null))
               C[3]="Free    ";
             else C[3]="Occupied";
            
             if(rs3.getString("p5").equalsIgnoreCase("")||rs3.getString("p5").equalsIgnoreCase("lab")||rs3.getString("p5").equalsIgnoreCase(null))
               C[4]="Free    ";
             else C[4]="Occupied";
           
            if(rs3.getString("p6").equalsIgnoreCase("")||rs3.getString("p6").equalsIgnoreCase("lab")||rs3.getString("p6").equalsIgnoreCase(null))
               C[5]="Free    ";
             else C[5]="Occupied";
           
            if(rs3.getString("p7").equalsIgnoreCase("")||rs3.getString("p7").equalsIgnoreCase("lab")||rs3.getString("p7").equalsIgnoreCase(null))
               C[6]="Free    ";
             else C[6]="Occupied";
           
           if(rs3.getString("p8").equalsIgnoreCase("")||rs3.getString("p8").equalsIgnoreCase("lab")||rs3.getString("p8").equalsIgnoreCase(null))
               C[7]="Free    ";
             else C[7]="Occupied";
           
            if(rs3.getString("p9").equalsIgnoreCase("")||rs3.getString("p9").equalsIgnoreCase("lab")||rs3.getString("p9").equalsIgnoreCase(null))
               C[8]="Free    ";
             else C[8]="Occupied";
           
            if(rs3.getString("p10").equalsIgnoreCase("")||rs3.getString("p10").equalsIgnoreCase("lab")||rs3.getString("p10").equalsIgnoreCase(null))
               C[9]="Free    ";
             else C[9]="Occupied";
           
             if(rs3.getString("p11").equalsIgnoreCase("")||rs3.getString("p11").equalsIgnoreCase("lab")||rs3.getString("p11").equalsIgnoreCase(null))
               C[10]="Free    ";
             else C[10]="Occupied";
           
              if(rs3.getString("p12").equalsIgnoreCase("")||rs3.getString("p12").equalsIgnoreCase("lab")||rs3.getString("p12").equalsIgnoreCase(null))
               C[11]="Free    ";
             else C[11]="Occupied";
           
               if(rs3.getString("p13").equalsIgnoreCase("")||rs3.getString("p13").equalsIgnoreCase("lab")||rs3.getString("p13").equalsIgnoreCase(null))
               C[12]="Free    ";
             else C[12]="Occupied";
           
             if(rs3.getString("p14").equalsIgnoreCase("")||rs3.getString("p14").equalsIgnoreCase("lab")||rs3.getString("p14").equalsIgnoreCase(null))
               C[13]="Free    ";
             else C[13]="Occupied";
             
             for(int i=0;i<18;i++){
               B[i]=""; 
           }
             
             }
//TODO  *///format output block and room
                textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t Block " + block + " Room " + room + " \n\n\n");
                textarea.appendText("   Time         Monday   Tuesday   Wednesday   Thursday    Friday   Saturday   Sunday\n\n");
                textarea.appendText(" 02:30-03:20    " + A[0] + "   " + A[7] + " " + A[14] + "   " + A[21] + " " + A[28]  +"\t"+C[0]+" \t "+B[14]+C[7]+"\n");
                textarea.appendText(" 03:30-04:20    " + A[1] + "   " + A[8] + " " + A[15] + "   " + A[22] + " " + A[29]  +"\t"+C[1]+" \t "+B[15]+C[8]+"\n");
                textarea.appendText(" 04:30-05:20    " + A[2] + "   " + A[9] + " " + A[16] + "   " + A[23] + " " + A[30]  +"\t"+C[2]+" \t "+B[16]+C[9]+"\n");
                textarea.appendText(" 05:30-06:20    " + A[3] + "   " + A[10]+ " " + A[17] + "   " + A[24] + " " + A[31]  +"\t"+C[3]+" \t "+B[17]+C[10]+"\n");
                textarea.appendText(" 07:30-08:20    " + A[4] + "   " + A[11]+ " " + A[18] + "   " + A[25] + " " + A[32]  +"\t"+B[10]+C[4]+" \t "+C[11]+"\n");
                textarea.appendText(" 08:30-09:20    " + A[5] + "   " + A[12]+ " " + A[19] + "   " + A[26] + " " + A[33]  +"\t"+B[11]+C[5]+" \t "+C[12]+"\n");
                textarea.appendText(" 09:30-10:20    " + A[6] + "   " + A[13]+ " " + A[20] + "   " + A[27] + " " + A[34]  +"\t"+B[12]+C[6]+" \t "+C[13]+"\n");
                textarea.appendText(" 10:30-11:20                                                                             "+B[13]+ " \t \n");
                textarea.appendText(" 12:00-12:50    " + B[0] + "   " + B[2] + " " + B[4]  + "   " + B[6] +  " " + B[8]    +"\t"+B[13]+" \t \n");
                textarea.appendText(" 13:00-13:50    " + B[1] + "   " + B[3] + " " + B[5]  + "   " + B[7] +  " " + B[9]   +"\t"+" \t "+"\n\n");      
                textarea.appendText("\n\n\n================================================================================");
                
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
              
           }catch(SQLException err){
        Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("First try catch block"+err);
                alert.show();
               return;
          }
        }
  else if(a=="Time & Block"){
      
      

      int d1=1,time1=0,count1=1,block1;

              database c=new database();
               con=c.connnect();
      
            block1=(Integer) combo1.getValue();
           
            String time=(String) combo2.getValue();
            String days1=(String) combo3.getValue();
           
            String[] t={"02:30-03:20","03:30-4:20","04:30-05:20","05:30-06:20",
                    "07:30-08:20","08:30-09:20","09:30-10:20","12:00-12:50","13:00-13:50"};

            String[] period={"p1","p2","p3","p4","p5","p6","p7",
                    "p8","p9","p10","p11","p12","p13","p14",
                    "p15","p16","p17","p18","p19","p20","p21",
                    "p22","p23","p24","p25","p26","p27","p28",
                    "p29","p30","p31","p32","p33","p34","p35"};
           
            String[] days={"Monday","Tusday","Wedensday","Thursday","Friday","Saturday","Sunday"};          
                    
            for(int i=0;i<days.length;i++){
                if(days1==days[i]){
                    d1+=i*7;
                    count1=i; 
                }
            }
            
          for(int i=0;i<t.length;i++){
              if(time==t[i]) {
                  time1 = i;
                    d1+=i;
                            }
          }
          
            String V[]=new String[50];
         
          for(int i=0;i<50;i++){
               V[i]="";}
          int i=0;
              
          if((time1<7) && (count1<5)){
              StringBuilder sql1=new StringBuilder(); 
              sql1.append("select room from table2 where block='");
              sql1.append(block1);
              sql1.append("' and p");
              sql1.append(d1);
              sql1.append("='");
              sql1.append("'");
              String sql=sql1.toString();
         try{
                 int controler=0; 
              Statement s = con.createStatement();
              ResultSet rs = s.executeQuery(sql);
          System.out.print(sql);
              while(rs.next()){
                  controler++;
                int room=rs.getInt("room");
                System.out.println(room);
                V[i]=""+room;
                i++;
                }
          if(controler!=0){ 
              //block-time-day
                textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t Block " + combo1.getValue() + "\t At "+combo2.getValue()+" \t On "+combo3.getValue() +" \n\n\n");
                textarea.appendText("Unocuppide Rooms are \n\n");
                textarea.appendText("\t"+V[0]+"\t"+V[1]+"\t"+V[2]+"\t"+V[3]+"\t"+V[4]+"\t"+V[5]+"\t"+V[6]+"\t"+V[7]+"\t"+V[8]+"\t"+V[9]+"\n\n");
                textarea.appendText("\t"+V[10]+"\t"+V[11]+"\t"+V[12]+"\t"+V[13]+"\t"+V[14]+"\t"+V[15]+"\t"+V[16]+"\t"+V[17]+"\t"+V[18]+"\t"+V[19]+"\n\n");
                textarea.appendText("\t"+V[20]+"\t"+V[21]+"\t"+V[22]+"\t"+V[23]+"\t"+V[24]+"\t"+V[25]+"\t"+V[26]+"\t"+V[27]+"\t"+V[28]+"\t"+V[29]+"\n");
                textarea.appendText("\t"+V[30]+"\t"+V[31]+"\t"+V[32]+"\t"+V[33]+"\t"+V[34]+"\t"+V[35]+"\t"+V[36]+"\t"+V[37]+"\t"+V[38]+"\t"+V[39]+"\n");
                textarea.appendText("\t"+V[40]+"\t"+V[41]+"\t"+V[42]+"\t"+V[43]+"\t"+V[44]+"\t"+V[45]+"\t"+V[46]+"\t"+V[47]+"\t"+V[48]+"\t"+V[49]+"\n");
                textarea.appendText("\n\n\n================================================================================");
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
             }else{
          textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t Block " + combo1.getValue() + "\t On"+combo2.getValue()+" \t At "+combo3.getValue() +" \n\n\n");
                textarea.appendText("\n\n\t\t NO required data is inserted \n\n\n\n\n\n\n\n\n\n\n\n\n\n");
               
                textarea.appendText("\n\n\n================================================================================");
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
         }
          
        
            }catch(SQLException err){
              Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("block and time search "+err);
                alert.show();
               return;
              }
            }
         else if((time1>6) && (count1<5)){
             int co=count1*2;
             if(time1==7){co+=1;}
              if(time1==8){co+=2;}
               StringBuilder sql1=new StringBuilder(); 
              sql1.append("select room from table3 where block='");
              sql1.append(block1);
              sql1.append("' and p");
              sql1.append(co);
              sql1.append("='");
              sql1.append("'");
              String sql=sql1.toString();
          try{
                  int controler=0;
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
          System.out.println(sql);
                while(rs.next()){
                    controler++;
               System.out.println(sql+"from the while loop");
                int room=rs.getInt("room");
                V[i]=""+room;
                i++;
             }
             if(controler!=0){ 
                 //block-time-day
                textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t Block " + combo1.getValue() + "\t At"+combo2.getValue()+" \t On "+combo3.getValue() +" \n\n\n");
                textarea.appendText("Unocuppide Rooms are \n\n");
                textarea.appendText("\t"+V[0]+"\t"+V[1]+"\t"+V[2]+"\t"+V[3]+"\t"+V[4]+"\t"+V[5]+"\t"+V[6]+"\t"+V[7]+"\t"+V[8]+"\t"+V[9]+"\n\n");
                textarea.appendText("\t"+V[10]+"\t"+V[11]+"\t"+V[12]+"\t"+V[13]+"\t"+V[14]+"\t"+V[15]+"\t"+V[16]+"\t"+V[17]+"\t"+V[18]+"\t"+V[19]+"\n\n");
                textarea.appendText("\t"+V[20]+"\t"+V[21]+"\t"+V[22]+"\t"+V[23]+"\t"+V[24]+"\t"+V[25]+"\t"+V[26]+"\t"+V[27]+"\t"+V[28]+"\t"+V[29]+"\n");
                textarea.appendText("\t"+V[30]+"\t"+V[31]+"\t"+V[32]+"\t"+V[33]+"\t"+V[34]+"\t"+V[35]+"\t"+V[36]+"\t"+V[37]+"\t"+V[38]+"\t"+V[39]+"\n");
                textarea.appendText("\t"+V[40]+"\t"+V[41]+"\t"+V[42]+"\t"+V[43]+"\t"+V[44]+"\t"+V[45]+"\t"+V[46]+"\t"+V[47]+"\t"+V[48]+"\t"+V[49]+"\n");
                textarea.appendText("\n\n\n================================================================================");
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
             }else{
                textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t Block " + combo1.getValue() + "\t At "+combo2.getValue()+" \t On "+combo3.getValue() +" \n\n\n");
                textarea.appendText("\n\n\t\t ALL ROOM ARE OCUPIDE \n OR NO INSERTED DATA. \n\n\n\n\n\n\n\n\n\n\n\n\n\n");
               
                textarea.appendText("\n\n\n================================================================================");
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
         }
        
            }catch(SQLException err){
              Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("block and time search 2"+err);
                alert.show();
               return;
              }
               }
      else if((count1>4)&&(time1<7)){
         String sql;
          StringBuilder sql1=new StringBuilder(); 
             
             int co=0,co1=0;
             if((time1<4) && (count1==6) ){ 
              co=count1-4; 
              co1=co+14;
              
              sql1.append("select table3.room,table4.room As room from table3 join table4 on table3.block=table4.block where table3.block='");
              sql1.append(block1);
              sql1.append("' and table3.p");
              sql1.append(co1);
              sql1.append("='");
              sql1.append("' or table4.p");
              sql1.append(co);
              sql1.append("='");
              sql1.append("'");
                sql=sql1.toString();
        try{
                  int COUNTER=0;
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                System.out.println(sql);
                while(rs.next()){
                    COUNTER++;
                int room=rs.getInt("room");
                V[i]=""+room;
                i++;
             }
             if(COUNTER!=0){
                //block-day-time
                textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t Block " + combo1.getValue() + "\t At "+combo2.getValue()+" \t On "+combo3.getValue() +" \n\n\n");
                textarea.appendText("Unocuppide Rooms are \n\n");
                textarea.appendText("\t"+V[0]+"\t"+V[1]+"\t"+V[2]+"\t"+V[3]+"\t"+V[4]+"\t"+V[5]+"\t"+V[6]+"\t"+V[7]+"\t"+V[8]+"\t"+V[9]+"\n\n");
                textarea.appendText("\t"+V[10]+"\t"+V[11]+"\t"+V[12]+"\t"+V[13]+"\t"+V[14]+"\t"+V[15]+"\t"+V[16]+"\t"+V[17]+"\t"+V[18]+"\t"+V[19]+"\n\n");
                textarea.appendText("\t"+V[20]+"\t"+V[21]+"\t"+V[22]+"\t"+V[23]+"\t"+V[24]+"\t"+V[25]+"\t"+V[26]+"\t"+V[27]+"\t"+V[28]+"\t"+V[29]+"\n");
                textarea.appendText("\t"+V[30]+"\t"+V[31]+"\t"+V[32]+"\t"+V[33]+"\t"+V[34]+"\t"+V[35]+"\t"+V[36]+"\t"+V[37]+"\t"+V[38]+"\t"+V[39]+"\n");
                textarea.appendText("\t"+V[40]+"\t"+V[41]+"\t"+V[42]+"\t"+V[43]+"\t"+V[44]+"\t"+V[45]+"\t"+V[46]+"\t"+V[47]+"\t"+V[48]+"\t"+V[49]+"\n");
                textarea.appendText("\n\n\n================================================================================");
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
             }else{
          textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t Block " + combo1.getValue() + "\t At "+combo2.getValue()+" \t On "+combo3.getValue() +" \n\n\n");
                textarea.appendText("\n\n\t\t ALL ROOM ARE OCCUPIED  OR NO DATA IS INSERTED \n\n\n\n\n\n\n\n\n\n\n\n\n\n");
               
                textarea.appendText("\n\n\n================================================================================");
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
         }
           
            }catch(SQLException err){
              Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("block and time search 3"+err);
                alert.show();
               return;
              }
             }
             
         if((time1>3) && (count1==6)){
             co=1+time1;
              sql1.append("select room  from table4 where block='");
              sql1.append(block1);
              sql1.append("' and table4.p");
              sql1.append(co);
              sql1.append("='");
              sql1.append("'");
           sql=sql1.toString();
        try{
                  int CONTROLER=0;
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                System.out.println(sql);
                while(rs.next()){
                    CONTROLER++;
                int room=rs.getInt("room");
                V[i]=""+room;
                i++;
             }
             if(CONTROLER!=0){ 
                 // day-time-block
                textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t Block " + combo1.getValue() + "\t At "+combo2.getValue()+" \t On "+combo3.getValue() +" \n\n\n");
                textarea.appendText("Unocuppide Rooms are \n\n");
                textarea.appendText("\t"+V[0]+"\t"+V[1]+"\t"+V[2]+"\t"+V[3]+"\t"+V[4]+"\t"+V[5]+"\t"+V[6]+"\t"+V[7]+"\t"+V[8]+"\t"+V[9]+"\n\n");
                textarea.appendText("\t"+V[10]+"\t"+V[11]+"\t"+V[12]+"\t"+V[13]+"\t"+V[14]+"\t"+V[15]+"\t"+V[16]+"\t"+V[17]+"\t"+V[18]+"\t"+V[19]+"\n\n");
                textarea.appendText("\t"+V[20]+"\t"+V[21]+"\t"+V[22]+"\t"+V[23]+"\t"+V[24]+"\t"+V[25]+"\t"+V[26]+"\t"+V[27]+"\t"+V[28]+"\t"+V[29]+"\n");
                textarea.appendText("\t"+V[30]+"\t"+V[31]+"\t"+V[32]+"\t"+V[33]+"\t"+V[34]+"\t"+V[35]+"\t"+V[36]+"\t"+V[37]+"\t"+V[38]+"\t"+V[39]+"\n");
                textarea.appendText("\t"+V[40]+"\t"+V[41]+"\t"+V[42]+"\t"+V[43]+"\t"+V[44]+"\t"+V[45]+"\t"+V[46]+"\t"+V[47]+"\t"+V[48]+"\t"+V[49]+"\n");
                textarea.appendText("\n\n\n================================================================================");
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
             }else{
          textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t Block " + combo1.getValue() + "\t At "+combo2.getValue()+" \t On "+combo3.getValue() +" \n\n\n");
                textarea.appendText("\n\n\t\t ALL ROOM ARE OCCUPIED OR DATA IS NOT INSERTED \n\n\n\n\n\n\n\n\n\n\n\n\n\n");
               
                textarea.appendText("\n\n\n================================================================================");
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
         }
           
            }catch(SQLException err){
              Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("block and time search 3"+err);
                alert.show();
               return;
              }
         }     
       if((time1>3) && (count1==5)){
           co1=10+time1-3;
           co=4+time1-3;
             sql1.append("select table3.room,table4.room As room from table3 join table4 on table3.block=table4.block where table3.block='");
              sql1.append(block1);
              sql1.append("' and table3.p");
              sql1.append(co1);
              sql1.append("='");
              sql1.append("' or table4.p");
              sql1.append(co);
              sql1.append("='");
              sql1.append("'");
              sql=sql1.toString();
        try{
                  int controler=0;
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);
                System.out.println(sql);
                while(rs.next()){
                    controler++;
                int room=rs.getInt("room");
                V[i]=""+room;
                i++;
             }
             if(controler!=0){   textarea.setText(""); 
             // day and time block
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t Block " + combo1.getValue() + "\t at"+combo2.getValue()+" \t On "+combo3.getValue() +" \n\n\n");
                textarea.appendText("Unocuppide Rooms are \n\n");
                textarea.appendText("\t"+V[0]+"\t"+V[1]+"\t"+V[2]+"\t"+V[3]+"\t"+V[4]+"\t"+V[5]+"\t"+V[6]+"\t"+V[7]+"\t"+V[8]+"\t"+V[9]+"\n\n");
                textarea.appendText("\t"+V[10]+"\t"+V[11]+"\t"+V[12]+"\t"+V[13]+"\t"+V[14]+"\t"+V[15]+"\t"+V[16]+"\t"+V[17]+"\t"+V[18]+"\t"+V[19]+"\n\n");
                textarea.appendText("\t"+V[20]+"\t"+V[21]+"\t"+V[22]+"\t"+V[23]+"\t"+V[24]+"\t"+V[25]+"\t"+V[26]+"\t"+V[27]+"\t"+V[28]+"\t"+V[29]+"\n");
                textarea.appendText("\t"+V[30]+"\t"+V[31]+"\t"+V[32]+"\t"+V[33]+"\t"+V[34]+"\t"+V[35]+"\t"+V[36]+"\t"+V[37]+"\t"+V[38]+"\t"+V[39]+"\n");
                textarea.appendText("\t"+V[40]+"\t"+V[41]+"\t"+V[42]+"\t"+V[43]+"\t"+V[44]+"\t"+V[45]+"\t"+V[46]+"\t"+V[47]+"\t"+V[48]+"\t"+V[49]+"\n");
                textarea.appendText("\n\n\n================================================================================");
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
             }else{
          textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t Block " + combo1.getValue() + "\t At "+combo2.getValue()+" \t On "+combo3.getValue() +" \n\n\n");
                textarea.appendText("\n\n\t\t ALL ROOM ARE OCCUIPED OR NO DATA IS INSRTED \n\n\n\n\n\n\n\n\n\n\n\n\n\n");
               
                textarea.appendText("\n\n\n================================================================================");
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
         }
           
            }catch(SQLException err){
              Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("block and time search 3"+err);
                alert.show();
               return;
              }  
               }
          }
         
      }
  else if(a=="department & section"){
     try{
      System.out.println("We made it");
       database c=new database();
           con=c.connnect();
      
        String[] A=new String[35];
        String[] B=new String[18];
        String[] C=new String[14];
      
        for(int i=0;i<35;i++){
        A[i]="Free    ";
        }
        for(int i=0;i<18;i++){
        B[i]="Free    ";
        }
        for(int i=0;i<14;i++){
        C[i]="Free    ";
        
        }
        
      String sql="";
      String z1=(String) combo1.getValue();
      String z2=(String) combo2.getValue();
      String z3=(String) combo3.getValue();
      String z4=(String) combo4.getValue();
      String z5=(String) combo5.getValue();
      
   if(z2.equalsIgnoreCase("Regular"))
      {    
      
          sql = "select * from table2 inner join table1 on table1.block=table2.block and table1.room=table2.room \n" +
"and table1.course_type= table2.course_type where table1.department ='"+z1+"'and table1.section='"+z3+"'  and table1.student_type='"+z5+"' and table1.level="+z4;                    
           System.out.println(sql);
      
          Statement ss = con.createStatement();               
            ResultSet rss = ss.executeQuery(sql);
          
      
           if(rss.next()){
             if(rss.getString("p1").equalsIgnoreCase("")||rss.getString("p1").equalsIgnoreCase("lab")||rss.getString("p1").equalsIgnoreCase(null))
               A[0]="Free    ";
             else A[0]="Occupied";
           
              if(rss.getString("p2").equalsIgnoreCase("")||rss.getString("p2").equalsIgnoreCase("lab")||rss.getString("p2").equalsIgnoreCase(null))
               A[1]="Free    ";
             else A[1]="Occupied";
           
            if(rss.getString("p3").equalsIgnoreCase("")||rss.getString("p3").equalsIgnoreCase("lab")||rss.getString("p3").equalsIgnoreCase(null))
               A[2]="Free    ";
             else A[2]="Occupied";
            
            if(rss.getString("p4").equalsIgnoreCase("")||rss.getString("p4").equalsIgnoreCase("lab")||rss.getString("p4").equalsIgnoreCase(null))
               A[3]="Free    ";
             else A[3]="Occupied";
            
             if(rss.getString("p5").equalsIgnoreCase("")||rss.getString("p5").equalsIgnoreCase("lab")||rss.getString("p5").equalsIgnoreCase(null))
               A[4]="Free    ";
             else A[4]="Occupied";
           
            if(rss.getString("p6").equalsIgnoreCase("")||rss.getString("p6").equalsIgnoreCase("lab")||rss.getString("p6").equalsIgnoreCase(null))
               A[5]="Free    ";
             else A[5]="Occupied";
           
            if(rss.getString("p7").equalsIgnoreCase("")||rss.getString("p7").equalsIgnoreCase("lab")||rss.getString("p7").equalsIgnoreCase(null))
               A[6]="Free    ";
             else A[6]="Occupied";
           
           if(rss.getString("p8").equalsIgnoreCase("")||rss.getString("p8").equalsIgnoreCase("lab")||rss.getString("p8").equalsIgnoreCase(null))
               A[7]="Free    ";
             else A[7]="Occupied";
           
            if(rss.getString("p9").equalsIgnoreCase("")||rss.getString("p9").equalsIgnoreCase("lab")||rss.getString("p9").equalsIgnoreCase(null))
               A[8]="Free    ";
             else A[8]="Occupied";
           
            if(rss.getString("p10").equalsIgnoreCase("")||rss.getString("p10").equalsIgnoreCase("lab")||rss.getString("p10").equalsIgnoreCase(null))
               A[9]="Free    ";
             else A[9]="Occupied";
           
             if(rss.getString("p11").equalsIgnoreCase("")||rss.getString("p11").equalsIgnoreCase("lab")||rss.getString("p11").equalsIgnoreCase(null))
               A[10]="Free    ";
             else A[10]="Occupied";
           
              if(rss.getString("p12").equalsIgnoreCase("")||rss.getString("p12").equalsIgnoreCase("lab")||rss.getString("p12").equalsIgnoreCase(null))
               A[11]="Free    ";
             else A[11]="Occupied";
           
               if(rss.getString("p13").equalsIgnoreCase("")||rss.getString("p13").equalsIgnoreCase("lab")||rss.getString("p13").equalsIgnoreCase(null))
               A[12]="Free    ";
             else A[12]="Occupied";
           
             if(rss.getString("p14").equalsIgnoreCase("")||rss.getString("p14").equalsIgnoreCase("lab")||rss.getString("p14").equalsIgnoreCase(null))
               A[13]="Free    ";
             else A[13]="Occupied";
           
             if(rss.getString("p15").equalsIgnoreCase("")||rss.getString("p15").equalsIgnoreCase("lab")||rss.getString("p15").equalsIgnoreCase(null))
               A[14]="Free    ";
             else A[14]="Occupied";
           
              if(rss.getString("p16").equalsIgnoreCase("")||rss.getString("p16").equalsIgnoreCase("lab")||rss.getString("p16").equalsIgnoreCase(null))
               A[15]="Free    ";
             else A[15]="Occupied";
           
             if(rss.getString("p17").equalsIgnoreCase("")||rss.getString("p17").equalsIgnoreCase("lab")||rss.getString("p17").equalsIgnoreCase(null))
               A[16]="Free    ";
             else A[16]="Occupied";
             
            if(rss.getString("p18").equalsIgnoreCase("")||rss.getString("p18").equalsIgnoreCase("lab")||rss.getString("p18").equalsIgnoreCase(null))
               A[17]="Free    ";
             else A[17]="Occupied";
             
            if(rss.getString("p19").equalsIgnoreCase("")||rss.getString("p19").equalsIgnoreCase("lab")||rss.getString("p19").equalsIgnoreCase(null))
               A[18]="Free    ";
             else A[18]="Occupied";
            
           if(rss.getString("p20").equalsIgnoreCase("")||rss.getString("p20").equalsIgnoreCase("lab")||rss.getString("p20").equalsIgnoreCase(null))
               A[19]="Free    ";
             else A[19]="Occupied";
              
           if(rss.getString("p21").equalsIgnoreCase("")||rss.getString("p21").equalsIgnoreCase("lab")||rss.getString("p21").equalsIgnoreCase(null))
               A[20]="Free    ";
             else A[20]="Occupied";
           
          if(rss.getString("p22").equalsIgnoreCase("")||rss.getString("p22").equalsIgnoreCase("lab")||rss.getString("p22").equalsIgnoreCase(null))
               A[21]="Free    ";
             else A[21]="Occupied";
             
          if(rss.getString("p23").equalsIgnoreCase("")||rss.getString("p23").equalsIgnoreCase("lab")||rss.getString("p23").equalsIgnoreCase(null))
               A[22]="Free    ";
             else A[22]="Occupied";
          
           if(rss.getString("p24").equalsIgnoreCase("")||rss.getString("p24").equalsIgnoreCase("lab")||rss.getString("p24").equalsIgnoreCase(null))
               A[23]="Free    ";
             else A[23]="Occupied";
           
           if(rss.getString("p25").equalsIgnoreCase("")||rss.getString("p25").equalsIgnoreCase("lab")||rss.getString("p25").equalsIgnoreCase(null))
               A[24]="Free    ";
             else A[24]="Occupied";
             
           if(rss.getString("p26").equalsIgnoreCase("")||rss.getString("p26").equalsIgnoreCase("lab")||rss.getString("p26").equalsIgnoreCase(null))
               A[25]="Free    ";
             else A[25]="Occupied";
           
            if(rss.getString("p27").equalsIgnoreCase("")||rss.getString("p27").equalsIgnoreCase("lab")||rss.getString("p27").equalsIgnoreCase(null))
               A[26]="Free    ";
             else A[26]="Occupied";
           
            if(rss.getString("p28").equalsIgnoreCase("")||rss.getString("p28").equalsIgnoreCase("lab")||rss.getString("p28").equalsIgnoreCase(null))
               A[27]="Free    ";
             else A[27]="Occupied";
            
            if(rss.getString("p29").equalsIgnoreCase("")||rss.getString("p29").equalsIgnoreCase("lab")||rss.getString("p29").equalsIgnoreCase(null))
               A[28]="Free    ";
             else A[28]="Occupied";
           
             if(rss.getString("p30").equalsIgnoreCase("")||rss.getString("p30").equalsIgnoreCase("lab")||rss.getString("p30").equalsIgnoreCase(null))
               A[29]="Free    ";
             else A[29]="Occupied";
           
             if(rss.getString("p31").equalsIgnoreCase("")||rss.getString("p31").equalsIgnoreCase("lab")||rss.getString("p31").equalsIgnoreCase(null))
               A[30]="Free    ";
             else A[30]="Occupied";
             
             if(rss.getString("p32").equalsIgnoreCase("")||rss.getString("p32").equalsIgnoreCase("lab")||rss.getString("p32").equalsIgnoreCase(null))
               A[31]="Free    ";
             else A[31]="Occupied";
            
            if(rss.getString("p33").equalsIgnoreCase("")||rss.getString("p33").equalsIgnoreCase("lab")||rss.getString("p33").equalsIgnoreCase(null))
               A[32]="Free    ";
             else A[32]="Occupied";
           
             if(rss.getString("p34").equalsIgnoreCase("")||rss.getString("p34").equalsIgnoreCase("lab")||rss.getString("p34").equalsIgnoreCase(null))
               A[33]="Free    ";
             else A[33]="Occupied";
           
            if(rss.getString("p35").equalsIgnoreCase("")||rss.getString("p35").equalsIgnoreCase("lab")||rss.getString("p35").equalsIgnoreCase(null))
               A[34]="Free    ";
             else A[34]="Occupied";
              System.out.println("We made it regular 3");
      
           }
            
           
 
                textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t " + z1 + "  " +z4+ " "+z3+" "+z2+" "+z5 +" \n\n\n");
                textarea.appendText("\t   Time      \t Monday \tTuesday \tWednesday \t Thursday \t Friday \n\n");
                textarea.appendText("\t 02:30-03:20 \t " + A[0] + "\t" + A[7] + "\t" + A[14] + "\t" + A[21] + "\t" + A[28]  +"\n");
                textarea.appendText("\t 03:30-04:20 \t " + A[1] + "\t" + A[8] + "\t" + A[15] + "\t" + A[22] + "\t" + A[29]  +"\n");
                textarea.appendText("\t 04:30-05:20 \t " + A[2] + "\t" + A[9] + "\t" + A[16] + "\t" + A[23] + "\t" + A[30]  +"\n");
                textarea.appendText("\t 05:30-06:20 \t " + A[3] + "\t" + A[10]+ "\t" + A[17] + "\t" + A[24] + "\t" + A[31]  +"\n");
                textarea.appendText("\t 07:30-08:20 \t " + A[4] + "\t" + A[11]+ "\t" + A[18] + "\t" + A[25] + "\t" + A[32]  +"\n");
                textarea.appendText("\t 08:30-09:20 \t " + A[5] + "\t" + A[12]+ "\t" + A[19] + "\t" + A[26] + "\t" + A[33]  +"\n");
                textarea.appendText("\t 09:30-10:20 \t " + A[6] + "\t" + A[13]+ "\t" + A[20] + "\t" + A[27] + "\t" + A[34]  +"\n");
                
                textarea.appendText("\n\n\n================================================================================");
                
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
            
            
      }
      else if(z2.equalsIgnoreCase("Weekend"))
      {    System.out.println("We made it weekend");
      
            sql = "select * from table4 inner join table1 on table1.block=table4.block and table1.room=table4.room \n" +
"and table1.course_type= table4.course_type where table1.department ='"+z1+"'and table1.section='"+z3+"'  and table1.student_type='"+z5+"' and table1.level="+z4;                    
           Statement s = con.createStatement();               
            ResultSet rs = s.executeQuery(sql);
        
           if(rs.next()){
             if(rs.getString("p1").equalsIgnoreCase("")||rs.getString("p1").equalsIgnoreCase("lab")||rs.getString("p1").equalsIgnoreCase(null))
               A[0]="Free    ";
             else A[0]="Occupied";
           
              if(rs.getString("p2").equalsIgnoreCase("")||rs.getString("p2").equalsIgnoreCase("lab")||rs.getString("p2").equalsIgnoreCase(null))
               A[1]="Free    ";
             else A[1]="Occupied";
           
            if(rs.getString("p3").equalsIgnoreCase("")||rs.getString("p3").equalsIgnoreCase("lab")||rs.getString("p3").equalsIgnoreCase(null))
               A[2]="Free    ";
             else A[2]="Occupied";
            
            if(rs.getString("p4").equalsIgnoreCase("")||rs.getString("p4").equalsIgnoreCase("lab")||rs.getString("p4").equalsIgnoreCase(null))
               A[3]="Free    ";
             else A[3]="Occupied";
            
             if(rs.getString("p5").equalsIgnoreCase("")||rs.getString("p5").equalsIgnoreCase("lab")||rs.getString("p5").equalsIgnoreCase(null))
               A[4]="Free    ";
             else A[4]="Occupied";
           
            if(rs.getString("p6").equalsIgnoreCase("")||rs.getString("p6").equalsIgnoreCase("lab")||rs.getString("p6").equalsIgnoreCase(null))
               A[5]="Free    ";
             else A[5]="Occupied";
           
            if(rs.getString("p7").equalsIgnoreCase("")||rs.getString("p7").equalsIgnoreCase("lab")||rs.getString("p7").equalsIgnoreCase(null))
               A[6]="Free    ";
             else A[6]="Occupied";
           
           if(rs.getString("p8").equalsIgnoreCase("")||rs.getString("p8").equalsIgnoreCase("lab")||rs.getString("p8").equalsIgnoreCase(null))
               A[7]="Free    ";
             else A[7]="Occupied";
           
            if(rs.getString("p9").equalsIgnoreCase("")||rs.getString("p9").equalsIgnoreCase("lab")||rs.getString("p9").equalsIgnoreCase(null))
               A[8]="Free    ";
             else A[8]="Occupied";
           
            if(rs.getString("p10").equalsIgnoreCase("")||rs.getString("p10").equalsIgnoreCase("lab")||rs.getString("p10").equalsIgnoreCase(null))
               A[9]="Free    ";
             else A[9]="Occupied";
           
             if(rs.getString("p11").equalsIgnoreCase("")||rs.getString("p11").equalsIgnoreCase("lab")||rs.getString("p11").equalsIgnoreCase(null))
               A[10]="Free    ";
             else A[10]="Occupied";
           
              if(rs.getString("p12").equalsIgnoreCase("")||rs.getString("p12").equalsIgnoreCase("lab")||rs.getString("p12").equalsIgnoreCase(null))
               A[11]="Free    ";
             else A[11]="Occupied";
           
               if(rs.getString("p13").equalsIgnoreCase("")||rs.getString("p13").equalsIgnoreCase("lab")||rs.getString("p13").equalsIgnoreCase(null))
               A[12]="Free    ";
             else A[12]="Occupied";
           
             if(rs.getString("p14").equalsIgnoreCase("")||rs.getString("p14").equalsIgnoreCase("lab")||rs.getString("p14").equalsIgnoreCase(null))
               A[13]="Free    ";
             else A[13]="Occupied";
           
           }
            
      
 
                textarea.setText("");  
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t " + z1 + " \t " +z4+ "\t "+z3+"\t "+z2+" \t"+z5 +" \n\n\n");
                textarea.appendText("\t   Time      \t Saterday \t Sunday  \n\n");
                textarea.appendText("\t 02:30-03:20 \t " + A[0] + "\t" + A[7] +"\n");
                textarea.appendText("\t 03:30-04:20 \t " + A[1] + "\t" + A[8] +"\n");
                textarea.appendText("\t 04:30-05:20 \t " + A[2] + "\t" + A[9] +"\n");
                textarea.appendText("\t 05:30-06:20 \t " + A[3] + "\t" + A[10]+"\n");
                textarea.appendText("\t 07:30-08:20 \t " + A[4] + "\t" + A[11]+"\n");
                textarea.appendText("\t 08:30-09:20 \t " + A[5] + "\t" + A[12]+"\n");
                textarea.appendText("\t 09:30-10:20 \t " + A[6] + "\t" + A[13]+"\n");
                
                textarea.appendText("\n\n\n================================================================================");
                
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
            
             
      }else if(z2.equalsIgnoreCase("night"))
      {                 System.out.println("From Night");   
                sql = "select * from table3 inner join table1 on table1.block=table3.block and table1.room=table3.room \n" +
"and table1.course_type= table3.course_type where table1.department ='"+z1+"'and table1.section='"+z3+"'  and table1.student_type='"+z5+"' and table1.level="+z4;                    
                           
           Statement s = con.createStatement();               
            ResultSet rs = s.executeQuery(sql);
        
           if(rs.next()){
             if(rs.getString("p1").equalsIgnoreCase("")||rs.getString("p1").equalsIgnoreCase("lab")||rs.getString("p1").equalsIgnoreCase(null))
               A[0]="Free    ";
             else A[0]="Occupied";
           
              if(rs.getString("p2").equalsIgnoreCase("")||rs.getString("p2").equalsIgnoreCase("lab")||rs.getString("p2").equalsIgnoreCase(null))
               A[1]="Free    ";
             else A[1]="Occupied";
           
            if(rs.getString("p3").equalsIgnoreCase("")||rs.getString("p3").equalsIgnoreCase("lab")||rs.getString("p3").equalsIgnoreCase(null))
               A[2]="Free    ";
             else A[2]="Occupied";
            
            if(rs.getString("p4").equalsIgnoreCase("")||rs.getString("p4").equalsIgnoreCase("lab")||rs.getString("p4").equalsIgnoreCase(null))
               A[3]="Free    ";
             else A[3]="Occupied";
            
             if(rs.getString("p5").equalsIgnoreCase("")||rs.getString("p5").equalsIgnoreCase("lab")||rs.getString("p5").equalsIgnoreCase(null))
               A[4]="Free    ";
             else A[4]="Occupied";
           
            if(rs.getString("p6").equalsIgnoreCase("")||rs.getString("p6").equalsIgnoreCase("lab")||rs.getString("p6").equalsIgnoreCase(null))
               A[5]="Free    ";
             else A[5]="Occupied";
           
            if(rs.getString("p7").equalsIgnoreCase("")||rs.getString("p7").equalsIgnoreCase("lab")||rs.getString("p7").equalsIgnoreCase(null))
               A[6]="Free    ";
             else A[6]="Occupied";
           
           if(rs.getString("p8").equalsIgnoreCase("")||rs.getString("p8").equalsIgnoreCase("lab")||rs.getString("p8").equalsIgnoreCase(null))
               A[7]="Free    ";
             else A[7]="Occupied";
           
            if(rs.getString("p9").equalsIgnoreCase("")||rs.getString("p9").equalsIgnoreCase("lab")||rs.getString("p9").equalsIgnoreCase(null))
               A[8]="Free    ";
             else A[8]="Occupied";
           
            if(rs.getString("p10").equalsIgnoreCase("")||rs.getString("p10").equalsIgnoreCase("lab")||rs.getString("p10").equalsIgnoreCase(null))
               A[9]="Free    ";
             else A[9]="Occupied";
           
             if(rs.getString("p11").equalsIgnoreCase("")||rs.getString("p11").equalsIgnoreCase("lab")||rs.getString("p11").equalsIgnoreCase(null))
               A[10]="Free    ";
             else A[10]="Occupied";
           
              if(rs.getString("p12").equalsIgnoreCase("")||rs.getString("p12").equalsIgnoreCase("lab")||rs.getString("p12").equalsIgnoreCase(null))
               A[11]="Free    ";
             else A[11]="Occupied";
           
               if(rs.getString("p13").equalsIgnoreCase("")||rs.getString("p13").equalsIgnoreCase("lab")||rs.getString("p13").equalsIgnoreCase(null))
               A[12]="Free    ";
             else A[12]="Occupied";
           
             if(rs.getString("p14").equalsIgnoreCase("")||rs.getString("p14").equalsIgnoreCase("lab")||rs.getString("p14").equalsIgnoreCase(null))
               A[13]="Free    ";
             else A[13]="Occupied";
           
             if(rs.getString("p15").equalsIgnoreCase("")||rs.getString("p15").equalsIgnoreCase("lab")||rs.getString("p15").equalsIgnoreCase(null))
               A[14]="Free    ";
             else A[14]="Occupied";
           
              if(rs.getString("p16").equalsIgnoreCase("")||rs.getString("p16").equalsIgnoreCase("lab")||rs.getString("p16").equalsIgnoreCase(null))
               A[15]="Free    ";
             else A[15]="Occupied";
           
             if(rs.getString("p17").equalsIgnoreCase("")||rs.getString("p17").equalsIgnoreCase("lab")||rs.getString("p17").equalsIgnoreCase(null))
               A[16]="Free    ";
             else A[16]="Occupied";
             
            if(rs.getString("p18").equalsIgnoreCase("")||rs.getString("p18").equalsIgnoreCase("lab")||rs.getString("p18").equalsIgnoreCase(""))
               A[17]="Free    ";
             else A[17]="Occupied";
        }
                     
               textarea.setText("");  
                
//                textarea.appendText(String.format());
                textarea.appendText("================================================================================\n\n\n");
                textarea.appendText("             \t\t " + z1 + "  " +z4+ " "+z3+" "+z2+" "+z5 +" \n\n\n");
                textarea.appendText(String.format("%-13s   %-5s   %-5s   %-5s   %-5s   %-5s   %-5s   %-5s\n",
                        "Time","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"));
                textarea.appendText(String.format("%-13s %-10s %-10s %-10s %-10s %-10s %-7s  %-10s\n",
                        "02:30-03:20","","","","","","",A[14]));
                textarea.appendText(String.format("%-13s %-10s %-10s %-10s %-10s %-10s %-7s  %-10s\n",
                        "03:30-04:20","","","","","","",A[15]));
                textarea.appendText(String.format("%-13s %-10s %-10s %-10s %-10s %-10s %-7s  %-10s\n",
                        "04:30-05:20","","","","","","",A[16]));
                textarea.appendText(String.format("%-13s %-10s %-10s %-10s %-10s %-10s %-7s  %-10s\n",
                        "05:30-06:20","","","","","","",A[17]));
                textarea.appendText(String.format("%-13s %-10s %-10s %-10s %-10s %-8s %-10s  %-10s\n",
                        "07:30-08:20","","","","","",A[10],""));
                textarea.appendText(String.format("%-13s %-10s %-10s %-10s %-10s %-8s %-10s  %-10s\n",
                        "08:30-09:20","","","","","",A[11],""));
                textarea.appendText(String.format("%-13s %-10s %-10s %-10s %-10s %-8s %-10s  %-10s\n",
                        "09:30-10:20","","","","","",A[12],""));
                textarea.appendText(String.format("%-13s %-10s %-10s %-10s %-10s %-8s %-10s  %-10s\n",
                        "10:30-11:20","","","","","",A[13],""));
//                textarea.appendText("    " + A[0] + "  \t  " + A[2] + "  \t  " + A[4]  + "  \t  " + A[6] + " \t   " + A[8]+"\n");
                textarea.appendText(String.format("%-13s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                        "12:00-12:50",A[0],A[2],A[4],A[6],A[8],"",""));
//                textarea.appendText("13:00-13:50    " + A[1] + "   \t " + A[3] + "   \t " + A[5]  + " \t   " + A[7] + "  \t  " + A[9] +"\n");      
               textarea.appendText(String.format("%-13s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                        "12:00-12:50",A[1],A[3],A[5],A[7],A[9],"",""));
                textarea.appendText("\n\n\n================================================================================");
                
                textarea.appendText("\n This page is Generated on  "+day+"-"+mon+"-"+year+"  " +
                        "at " + hour +":"+min+":"+sec);
            
      }  
             
             
     
            
        
       }catch(SQLException err){
        Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("Try cahtc block2 "+err);
                alert.show();
               return;
          }
       }
    }
    @FXML
    private void combo_searchby(ActionEvent event) {
       String a=(String) by_combo.getValue();  
         
           com1.removeAll(com1);
           com2.removeAll(com2);
           com3.removeAll(com3);
           com4.removeAll(com4);
           com5.removeAll(com5); 
           Time.removeAll();
       if(a.equalsIgnoreCase( "Block & Room")){
           combo1.setPromptText("Block");
           combo1.setVisible(true);
       
           combo2.setPromptText("Room");                                               
           combo2.setVisible(true);
               
           combo3.setVisible(false);
           combo4.setVisible(false);
           combo5.setVisible(false);
       
           try{        
           database c=new database();
               con=c.connnect();
               
            Statement s = con.createStatement();
            String sql = "select distinct block from table1";
            ResultSet rs = s.executeQuery(sql);
         
            while(rs.next()){
                        
            com1.add(rs.getInt("block")); 
            }
            
            
            
          }catch(SQLException err){
        Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("at the combo_searchby 1 "+err);
                alert.show();
               return;
       }
           
       }else if(a.equalsIgnoreCase("Time & Block")){
           
           combo1.setPromptText("Block");
           combo1.setVisible(true);
       
           combo2.setPromptText("Time");
           combo2.setVisible(true);          
           
           combo3.setVisible(true);
           combo3.setPromptText("Day");
                 
           combo4.setVisible(false);
           combo5.setVisible(false);
       
                   
       try{        
           database c=new database();
               con=c.connnect();
               
            Statement s = con.createStatement();
            String sql = "select distinct block from table1";
            ResultSet rs = s.executeQuery(sql);
         
            while(rs.next()){
                        
            com1.add(rs.getInt("block")); 
            }
            
            
            
          }catch(SQLException err){
        
              Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("at combo_searchby Time and block "+err);
                alert.show();
               return;
       }
       
       }else if(a.equalsIgnoreCase("department & section"))
       
       {
           combo1.setPromptText("Department");
           combo1.setVisible(true);
       
           combo2.setPromptText("Type");
           combo2.setVisible(true);          
           
           combo3.setVisible(true);
           combo3.setPromptText("Section");
           
           combo4.setVisible(true);
           combo4.setPromptText("Level");
           
           combo5.setVisible(true);
           combo5.setPromptText("program");
     
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
                alert.setContentText("at the combo_searchby department & section"+err);
                alert.show();
               return;
       }
       }
    }


  

    @FXML
    private void combo1(ActionEvent event) {
                com2.removeAll(com2);
        String check=(String) by_combo.getValue();  
        if(check=="Block & Room"|| check==null){
     
            Integer a =(Integer) combo1.getValue();
       
       
            try{
                
          
               database c=new database();
               con=c.connnect();
                       
            Statement s = con.createStatement();
            String sql = "select distinct room from table1 where block="+a;
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                        
            com2.add(rs.getInt("room"));             
   
            }
       }catch(SQLException err){
           Alert alert=new Alert(Alert.AlertType.ERROR); 
                alert.setHeaderText(null);
                alert.setContentText("at the combo1 Block and room"+err);
                alert.show();
               return;
          }
        }
        
        else if(check=="Time & Block"){
           String[] time={"02:30-03:20","03:30-4:20","04:30-05:20","05:30-06:20",
            "07:30-08:20","08:30-09:20","09:30-10:20","12:00-12:50","13:00-13:50"};
            for(int i=0;i<time.length;i++)
                com2.add(time[i]);             

        }
        else if(check=="department & section")
        {   String dep=(String) combo1.getValue();     
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
    }

    @FXML
    private void combo2(ActionEvent event) {
      String check=(String) by_combo.getValue();  
            com3.removeAll(com3);
      if(check=="Time & Block"){
  
          String test=(String) combo2.getValue();
         String[] day={"Monday","Tusday","Wedensday","Thursday","Friday","Saturday","Sunday"};          
            
          if((test=="12:00-12:50")|| (test=="13:00-13:50")  )   
          {   for(int i=0;i<5;i++) 
                     com3.add(day[i]);             
          } else{
              for(int i=0;i<7;i++) 
                     com3.add(day[i]); 
          }        
         
        }
      else if(check=="department & section"){
                  
       try{    
            
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
   
        
    }

    @FXML
    private void combo3(ActionEvent event) {
          ArrayList<String> sect=new ArrayList<>();     
        String check=(String) by_combo.getValue();  
       com4.removeAll(com4);

         if(check=="department & section")
           {        
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
                         if(!sect.contains(rs.getString("level")))
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
    }

    @FXML
    private void combo4(ActionEvent event) {
      com5.removeAll(com5);
     
        String check=(String) by_combo.getValue();  
          ArrayList<String> sect=new ArrayList<>();     
             
         String d1=(String) combo1.getValue();
         String d2=(String) combo2.getValue();
         String d3=(String) combo3.getValue();
         String d4=(String) combo4.getValue();
  
     
    if(check=="department & section")
        {        
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
                       if(!sect.contains(rs.getString("student_type")))                     
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
    }

    @FXML
    private void combo5(ActionEvent event) {
    }
    
    private void print(Node node){
        PrinterJob job = PrinterJob.createPrinterJob();
        if(job != null){
            PageLayout layout = Printer.getDefaultPrinter().createPageLayout(Paper.A4, PageOrientation.LANDSCAPE,Printer.MarginType.DEFAULT);
            boolean printed = job.printPage(layout,node);
            if(printed){
                job.endJob();
            }else{
                System.out.println("Print cancelled or failed.");
            }
        }else{
            System.out.println("Could not create a PrinterJob.");
        }
        
    
    
    }
    @FXML
    private void print_page(ActionEvent event) {
 
        textarea.setPrefRowCount(70);
        textarea.setPrefColumnCount(70);
        
        Label linesToPrint = new Label();
        linesToPrint.setFont(new Font("Consolas",13));
        String[] listOfItems = textarea.getText().split("\n");
        for(int line = 0; line < listOfItems.length; line++){
            linesToPrint.setText(linesToPrint.getText() + 
                                    listOfItems[line] + "\n");
        }
        print(linesToPrint);
      
    }

    @FXML
    private void home(MouseEvent event) {
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
}

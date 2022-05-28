/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author KIMOK
 */
public class Best extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
           stage.setScene(scene);
           stage.initStyle(StageStyle.UNDECORATED);
       
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sql();
        launch(args);
            
    }
   public static void sql(){
        try {
            database c=new database();
            Connection con=c.connnect();
            
            Statement stme=con.createStatement();
            stme.executeUpdate("CREATE TABLE IF NOT EXISTS table1(block int ,room int,course_type varchar(15),section varchar(10),\n" +
"level varchar(20),department varchar(50),semistor int,student_type varchar(30),year year\n" +
",primary key ( block,room,course_type))");
 stme.executeUpdate("CREATE TABLE IF NOT EXISTS table2(block int ,room int,course_type varchar(15),p1 varchar(20),p2 varchar(20),p3 varchar(20),p4 varchar(20),p5 varchar(20),\n" +
"p6 varchar(20),p7 varchar(20),p8 varchar(20),p9 varchar(20),p10 varchar(20),p11 varchar(20)\n" +
",p12 varchar(20),p13 varchar(20),p14 varchar(20), p15 varchar(20),p16 varchar(20),p17 varchar(20)\n" +
",p18 varchar(20),p19 varchar(20),p20 varchar(20),p21 varchar(20),p22 varchar(20),\n" +
"p23 varchar(20),p24 varchar(20),p25 varchar(20),p26 varchar(20),p27 varchar(20),p28 varchar(20)\n" +
",p29 varchar(20), p30 varchar(20),p31 varchar(20),p32 varchar(20),p33 varchar(20),p34 varchar(20),\n" +
"p35 varchar(20) ,primary key(block,room,course_type),foreign key (block,room,course_type) references table1 (block,room,course_type) on delete cascade on update cascade)");
  stme.executeUpdate("CREATE TABLE IF NOT EXISTS table3(block int ,room int,course_type varchar(15),p1 varchar(20),p2 varchar(20),p3 varchar(20),p4 varchar(20),p5 varchar(20),\n" +
"p6 varchar(20),p7 varchar(20),p8 varchar(20),p9 varchar(20),p10 varchar(20),p11 varchar(20)\n" +
",p12 varchar(20),p13 varchar(20),p14 varchar(20), p15 varchar(20),p16 varchar(20),p17 varchar(20)\n" +
",p18 varchar(20),primary key(block,room,course_type),foreign key (block,room,course_type) references table1 (block,room,course_type) on delete cascade on update cascade)");
  
 stme.executeUpdate("CREATE TABLE IF NOT EXISTS table4(block int ,room int,course_type varchar(15),p1 varchar(20),p2 varchar(20),p3 varchar(20),p4 varchar(20),p5 varchar(20),\n" +
"p6 varchar(20),p7 varchar(20),p8 varchar(20),p9 varchar(20),p10 varchar(20),p11 varchar(20),\n" +
"p12 varchar(20),p13 varchar(20),p14 varchar(20),primary key(block,room,course_type),foreign key (block,room,course_type) references table1 (block,room,course_type) on delete cascade on update cascade)");
                        
 stme.executeUpdate("CREATE TABLE IF NOT EXISTS admin(id int auto_increment,username varchar(50),password varchar(50),backup varchar(50),primary key(id))");   

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
}  
}



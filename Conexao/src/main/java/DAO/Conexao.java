/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Rapidonet
 */

 
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rapidonet
 */
public class Conexao {

   
    
    
    
   public static Connection conectar() {
       Connection conexao=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");            
               return DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "user", "291286");
        }catch(ClassNotFoundException|SQLException e){
          throw new RuntimeException("erro ao salvar"+e);
        }
              
                    
        
            
        }
   
   
 public static Connection conectar2() {
       Connection conexao=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");            
               return DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "user", "291286");
        }catch(ClassNotFoundException|SQLException e){
          throw new RuntimeException("erro ao salvar"+e);
        }          
       }
    
   
   
   public static Connection desconectar() throws SQLException{
   
  conectar().close();
       
   return null;
   
   }
   
}
  



   

    
    
    
    
    
    
    
    

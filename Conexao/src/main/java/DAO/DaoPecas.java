/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Pecas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rapidonet
 */
public class DaoPecas {
    
    
    
    public void salvar(Pecas p) throws SQLException{
        
        Connection con=Conexao.conectar();
       // Connection con1=Conexao.conectar2();
        PreparedStatement stmt=null;
        PreparedStatement stmt1=null;
       String sql="insert into cliente (codigo,descricao,equipamento)values(?,?,?)";
        try {
           stmt=con.prepareStatement(sql);
           stmt.setString(1, p.getCodigo());
           stmt.setString(2, p.getDescricao());
           stmt.setString(3, p.getEquipamento());
           stmt.executeUpdate();
           
           /*=con1.prepareStatement(sql);
           stmt1.setString(1, p.getCodigo());
           stmt1.setString(2, p.getDescricao());
           stmt1.setString(3, p.getEquipamento());
           stmt1.executeUpdate();
         */  
           
           
           
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null,"erro ao salvar dados"+ e.toString());
        } finally{
        
            try {       
                
                
                Conexao.conectar().close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoPecas.class.getName()).log(Level.SEVERE, null, ex);
            }
            } 
        }
    
    public boolean excluir(String codigo) throws SQLException{
 Connection con=Conexao.conectar();
        
        PreparedStatement stmt=null;
        PreparedStatement stmt1=null;
       String sql="delete from cliente where codigo=?";
         
        try {
            stmt=con.prepareStatement(sql);             
             stmt.setString(1, codigo);
             stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoPecas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return false;
         
        }

   
   
    
    
    public List<Pecas> carregarTabela(){
        Connection con1=new Conexao().conectar();
        PreparedStatement stmt=null;
        ResultSet rs=null;
         List<Pecas> pecas=new ArrayList();
        String sql="select * from cliente";        
        try {            
            stmt=con1.prepareStatement(sql);
            rs=stmt.executeQuery();//colcado dentro do ResultedSet                       
            while(rs.next()){
                Pecas peca=new Pecas();
                peca.setCodigo(rs.getString("codigo"));
                peca.setDescricao(rs.getString("descricao"));
                peca.setEquipamento(rs.getString("equipamento"));
            pecas.add(peca);            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoPecas.class.getName()).log(Level.SEVERE, null, ex);
           
        }finally{      
        }
     return pecas;    
    }
    
    
    
    
    }
  
    


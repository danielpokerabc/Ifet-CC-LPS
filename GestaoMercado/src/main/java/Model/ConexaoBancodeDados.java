/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PDaniel
 */
public class ConexaoBancodeDados {
    private Connection conexao = null;
    
    private static final String Drive = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dbloja";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection(){
        try {
            Class.forName(Drive);
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro na Conexao", ex);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na Conexao", ex);
        }
        
        
    }
    
    public static void closeConnection (Connection connects){
        //Para verificar a Conexao
        if(connects != null){
            try {
                connects.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro na Conexao", ex);
            }
        }
        
        
    }
    public static void closeConnection (Connection connects, PreparedStatement stmt){
        //Para verificar a Conexao
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro na Conexao", ex);
            }
        }
        closeConnection(connects);
        
    }
    public static void closeConnection (Connection connects, PreparedStatement stmt, ResultSet e){
        //Para verificar a Conexao
        if(e != null){
            try {
                e.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro na Conexao", ex);
            }
        }
        closeConnection(connects, stmt);
        
    }
    
}

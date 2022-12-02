/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import Model.ConexaoBancodeDados;
import Model.Funcionarios;
import Model.GeraTabelasSQL;
import Model.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *CRUD//Creat Read Update Delete
 * @author PDaniel
 */

public @Data class CategoriaDAO {
    public static Connection conexao;
    static PreparedStatement pStatement=null;
    //conexao = null;
    
    static ConexaoBancodeDados conexaoDados = new ConexaoBancodeDados();
    GeraTabelasSQL geraTabelas = new GeraTabelasSQL();
    
    
    
    public CategoriaDAO(){
        conexao = ConexaoBancodeDados.getConnection();
    
    }
    public static boolean a(){
        //savee();
        return true;
    
    }
    
    public static boolean savee(){
        
        String sqlInsert = " INSERT INTO Funcionarios ("
            + "id,"
            + "nome,"
            + "cpf,"
            + "email,"
            + "telefone,"
            + "contaBanco"
            + ") VALUES(?,?,?,?,?,?);";
        
        try{
            pStatement = conexao.prepareStatement(sqlInsert);
            pStatement.setInt(1, Funcionarios.getId());
            pStatement.setString(2, Funcionarios.getNome());
            pStatement.setString(3, Funcionarios.getCpf());
            pStatement.setString(4, Funcionarios.getEmail());
            pStatement.setString(5, Funcionarios.getTelefone());
            pStatement.setString(6, Funcionarios.getContaBanco());
            pStatement.executeUpdate();
            System.out.println("Os dados foram iseridos no SQL");
            
            return true;
        }catch(SQLException e){
            System.err.println("Erro de Salve");
            
            return false;
        }finally{
            if(pStatement !=null){
                try {
                    pStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conexaoDados.closeConnection(conexao,pStatement);
        }
        
    }
   
}

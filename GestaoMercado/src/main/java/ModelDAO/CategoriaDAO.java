/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;
import Model.Gerentes;
import Model.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Data;

/**
 *CRUD//Creat Read Update Delete
 * @author PDaniel
 */

public @Data class CategoriaDAO {
    public static Connection conexao;
    static PreparedStatement pStatement=null;
    //conexao = null;
    
    
    
    
    
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
            pStatement.setInt(1, Gerentes.getId());
            pStatement.setString(2, Gerentes.getNome());
            pStatement.setString(3, Gerentes.getCpf());
            pStatement.setString(4, Gerentes.getEmail());
            pStatement.setString(5, Gerentes.getTelefone());
            pStatement.setString(6, Gerentes.getContaBanco());
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
        }
        
    }
   
}

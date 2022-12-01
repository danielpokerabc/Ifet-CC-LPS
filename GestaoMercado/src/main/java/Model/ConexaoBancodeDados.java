/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author PDaniel
 */
public class ConexaoBancodeDados {
    private Connection conexao = null;
    /**
     * Conecta a um banco de dados (cria o banco se ele não existir)
     *
     * @return
     */
    public boolean conectar() {

        try {
            String url = "jdbc:sqlite:src/main/java/Image/GestaoMercado.db";

            this.conexao = DriverManager.getConnection(url);
            System.out.println("Conectado");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }
    
    public boolean desconectar() {

        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();
            }
            System.out.println("desconectado");
        } catch (SQLException e) {

            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    /**
     * Para Sql serem executado ou criar as tabelas
     * @return 
     */
    public Statement criarStatement(){
        try{
            return this.conexao.createStatement();
        }
        catch(SQLException e){
            return null;
        }
    }
    
    /**
     * Para Sql serem executado ou criar as tabelas
     * @param sql
     * @return 
     */
    public PreparedStatement criarPersonalisadaStatement(String sql){
        try{
            return this.conexao.prepareStatement(sql);
        }
        catch(SQLException e){
            return null;
        }
    }
    public Connection getConexao(){
        return this.conexao;
    }
}

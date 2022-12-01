/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PDaniel
 */
public class GeraTabelasSQL {
    private ConexaoBancodeDados conexaoDados;
    
    public void GeraTabelasSQL(ConexaoBancodeDados BancodeDados){
        this.conexaoDados= BancodeDados;
    }
    
    public void CriaTabelasFuncionario(){
        String sql = "CREATE TABLE IF NOT EXISTS Funcionarios"
            +"("
            +"id integer PRIMARY KEY AUTOINCREMENT,"
            +"nome text NOT NULL,"
            +"cpf text,"
            +"email text,"
            +"telefone text,"
            +"contaBanco text"
            +");";
        
        //Executando sql de criare tabela
        boolean conectou = false;
        
        try{
            conectou = this.conexaoDados.conectar();
            
            Statement stmt = this.conexaoDados.criarStatement();
            stmt.execute(sql);
            System.err.println("A Tabela Funcionario Criada ou Atualizada");
        }catch(SQLException e){
            //Erro
            System.err.println("ErroConexao"+e);
        }finally{
            if(conectou){//fechando a conexao se tiver aberta
                //this.conexaoDados.desconectar();
            }
        }
    }
}

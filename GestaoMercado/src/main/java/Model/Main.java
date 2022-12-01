/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Model;

import View.Menu;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    

    public static void main(String[] args) {
        
        PreparedStatement preparedStatement = null;
        
        ConexaoBancodeDados conexaoDados = new ConexaoBancodeDados();
        GeraTabelasSQL geraTabelas = new GeraTabelasSQL();
        geraTabelas.GeraTabelasSQL(conexaoDados);
        geraTabelas.CriaTabelasFuncionario();
        
        
        Menu telaMenu = new Menu();
        telaMenu.setVisible(true);//Fun�ao padrao para ativar a tela
        
        Funcionarios funcion = new Funcionarios();
        funcion.setId(1);
        funcion.setNome("Daniel");
        funcion.setCpf("12918291912");
        funcion.setEmail("Daniel@Gmail.com");
        funcion.setTelefone("32999999999");
        funcion.setContaBanco("32999999999");
        
        //conexaoDados.conectar();
        
        String sqlInsert = " INSERT INTO Funcionarios ("
            + "id,"
            + "nome,"
            + "cpf,"
            + "email,"
            + "telefone,"
            + "contaBanco"
            + ") VALUES(?,?,?,?,?,?);";
        //ConexaoDados.desconectar();
        
        preparedStatement = conexaoDados.criarPersonalisadaStatement(sqlInsert);
        
        try{
            
            preparedStatement.setInt(1, Funcionarios.getId());
            preparedStatement.setString(2, Funcionarios.getNome());
            preparedStatement.setString(3, Funcionarios.getCpf());
            preparedStatement.setString(4, Funcionarios.getEmail());
            preparedStatement.setString(5, Funcionarios.getTelefone());
            preparedStatement.setString(6, Funcionarios.getContaBanco());
            
            int resultado = 9;//preparedStatement.executeUpdate();//recebe 0 ou 1
            if(resultado == 1){
                System.out.println("Os dados foram iseridos no SQL");
            }else if(resultado == 0){
                System.out.println("Erro ao adicionar no SQL");
            }
            
        }
        catch(SQLException e){
            System.out.println("Erro ao adicionar no SQL:"+e);
        }finally{
            if(preparedStatement !=null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conexaoDados.desconectar();
        }
    }
}

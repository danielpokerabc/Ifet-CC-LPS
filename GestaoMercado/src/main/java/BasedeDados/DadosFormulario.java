/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BasedeDados;

import Model.Gerentes;
import Model.Main;
import Model.Produtos;
import View.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author PDaniel
 */
public class DadosFormulario {
    static Connection con=null;
    static ResultSet rs=null;
    static PreparedStatement pat=null;
    
    public static void VerificaLogin(String login, String senha){
        String sql="select * from Funcionarios where login=? and senha=?";//vai procurar em todo BD referencia do campo da caixa de texto o login and senha
        // ? sera substituido pelo conteudo das variaveis
        try{
            // Cria a conexão com o banco de dados
            con = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDados\\GestaoMercado.db");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            
            pat = con.prepareStatement(sql);
            pat.setString(1, login);
            pat.setString(2, senha);//esse traço no gettext é por causa da caracteristica de esconde senha 
            
            //executando a consulta no banco de dados
            ResultSet rs = pat.executeQuery();
            
            if(rs.next()){
                System.out.println("Login Sucesso!!!!");
                Menu telaMenu = new Menu();
                telaMenu.setVisible(true);//Fun�ao padrao para ativar a tela
            }else{
                System.out.println("Login Falieds!!!!");
                JOptionPane.showConfirmDialog(null, "Usuario e/ou Senha Invalida!");
            }
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, ""+e);
            System.out.println("Sem Login no Base de Dados!!!!");
        }
    }
    public static void GeraTabela(){
        
        PreparedStatement pat=null;
        Connection connection = null;
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDados\\GestaoMercado.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            System.err.println(Gerentes.Data[0][0]);
            // Roda os comandos para o SQLite
            statement.executeUpdate("DROP TABLE IF EXISTS Funcionarios");
            statement.executeUpdate("CREATE TABLE Funcionarios "+"("
            +"id integer PRIMARY KEY AUTOINCREMENT,"
            +"nome STRING NOT NULL,"
            +"cpf STRING,"
            +"email STRING,"
            +"telefone STRING,"
            +"contaBanco STRING,"
            +"login STRING,"
            +"senha STRING )");
            System.err.println(Gerentes.Data[0][0]);
            statement.executeUpdate("INSERT INTO Funcionarios VALUES("
                    +" '1' "+", ' "
                    +Gerentes.Data[0][0]+"' , '"
                    +Gerentes.Data[0][1]+"' , '"
                    +Gerentes.Data[0][2]+"' , '"
                    +Gerentes.Data[0][3]+"' , '"
                    +Gerentes.Data[0][4]+"' , '"
                    +"admin"+"' , '"
                    +"admin"
                    +"' )");
           
          //statement.executeUpdate("INSERT INTO Gerentes VALUES(1, 'Marcos Oliveira', 'admin', 'admin')");
          //statement.executeUpdate("INSERT INTO Gerentes VALUES(2, 'James Gosling', 'admin2', 'admin2')");
          ResultSet rs = statement.executeQuery("SELECT * FROM Funcionarios");
          while(rs.next()) {
            // Ler os dados inseridos
            //System.out.println("NOME DO CARA  : " + rs.getString("name"));
            //System.out.println("IDENTIFICAÇÃO : " + rs.getInt("id"));
            //System.out.println("login : " + rs.getString("login"));
            //System.out.println("senha : " + rs.getString("senha"));
          }
        } catch(SQLException e) {
          // Se a mensagem de erro for: "out of memory",
          // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
          System.err.println(e.getMessage());
        }

        finally {
          try {
            if(connection != null){
              connection.close();
            }
          } catch(SQLException e) {
            // Falhou também para fechar o arquivo
            System.err.println(e.getMessage());
          }
        }
    }
    
    
public static void GeraTabelaProdutos(){
        
        PreparedStatement pat=null;
        Connection connection = null;
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDados\\GestaoMercado.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            // Roda os comandos para o SQLite
            statement.executeUpdate("DROP TABLE IF EXISTS Produtos");
            statement.executeUpdate("CREATE TABLE Produtos "+"("
            +"id integer PRIMARY KEY AUTOINCREMENT,"
            +"nomeProduto STRING NOT NULL,"
            +"codBarras STRING,"
            +"dataVencimento STRING"
            +" )");
            //System.err.println(Gerentes.Data[0][0]);
            statement.executeUpdate("INSERT INTO Produtos VALUES("
                    +" '1' "+", ' "
                    +Produtos.DataProduto[0][0]+"' , '"
                    +Produtos.DataProduto[0][1]+"' , '"
                    +Produtos.DataProduto[0][2]+"' "
                    
                    +" )");
           
          ResultSet rs = statement.executeQuery("SELECT * FROM Produtos");
          while(rs.next()) {
            // Ler os dados inseridos
            //System.out.println("nomeProduto  : " + rs.getString("nomeProduto"));
            //System.out.println("codBarras : " + rs.getInt("codBarras"));
            //System.out.println("dataVencimento : " + rs.getString("dataVencimento"));
            //System.out.println("senha : " + rs.getString("senha"));
          }
        } catch(SQLException e) {
          // Se a mensagem de erro for: "out of memory",
          // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
          System.err.println(e.getMessage());
        }

        finally {
          try {
            if(connection != null){
              connection.close();
            }
          } catch(SQLException e) {
            // Falhou também para fechar o arquivo
            System.err.println(e.getMessage());
          }
        }
    }
     /*String sql = "CREATE TABLE IF NOT EXISTS Gerentes"
            +"("
            +"id integer PRIMARY KEY AUTOINCREMENT,"
            +"nome text NOT NULL,"
            +"cpf text,"
            +"email text,"
            +"telefone text,"
            +"contaBanco text"
            +");";*/
}

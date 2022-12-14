/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BasedeDados;

import Model.Gerentes;
import Model.Main;
import Model.Produtos;
import View.GerenciamentoFuncionarios;
import View.Menu;
import View.ViewLogin;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PDaniel
 */
public class GerenciadorBD {
    static Connection con=null;
    static ResultSet rs=null;
    static PreparedStatement pat=null;
    @Getter@Setter
    public static String[][] DataProduto;// = new String[8][8];
    @Getter@Setter
    public static String[][] DataGerente;
    @Getter@Setter
    private static int LinhasCounts;
    @Getter@Setter
    public static int LoginConfirm=0;
    
    public static void VerificaLogin(String login, String senha){
        String sql="select * from Gerentes where login=? and senha=?";//vai procurar em todo BD na coluna login and senha
        // ? sera substituido pelo conteudo das variaveis
        try{
            // Cria a conexão com o banco de dados
            con = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDados\\GestaoMercado.db");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            
            pat = con.prepareStatement(sql);
            pat.setString(1, login);// 1 e 2 sao sequencia do ponto de interrogação
            pat.setString(2, senha);//esse traço no gettext é por causa da caracteristica de esconde senha 
            
            //executando a consulta no banco de dados
            ResultSet rs = pat.executeQuery();
            
            if(rs.next()){
                
                LoginConfirm=1;
                JOptionPane.showMessageDialog(null, "Login Realizado!!!!");
                Menu.ParaMudarNomeBotao();
                System.out.println("Login Sucesso!!!!");
            }else{
                System.out.println("Login Falieds!!!!");
                JOptionPane.showMessageDialog(null, "Usuario e/ou Senha Invalida!");
            }
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, ""+e);
            System.out.println("Sem Login no Base de Dados!!!!");
        }finally {
          try {
            if(con != null){
              con.close();
            }
          } catch(SQLException e) {
            // Falhou também para fechar o arquivo
            System.err.println(e.getMessage());
          }
        }
    }
    public static void AdicionaGerente(){
        
        PreparedStatement pat=null;
        Connection connection = null;
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDados\\GestaoMercado.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
                        
            ResultSet rs = statement.executeQuery("SELECT * FROM Gerentes");
            //ResultSet rsLinhas = statement.executeQuery("SELECT COUNT(id) FROM Gerentes");
            LinhasCounts=0;
            while(rs.next()) {
              LinhasCounts++;

            }
            LinhasCounts++;
            
            statement.executeUpdate("INSERT INTO Gerentes VALUES("
                    +LinhasCounts+", ' "
                    +Gerentes.getNome()+"' , '"
                    +Gerentes.getCpf()+"' , '"
                    +Gerentes.getEmail()+"' , '"
                    +Gerentes.getTelefone()+"' , '"
                    +Gerentes.getContaBanco()+"' , '"
                    +"admin"+"' , '"
                    +"admin"
                    +"' )");
           
         
            
            
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
    
    
public static void AdicionaProdutos(){
        
        PreparedStatement pat=null;
        Connection connection = null;
        //Connection conn = null;
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDados\\GestaoMercado.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            
           // Roda os comandos para o SQLite            
           
            ResultSet rs = statement.executeQuery("SELECT * FROM Produtos");
            //ResultSet rsLinhas = statement.executeQuery("SELECT COUNT(id) FROM Produtos");
            LinhasCounts=0;
            while(rs.next()) {
              LinhasCounts++;

            }
            LinhasCounts++;
            System.out.println("NumeroLinhas : " + LinhasCounts);
                        
            
            statement.executeUpdate("INSERT INTO Produtos VALUES("
                      +getLinhasCounts()+", ' "
                      +Produtos.getNome()+"' , '"
                      +Produtos.getCodBarras()+"' , '"
                      +Produtos.getDataVencimento()+"' , '"
                      +Produtos.getPreco()

                      +"' )");
            
            DataProduto = new String[LinhasCounts][4];
            ResultSet rs2 = statement.executeQuery("SELECT * FROM Produtos");
            int i=0;
            while(rs2.next()) {
                
                DataProduto[i][0]=rs2.getString("nomeProduto");
                DataProduto[i][1]=rs2.getString("codBarras");
                DataProduto[i][2]=rs2.getString("dataVencimento");
                DataProduto[i][3]=rs2.getString("preco");
                i++;
            }
            
            //res.close();
            //System.out.println("DataProduto : "+ DataProduto);
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

public static void EditaTabelaGerentes(){
    String sql="UPDATE Gerentes"
            + " SET "
            + " nome = ?,"
            + " cpf = ?,"
            + " email = ?,"
            + " telefone = ?,"
            + " contaBanco = ?,"
            + " login = ?,"
            + " senha = ?"
            + " WHERE id = ?";//vai procurar em todo BD na coluna login and senha
    
        // ? sera substituido pelo conteudo das variaveis
        try{
            // Cria a conexão com o banco de dados
            con = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDados\\GestaoMercado.db");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            
            pat = con.prepareStatement(sql);
            pat.setString(1,Gerentes.getNome());// 1 e 2 sao sequencia do ponto de interrogação
            pat.setString(2,Gerentes.getCpf());//esse traço no gettext é por causa da caracteristica de esconde senha 
            pat.setString(3,Gerentes.getEmail());
            pat.setString(4,Gerentes.getTelefone());
            pat.setString(5,Gerentes.getContaBanco());
            pat.setString(6,"admin");
            pat.setString(7,"admin");
            pat.setInt(8,Gerentes.getId());
            
            pat.executeUpdate();
            System.out.println("Atualizado com Sucesso!!!!");

            
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, ""+e);
            System.out.println("Falha na Edição!!!!");
        }finally {
          try {
            if(con != null){
              con.close();
            }
          } catch(SQLException e) {
            // Falhou também para fechar o arquivo
            System.err.println(e.getMessage());
          }
        }
}
public static void EditaTabelaProdutos(){
    String sql="UPDATE Produtos"
            + " SET "
            + " nomeProduto = ?,"
            + " codBarras = ?,"
            + " dataVencimento = ?,"
            + " preco = ?"            
            + " WHERE id = ?";//vai procurar em todo BD na coluna login and senha
    
        // ? sera substituido pelo conteudo das variaveis
        try{
            // Cria a conexão com o banco de dados
            con = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDados\\GestaoMercado.db");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            
            pat = con.prepareStatement(sql);
            pat.setString(1,Produtos.getNome());// 1 e 2 sao sequencia do ponto de interrogação
            pat.setString(2,Produtos.getCodBarras());//esse traço no gettext é por causa da caracteristica de esconde senha 
            pat.setString(3,Produtos.getDataVencimento());
            pat.setString(4,Produtos.getPreco());
            pat.setInt(5,Produtos.getId());
            
            pat.executeUpdate();
            System.out.println("Atualizado com Sucesso!!!!");

            
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, ""+e);
            System.out.println("Falha na Edição!!!!");
        }finally {
          try {
            if(con != null){
              con.close();
            }
          } catch(SQLException e) {
            // Falhou também para fechar o arquivo
            System.err.println(e.getMessage());
          }
        }
}
public static void LerTabelaGerentes(){
    PreparedStatement pat=null;
    Connection connection = null;
    LinhasCounts = 0;
    int Atable=0;
    
    
    try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDados\\GestaoMercado.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            
            //Verifica se a Tabela foi Criada
            //Verificando se uma tabela existe
            
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet res = meta.getTables(null, null,"Gerentes" ,null);// new String[] {"Produtos"});//,new String[] {"Tables"});
            
            System.out.println("List of tables: ");
            while (!res.next() && Atable!=1) {
                Atable=1;
                System.out.println("Nao existe Tabela, Gerando uma nova tabela: ");//null se nao existe
                
                // Roda os comandos para o SQLite
                // Roda os comandos para o SQLite
                statement.executeUpdate("DROP TABLE IF EXISTS Gerentes");
                statement.executeUpdate("CREATE TABLE Gerentes "+"("
                +"id integer PRIMARY KEY AUTOINCREMENT,"
                +"nome STRING NOT NULL,"
                +"cpf STRING,"
                +"email STRING,"
                +"telefone STRING,"
                +"contaBanco STRING,"
                +"login STRING,"
                +"senha STRING )");
                
               
            }
            
            ResultSet rs = statement.executeQuery("SELECT * FROM Gerentes");
            //ResultSet rsLinhas = statement.executeQuery("SELECT COUNT(id) FROM Produtos");
            while(rs.next()) {
              LinhasCounts++;

            }
            LinhasCounts++;
            
            DataGerente = new String[LinhasCounts][8];
            ResultSet rs2 = statement.executeQuery("SELECT * FROM Gerentes");
            int i=0;
            while(rs2.next()) {
                
                DataGerente[i][0]=rs2.getString("id");
                DataGerente[i][1]=rs2.getString("nome");
                DataGerente[i][2]=rs2.getString("cpf");
                DataGerente[i][3]=rs2.getString("email");
                DataGerente[i][4]=rs2.getString("telefone");
                DataGerente[i][5]=rs2.getString("contaBanco");
                DataGerente[i][6]=rs2.getString("login");
                DataGerente[i][7]=rs2.getString("senha");
                
                i++;
            }
            //System.out.println("LinhasCounts : "+ LinhasCounts);
            //System.out.println("i : "+ i);
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

public static void LerTabelaProdutos(){
    PreparedStatement pat=null;
    Connection connection = null;
    LinhasCounts = 0;
    int Atable=0;
    
    
    try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDados\\GestaoMercado.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            
            //Verifica se a Tabela foi Criada
            //Verificando se uma tabela existe
            
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet res = meta.getTables(null, null,"Produtos" ,null);// new String[] {"Produtos"});//,new String[] {"Tables"});
            
            System.out.println("List of tables: ");
            while (!res.next() && Atable!=1) {
                Atable=1;//para nao pecorrer infinitamente tabelas que nao existe
                System.out.println("Nao existe Tabela, Gerando uma nova tabela: ");//null se nao existe
                
                // Roda os comandos para o SQLite
                statement.executeUpdate("DROP TABLE IF EXISTS Produtos");
                statement.executeUpdate("CREATE TABLE Produtos "+"("
                +"id integer PRIMARY KEY AUTOINCREMENT,"
                +"nomeProduto STRING NOT NULL,"
                +"codBarras STRING,"
                +"dataVencimento STRING,"
                +"preco STRING"
                +" )");
                
               
            }
            
            ResultSet rs = statement.executeQuery("SELECT * FROM Produtos");
            //ResultSet rsLinhas = statement.executeQuery("SELECT COUNT(id) FROM Produtos");
            while(rs.next()) {
              LinhasCounts++;

            }
            LinhasCounts++;
            
            DataProduto = new String[LinhasCounts][4];
            ResultSet rs2 = statement.executeQuery("SELECT * FROM Produtos");
            int i=0;
            while(rs2.next()) {
                
                DataProduto[i][0]=rs2.getString("nomeProduto");
                DataProduto[i][1]=rs2.getString("codBarras");
                DataProduto[i][2]=rs2.getString("dataVencimento");
                DataProduto[i][3]=rs2.getString("preco");
                i++;
            }
            //System.out.println("LinhasCounts : "+ LinhasCounts);
            //System.out.println("i : "+ i);
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
}

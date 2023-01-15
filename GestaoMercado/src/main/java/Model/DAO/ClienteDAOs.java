/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Cliente;
import static Model.DAO.GerenteDAOs.DataGerente;
import Model.Gerentes;
import Model.Pessoa;
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
public class ClienteDAOs {
    static Connection con=null;
    static ResultSet rs=null;
    static PreparedStatement pat=null;
    @Getter@Setter
    public static String[][] DataCliente;// = new String[8][8];
    private static int LinhasCounts=0;
    
    
    public static void LerTabelaClientes(){
    PreparedStatement pat=null;
    Connection connection = null;
    LinhasCounts = 0;
    int Atable=0;
    
    
    try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDadosDAO\\GestaoMercado.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            
            //Verifica se a Tabela foi Criada
            //Verificando se uma tabela existe
            
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet res = meta.getTables(null, null,"Clientes" ,null);// new String[] {"Produto"});//,new String[] {"Tables"});
            
            System.out.println("List of tables: ");
            while (!res.next() && Atable!=1) {
                Atable=1;
                System.out.println("Nao existe Tabela, Gerando uma nova tabela: ");//null se nao existe
                
                // Roda os comandos para o SQLite
                // Roda os comandos para o SQLite
                statement.executeUpdate("DROP TABLE IF EXISTS Clientes");
                statement.executeUpdate("CREATE TABLE Clientes "+"("
                +"id integer PRIMARY KEY AUTOINCREMENT,"
                +"nome STRING NOT NULL,"
                +"cpf STRING,"
                +"email STRING,"
                +"telefone STRING,"
                +"endereco STRING,"
                +"login STRING,"
                +"senha STRING )");
                
               
            }
            
            ResultSet rs = statement.executeQuery("SELECT * FROM Clientes");
            //ResultSet rsLinhas = statement.executeQuery("SELECT COUNT(id) FROM Produto");
            while(rs.next()) {
              LinhasCounts++;

            }
            
            DataCliente = new String[LinhasCounts][8];
            ResultSet rs2 = statement.executeQuery("SELECT * FROM Clientes");
            int i=0;
            while(rs2.next()) {
                
                DataCliente[i][0]=rs2.getString("id");
                DataCliente[i][1]=rs2.getString("nome");
                DataCliente[i][2]=rs2.getString("cpf");
                DataCliente[i][3]=rs2.getString("email");
                DataCliente[i][4]=rs2.getString("telefone");
                DataCliente[i][5]=rs2.getString("endereco");
                DataCliente[i][6]=rs2.getString("login");
                DataCliente[i][7]=rs2.getString("senha");
                Pessoa.setContaBanco(rs2.getString("endereco"));
                Pessoa.setNome(rs2.getString("nome"));
                Pessoa.setTelefone(rs2.getString("telefone"));
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

    public static void AdicionaCliente(){
        
        PreparedStatement pat=null;
        Connection connection = null;
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDadosDAO\\GestaoMercado.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
                        
            ResultSet rs = statement.executeQuery("SELECT * FROM Clientes");
            //ResultSet rsLinhas = statement.executeQuery("SELECT COUNT(id) FROM Gerentes");
            LinhasCounts=0;
            int MaxLinhasCounts=0;
            while(rs.next()) {
              if(MaxLinhasCounts<Integer.parseInt(rs.getString("id"))){
                  LinhasCounts=Integer.parseInt(rs.getString("id"));
              }

            }
            LinhasCounts++;
            
            statement.executeUpdate("INSERT INTO Clientes VALUES("
                    +LinhasCounts+", ' "
                    +Cliente.getNome()+"' , '"
                    +Cliente.getCpf()+"' , '"
                    +Cliente.getEmail()+"' , '"
                    +Cliente.getTelefone()+"' , '"
                    +Cliente.getContaBanco()+"' , '"
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
public static void EditaTabelaClientes(){
    String sql="UPDATE Clientes"
            + " SET "
            + " nome = ?,"
            + " cpf = ?,"
            + " email = ?,"
            + " telefone = ?,"
            + " endereco = ?,"
            + " login = ?,"
            + " senha = ?"
            + " WHERE id = ?";//vai procurar em todo BD na coluna login and senha
    
        // ? sera substituido pelo conteudo das variaveis
        try{
            // Cria a conexão com o banco de dados
            con = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDadosDAO\\GestaoMercado.db");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            
            pat = con.prepareStatement(sql);
            pat.setString(1,Cliente.getNome());// 1 e 2 sao sequencia do ponto de interrogação
            pat.setString(2,Cliente.getCpf());//esse traço no gettext é por causa da caracteristica de esconde senha 
            pat.setString(3,Cliente.getEmail());
            pat.setString(4,Cliente.getTelefone());
            pat.setString(5,Cliente.getContaBanco());
            pat.setString(6,"admin");
            pat.setString(7,"admin");
            pat.setInt(8,Cliente.getId());
            
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
public static void DeletaRegistroClientes(int id){
        PreparedStatement pat=null;
        Connection connection = null;
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDadosDAO\\GestaoMercado.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
                        
            ResultSet rs = statement.executeQuery("SELECT * FROM Clientes");
                        
            statement.execute("DELETE from Clientes where id="+id);      
            
            
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
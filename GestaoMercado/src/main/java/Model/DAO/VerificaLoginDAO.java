/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;
import Model.Pessoa;
import View.MenuGerentes;
import View.MenuPrincipal;
import static View.MenuPrincipal.getNome;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;

public class VerificaLoginDAO {
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
        String sql2="select * from Clientes where login=? and senha=?";//vai procurar em todo BD na coluna login and senha
        
        // ? sera substituido pelo conteudo das variaveis
        
        try{
            // Cria a conexão com o banco de dados
            con = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDadosDAO\\GestaoMercado.db");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
            
            pat = con.prepareStatement(sql);
            pat.setString(1, login);// 1 e 2 sao sequencia do ponto de interrogação
            pat.setString(2, senha);//esse traço no gettext é por causa da caracteristica de esconde senha 
            
            //executando a consulta no banco de dados
            ResultSet rs = pat.executeQuery();
            
            if(rs.next()&&(LoginConfirm !=1)){//Faz a consulta linha por linha
                
                MenuPrincipal.setNome(rs.getString("nome"));
                MenuPrincipal.jLabel1.setText("Bem Vindo! "+getNome());
                
                MenuPrincipal.BotaoAdiministradores();
                System.out.println("Nome: "+rs.getString("nome"));
                Pessoa.setContaBanco(rs.getString("endereco"));
                Pessoa.setContaBanco(rs.getString("endereco"));
                Pessoa.setNome(rs.getString("nome"));
                Pessoa.setTelefone(rs.getString("telefone"));
                
                LoginConfirm=1;
                JOptionPane.showMessageDialog(null, "Login Realizado!!!!");
                //MenuGerente.ParaMudarNomeBotao();
                MenuPrincipal.BLogin();
                System.out.println("Login Sucesso!!!!");
            }
            
            pat = con.prepareStatement(sql2);
            pat.setString(1, login);// 1 e 2 sao sequencia do ponto de interrogação
            pat.setString(2, senha);//esse traço no gettext é por causa da caracteristica de esconde senha 
            
            //executando a consulta no banco de dados
            ResultSet rs2 = pat.executeQuery();
            if(rs2.next()&&(LoginConfirm !=1)){//Faz a consulta linha por linha
                
                MenuPrincipal.setNome(rs.getString("nome"));
                MenuPrincipal.jLabel1.setText("Bem Vindo! "+getNome());
                
                System.out.println("Nome: "+rs.getString("nome"));
                LoginConfirm=1;
                JOptionPane.showMessageDialog(null, "Login Realizado!!!!");
                //MenuGerente.ParaMudarNomeBotao();
                MenuPrincipal.BLogin();
                System.out.println("Login Sucesso!!!!");
            }
            else if(LoginConfirm !=1){
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
}

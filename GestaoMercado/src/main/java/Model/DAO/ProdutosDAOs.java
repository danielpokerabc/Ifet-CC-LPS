package Model.DAO;

import Model.Produtos;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PDaniel
 */
public class ProdutosDAOs {
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
    @Getter@Setter
    public static byte[] byteImage;
    @Getter@Setter
    public static String StringDiretorioImage;
    
    public static void AdicionaProdutos() throws IOException{

            PreparedStatement pat=null;
            Connection connection = null;
            //Connection conn = null;
            try {
                // Cria a conexão com o banco de dados
                connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDadosDAO\\GestaoMercado.db");
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
                
                if(getStringDiretorioImage()!=null){
                    setByteImage( converterImagem(new File(""+getStringDiretorioImage()+"")));
                    
                    //setStringDiretorioImage() = null;
                }
                System.out.println("getStringDiretorioImage : "+ getStringDiretorioImage());

                statement.executeUpdate("INSERT INTO Produtos VALUES("
                          +getLinhasCounts()+", ' "
                          +Produtos.getNome()+"' , '"
                          +Produtos.getCodBarras()+"' , '"
                          +Produtos.getDataVencimento()+"' , '"
                          +Produtos.getPreco()+"' , '"
                          +getByteImage()//variavel local byteImage
                          +"' )");

                DataProduto = new String[LinhasCounts][5];
                ResultSet rs2 = statement.executeQuery("SELECT * FROM Produtos");
                int i=0;
                while(rs2.next()) {
                    DataProduto[i][0]=rs2.getString("id");
                    DataProduto[i][1]=rs2.getString("nomeProduto");
                    DataProduto[i][2]=rs2.getString("codBarras");
                    DataProduto[i][3]=rs2.getString("dataVencimento");
                    DataProduto[i][4]=rs2.getString("preco");
                    if(rs2.getBytes("imagens")!=null){
                        ggetImage(rs2.getBytes("imagens"),DataProduto[i][0].toString());//A Image salva na pasta
                    
                    }
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

    public static void EditaTabelaProdutos(){
        String sql="UPDATE Produtos"
                + " SET "
                + " nomeProduto = ?,"
                + " codBarras = ?,"
                + " dataVencimento = ?,"
                + " preco = ?,"
                + " imagens = ?" 
                + " WHERE id = ?";//vai procurar em todo BD na coluna login and senha

            // ? sera substituido pelo conteudo das variaveis
            try{
                // Cria a conexão com o banco de dados
                con = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\BasedeDadosDAO\\GestaoMercado.db");
                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar
                
                if(getStringDiretorioImage()!=null){
                    converterImagem(new File(""+getStringDiretorioImage()+""));
                    System.out.println("ggetImage ");
                    //setStringDiretorioImage() = null;
                }
                
                pat = con.prepareStatement(sql);
                pat.setString(1,Produtos.getNome());// 1 e 2 sao sequencia do ponto de interrogação
                pat.setString(2,Produtos.getCodBarras());//esse traço no gettext é por causa da caracteristica de esconde senha 
                pat.setString(3,Produtos.getDataVencimento());
                pat.setString(4,Produtos.getPreco());
                pat.setBytes(5,byteImage);
                pat.setInt(6,Produtos.getId());
                
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
    

    public static void LerTabelaProdutos(){
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
                    +"preco STRING,"
                    +"imagens BLOB"
                    +" )");


                }

                ResultSet rs = statement.executeQuery("SELECT * FROM Produtos");
                //ResultSet rsLinhas = statement.executeQuery("SELECT COUNT(id) FROM Produtos");
                while(rs.next()) {
                  LinhasCounts++;

                }
                LinhasCounts++;

                DataProduto = new String[LinhasCounts][5];
                ResultSet rs2 = statement.executeQuery("SELECT * FROM Produtos");
                int i=0;
                while(rs2.next()) {
                    DataProduto[i][0]=rs2.getString("id");
                    DataProduto[i][1]=rs2.getString("nomeProduto");
                    DataProduto[i][2]=rs2.getString("codBarras");
                    DataProduto[i][3]=rs2.getString("dataVencimento");
                    DataProduto[i][4]=rs2.getString("preco");
                    if(rs2.getBytes("imagens")!=null){
                        ggetImage(rs2.getBytes("imagens"),DataProduto[i][0].toString());//A Image salva na pasta
                        //System.out.println("ggetImage ");
                    }
                    i++;
                }
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
    
    public static byte[] converterImagem(File file) {
        
        try {
            BufferedImage bImage = ImageIO.read(file);
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "png", bos);
            byteImage = bos.toByteArray();
            //System.err.println("byteImage: "+byteImage);
            //return bytes;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProdutosDAOs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return byteImage;
        
    }
    //byteImage = converterImagem(new File("caminho_da_img.jpg"));
    
    public static byte[] ggetImage(byte[] img, String nomeImage) {//Pega a image da BD e salva na pasta
        try {
            //File f = new File("src\\main\\java\\Image\\ProdutoIds"+nomeImage + ".png");
            //System.out.println("ProdutoIds!!!!");
            //if(f !=null){//f.exists()
            ByteArrayInputStream bis = new ByteArrayInputStream(img);
            BufferedImage bImage2 = ImageIO.read(bis);
            ImageIO.write(bImage2, "png", new File("src\\main\\java\\Image\\ProdutoIds"+ nomeImage + ".png"));
                //System.out.println("Not isDirectory !!!!");
            //}
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return img;
    }
    //getImage(rs2.getBytes("imagem"));
}

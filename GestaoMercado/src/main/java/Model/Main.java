/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Model;

import ModelDAO.CategoriaDAO;
import View.Menu;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

public class Main {
    private boolean Saveresultaso=false;
    CategoriaDAO catDAO = new CategoriaDAO();
    //Funcionarios funcion = new Funcionarios();
    PreparedStatement pStatement = null;
    
    @Getter@Setter
    public static int ativaSaveBD=0;
    
    public static void main(String[] args) {
        
            
        Menu telaMenu = new Menu();
        telaMenu.setVisible(true);//Fun�ao padrao para ativar a tela
        /*
        Funcionarios funcion = new Funcionarios(0,"","","","","");
        funcion.setId(1);
        funcion.setNome("Daniel");
        funcion.setCpf("12918291912");
        funcion.setEmail("Daniel@Gmail.com");
        funcion.setTelefone("32999999999");
        funcion.setContaBanco("32999999999");
        funcion.Leitura();
        
        /*
        try {
            
            //Funcionarios.Salva();
            
            //boolean b;
            //CategoriaDAO.savee();
            //System.out.println("SQL:"+b);

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}

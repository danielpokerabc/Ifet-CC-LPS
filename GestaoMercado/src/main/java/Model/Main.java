/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Model;

import ModelDAO.CategoriaDAO;
import View.Menu;
import View.ViewLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.Getter;
import lombok.Setter;

public class Main {
    
    public static void main(String[] args) {
        
        ViewLogin viewLogin = new ViewLogin();
        viewLogin.setVisible(true);//Fun�ao padrao para ativar a tela
        //Menu telaMenu = new Menu();
        //telaMenu.setVisible(true);//Fun�ao padrao para ativar a tela
        
        
    }
}

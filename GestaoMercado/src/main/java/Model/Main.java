/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Model;

import View.CRUDCliente;
import View.CRUDProdutos;
import View.MenuPrincipal;
import View.SelectImagens;
import View.ViewLogins;

public class Main {
    
    public static void main(String[] args) {
        
        MenuPrincipal telaMenu = new MenuPrincipal();
        //CRUDCliente telaMenu = new CRUDCliente();
        //telaMenu.setVisible(true);//Fun�ao padrao para ativar a tela
        //CRUDProdutos telaMenu = new CRUDProdutos();
        telaMenu.setVisible(true);
        
    }
}

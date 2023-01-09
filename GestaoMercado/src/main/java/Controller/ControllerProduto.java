/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ProdutosDAOs;
import java.io.IOException;


public class ControllerProduto {
    
    public static void LerTabelaProdutosBD(){
        
        ProdutosDAOs.LerTabelaProdutos();
    
    }
    
    public static void AdicionaProdutosBD() throws IOException{
        ProdutosDAOs.AdicionaProdutos();
    }
    
    public static void EditaProdutosBD(){
        ProdutosDAOs.EditaTabelaProdutos();
    }
    
    public void DeletaProdutosBD(int ids){
        
    }
    
}

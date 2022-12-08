/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PDaniel
 */
public class Produtos {
    @Getter@Setter
    public static String Nome;
    @Getter@Setter
    public static String CodBarras;
    @Getter@Setter
    public static String DataVencimento;
    @Getter@Setter
    public static String[][] DataProduto = new String[8][8];
    
    public static void cadastroProduto(){
        
        DataProduto[0][0] = getNome()+"";
        DataProduto[0][1] = getCodBarras()+"";
        DataProduto[0][2] = getDataVencimento()+"";
        
        System.out.println(DataProduto[0][0]+DataProduto[0][1]+DataProduto[0][2]);
        
    }
}

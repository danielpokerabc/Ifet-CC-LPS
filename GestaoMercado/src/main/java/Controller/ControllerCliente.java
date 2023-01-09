/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ClienteDAOs;
import static Model.DAO.ClienteDAOs.AdicionaCliente;
import static Model.DAO.ClienteDAOs.EditaTabelaClientes;

public class ControllerCliente {
    
    public static void LerTabelaClientesBD(){
        
        ClienteDAOs.LerTabelaClientes();
    
    }
    
    public static void AdicionaClienteBD(){
        AdicionaCliente();
    }
    
    public static void EditaClienteBD(){
        EditaTabelaClientes();
    }
    
    public static void DeletaClienteBD(int ids){
        ClienteDAOs.DeletaRegistroClientes(ids);
    }
    
}

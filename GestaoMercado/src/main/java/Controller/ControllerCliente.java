/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ClienteDAOs;
import static Model.DAO.ClienteDAOs.AdicionaCliente;
import static Model.DAO.ClienteDAOs.EditaTabelaClientes;
import Model.Validate.ValidateCPFs;
import javax.swing.JOptionPane;

public class ControllerCliente {
    public static boolean ReturnVerificacaoCPF=false;
    
    public static void LerTabelaClientesBD(){
        
        ClienteDAOs.LerTabelaClientes();
    
    }
    
    public static void AdicionaClienteBD(String cpf){
        ReturnVerificacaoCPF=false;
        if(ValidateCPFs.validCPF(cpf)){
            AdicionaCliente();
            ReturnVerificacaoCPF=true;
        }
        if(!ValidateCPFs.validCPF(cpf)){
            JOptionPane.showMessageDialog(null, "CPF Invalido!!!!");
            
        }
    }
    
    public static void EditaClienteBD(String cpf){
        ReturnVerificacaoCPF=false;
        if(ValidateCPFs.validCPF(cpf)){
            EditaTabelaClientes();
            ReturnVerificacaoCPF = true;
        }
        if(!ValidateCPFs.validCPF(cpf)){
            JOptionPane.showMessageDialog(null, "CPF Invalido!!!!");
            
        }
    }
    
    public static void DeletaClienteBD(int ids){
        ClienteDAOs.DeletaRegistroClientes(ids);
    }
    
}

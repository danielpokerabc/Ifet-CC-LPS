/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.VerificaLoginDAO;

/**
 *
 * @author PDaniel
 */
public class ControllerLogins {
    
    public static void ControllerVerificaLogin(String login, String senha){
        VerificaLoginDAO.VerificaLogin(login, senha);
    }
    
}

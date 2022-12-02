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
public class Pessoa {
        @Getter@Setter
        public static String Nome;
        @Getter@Setter
        public static String Email;
        @Getter@Setter
        public static Integer id;

        @Getter@Setter
        public static String Telefone;
        @Getter@Setter
        public static String Cpf;
        @Getter@Setter
        public static String ContaBanco;
        public Pessoa(Integer id,String Nome, String Email,String Telefone,String Cpf,String ContaBanco) {
                    this.Nome = Nome;
                    this.Email = Email;
                    this.Telefone = Telefone;
                    this.Cpf = Cpf;
                    this.ContaBanco = ContaBanco;
                    this.id=id;
                    //this.data_nascimento = _data;
        }
}

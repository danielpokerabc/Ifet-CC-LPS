/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.GerenciamentoFuncionarios;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PDaniel
 */

public class Funcionarios extends Pessoa{

    
    
    
    
    @Getter@Setter
    public static String[][] Data;// = new String[8][8];
    
    
    public Funcionarios(Integer id,String Nome, String Email,String Telefone,String Cpf,String ContaBanco) {
        super(id,Nome,Email,Telefone,Cpf,ContaBanco);
    }
    public String funcion;
    public static void salva(){
        try {
            FileWriter fw = new  FileWriter("Funcionario.txt", true);
            PrintWriter pw = new PrintWriter(fw,true);//escreve e pula linhas
            pw.print(getNome());
            pw.print(";");
            pw.print(getCpf());
            pw.print(";");
            pw.print(getEmail());
            pw.print(";");
            pw.print(getTelefone());
            pw.print(";");
            pw.print(getContaBanco());
            
            pw.println("");
            pw.flush();//envia os dados ao vivo
            pw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(GerenciamentoFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void Leitura(){
        try {
            FileReader arq = new FileReader("Funcionario.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            //Funcionarios funcion = new Funcionarios();
            
            try {
                Path file = Paths.get("Funcionario.txt");

                long count = Files.lines(file).count();
                System.out.println("Total Lines: " + count);
                Data = new String[(int)count][7];

            } catch (Exception ex) {
                Logger.getLogger(Funcionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String linha="";
            String[] textoSeparado;// = linha.split(";");
            int i=0;
            try {
                linha = lerArq.readLine();
                
                while(linha != null){
                    
                    
                    textoSeparado = linha.split(";");
                    /*
                    funcion.setId(1);
                    funcion.setNome(textoSeparado[0]);
                    funcion.setCpf(textoSeparado[1]);
                    funcion.setEmail(textoSeparado[2]);
                    funcion.setTelefone(textoSeparado[3]);
                    funcion.setContaBanco(textoSeparado[4]);
                    */                    
                    
                    Data[i][0]=textoSeparado[0]+"";
                    Data[i][1]=textoSeparado[1]+"";
                    Data[i][2]=textoSeparado[2]+"";
                    Data[i][3]=textoSeparado[3]+"";
                    Data[i][4]=textoSeparado[4]+"";
                    linha = lerArq.readLine();
                    i+=1;
                }
                //System.out.print(Data);
            } catch (IOException ex ) {
                Logger.getLogger(Funcionarios.class.getName()).log(Level.SEVERE, null, ex);
            }catch (ArrayIndexOutOfBoundsException ex ) {
                Logger.getLogger(Funcionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Funcionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
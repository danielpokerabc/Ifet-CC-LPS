/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.DAO.ProdutosDAOs;
import Model.DAO.VerificaLoginDAO;
import Model.Gerentes;
import Model.Pessoa;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PDaniel
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    
    public ActionListener btnCLick;
    public int contBtn = 0;
    int BarraX=0;
    int BarraY=0;
    int i=0;
    int Linha=0;
    int LColuna=0;
    private boolean AtivaBarra=false;
    
    private Image imagem0;
    @Getter@Setter
    public static String nome;
    
    /**
     * Creates new form MenuPrograma
     */
    public MenuPrincipal() {
        initComponents();
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(749, 400);
        i=0;
        jButton1.setSize(40, 20);
        jButton1.setIcon(new ImageIcon("src\\main\\java\\Image\\BuyCars00.png"));
        
        ProdutosDAOs.LerTabelaProdutos();
        for(i=0;i<ProdutosDAOs.getLinhasCounts()-1;i++){
            
            if(AtivaBarra){
                BarraY+=110;
            }
            
            if(((i%3) == 0)&& (i!=0)){
                LColuna+=148;//110
                Linha=0;
                AtivaBarra=true;
            }
            Botao();
            Linha+=237;
            System.out.println(i);
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        BLogin = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1007, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        BLogin.setText("Login");
        BLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLoginActionPerformed(evt);
            }
        });

        jButton2.setText("Cadastrar");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Bem Vindo!");

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(67, 67, 67)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BLogin)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BLogin)
                        .addComponent(jButton2)
                        .addComponent(jLabel1))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLoginActionPerformed
        // TODO add your handling code here:
        if(VerificaLoginDAO.LoginConfirm==1){
            VerificaLoginDAO.LoginConfirm=0;
            BLogin.setText("Login");
            JOptionPane.showMessageDialog(null, "Deslogado com Sucesso!!!!");
            jLabel1.setText("Bem Vindo!");
            
        }else{
            ViewLogins viewLogin = new ViewLogins();
            viewLogin.setVisible(true);//Fun�ao padrao para ativar a tela
            
        }
    }//GEN-LAST:event_BLoginActionPerformed

    public static void BLogin(){
        BLogin.setText("Sair");
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CadastroClientes telaMenu = new CadastroClientes();
        telaMenu.setVisible(true);//Fun�ao padrao para ativar a tela
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.print("zzzz");
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void BotaoMaisMenos(){
        JTextField jTextField = new JTextField();
        jTextField.setLocation(100, 100);
        jPanel1.add(jTextField);
    }
   
    public void Botao(){
        
        JButton adicionar = new JButton();
        adicionar.setText("");
        adicionar.setForeground(Color.BLACK);
        adicionar.setMargin(new Insets(2, 10, 2, 14));
        adicionar.setFont(new Font("Linux libertine G", Font.BOLD, 12));
        adicionar.setSize(237, 105);
        adicionar.setLocation(0, 0);
        adicionar.setContentAreaFilled(false);//desativa efeito botao
        adicionar.setBorderPainted(false);
        adicionar.setPreferredSize(new Dimension(107, 105));
        
        adicionar.setIcon(new ImageIcon("src\\main\\java\\Image\\ProdutoIds"+ProdutosDAOs.DataProduto[i][0]+".png"));
        
        //jPanel1.add(adicionar);
        jPanel1.setPreferredSize(new Dimension(BarraX, BarraY));
        BotaoMaisMenos();
        
        JDesktopPane jDesktopPane1 = new JDesktopPane();
        jDesktopPane1.setSize(227, 135);
        jDesktopPane1.setLocation(Linha, LColuna);
        jDesktopPane1.add(adicionar);
        
        JTextField jTextField = new JTextField();
        jTextField.setLocation(100, 110);
        jTextField.setToolTipText("Quantidade");
        jTextField.setSize(40, 20);
        jDesktopPane1.add(jTextField);
        
        JButton Bmais = new JButton();
        Bmais.setText("+");
        Bmais.setForeground(Color.BLACK);
        Bmais.setMargin(new Insets(2, 10, 2, 14));
        Bmais.setFont(new Font("Linux libertine G", Font.BOLD, 17));
        Bmais.setSize(40, 20);
        Bmais.setLocation(130, 110);
        Bmais.setContentAreaFilled(false);//desativa efeito botao
        Bmais.setBorderPainted(false);
        jDesktopPane1.add(Bmais);
        
        JButton Bmenos = new JButton();
        Bmenos.setText("-");
        Bmenos.setForeground(Color.BLACK);
        Bmenos.setMargin(new Insets(2, 10, 2, 14));
        Bmenos.setFont(new Font("Linux libertine G", Font.BOLD, 17));
        Bmenos.setSize(40, 20);
        Bmenos.setLocation(70, 110);
        Bmenos.setContentAreaFilled(false);//desativa efeito botao
        Bmenos.setBorderPainted(false);
        jDesktopPane1.add(Bmenos);
        
        jPanel1.add(jDesktopPane1);
                
        //jPanel1.revalidate();
        //jPanel1.repaint();
                
    }
    public static void main(String args[]) {
        int a=0;
        a+=1;
        System.out.print(""+a);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

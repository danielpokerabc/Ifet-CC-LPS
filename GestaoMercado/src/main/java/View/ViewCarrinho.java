/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.DAO.ProdutosDAOs;
import Model.DAO.VerificaLoginDAO;
import Model.Pessoa;
import static View.MenuPrincipal.ProdutoConts;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PDaniel
 */
public class ViewCarrinho extends javax.swing.JFrame {
    
    
    public ActionListener btnCLick;
    public int contBtn = 0;
    int BarraX=0;
    int BarraY=0;
    int i=0;
    int Linha=0;
    int LColuna=0;
    public String JTextoCompra=null;
    private boolean AtivaBarra=false;
    public float ValorMaximo=0; 
    public int ProdutoLocalVetores=0;
    
    @Getter@Setter
    public static String nome;
    
    /**
     * Creates new form MenuPrograma
     */
    public ViewCarrinho() {
        initComponents();
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(749, 450);
        i=0;
        
        
        ProdutosDAOs.LerTabelaProdutos();
        Nome.setText("Nome: "+Pessoa.getNome());
        Telefone.setText("Telefone: "+Pessoa.getTelefone());
        EnderecoTexto.setText("Endereço: "+Pessoa.getContaBanco());
        
        for(i=0;i<ProdutosDAOs.getLinhasCounts()-1;i++){
            EnderecoTexto.setText("Endereço: "+Pessoa.getContaBanco());
            //ProdutosDAOs.DataProduto[i][0]
            if(ProdutoConts[(Integer.parseInt(ProdutosDAOs.DataProduto[i][0]))] != 0){
                JTextoCompra ="Produto: "+ProdutosDAOs.DataProduto[i][1]
                        +" X Quantidade: "+ProdutoConts[(Integer.parseInt(ProdutosDAOs.DataProduto[i][0]))]
                        +" X Preço: "+Float.parseFloat(ProdutosDAOs.DataProduto[i][4])
                        +" X Valor Total: "+Float.parseFloat(ProdutosDAOs.DataProduto[i][4])*ProdutoConts[(Integer.parseInt(ProdutosDAOs.DataProduto[i][0]))];
                ValorMaximo += Float.parseFloat(ProdutosDAOs.DataProduto[i][4])*ProdutoConts[(Integer.parseInt(ProdutosDAOs.DataProduto[i][0]))];
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
            
            }else{
                JTextoCompra =null;
            }
            
        }
        EnderecoTexto1.setText("Valor Total: "+ValorMaximo); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AdicionaCarrinho = new javax.swing.JButton();
        EnderecoTexto = new javax.swing.JLabel();
        EnderecoTexto1 = new javax.swing.JLabel();
        Nome = new javax.swing.JLabel();
        Telefone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Carrinho");

        AdicionaCarrinho.setText("Confirmar Compras");
        AdicionaCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionaCarrinhoActionPerformed(evt);
            }
        });

        EnderecoTexto.setText("Endereço:");

        EnderecoTexto1.setText("Valor Total:");

        Nome.setText("Nome:");

        Telefone.setText("Telefone:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AdicionaCarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EnderecoTexto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EnderecoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EnderecoTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdicionaCarrinho))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(EnderecoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdicionaCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionaCarrinhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdicionaCarrinhoActionPerformed

    public void Botao(){
        
        JLabel jlabel= new JLabel();
        jlabel.setText(JTextoCompra);
        jlabel.setForeground(Color.BLACK);
        jlabel.setFont(new Font("Linux libertine G", Font.BOLD, 18));
        
        
        jPanel1.setLayout(new GridLayout(0,1, 5, 5));
        jlabel.setBorder(BorderFactory.createLineBorder(Color.black));
        jlabel.setHorizontalAlignment(SwingConstants.CENTER);
        jlabel.setVerticalAlignment(SwingConstants.CENTER);        
        
        jPanel1.setPreferredSize(new Dimension(BarraX, BarraY));
        jPanel1.add(jlabel);
                        
    }
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionaCarrinho;
    private javax.swing.JLabel EnderecoTexto;
    private javax.swing.JLabel EnderecoTexto1;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Telefone;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

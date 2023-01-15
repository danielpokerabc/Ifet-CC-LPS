/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ControllerProduto;
import Model.DAO.ProdutosDAOs;
import Model.Produtos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CRUDProdutos extends javax.swing.JFrame {

    /**
     * Creates new form CRUDProdutos
     */
    private int idVerifica=0;
    
    public CRUDProdutos() {
        
        initComponents();
        habilitarDesabilitaCampos(false);
        jTable();
        ButtonImage.setIcon(new ImageIcon("src\\main\\java\\Image\\cancel_32x32.png"));
        SetCampoImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodBarras = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDataVencimento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        ButtonNew = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ButtonNew1 = new javax.swing.JButton();
        txtPreco1 = new javax.swing.JTextField();
        ButtonImage = new javax.swing.JButton();
        Apagars = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Cod. de Barras:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Gerenciamento de Produtos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nome do Produto:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Cod. de Barras:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Data de Vencimento:");

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Cod. de Barras", "Data Vencimento"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Preço:");

        ButtonNew.setText("Novo");
        ButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNewActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Adicione uma Imagem 227x105:");

        ButtonNew1.setText("...");
        ButtonNew1.setContentAreaFilled(false);
        ButtonNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNew1ActionPerformed(evt);
            }
        });

        txtPreco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPreco1ActionPerformed(evt);
            }
        });

        ButtonImage.setBorderPainted(false);
        ButtonImage.setContentAreaFilled(false);
        ButtonImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonImageActionPerformed(evt);
            }
        });

        Apagars.setText("Apagar");
        Apagars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApagarsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNomeProduto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCodBarras, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(7, 7, 7)
                                            .addComponent(Apagars))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                            .addComponent(txtDataVencimento, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPreco1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonNew1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(ButtonImage, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(15, 15, 15))))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1)
                        .addComponent(txtCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonImage, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonNew1)
                    .addComponent(txtPreco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonNew)
                    .addComponent(Apagars))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void jTable(){
        ControllerProduto.LerTabelaProdutosBD();
        String Titulo[] ={"Id","Nome do Produto", "Cod. de Barras", "Data de Vencimento", "Preco"};
        
        DefaultTableModel model = new DefaultTableModel(ProdutosDAOs.DataProduto,Titulo);
        jTable3.setModel(model);
        
        
        //System.out.println("Tamanho matrix: "+GerenteDAO.DataProduto.length);
    }
    public void habilitarDesabilitaCampos(boolean flag) {
        txtNomeProduto.setEnabled(flag);
        txtCodBarras.setEnabled(flag);
        txtDataVencimento.setEnabled(flag);
        txtPreco.setEnabled(flag);
        txtPreco1.setEnabled(flag);
        ButtonNew1.setEnabled(flag);
        
    }
    public void limparCampos() {
        txtNomeProduto.setText("");
        txtCodBarras.setText("");
        txtDataVencimento.setText("");
        txtPreco.setText("");
        txtPreco1.setText("");
    }
    public static void SetCampoImage(){
        if(ProdutosDAOs.getStringDiretorioImage()!=null){
            txtPreco1.setText(ProdutosDAOs.getStringDiretorioImage());
        }else{
            txtPreco1.setText("");
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if((idVerifica == 0)&&(!txtNomeProduto.getText().isEmpty())&&(!txtCodBarras.getText().isEmpty())&&(!txtDataVencimento.getText().isEmpty())&&(!txtPreco.getText().isEmpty())){
            Produtos.setNome(txtNomeProduto.getText());
            Produtos.setCodBarras(txtCodBarras.getText());
            Produtos.setDataVencimento(txtDataVencimento.getText());
            Produtos.setPreco(txtPreco.getText());

            try {
                ControllerProduto.AdicionaProdutosBD();
            } catch (IOException ex) {
                Logger.getLogger(CRUDProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if((idVerifica == 1)&&(!txtNomeProduto.getText().isEmpty())&&(!txtCodBarras.getText().isEmpty())&&(!txtDataVencimento.getText().isEmpty())&&(!txtPreco.getText().isEmpty())){
            Produtos.setNome(txtNomeProduto.getText());
            Produtos.setCodBarras(txtCodBarras.getText());
            Produtos.setDataVencimento(txtDataVencimento.getText());
            Produtos.setPreco(txtPreco.getText());
            
            ControllerProduto.EditaProdutosBD();
            ControllerProduto.LerTabelaProdutosBD();
            
            idVerifica=0;
        }
        if((txtNomeProduto.getText().isEmpty())&&(txtCodBarras.getText().isEmpty())&&(txtDataVencimento.getText().isEmpty())&&(txtPreco.getText().isEmpty())){
            
            JOptionPane.showMessageDialog(null, "Preencher todos os dados!!!!");
        }
        
        
        jTable();
        habilitarDesabilitaCampos(false);
        limparCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNewActionPerformed
        // TODO add your handling code here:
        habilitarDesabilitaCampos(true);
        idVerifica=0;
        limparCampos();
    }//GEN-LAST:event_ButtonNewActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        habilitarDesabilitaCampos(true);
        
        DefaultTableModel tmodel=(DefaultTableModel)jTable3.getModel();
        int selectPosicaoTable = jTable3.getSelectedRow();
        
        Produtos.setId(Integer.parseInt(tmodel.getValueAt(selectPosicaoTable, 0).toString()));
        
        txtNomeProduto.setText(tmodel.getValueAt(selectPosicaoTable, 1).toString());
        txtCodBarras.setText(tmodel.getValueAt(selectPosicaoTable, 2).toString());
        txtDataVencimento.setText(tmodel.getValueAt(selectPosicaoTable, 3).toString());
        txtPreco.setText(tmodel.getValueAt(selectPosicaoTable, 4).toString());
        
        
        //System.out.println("Produtos.getId: "+Produtos.getId());
        ButtonImage.setIcon(new ImageIcon("src\\main\\java\\Image\\ProdutoIds"+Produtos.getId().toString() +".png"));
        
        
        idVerifica=1;
    }//GEN-LAST:event_jTable3MouseClicked

    private void ButtonNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNew1ActionPerformed
        // TODO add your handling code here:
        SelectImagens SImagem = new SelectImagens();
        SImagem.setVisible(true);
    }//GEN-LAST:event_ButtonNew1ActionPerformed

    private void ButtonImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonImageActionPerformed
        //ButtonImage.setIcon(new ImageIcon("src\\main\\java\\Image\\feijao.png"));
    }//GEN-LAST:event_ButtonImageActionPerformed

    private void txtPreco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPreco1ActionPerformed
        // TODO add your handling code here:
        if(ProdutosDAOs.getStringDiretorioImage()!=null){
            txtPreco1.setText(ProdutosDAOs.getStringDiretorioImage());
        }else{
            txtPreco1.setText("");
        }
        
    }//GEN-LAST:event_txtPreco1ActionPerformed

    private void ApagarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApagarsActionPerformed
        // TODO add your handling code here:
        ProdutosDAOs.DeletaRegistroProdutos(Produtos.getId());
        ProdutosDAOs.LerTabelaProdutos();
        habilitarDesabilitaCampos(false);
        jTable();
        ButtonImage.setIcon(new ImageIcon("src\\main\\java\\Image\\cancel_32x32.png"));
        SetCampoImage();
        limparCampos();
    }//GEN-LAST:event_ApagarsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUDProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDProdutos().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Apagars;
    private static javax.swing.JButton ButtonImage;
    private javax.swing.JButton ButtonNew;
    private javax.swing.JButton ButtonNew1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField txtCodBarras;
    private javax.swing.JTextField txtDataVencimento;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPreco;
    public static javax.swing.JTextField txtPreco1;
    // End of variables declaration//GEN-END:variables
}

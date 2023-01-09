/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ControllerCliente;
import Model.Cliente;
import static Model.DAO.ClienteDAOs.DataCliente;
import Model.DAO.GerenteDAOs;
import Model.Gerentes;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PDaniel
 */
public class CRUDCliente extends javax.swing.JFrame {

    /**
     * Creates new form CadastroFuncionarios
     */
    private int idVerifica=0;
    public CRUDCliente() {
        initComponents();
        habilitarDesabilitaCampos(false);
        
        Jtable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        TextNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextCPF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextTelefone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextContaBanco = new javax.swing.JTextField();
        jButton2SalvaConfirmado = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMenu1.setText("jMenu1");

        jTextField4.setText("jTextField4");

        jButton1.setText("jButton1");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNomeActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Gerenciamento de Clientes");

        jLabel3.setText("Cpf:");

        jTextCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCPFActionPerformed(evt);
            }
        });

        jLabel4.setText("Email:");

        jTextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEmailActionPerformed(evt);
            }
        });

        jLabel5.setText("Telefone:");

        jLabel6.setText("ContaBanco:");

        jButton2SalvaConfirmado.setText("Confirmar ");
        jButton2SalvaConfirmado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvaOUConfirma(evt);
            }
        });

        jButton5.setText("Novo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Apagar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Email", "Telefone", "Conta de Banco"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextNome))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextTelefone))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextContaBanco, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextEmail))))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2SalvaConfirmado)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextContaBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton2SalvaConfirmado)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCPFActionPerformed

    private void jTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextEmailActionPerformed
    public void limparCampos() {
        TextNome.setText("");
        jTextCPF.setText("");
        jTextEmail.setText("");
        jTextTelefone.setText("");
        jTextContaBanco.setText("");
    }
    
    public void Jtable(){
        String Titulo[] ={"id","Nome", "CPF", "Email", "Telefone", "Conta de Banco"};
        ControllerCliente.LerTabelaClientesBD();
        DefaultTableModel model = new DefaultTableModel(DataCliente,Titulo);
        jTable1.setModel(model);
    }
    private void BotaoSalvaOUConfirma(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvaOUConfirma
        // TODO add your handling code here:
        
        if((idVerifica==0) &&(!TextNome.getText().isEmpty())&&(!jTextCPF.getText().isEmpty())&&(!jTextEmail.getText().isEmpty())&&(!jTextTelefone.getText().isEmpty())&&(!jTextContaBanco.getText().isEmpty())){
            //Funcionarios funcion = new Gerentes(0,"","","","","");
        
            //Gerentes.setId(1);
            Cliente.setNome(TextNome.getText());
            Cliente.setCpf(jTextCPF.getText());
            Cliente.setEmail(jTextEmail.getText());
            Cliente.setTelefone(jTextTelefone.getText());
            Cliente.setContaBanco(jTextContaBanco.getText());

            ControllerCliente.AdicionaClienteBD();
            ControllerCliente.LerTabelaClientesBD();
            Jtable();
            limparCampos();
            habilitarDesabilitaCampos(false);
            idVerifica=0;
        }
        if((idVerifica==1) &&(!TextNome.getText().isEmpty())&&(!jTextCPF.getText().isEmpty())&&(!jTextEmail.getText().isEmpty())&&(!jTextTelefone.getText().isEmpty())&&(!jTextContaBanco.getText().isEmpty())){
            //Funcionarios funcion = new Gerentes(0,"","","","","");
        
            //Gerentes.setId(1);
            Cliente.setNome(TextNome.getText());
            Cliente.setCpf(jTextCPF.getText());
            Cliente.setEmail(jTextEmail.getText());
            Cliente.setTelefone(jTextTelefone.getText());
            Cliente.setContaBanco(jTextContaBanco.getText());

            ControllerCliente.EditaClienteBD();
            ControllerCliente.LerTabelaClientesBD();
            Jtable();
            limparCampos();
            habilitarDesabilitaCampos(false);
            idVerifica=0;
        }
        if((TextNome.getText()==null)&&(jTextCPF.getText()==null)&&(jTextEmail.getText()==null)&&(jTextTelefone.getText()==null)&&(jTextContaBanco.getText()==null)){
            PreencherCampo dialog = new PreencherCampo();
            dialog.setVisible(true);
            
        }
        
    }//GEN-LAST:event_BotaoSalvaOUConfirma

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        limparCampos();
        habilitarDesabilitaCampos(true);
        idVerifica=0;
    }//GEN-LAST:event_jButton5ActionPerformed
    public void habilitarDesabilitaCampos(boolean flag) {
        TextNome.setEnabled(flag);
        jTextCPF.setEnabled(flag);
        jTextEmail.setEnabled(flag);
        jTextTelefone.setEnabled(flag);
        jTextContaBanco.setEnabled(flag);
        
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(idVerifica==1){
            ControllerCliente.DeletaClienteBD(Cliente.getId());
            ControllerCliente.LerTabelaClientesBD();
            Jtable();
            limparCampos();
            habilitarDesabilitaCampos(false);
        }
        idVerifica=0;
    }//GEN-LAST:event_jButton6ActionPerformed

    private void TextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNomeActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel tmodel=(DefaultTableModel)jTable1.getModel();
        int selectPosicaoTable = jTable1.getSelectedRow();
        
        Cliente.setId(Integer.parseInt(tmodel.getValueAt(selectPosicaoTable, 0).toString()));
        TextNome.setText(tmodel.getValueAt(selectPosicaoTable, 1).toString());
        jTextCPF.setText(tmodel.getValueAt(selectPosicaoTable, 2).toString());
        jTextEmail.setText(tmodel.getValueAt(selectPosicaoTable, 3).toString());
        jTextTelefone.setText(tmodel.getValueAt(selectPosicaoTable, 4).toString());
        jTextContaBanco.setText(tmodel.getValueAt(selectPosicaoTable, 5).toString());
        habilitarDesabilitaCampos(true);
        idVerifica=1;
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(CRUDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new CRUDCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextNome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2SalvaConfirmado;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCPF;
    private javax.swing.JTextField jTextContaBanco;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextTelefone;
    // End of variables declaration//GEN-END:variables
}

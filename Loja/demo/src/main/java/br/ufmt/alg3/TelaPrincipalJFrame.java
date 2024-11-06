/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.ufmt.alg3;

/**
 *
 * @author aluno
 */
public class TelaPrincipalJFrame extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalJFrame
     */
    public TelaPrincipalJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        telaPrincipalMenuBar = new javax.swing.JMenuBar();
        arquivojMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        clientejMenu = new javax.swing.JMenu();
        cadastrarMenuItem = new javax.swing.JMenuItem();
        editarjMenuItem = new javax.swing.JMenuItem();
        excluirjMenuItem = new javax.swing.JMenuItem();
        sobrejMenu = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        arquivojMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufmt/alg3/imagens/page.png"))); // NOI18N
        arquivojMenu.setText("Arquivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufmt/alg3/imagens/door_out.png"))); // NOI18N
        jMenuItem1.setText("Sair");
        arquivojMenu.add(jMenuItem1);

        telaPrincipalMenuBar.add(arquivojMenu);

        clientejMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufmt/alg3/imagens/group.png"))); // NOI18N
        clientejMenu.setText("Clientes");

        cadastrarMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufmt/alg3/imagens/user_add.png"))); // NOI18N
        cadastrarMenuItem.setText("Cadastrar");
        cadastrarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarMenuItemActionPerformed(evt);
            }
        });
        clientejMenu.add(cadastrarMenuItem);

        editarjMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufmt/alg3/imagens/user_edit.png"))); // NOI18N
        editarjMenuItem.setText("Editar");
        clientejMenu.add(editarjMenuItem);

        excluirjMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufmt/alg3/imagens/user_delete.png"))); // NOI18N
        excluirjMenuItem.setText("Excluir");
        excluirjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirjMenuItemActionPerformed(evt);
            }
        });
        clientejMenu.add(excluirjMenuItem);

        telaPrincipalMenuBar.add(clientejMenu);

        sobrejMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufmt/alg3/imagens/information.png"))); // NOI18N
        sobrejMenu.setText("Sobre");

        jMenuItem4.setText("jMenuItem4");
        sobrejMenu.add(jMenuItem4);

        telaPrincipalMenuBar.add(sobrejMenu);

        setJMenuBar(telaPrincipalMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarMenuItemActionPerformed
                                                  
        jPanel1.removeAll();
        jPanel1.add(new CadastrarClienteJPanel());
        jPanel1.setVisible(false);
        jPanel1.setVisible(true);
              // TODO add your handling code here:
    }//GEN-LAST:event_cadastrarMenuItemActionPerformed

    private void excluirjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirjMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_excluirjMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu arquivojMenu;
    private javax.swing.JMenuItem cadastrarMenuItem;
    private javax.swing.JMenu clientejMenu;
    private javax.swing.JMenuItem editarjMenuItem;
    private javax.swing.JMenuItem excluirjMenuItem;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu sobrejMenu;
    private javax.swing.JMenuBar telaPrincipalMenuBar;
    // End of variables declaration//GEN-END:variables
}

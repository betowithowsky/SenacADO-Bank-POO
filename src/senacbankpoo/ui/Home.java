/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.ui;

import javax.swing.JFrame;
import senacbankpoo.ui.caixa.TelaCaixaCorrente;
import senacbankpoo.ui.caixa.TelaCaixaPoupanca;
import senacbankpoo.ui.clientes.TelaConsultaPessoaJuridica;
import senacbankpoo.ui.clientes.TelaConsultarPessoasFisicas;
import senacbankpoo.ui.contas.TelaConsultarContaPoupanca;
import senacbankpoo.ui.contas.TelaConsultarContasCorrente;

/**
 *
 * @author Beto
 */
public class Home extends javax.swing.JFrame {

    private TelaConsultarPessoasFisicas telaConsultarPessoasFisicas = null;
    private TelaConsultaPessoaJuridica telaConsultaPessoaJuridica = null;

    private TelaConsultarContasCorrente telaConsultarContasCorrente = null;
    private TelaConsultarContaPoupanca telaConsultarContaPoupanca = null;

    private TelaCaixaCorrente telaCaixaCorrente = null;
    private TelaCaixaPoupanca telaCaixaPoupanca = null;

    /**
     * Creates new form Home
     */
    public Home() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Clientes");

        jMenuItem1.setText("Gereneciador Pessoa Fisica");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Gerenciador Pessoa Jurídica");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Contas");

        jMenuItem3.setText("Gerenciar Contas Correntes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem5.setText("Gerenciar Contas Poupança");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Caixa Eletronico");

        jMenuItem4.setText("Home");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (telaConsultarPessoasFisicas == null || !telaConsultarPessoasFisicas.isDisplayable()) {
            telaConsultarPessoasFisicas = new TelaConsultarPessoasFisicas();
            telaConsultarPessoasFisicas.pack();
            telaConsultarPessoasFisicas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            telaConsultarPessoasFisicas.setLocationRelativeTo(null);
            telaConsultarPessoasFisicas.setVisible(true);
        }
        telaConsultarPessoasFisicas.toFront();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (telaConsultaPessoaJuridica == null || !telaConsultaPessoaJuridica.isDisplayable()) {
            telaConsultaPessoaJuridica = new TelaConsultaPessoaJuridica();
            telaConsultaPessoaJuridica.pack();
            telaConsultaPessoaJuridica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            telaConsultaPessoaJuridica.setLocationRelativeTo(null);
            telaConsultaPessoaJuridica.setVisible(true);
        }
        telaConsultaPessoaJuridica.toFront();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (telaConsultarContasCorrente == null || !telaConsultarContasCorrente.isDisplayable()) {
            telaConsultarContasCorrente = new TelaConsultarContasCorrente();
            telaConsultarContasCorrente.pack();
            telaConsultarContasCorrente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            telaConsultarContasCorrente.setLocationRelativeTo(null);
            telaConsultarContasCorrente.setVisible(true);
        }
        telaConsultarContasCorrente.toFront();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (telaCaixaCorrente == null || !telaCaixaCorrente.isDisplayable()) {
            telaCaixaCorrente = new TelaCaixaCorrente();
            telaCaixaCorrente.pack();
            telaCaixaCorrente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            telaCaixaCorrente.setLocationRelativeTo(null);
            telaCaixaCorrente.setVisible(true);
        }
        telaConsultarContasCorrente.toFront();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (telaCaixaPoupanca == null || !telaCaixaPoupanca.isDisplayable()) {
            telaCaixaPoupanca = new TelaCaixaPoupanca();
            telaCaixaPoupanca.pack();
            telaCaixaPoupanca.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            telaCaixaPoupanca.setLocationRelativeTo(null);
            telaCaixaPoupanca.setVisible(true);
        }
        telaConsultarContaPoupanca.toFront();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
}

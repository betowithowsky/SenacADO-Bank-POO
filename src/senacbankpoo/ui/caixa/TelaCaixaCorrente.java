/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.ui.caixa;

import javax.swing.JFrame;
import senacbankpoo.services.login.ServicoLoginCorrente;

/**
 *
 * @author Beto
 */
public class TelaCaixaCorrente extends javax.swing.JFrame {
    
    private TelaSaqueCorrente telaSaque = null;
    private TelaTransferencia telaTranferencia = null;
    private TelaDeposito telaDeposito = null;

    /**
     * Creates new form TelaCaixaHome
     */
    public TelaCaixaCorrente() {
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

        buttonDepositar = new javax.swing.JButton();
        buttonSacar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonTranferir = new javax.swing.JButton();
        LabelBoasVindas = new javax.swing.JLabel();
        LabelSaldo = new javax.swing.JLabel();

        buttonDepositar.setText("Depositar");

        buttonSacar.setText("Sacar");
        buttonSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSacarActionPerformed(evt);
            }
        });

        jButton4.setText("Sair");

        jLabel1.setText("Caixa Eletronico");

        buttonTranferir.setText("Transferir");
        buttonTranferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTranferirActionPerformed(evt);
            }
        });

        LabelBoasVindas.setText("Bem Vindo " + ServicoLoginCorrente.contaLogada.getNomeCliente());

        LabelSaldo.setText("Saldo: " + ServicoLoginCorrente.contaLogada.getSaldo());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonSacar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonDepositar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton4))
                            .addComponent(buttonTranferir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelBoasVindas)))
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelSaldo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelBoasVindas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelSaldo)
                .addGap(11, 11, 11)
                .addComponent(buttonTranferir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSacar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDepositar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTranferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTranferirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTranferirActionPerformed

    private void buttonSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSacarActionPerformed
        if (telaSaque == null || !telaSaque.isDisplayable()) {
                telaSaque = new TelaSaqueCorrente();
                telaSaque.pack();
                telaSaque.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                telaSaque.setLocationRelativeTo(null);
                telaSaque.setVisible(true);
            }
            telaSaque.toFront();
    }//GEN-LAST:event_buttonSacarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBoasVindas;
    private javax.swing.JLabel LabelSaldo;
    private javax.swing.JButton buttonDepositar;
    private javax.swing.JButton buttonSacar;
    private javax.swing.JButton buttonTranferir;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.ui.caixa;

import javax.swing.JFrame;
import senacbankpoo.services.caixaEletronico.ServicoCaixaEletronico;
import senacbankpoo.services.login.ServicoLoginCorrente;
import static senacbankpoo.services.login.ServicoLoginCorrente.contaLogada;

/**
 *
 * @author Beto
 */
public class TelaCaixaCorrente extends javax.swing.JFrame {
    
    private TelaSaqueCorrente telaSaque = null;
    private TelaTransferencia telaTranferencia = null;
    
    public double saldoSessao = ServicoCaixaEletronico.saldo(contaLogada.getId());


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

        buttonSacar = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        buttonTranferir = new javax.swing.JButton();
        LabelBoasVindas = new javax.swing.JLabel();
        labelIdClienteSessao = new javax.swing.JLabel();
        LabelSaldoConta = new javax.swing.JLabel();

        buttonSacar.setText("Sacar");
        buttonSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSacarActionPerformed(evt);
            }
        });

        buttonSair.setText("Logar");

        labelTitulo.setText("Caixa Eletronico");

        buttonTranferir.setText("Transferir");
        buttonTranferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTranferirActionPerformed(evt);
            }
        });

        LabelBoasVindas.setText("Bem Vindo " + senacbankpoo.services.login.ServicoLoginCorrente.contaLogada.getNomeCliente());

        labelIdClienteSessao.setText("Id:" + ServicoLoginCorrente.contaLogada.getId());

        LabelSaldoConta.setText("Saldo: " + saldoSessao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(labelTitulo))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelBoasVindas)))
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonSacar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonSair))
                            .addComponent(buttonTranferir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelIdClienteSessao)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelSaldoConta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelBoasVindas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelSaldoConta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIdClienteSessao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonTranferir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSacar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSair)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTranferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTranferirActionPerformed
        if (telaTranferencia == null || !telaTranferencia.isDisplayable()) {
                telaTranferencia = new TelaTransferencia();
                telaTranferencia.pack();
                telaTranferencia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                telaTranferencia.setLocationRelativeTo(null);
                telaTranferencia.setVisible(true);
                telaTranferencia.telaCaixaCorrente = this;
            }
            telaTranferencia.toFront();
    }//GEN-LAST:event_buttonTranferirActionPerformed

    private void buttonSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSacarActionPerformed
        if (telaSaque == null || !telaSaque.isDisplayable()) {
                telaSaque = new TelaSaqueCorrente();
                telaSaque.pack();
                telaSaque.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                telaSaque.setLocationRelativeTo(null);
                telaSaque.setVisible(true);
                telaSaque.telaCaixaCorrente = this;
            }
            telaSaque.toFront();
    }//GEN-LAST:event_buttonSacarActionPerformed

    public void atualizaSaldo (){
        LabelSaldoConta.setText("Saldo: " + ServicoCaixaEletronico.saldo(contaLogada.getId()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBoasVindas;
    private javax.swing.JLabel LabelSaldoConta;
    private javax.swing.JButton buttonSacar;
    private javax.swing.JButton buttonSair;
    private javax.swing.JButton buttonTranferir;
    private javax.swing.JLabel labelIdClienteSessao;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}

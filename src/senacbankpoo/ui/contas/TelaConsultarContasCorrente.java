/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.ui.contas;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import senacbankpoo.model.ContaCorrente;
import senacbankpoo.services.conta.ServicoContaCorrente;

/**
 *
 * @author Beto
 */
public class TelaConsultarContasCorrente extends javax.swing.JFrame {

    private TelaCriarContaCorrente telaCriarContaCorrente;
    
    /**
     * Creates new form TelaConsultarContas
     */
    public TelaConsultarContasCorrente() {
        initComponents();
        setTitle("Consultar Contas Corrente");
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoConta = new javax.swing.JTextField();
        botaoBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContasCorrente = new javax.swing.JTable();
        botaoCriarNovaConta = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();

        jLabel1.setText("Numero ou Nome do Titutal da Conta:");

        botaoBuscar.setText("Buscar");
        botaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarActionPerformed(evt);
            }
        });

        tabelaContasCorrente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Num.Conta", "Nome Titular", "Sobrenome Titular", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(tabelaContasCorrente);

        botaoCriarNovaConta.setText("Nova Conta");
        botaoCriarNovaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarNovaContaActionPerformed(evt);
            }
        });

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoBuscar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoCriarNovaConta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCriarNovaConta)
                    .addComponent(botaoSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarActionPerformed
        String pesquisa = campoConta.getText();
        try {
            ArrayList<ContaCorrente> contas = new ArrayList<ContaCorrente>();
            if(pesquisa.equals(""))
            contas = ServicoContaCorrente.listar();
            else
            contas = ServicoContaCorrente.procurarPeloClienteId(Integer.parseInt(pesquisa));

            if(contas.size() > 0)
            atualizarTabela(contas);
            else
            JOptionPane.showMessageDialog(rootPane, "Nenhuma Conta foi encontrada", "Aviso!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoBuscarActionPerformed

    private void atualizarTabela(ArrayList<ContaCorrente> contas) {
        DefaultTableModel model = (DefaultTableModel)tabelaContasCorrente.getModel();
        model.setRowCount(0);
        for (ContaCorrente conta : contas) {
            Object[] row = {
                conta.getNumConta(),
                conta.getNomeCliente(),
                conta.getSobrenomeCliente(),                
                conta.getSaldo()
            };
            model.addRow(row);
        }
    }
    
    private void botaoCriarNovaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarNovaContaActionPerformed
        //int selected = tabelaContas.getSelectedRow();
            try {
                if(telaCriarContaCorrente == null || !telaCriarContaCorrente.isDisplayable()) {
                    telaCriarContaCorrente = new TelaCriarContaCorrente();
                    telaCriarContaCorrente.pack();
                    telaCriarContaCorrente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    telaCriarContaCorrente.setLocationRelativeTo(null);
                    telaCriarContaCorrente.setVisible(true);
                }
                telaCriarContaCorrente.toFront();
                //DefaultTableModel model = (DefaultTableModel)clientesTabela.getModel();
                //String cpf = (String)model.getValueAt(selected, 0);
                //ContaCorrente contaCorrente = ServicoContaCorrente.procurarPeloNumero(cpf);

                //telaCriarContaCorrente.alterarCliente(contaCorrente);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_botaoCriarNovaContaActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoCriarNovaConta;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField campoConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaContasCorrente;
    // End of variables declaration//GEN-END:variables
}

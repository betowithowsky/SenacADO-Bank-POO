/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.repository.caixaeletronico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import senacbankpoo.connection.ConnectionUtils;
import senacbankpoo.model.Conta;
import senacbankpoo.model.ContaCorrente;
import senacbankpoo.model.PessoaJuridica;
import senacbankpoo.repository.contracts.IRepositorioCaixaEletronico;
import static senacbankpoo.services.login.ServicoLogin.contaLogada;

/**
 *
 * @author Beto
 */
public class RepositorioCaixaEletronico implements IRepositorioCaixaEletronico{
    
    static Connection connection;

    @Override
    public void saque(Object entity, double quantidade) {
        try {
            if(contaLogada.saque(quantidade) == true){
            connection = ConnectionUtils.getConnection();
            ContaCorrente conta = (ContaCorrente) entity;
            String sql = "UPDATE contaCorrente SET Saldo=? WHERE Id = ?";            
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setDouble(1, conta.getSaldo());
            pst.setInt(2, conta.getId());
            pst.execute();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposito(Conta conta, double quantidade) {
        conta.deposito(quantidade);
        System.out.println("Conlcúido.");
    }
    
}

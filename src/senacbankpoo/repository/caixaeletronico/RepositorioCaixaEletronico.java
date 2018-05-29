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
import static senacbankpoo.services.login.ServicoLoginCorrente.contaLogada;

/**
 *
 * @author Beto
 */
public class RepositorioCaixaEletronico implements IRepositorioCaixaEletronico{
    
    static Connection connection;

    @Override
    public void saque(int idConta, double quantidade) {
        try {
            if(contaLogada.getSaldo() > quantidade){
            double novoSaldo = contaLogada.getSaldo() - quantidade;
            connection = ConnectionUtils.getConnection();            
            String sql = "UPDATE contaCorrente SET Saldo = ? WHERE Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, novoSaldo);
            ps.setInt(2, idConta);           
            ps.execute();
                    
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

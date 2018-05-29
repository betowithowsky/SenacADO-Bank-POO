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
import senacbankpoo.model.PessoaJuridica;
import senacbankpoo.repository.contracts.IRepositorioCaixaEletronico;

/**
 *
 * @author Beto
 */
public class RepositorioCaixaEletronico implements IRepositorioCaixaEletronico{
    
    static Connection connection;

    @Override
    public void saque(Conta conta, double quantidade) {
        if(conta.saque(quantidade) == true){
            System.out.println("Ok, Sacou");
        }
        System.out.println("Não tem Saldo.");
    }

    @Override
    public void deposito(Conta conta, double quantidade) {
        conta.deposito(quantidade);
        System.out.println("Conlcúido.");
    }

    @Override
    public double saldo(Conta conta) {
        double saldo = conta.getSaldo();
        return saldo;
    }
    
}

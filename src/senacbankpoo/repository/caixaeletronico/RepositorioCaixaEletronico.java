/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.repository.caixaeletronico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import senacbankpoo.connection.ConnectionUtils;
import senacbankpoo.repository.contracts.IRepositorioCaixaEletronico;

/**
 *
 * @author Beto
 */
public class RepositorioCaixaEletronico implements IRepositorioCaixaEletronico{
    
    static Connection connection;

    @Override
    public void saque(int idContaOrigem, double valor) {
        try {
            if(saldo(idContaOrigem) > valor){
            connection = ConnectionUtils.getConnection();            
            String sql = "UPDATE contaCorrente SET Saldo = Saldo - ? WHERE Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, valor);
            ps.setInt(2, idContaOrigem);           
            ps.execute();
                    
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposito(int idContaOrigem, double valor) {
        try {
            connection = ConnectionUtils.getConnection();            
            String sql = "UPDATE contaCorrente SET Saldo = Saldo + ? WHERE numConta = " + idContaOrigem;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, valor);
            ps.execute();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public double saldo(int idContaOrigem){  
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "SELECT ContaCorrente.Saldo FROM ContaCorrente WHERE Id = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, idContaOrigem);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                double saldo = rs.getDouble("Saldo");
                return saldo;
            }
        
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public void transferencia(int idContaOrigem, int numContaDestino, double valor) {
        try {                     
            connection = ConnectionUtils.getConnection(); 
            
            String sql = "UPDATE contaCorrente SET Saldo = Saldo - ? WHERE Id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, valor);
            ps.setInt(2, idContaOrigem);   
            ps.execute();
            
            sql = "UPDATE contaCorrente SET Saldo = Saldo + ? WHERE numConta = ?";
            ps = connection.prepareStatement(sql);
            ps.setDouble(1, valor);
            ps.setInt(2, numContaDestino);           
            ps.execute();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

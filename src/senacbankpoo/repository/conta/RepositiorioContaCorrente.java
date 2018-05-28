/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.repository.conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import senacbankpoo.connection.ConnectionUtils;
import senacbankpoo.model.Conta;
import senacbankpoo.model.ContaCorrente;
import senacbankpoo.repository.contracts.IRepositorioConta;

/**
 *
 * @author Beto
 */
public class RepositiorioContaCorrente implements IRepositorioConta{
    
    static Connection connection;

    @Override
    public void inserir(Object entity) throws SQLException {
        try {
            connection = ConnectionUtils.getConnection();
            ContaCorrente conta = (ContaCorrente) entity;
            String sql = "INSERT INTO ContaCorrente(Saldo, Senha, ClienteId) VALUES (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setDouble(1, conta.getSaldo());
            pst.setString(2, conta.getPassword());
            pst.setInt(3, conta.getClienteId());
            pst.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Conta> listar() throws SQLException {
        ArrayList<Conta> contas = new ArrayList<Conta>();
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "SELECT * FROM ContaCorrente";
            
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                ContaCorrente conta = new ContaCorrente();
                conta.setId(rs.getInt("Id"));
                conta.setClienteId(rs.getInt("ClienteId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contas;
    }

    @Override
    public Object pegar(Integer id) throws SQLException {
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "SELECT * FROM ContaCorrente WHERE Id = ?";
            
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                ContaCorrente conta = new ContaCorrente();
                conta.setId(rs.getInt("Id"));
                conta.setClienteId(rs.getInt("ClienteId"));
                conta.setSaldo(rs.getDouble("Saldo"));
                return conta;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletar(Integer id) throws SQLException {
        try {
        connection = ConnectionUtils.getConnection();
        String sql = "DELETE FROM ContaCorrente WHERE id=?";
        
        PreparedStatement pst = connection.prepareStatement(sql);
        
        pst.setInt(1,id);
        
        
        pst.execute();
        
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

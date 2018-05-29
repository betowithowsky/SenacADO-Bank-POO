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
public class RepositorioContaCorrente implements IRepositorioConta{
    
    static Connection connection;

    @Override
    public void inserir(Object entity) throws SQLException {
        try {
            connection = ConnectionUtils.getConnection();
            ContaCorrente conta = (ContaCorrente) entity;
            String sql = "INSERT INTO ContaCorrente(numConta, Saldo, Senha, ClienteId) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, conta.getNumConta());
            pst.setDouble(2, 0);
            pst.setString(3, conta.getPassword());
            pst.setInt(4, conta.getClienteId());
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
    
    @Override
    public Object procurarPeloNumConta(int numConta) throws SQLException {
    try {
            connection = ConnectionUtils.getConnection();
            String sql = "SELECT * FROM ContaCorrente WHERE NumConta = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, numConta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ContaCorrente contaCorrente = new ContaCorrente();
                contaCorrente.setId(rs.getInt("id"));
                contaCorrente.setClienteId(rs.getInt("ClienteId"));
                contaCorrente.setSaldo(rs.getDouble("Saldo"));
                return contaCorrente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;    }

    @Override
    public boolean verificaNumeroConta(String numConta) throws SQLException {
        try {
            connection = ConnectionUtils.getConnection();
            
            String sql = "SELECT * FROM ContaCorrente WHERE numConta = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, numConta);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Object buscarPorIdCliente(int idCliente) throws SQLException {
 ArrayList<ContaCorrente> clientes = new ArrayList();
        try {
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM ContaCorrente WHERE ClienteId = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, String.valueOf(idCliente));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ContaCorrente contaCorrente = new ContaCorrente();
                contaCorrente.setId(rs.getInt("id"));
                contaCorrente.setClienteId(rs.getInt("ClienteId"));
                contaCorrente.setSaldo(rs.getDouble("Saldo"));
                return contaCorrente;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return clientes;
    }
    
}

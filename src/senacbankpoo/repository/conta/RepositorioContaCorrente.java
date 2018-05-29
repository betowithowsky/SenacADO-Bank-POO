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
    public ArrayList<ContaCorrente> listar() throws SQLException {
        ArrayList<ContaCorrente> contas = new ArrayList<ContaCorrente>();
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "SELECT PessoaFisica.NOME, PessoaFisica.SOBRENOME, ContaCorrente.NUMCONTA, CONTACORRENTE.SALDO FROM PessoaFisica INNER JOIN contaCorrente ON PessoaFisica.ID = contaCorrente.clienteId";
            
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                ContaCorrente conta = new ContaCorrente();
                conta.setNomeCliente(rs.getString("nome"));
                conta.setSobrenomeCliente(rs.getString(("sobrenome")));
                conta.setnumConta(rs.getInt("numConta"));
                conta.setSaldo(rs.getDouble(("Saldo")));
                contas.add(conta);
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
 ArrayList<ContaCorrente> contas = new ArrayList();
        try {
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT PessoaFisica.NOME, PessoaFisica.SOBRENOME, ContaPoupanca.NUMCONTA, CONTAPOUPANCA.SALDO  FROM PessoaFisica INNER JOIN ContaPoupanca ON PessoaFisica.ID = contaPoupanca.clienteId WHERE ClienteId = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, String.valueOf(idCliente));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ContaCorrente conta = new ContaCorrente();
                conta.setNomeCliente(rs.getString("nome"));
                conta.setSobrenomeCliente(rs.getString(("sobrenome")));
                conta.setnumConta(rs.getInt("numConta"));
                conta.setSaldo(rs.getDouble(("Saldo")));
                contas.add(conta);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return contas;
    }
    
    @Override
    public Object loginConta(int numConta, String senha) throws SQLException {
        try {
            connection = ConnectionUtils.getConnection();
            
            String sql = "SELECT PessoaFisica.NOME, PessoaFisica.SOBRENOME, ContaCorrente.NUMCONTA, CONTACORRENTE.SALDO, CONTACORRENTE.SENHA FROM PessoaFisica INNER JOIN ContaCorrente ON PessoaFisica.ID = contaCorrente.clienteId WHERE numConta = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, numConta);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ContaCorrente conta = new ContaCorrente();
                conta.setNomeCliente(rs.getString("nome"));
                conta.setSobrenomeCliente(rs.getString(("sobrenome")));
                conta.setnumConta(rs.getInt("numConta"));
                conta.setPassword(rs.getString("senha"));
                conta.setSaldo(rs.getDouble(("Saldo")));                
                if(senha.equals(conta.getPassword())){
                return conta;
                }
                
            }          
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
}

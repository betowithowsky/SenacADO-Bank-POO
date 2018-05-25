/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.repository.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import senacbankpoo.connection.ConnectionUtils;
import senacbankpoo.model.Pessoa;
import senacbankpoo.model.PessoaFisica;
import senacbankpoo.repository.contracts.IRepositorio;

/**
 *
 * @author Beto
 */
public class RepositiorioPessoaFisica implements IRepositorio{
    
    static Connection connection;

    @Override
    public void inserir(Object entity) throws SQLException {
        try{
            connection = ConnectionUtils.getConnection();
            PessoaFisica cliente = (PessoaFisica) entity;
            String sql = "INSERT INTO PessoaFisica(Nome, Sobrenome, CPF, DataNascimento, DataRegistro) VALUES (?, ?, ?, ?, CURRENT_DATE)";
            PreparedStatement pst = connection.prepareStatement(sql);
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            pst.setString(1, cliente.getNome());
            pst.setString(2, format.format(cliente.getDataNascimento()));
            pst.setInt(3, cliente.getGenero());
            pst.setString(4, cliente.getCpf());
            pst.execute();
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Object listar() throws SQLException {
        ArrayList<PessoaFisica> clientes = new ArrayList<PessoaFisica>();
        try {
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM PessoaFisica";

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                PessoaFisica cliente = new PessoaFisica();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
                cliente.setGenero(rs.getInt("GeneroId"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Object pegar(Integer id) throws SQLException {
        try {
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM PessoaFisica WHERE Id = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                PessoaFisica cliente = new PessoaFisica();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
                cliente.setGenero(rs.getInt("GeneroId"));
                return cliente;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void atualizar(Object entity) throws SQLException {
        try {
            PessoaFisica cliente = (PessoaFisica) entity;
            connection = ConnectionUtils.getConnection();
            String sql = "UPDATE PessoaFisica SET Nome=?, DataNascimento=?, GeneroId=?, CPF=? WHERE Id = ?";

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, format.format(cliente.getDataNascimento()));
            ps.setInt(3, cliente.getGenero());
            ps.setString(4, cliente.getCpf());
            ps.setInt(9, cliente.getId());
            
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Integer id) throws SQLException {
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "DELETE FROM PessoaFisica WHERE Id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object buscarPorNome(String nome) throws SQLException {
         ArrayList<PessoaFisica> clientes = new ArrayList();
        try {
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM PessoaFisica WHERE LOWER(Nome) Like ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nome.toLowerCase() + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                PessoaFisica cliente = new PessoaFisica();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
                cliente.setGenero(rs.getInt("GeneroId"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return clientes;
    }
    
}

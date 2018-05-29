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
import java.util.ArrayList;
import senacbankpoo.connection.ConnectionUtils;
import senacbankpoo.model.PessoaJuridica;
import senacbankpoo.repository.contracts.IRepositorio;
import senacbankpoo.repository.contracts.IRepositorioPessoaJuridica;

/**
 *
 * @author Beto
 */
public class RepositorioPessoaJuridica implements IRepositorio, IRepositorioPessoaJuridica {

    static Connection connection;

    @Override
    public void inserir(Object entity) throws SQLException {
        try {
            connection = ConnectionUtils.getConnection();
            PessoaJuridica cliente = (PessoaJuridica) entity;
            String sql = "INSERT INTO PessoaJuridica(Nome, CNPJ, DataRegistro) VALUES (?, ?, CURRENT_DATE)";
            PreparedStatement pst = connection.prepareStatement(sql);

            // DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCnpj());
            pst.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Object listar() throws SQLException {
        ArrayList<PessoaJuridica> clientes = new ArrayList<PessoaJuridica>();
        try {
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM PessoaJuridica";

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                PessoaJuridica cliente = new PessoaJuridica();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setCnpj(rs.getString("CNPJ"));
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

            String sql = "SELECT * FROM PessoaJuridica WHERE Id = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                PessoaJuridica cliente = new PessoaJuridica();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setCnpj(rs.getString("CNPJ"));
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
            PessoaJuridica cliente = (PessoaJuridica) entity;
            connection = ConnectionUtils.getConnection();
            String sql = "UPDATE PessoaJuridica SET CNPJ=? WHERE Id = ?";

            // DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getCnpj());
            
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Integer id) throws SQLException {
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "DELETE FROM PessoaJuridica WHERE Id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object buscarPorNome(String nome) throws SQLException {
        ArrayList<PessoaJuridica> clientes = new ArrayList();
        try {
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM PessoaJuridica WHERE LOWER(Nome) Like ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nome.toLowerCase() + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                PessoaJuridica cliente = new PessoaJuridica();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCnpj(rs.getString("CNPJ"));
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
    public Object procurarPeloCNPJ(String CNPJ) throws SQLException {
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "SELECT * FROM PessoaJuridica WHERE CNPJ = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, CNPJ);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PessoaJuridica cliente = new PessoaJuridica();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCnpj(rs.getString("CNPJ"));
               
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean verificaCNPJ(String CNPJ) {
        try {
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM PessoaJuridica WHERE CNPJ = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, CNPJ);
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

}

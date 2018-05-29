/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.repository.contracts;

import java.sql.SQLException;

/**
 *
 * @author Beto
 */
public interface IRepositorioConta {
    void inserir(Object entity) throws SQLException;
    Object listar() throws SQLException;
    Object pegar(Integer id) throws SQLException;
    void deletar(Integer id) throws SQLException;
    public Object buscarPorIdCliente(int idCliente) throws SQLException;
    public Object procurarPeloNumConta(int numConta) throws SQLException;
    public boolean verificaNumeroConta(String numConta) throws SQLException;
    public Object loginConta(int numConta, String senha) throws SQLException;
    
}

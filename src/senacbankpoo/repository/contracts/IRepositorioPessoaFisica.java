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
public interface IRepositorioPessoaFisica extends IRepositorio{    
    public Object procurarPeloCPF (String CPF) throws SQLException;
    public boolean verificaCPF (String CPF) throws SQLException; 
}

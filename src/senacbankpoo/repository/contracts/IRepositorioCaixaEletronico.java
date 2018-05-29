/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.repository.contracts;

import senacbankpoo.model.Conta;

/**
 *
 * @author Beto
 */
public interface IRepositorioCaixaEletronico {
    public void saque(Object entity, double quantidade);
    public void deposito(Conta conta, double quantidade);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.repository.contracts;

/**
 *
 * @author Beto
 */
public interface IRepositorioCaixaEletronico {
    public void saque(double quantidade);
    public void deposito(double quantidade);
    public double saldo();
}

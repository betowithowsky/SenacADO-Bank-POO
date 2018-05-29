/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.services.caixaEletronico;

import senacbankpoo.model.Conta;
import senacbankpoo.repository.caixaeletronico.RepositorioCaixaEletronico;
import senacbankpoo.repository.contracts.IRepositorioCaixaEletronico;

/**
 *
 * @author Beto
 */
public class ServicoCaixaEletronico implements IRepositorioCaixaEletronico{
    
    static IRepositorioCaixaEletronico repositorio = new RepositorioCaixaEletronico();

    @Override
    public void saque(Conta conta, double quantidade) {
        try {
            repositorio.saque(conta, quantidade);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void deposito(Conta conta, double quantidade) {
        try {
            repositorio.deposito(conta, quantidade);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public double saldo(Conta conta) {
        try {
            return repositorio.saldo(conta);
        } catch (Exception e) {
            e.getMessage();
        }
        return 0;
    }
    
}

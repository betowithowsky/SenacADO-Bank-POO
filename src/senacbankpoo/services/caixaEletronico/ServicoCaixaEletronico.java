/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.services.caixaEletronico;

import senacbankpoo.model.Conta;
import senacbankpoo.model.ContaCorrente;
import senacbankpoo.repository.caixaeletronico.RepositorioCaixaEletronico;
import senacbankpoo.repository.contracts.IRepositorioCaixaEletronico;

/**
 *
 * @author Beto
 */
public class ServicoCaixaEletronico{
    
    static IRepositorioCaixaEletronico repositorio = new RepositorioCaixaEletronico();

    public static void saque(Conta conta, double quantidade) {
        try {
            repositorio.saque(conta, quantidade);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void deposito(Conta conta, double quantidade) {
        try {
            repositorio.deposito(conta, quantidade);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
}

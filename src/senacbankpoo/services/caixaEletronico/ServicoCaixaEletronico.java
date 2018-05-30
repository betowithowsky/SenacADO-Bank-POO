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

    public static void saque(int idConta, double quantidade) {
        try {
            repositorio.saque(idConta, quantidade);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void deposito(int idConta, double quantidade) {
        try {
            repositorio.deposito(idConta, quantidade);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public static void transferencia(int idContaOrigem, int numContaDestino, double valor) {
        try {
            if(saldo(idContaOrigem) < valor){
                new Exception("Saldo Insuficiente.");
            }
            
            repositorio.transferencia(idContaOrigem, numContaDestino, valor);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public static double saldo(int idConta) {
        try {
            return repositorio.saldo(idConta);
        } catch (Exception e) {
            e.getMessage();
        }
        return 0;
    }
    
    
}

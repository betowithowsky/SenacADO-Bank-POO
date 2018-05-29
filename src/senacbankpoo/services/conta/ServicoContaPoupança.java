/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.services.conta;

import java.text.ParseException;
import senacbankpoo.model.ContaPoupanca;
import senacbankpoo.repository.conta.RepositorioContaPoupanca;
import senacbankpoo.repository.contracts.IRepositorioConta;

/**
 *
 * @author Beto
 */
public class ServicoContaPoupança {
    
    static IRepositorioConta repositorio = new RepositorioContaPoupanca();
    
    public static void cadastrar(ContaPoupanca conta) throws ParseException {

        try {
            repositorio.inserir(conta);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

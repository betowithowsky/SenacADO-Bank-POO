/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.services.conta;

import java.text.ParseException;
import java.util.ArrayList;
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
    
    public static void atualizar(ContaPoupanca conta) throws Exception {
        //ValidadorCliente.validar(cliente, true);

        try {
            //repositorio.atualizar(conta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ContaPoupanca procurarPeloNumero(int numConta) {
        try {
            return (ContaPoupanca) repositorio.procurarPeloNumConta(numConta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<ContaPoupanca> procurarPeloClienteId(int clienteId) {
        try {
            return (ArrayList<ContaPoupanca>) repositorio.buscarPorIdCliente(clienteId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<ContaPoupanca> listar() {
        try {
            return (ArrayList<ContaPoupanca>) repositorio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ContaPoupanca obterConta(Integer id) {
        try {
            return (ContaPoupanca) repositorio.pegar(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void excluirConta(Integer id) {
        try {
            repositorio.deletar(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

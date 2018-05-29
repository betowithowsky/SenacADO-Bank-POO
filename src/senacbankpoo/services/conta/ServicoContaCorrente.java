/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.services.conta;

import java.text.ParseException;
import java.util.ArrayList;
import senacbankpoo.model.ContaCorrente;
import senacbankpoo.repository.conta.RepositorioContaCorrente;
import senacbankpoo.repository.contracts.IRepositorioConta;


/**
 *
 * @author Beto
 */
public class ServicoContaCorrente {
    
     static IRepositorioConta repositorio = new RepositorioContaCorrente();
    
    public static void cadastrar(ContaCorrente conta) throws ParseException {

        try {
            repositorio.inserir(conta);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public static void atualizar(ContaCorrente conta) throws Exception {
        //ValidadorCliente.validar(cliente, true);

        try {
            //repositorio.atualizar(conta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ContaCorrente procurarPeloNumero(int numConta) {
        try {
            return (ContaCorrente) repositorio.procurarPeloNumConta(numConta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<ContaCorrente> procurarPeloNome(int clienteId) {
        try {
            return (ArrayList<ContaCorrente>) repositorio.buscarPorIdCliente(clienteId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<ContaCorrente> listar() {
        try {
            return (ArrayList<ContaCorrente>) repositorio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ContaCorrente obterConta(Integer id) {
        try {
            return (ContaCorrente) repositorio.pegar(id);
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

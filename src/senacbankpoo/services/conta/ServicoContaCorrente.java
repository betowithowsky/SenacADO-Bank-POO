/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.services.conta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public static ArrayList<ContaCorrente> procurarPeloClienteId(int clienteId) {
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
    
    public static void gerarCartaoTxt(ContaCorrente contaOrigem) throws IOException{  
        
        File file = new File("Cartao"+contaOrigem.getNomeCliente()+".txt");
        
            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }        

        try {
            FileWriter fileWriter = new FileWriter(file);

            BufferedWriter buffer = new BufferedWriter(fileWriter);
            
            buffer.write(contaOrigem.getNumConta() + ";" + contaOrigem.getNomeCliente());
            // feche o arquivo
            buffer.close();
            System.out.println("Done.");
        }
        catch(IOException ex) {
            System.out.println("Erro de escrita em '" + file + "'");
        }    
    }    
}

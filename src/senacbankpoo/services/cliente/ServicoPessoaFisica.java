/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.services.cliente;

import java.text.ParseException;
import java.util.ArrayList;
import senacbankpoo.model.PessoaFisica;
import senacbankpoo.repository.cliente.RepositorioPessoaFisica;
import senacbankpoo.repository.contracts.IRepositorioPessoaFisica;

/**
 *
 * @author Beto
 */
public class ServicoPessoaFisica {
    
    static IRepositorioPessoaFisica repositorio = new RepositorioPessoaFisica();
    
    public static void cadastrar(PessoaFisica cliente) throws ParseException {
        //ValidadorCliente.validar(cliente, false);

        try {
            repositorio.inserir(cliente);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void atualizar(PessoaFisica cliente) throws Exception {
        //ValidadorCliente.validar(cliente, true);

        try {
            repositorio.atualizar(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PessoaFisica procurarPeloCPF(String CPF) {
        try {
            return (PessoaFisica) repositorio.procurarPeloCPF(CPF);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<PessoaFisica> procurarPeloNome(String nome) {
        try {
            return (ArrayList<PessoaFisica>) repositorio.buscarPorNome(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<PessoaFisica> listar() {
        try {
            return (ArrayList<PessoaFisica>) repositorio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PessoaFisica obterCliente(Integer id) {
        try {
            return (PessoaFisica) repositorio.pegar(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void excluirCliente(Integer id) {
        try {
            repositorio.deletar(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

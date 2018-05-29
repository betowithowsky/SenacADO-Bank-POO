/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.services.cliente;

import java.text.ParseException;
import java.util.ArrayList;
import senacbankpoo.model.PessoaJuridica;
import senacbankpoo.repository.cliente.RepositorioPessoaJuridica;
import senacbankpoo.repository.contracts.IRepositorioPessoaJuridica;

/**
 *
 * @author Beto
 */
public class ServicoPessoaJuridica {
    
    static IRepositorioPessoaJuridica repositorio = new RepositorioPessoaJuridica();
    
    public static void cadastrar(PessoaJuridica cliente) throws ParseException {
        //ValidadorCliente.validar(cliente, false);

        try {
            repositorio.inserir(cliente);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void atualizar(PessoaJuridica cliente) throws Exception {
        //ValidadorCliente.validar(cliente, true);

        try {
            repositorio.atualizar(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PessoaJuridica procurarPeloCNPJ(String CNPJ) {
        try {
            return (PessoaJuridica) repositorio.procurarPeloCNPJ(CNPJ);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<PessoaJuridica> procurarPeloNome(String nome) {
        try {
            return (ArrayList<PessoaJuridica>) repositorio.buscarPorNome(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<PessoaJuridica> listar() {
        try {
            return (ArrayList<PessoaJuridica>) repositorio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PessoaJuridica obterCliente(Integer id) {
        try {
            return (PessoaJuridica) repositorio.pegar(id);
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

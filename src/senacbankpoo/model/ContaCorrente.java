/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.model;

/**
 *
 * @author Beto
 */
public class ContaCorrente extends Conta{
    private float transferir;
    private float taxamensal;
    private String nomeCliente;    
    private String SobrenomeCliente;
    private String CPF;
    
    public String getSobrenomeCliente() {
        return SobrenomeCliente;
    }

    public void setSobrenomeCliente(String SobrenomeCliente) {
        this.SobrenomeCliente = SobrenomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public float getTransferir() {
        return transferir;
    }

    public void setTransferir(float transferir) {
        this.transferir = transferir;
    }

    public float getTaxamensal() {
        return taxamensal;
    }

    public void setTaxamensal(float taxamensal) {
        this.taxamensal = taxamensal;
    }
}

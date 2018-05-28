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
public abstract class Conta {
  
    private int clienteId;
    private int id;
    private int numConta;
    private double saldo;
    private String password;
    
    public int getNumConta() {
        return numConta;
    }

    public void setnumConta(int numConta) {
        this.numConta = numConta;
    }
    
    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean saque(double quantidade){
        if(this.saldo < quantidade){
            return false;
        }else{
            double novoSaldo = this.saldo - quantidade;
            this.saldo = novoSaldo;
            return true;        
        }
    }
    
    public void deposito(double quantidade){
        this.saldo += quantidade;
    }
    
}

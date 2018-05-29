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
public class ContaPoupanca extends Conta {
    private float rendamensal;
    private float transferir;
    
    public float getRendamensal() {
        return rendamensal;
    }

    public void setRendamensal(float rendamensal) {
        this.rendamensal = rendamensal;
    }

    public float getTransferir() {
        return transferir;
    }

    public void setTransferir(float transferir) {
        this.transferir = transferir;
    }
    
}

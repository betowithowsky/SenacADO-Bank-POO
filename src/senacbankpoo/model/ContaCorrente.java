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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.services.login;

import senacbankpoo.model.ContaPoupanca;
import senacbankpoo.repository.conta.RepositorioContaPoupanca;
import senacbankpoo.repository.contracts.IRepositorioConta;

/**
 *
 * @author Yuri PC
 */
public class ServicoLoginPoupanca {
    
   static IRepositorioConta repositorio = new RepositorioContaPoupanca();
   
    public static ContaPoupanca contaLogada = null;
    
    public static boolean Login(int numConta, String senha){
        try{
            contaLogada = (ContaPoupanca) repositorio.loginConta(numConta, senha);
            if(contaLogada != null){
                return true;
            }             
            contaLogada = (ContaPoupanca) repositorio.loginConta(numConta, senha);
            return true;
        }catch (Exception e) {
            e.getMessage();
        }      
        return false;
    }
    
    public void Logout(){
        try{
            contaLogada = null;
        }catch (Exception e) {
            e.getMessage();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.services.login;

import senacbankpoo.model.ContaCorrente;
import senacbankpoo.repository.conta.RepositorioContaCorrente;
import senacbankpoo.repository.contracts.IRepositorioConta;

/**
 *
 * @author Beto
 */
public class ServicoLogin {
    
   static IRepositorioConta repositorio = new RepositorioContaCorrente();
    
    public static ContaCorrente contaLogada = null;
    
    public static boolean Login(int numConta, String senha){
        try{
            contaLogada = (ContaCorrente) repositorio.loginConta(numConta, senha);
            if(contaLogada != null){
                return true;
            }             
            //contaLogada = (ContaCorrente) repositorio.loginConta(numConta, senha);
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

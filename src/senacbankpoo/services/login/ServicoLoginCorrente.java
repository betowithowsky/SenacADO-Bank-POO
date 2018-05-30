/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.services.login;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import senacbankpoo.model.ContaCorrente;
import senacbankpoo.repository.conta.RepositorioContaCorrente;
import senacbankpoo.repository.contracts.IRepositorioConta;

/**
 *
 * @author Beto
 */
public class ServicoLoginCorrente {
    
   static IRepositorioConta repositorio = new RepositorioContaCorrente();
    
    public static ContaCorrente contaLogada = null;
    
    public static boolean Login(int numConta, String senha){
        try{
            contaLogada = (ContaCorrente) repositorio.loginConta(numConta, senha);
            if(contaLogada != null){
                return true;
            }             
            contaLogada = (ContaCorrente) repositorio.loginConta(numConta, senha);
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
    
    public static int leitorCartaoTxt(String file){
        // linha temporaria
        String linha = null;
        int numConta = 0;   
        String nomeTitular;
        
/*      ------------------------------------- */
/*      Abertura de arquivo e loop de leitura */
/*      ------------------------------------- */
        try {
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            
            // loop por cada linha do arquivo
            while((linha = bufferedReader.readLine()) != null) {
                String[] parts = linha.split(";");
                numConta = Integer.parseInt(parts[0]);   
                nomeTitular = parts[1];
            }   
            
            // feche o arquivo
            bufferedReader.close(); 
            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + file + "'");                
        }
        catch(IOException ex) {
            System.out.println("Erro lendo o arquivo '" + file + "'");                  
        }
        return numConta;
    }
}

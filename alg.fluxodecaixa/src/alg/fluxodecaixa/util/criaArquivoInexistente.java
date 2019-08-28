/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg.fluxodecaixa.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class criaArquivoInexistente extends FileNotFoundException {
    // Pega a pasta do projeto
    private static String _pastaProjeto = System.getProperty("user.dir");
    // Define o arquivo de configurações
    private static String _arquivo = "/src/alg/fluxodecaixa/util/config.ini";
    public criaArquivoInexistente(){

        int resposta = JOptionPane.showConfirmDialog(
                null,
                "O arquivo de configuração não existe, deseja criá-lo?", 
                "Erro", 
                JOptionPane.YES_NO_OPTION
        );
        if (resposta == JOptionPane.YES_OPTION) {
            // Cria o arquivo
            File arquivo = new File(_pastaProjeto + _arquivo);
            try {
                if( arquivo.createNewFile() ){
                    System.out.println("Arquivo criado");
                }else{
                    System.out.println("Arquivo não criado");
                }    
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "A aplicação será encerrada!");
            System.exit(0);
        }
    }
}

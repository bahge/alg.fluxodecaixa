package alg.fluxodecaixa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {
    // Cria um instancia de propriedades
    private static Properties _config = new Properties();
    // Pega a pasta do projeto
    private static String _pastaProjeto = System.getProperty("user.dir");
    // Define o arquivo de configurações
    private static String _arquivo = "/src/br/alg/indicadores/util/config.ini";
    
    public Config() {
        try {
            // Instancia o arquivo de propriedades
            FileInputStream fin = new FileInputStream(_pastaProjeto + _arquivo);
            // Abre o arquivo
            _config.load(fin);
        } catch (FileNotFoundException ex){
            System.out.println("Arquivo de configuração não foi encontrado");
        }catch (IOException ex) {
            System.out.println("Erro ao importar o arquivo de configurações");
        } 
    }
    
    public List<Object> BDConfig(){
        // Buscar propriedades do arquivo de configuração 
        String host = Config._config.getProperty("host");
        String bdnome = Config._config.getProperty("bdname");
        String porta = Config._config.getProperty("porta");
        String usuario = Config._config.getProperty("usuario");
        String senha = Config._config.getProperty("senha");
        return Arrays.asList(host, bdnome, porta, usuario, senha);
    }
    
    public boolean setConfig(String host, String bdnome, String porta, String usuario, String senha){
        Properties configuracoes = new Properties();
        try { 
            // Instancia o arquivo de propriedades
            FileInputStream fin = new FileInputStream(_pastaProjeto + _arquivo);
            _config.load(fin);
            _config.setProperty("host", host);
            _config.setProperty("bdname", bdnome);
            _config.setProperty("porta", porta);
            _config.setProperty("usuario", usuario);
            _config.setProperty("senha", senha);
            FileOutputStream fileOut = new FileOutputStream(_pastaProjeto + _arquivo);
            _config.store(fileOut, null); 
            return true;
        } catch (IOException ex) { 
            System.out.println("Erro carregando arquivo de configurações: "+ex.getMessage()); 
        }
        return false;
    }
    
    /*
    
    host=localhost
    bdname=BDIndicadores
    porta=5432
    usuario=postgres
    senha=qwaszx12
    
    */
}

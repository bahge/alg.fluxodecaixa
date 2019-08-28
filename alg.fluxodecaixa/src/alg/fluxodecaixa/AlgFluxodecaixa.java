package alg.fluxodecaixa;

import java.io.File;
import alg.fluxodecaixa.telas.telaPrincipal;
import alg.fluxodecaixa.telas.telaConfig;

public class AlgFluxodecaixa {
    // Pega a pasta do projeto
    private static String _pastaProjeto = System.getProperty("user.dir");
    // Define o arquivo de configurações
    private static String _arquivo = "/src/alg/fluxodecaixa/util/config.ini";
    
    public static void main(String[] args) {
        String caminho = _pastaProjeto + _arquivo;
        File teste = new File(caminho);
        if(teste.exists()){
            telaPrincipal abertura = new telaPrincipal();
        } else {
            telaConfig config = new telaConfig();
        }
    }
    
}

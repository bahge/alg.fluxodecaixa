package alg.fluxodecaixa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConBD {
    private static String BDhost;
    private static String BDname;
    private static String BDport;
    private static String BDuser;
    private static String BDpass;
    
    public ConBD(){
        Config configuracao;
        try {
            configuracao = new Config();
            List<Object> conf = configuracao.BDConfig();
            setBDhost((String) conf.get(0));
            setBDname((String) conf.get(1));
            setBDport((String) conf.get(2));
            setBDuser((String) conf.get(3));
            setBDpass((String) conf.get(4));
        } catch (criaArquivoInexistente ex) {
            Logger.getLogger(ConBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Connection getConnection() {
        
        Connection conexao = null;
        
        String urlCon = "jdbc:postgresql://" + getBDhost() + ":" + getBDport() +"/" + getBDname();
        
        try {
            /*Chama o drive para a conexão do jdbc instanciando diretamente */
            Class.forName("org.postgresql.Driver");
            
            conexao = 
            DriverManager.getConnection(urlCon, getBDuser(), getBDpass());
            
            
        } catch (SQLException e){
        
            System.out.println("Erro conectando ao banco: " + e.getMessage());
        
        } catch (ClassNotFoundException e) {
        
            System.out.println("Classe não encontrada: " + e.getMessage());
       
        }
        
        return conexao;
    }
    
   
    public static String getBDhost() {
        return BDhost;
    }

    public static void setBDhost(String BDhost) {
        ConBD.BDhost = BDhost;
    }

    public static String getBDname() {
        return BDname;
    }

    public static void setBDname(String BDname) {
        ConBD.BDname = BDname;
    }

    public static String getBDport() {
        return BDport;
    }

    public static void setBDport(String BDport) {
        ConBD.BDport = BDport;
    }

    public static String getBDuser() {
        return BDuser;
    }

    public static void setBDuser(String BDuser) {
        ConBD.BDuser = BDuser;
    }

    public static String getBDpass() {
        return BDpass;
    }

    public static void setBDpass(String BDpass) {
        ConBD.BDpass = BDpass;
    }    
}

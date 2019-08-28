package alg.fluxodecaixa.resultado.relatorio;

import alg.fluxodecaixa.util.ConBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class relatorioDAO {
    public relatorioDAO(){
        // Inicia a conexão
        ConBD conn = new ConBD();
    }
    
    public ArrayList<relatorio> listar() {
        return null;
    }
    
}

package alg.fluxodecaixa.resultado.despesa;

import alg.fluxodecaixa.util.ConBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class despesaDAO {
    public despesaDAO(){
        // Inicia a conexão
        ConBD conn = new ConBD();
    }
          
    public boolean cadastrar(despesa novaDespesa){
        return false;
    }
    
    public ArrayList<despesa> listar() {
        return null;
    }
    
    public boolean editar(despesa editarDespesa){
        return false;
    }
    
    public boolean apagar(int id) {
        return false;
    }
}

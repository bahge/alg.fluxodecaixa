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
        
        Connection conexao = ConBD.getConnection();
        boolean cadastrou = false;
        if (conexao != null) {
            try {
                PreparedStatement pStm =
                        conexao.prepareStatement("INSERT INTO resultados (classificacao, tipo, valor, ano, mes, id_user) "
                                + "VALUES (?, ?, ?, ?, ?, ?)");
                // Um para receita, dois para despesa
                pStm.setInt(1, 2);
                pStm.setInt(2, novaDespesa.getTipo());
                pStm.setFloat(3, novaDespesa.getValor());
                pStm.setInt(4, novaDespesa.getAno());
                pStm.setInt(5, novaDespesa.getMes());
                
                //Se der altera é o id do usuário
                pStm.setInt(6, 1);
                
                int linhas = pStm.executeUpdate();
                
                return true;
                
            } catch (SQLException ex) {
                //O ideal seria propagar a excessãp para não engessar
                System.out.println("Erro ao cadastrar usuário:" + ex.getMessage());
            }
        }
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

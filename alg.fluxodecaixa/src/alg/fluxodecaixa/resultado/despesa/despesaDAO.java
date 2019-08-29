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
        ArrayList<despesa> listaDespesa=null;
        Connection conexao = ConBD.getConnection();
        if (conexao != null) {
            try {
                //"Código", "Tipo", "Valor", "Mes", "Ano"
                Statement stm = conexao.createStatement();
                String sqlSelect = "SELECT Id, tipo, valor, mes, ano  FROM resultados WHERE classificacao = 2 ORDER BY mes ASC";
                ResultSet rs = stm.executeQuery(sqlSelect);
                //Verifica se não é vazio
                if (rs.isBeforeFirst()){
                    listaDespesa = new ArrayList();
                    while (rs.next()) {
                        despesa desp = new despesa();
                        //user.setId(rs.getInt("Id"));
                        desp.setId(rs.getInt("id"));
                        desp.setTipo(rs.getInt("tipo"));
                        desp.setValor(rs.getFloat("valor"));
                        desp.setMes(rs.getInt("mes"));
                        desp.setAno(rs.getInt("ano"));
                        listaDespesa.add(desp);
                    }
                }
            return listaDespesa;
            } catch (SQLException ex) {
                System.out.println("Erro listar receitas:" + ex.getMessage());
            }
        }
        return listaDespesa;
    }
    
    public boolean editar(despesa editarDespesa){
        return false;
    }
    
    public boolean apagar(int id) {
        return false;
    }
}

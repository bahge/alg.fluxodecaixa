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
    
    public float consultar(){
        float diferenca;
        float receita = 0;
        float despesa = 0;
        Connection conexao = ConBD.getConnection();
        if (conexao != null) {
            try {
                Statement stm = conexao.createStatement();
                String sqlSelect = "Select sum(valor) total from resultados where classificacao = 1";
                ResultSet rs = stm.executeQuery(sqlSelect);
                if(rs.isBeforeFirst()){
                    rs.next();
                    receita = rs.getFloat("total");
                }                   
            } catch (SQLException ex) {
                //O ideal seria propagar a excessãp para não engessar
                System.out.println("Erro ao procurar o usuário:" + ex.getMessage());
            }
            try {
                Statement stm = conexao.createStatement();
                String sqlSelect = "Select sum(valor) total from resultados where classificacao = 2";
                ResultSet rs = stm.executeQuery(sqlSelect);
                if(rs.isBeforeFirst()){
                    rs.next();
                    despesa = rs.getFloat("total");
                }                   
            } catch (SQLException ex) {
                //O ideal seria propagar a excessãp para não engessar
                System.out.println("Erro ao procurar o usuário:" + ex.getMessage());
            }
        }
        diferenca = receita - despesa;
        return diferenca;
    }
    
}

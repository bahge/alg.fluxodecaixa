/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg.fluxodecaixa.resultado.receita;

import alg.fluxodecaixa.util.ConBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author bahge
 */
public class receitaDAO {
    public receitaDAO(){
        // Inicia a conexão
        ConBD conn = new ConBD();
    }
          
    public boolean cadastrar(receita novaReceita){
        Connection conexao = ConBD.getConnection();
        boolean cadastrou = false;
        if (conexao != null) {
            try {
                PreparedStatement pStm =
                        conexao.prepareStatement("INSERT INTO resultados (classificacao, tipo, valor, ano, mes, id_user) "
                                + "VALUES (?, ?, ?, ?, ?, ?)");
                // Um para receita, dois para despesa
                pStm.setInt(1, 1);
                pStm.setInt(2, novaReceita.getTipo());
                pStm.setFloat(3, novaReceita.getValor());
                pStm.setInt(4, novaReceita.getAno());
                pStm.setInt(5, novaReceita.getMes());
                
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
    
    public ArrayList<receita> listar() {
        return null;
    }
    
    public boolean editar(receita editarReceita){
        return false;
    }
    
    public boolean apagar(int id) {
        return false;
    }    
}

package alg.fluxodecaixa.usuarioModel.DAO;

import alg.fluxodecaixa.usuarioModel.Usuario;
import alg.fluxodecaixa.util.ConBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {
    public UsuarioDAO(){
        // Inicia a conexão
        ConBD conn = new ConBD();
    }
    public int logar(Usuario usuario) {
        Connection conexao = ConBD.getConnection();
        int nv = -1;
        if (conexao != null) {
            try {
                Statement stm = conexao.createStatement();
                String sqlSelect = "SELECT * FROM usuarios WHERE login = '" 
                        + usuario.getLogin() +
                        "' AND senha = '"
                        + usuario.getSenha()
                        + "'";
                System.out.println(sqlSelect);
                ResultSet rs = stm.executeQuery(sqlSelect);
                if(rs.isBeforeFirst()){
                    rs.next();
                    nv = rs.getInt("nivel");
                    System.out.println("Usuário Logado, nível: " + nv);
                } else {
                    System.out.println("Usuário inválido");
                    return -1;
                }
                   
            } catch (SQLException ex) {
                //O ideal seria propagar a excessãp para não engessar
                System.out.println("Erro cadastrando aluno:" + ex.getMessage());
            }
        }
        return nv;
    }
    
    public boolean cadastrar(Usuario novoUsuario){

        Connection conexao = ConBD.getConnection();
        boolean nv = false;
        if (conexao != null) {
            try {
                PreparedStatement pStm =
                        conexao.prepareStatement("INSERT INTO usuarios (login, senha, nome, nivel, status, email) "
                                + "VALUES (?, ?, ?, ?, ?, ?)");
                //pStm.setInt(1, novoAluno.getCod());
                pStm.setString(1, novoUsuario.getLogin());
                pStm.setString(2, novoUsuario.getSenha());
                pStm.setString(3, novoUsuario.getNome());
                pStm.setInt(4, novoUsuario.getNivel());
                pStm.setInt(5, novoUsuario.getStatus());
                pStm.setString(6, novoUsuario.getEmail());
                
                int linhas = pStm.executeUpdate();
                
                return true;
                
            } catch (SQLException ex) {
                //O ideal seria propagar a excessãp para não engessar
                System.out.println("Erro cadastrando aluno:" + ex.getMessage());
            }
        }
        return false;
    }
    
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> listaUsuarios=null;
        
        Connection conexao = ConBD.getConnection();
        if (conexao != null) {
            try {
                Statement stm = conexao.createStatement();
                String sqlSelect = "SELECT Id, login, nome, email, status, nivel  FROM usuarios ORDER BY nome ASC";
                ResultSet rs = stm.executeQuery(sqlSelect);
                //Verifica se não é vazio
                if (rs.isBeforeFirst()){
                    listaUsuarios = new ArrayList();
                    while (rs.next()) {
                        Usuario user = new Usuario();
                        user.setId(rs.getInt("Id"));
                        user.setLogin(rs.getString("login"));
                        user.setNome(rs.getString("nome"));
                        user.setEmail(rs.getString("email"));
                        user.setStatus(rs.getInt("status"));
                        user.setNivel(rs.getInt("nivel"));
                        listaUsuarios.add(user);
                    }
                }
            return listaUsuarios;
            } catch (SQLException ex) {
                System.out.println("Erro listar usuarios:" + ex.getMessage());
            }
        }
        return listaUsuarios;
    }
}
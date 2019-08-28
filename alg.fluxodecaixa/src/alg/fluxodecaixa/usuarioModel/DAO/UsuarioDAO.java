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
    public int[] logar(Usuario usuario) {
        Connection conexao = ConBD.getConnection();
        int nv[];
        nv = new int[2];
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
                    nv[0] = rs.getInt("nivel");
                    System.out.println("Usuário Logado, nível: " + nv[0]);
                    nv[1] = rs.getInt("id");
                    System.out.println("Usuário Logado, nível: " + nv[1]);
                } else {
                    System.out.println("Usuário inválido");
                    return null;
                }
                   
            } catch (SQLException ex) {
                //O ideal seria propagar a excessãp para não engessar
                System.out.println("Erro ao logar o usuário:" + ex.getMessage());
            }
        }
        return nv;
    }
    
    public Usuario procurar(int id) {
        Connection conexao = ConBD.getConnection();
        Usuario procUser = new Usuario();
        if (conexao != null) {
            try {
                Statement stm = conexao.createStatement();
                String sqlSelect = "SELECT * FROM usuarios WHERE id = " + id;
                ResultSet rs = stm.executeQuery(sqlSelect);
                if(rs.isBeforeFirst()){
                    rs.next();
                    //nv = rs.getInt("nivel");
                    procUser.setLogin(rs.getString("login"));
                    procUser.setNome(rs.getString("nome"));
                    procUser.setEmail(rs.getString("email"));
                    procUser.setSenha(rs.getString("senha"));
                    procUser.setNivel(rs.getInt("nivel"));
                    procUser.setStatus(rs.getInt("status"));
                } else {
                    return procUser;
                }
                   
            } catch (SQLException ex) {
                //O ideal seria propagar a excessãp para não engessar
                System.out.println("Erro ao logar o usuário:" + ex.getMessage());
            }
        }
        return procUser;
    }
    
    public boolean procurar(String login) {
        Connection conexao = ConBD.getConnection();
        if (conexao != null) {
            try {
                Statement stm = conexao.createStatement();
                String sqlSelect = "SELECT * FROM usuarios WHERE login = '" + login + "'";
                ResultSet rs = stm.executeQuery(sqlSelect);
                if(rs.isBeforeFirst()){
                    rs.next();
                    return true;
                }                   
            } catch (SQLException ex) {
                //O ideal seria propagar a excessãp para não engessar
                System.out.println("Erro ao procurar o usuário:" + ex.getMessage());
            }
        }
        return false;
    }
    
    public boolean cadastrar(Usuario novoUsuario){

        Connection conexao = ConBD.getConnection();
        boolean nv = false;
        if (conexao != null) {
            try {
                PreparedStatement pStm =
                        conexao.prepareStatement("INSERT INTO usuarios (login, senha, nome, nivel, status, email) "
                                + "VALUES (?, ?, ?, ?, ?, ?)");
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
                System.out.println("Erro ao cadastrar usuário:" + ex.getMessage());
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
    
    public boolean editar(Usuario editarUsuario){
        Connection conexao = ConBD.getConnection();
        boolean nv = false;
        if (conexao != null) {
            try {
                PreparedStatement pStm =
                        conexao.prepareStatement(
                                "UPDATE usuarios SET "
                                        + "login = ?, "
                                        + "senha = ?, "
                                        + "nome = ?, "
                                        + "nivel = ?, "
                                        + "status = ?, "
                                        + "email = ? "
                                + "WHERE id = "+ editarUsuario.getId());
                pStm.setString(1, editarUsuario.getLogin());
                pStm.setString(2, editarUsuario.getSenha());
                pStm.setString(3, editarUsuario.getNome());
                pStm.setInt(4, editarUsuario.getNivel());
                pStm.setInt(5, editarUsuario.getStatus());
                pStm.setString(6, editarUsuario.getEmail());
                
                int linhas = pStm.executeUpdate();
                
                return true;
                
            } catch (SQLException ex) {
                //O ideal seria propagar a excessãp para não engessar
                System.out.println("Erro ao editar o usuário:" + ex.getMessage());
            }
        }
        return false;
    }
    
    public boolean apagar(int id) {
        Connection conexao = ConBD.getConnection();
        if (conexao != null) {
            try {
                PreparedStatement pStm =
                        conexao.prepareStatement("DELETE FROM usuarios WHERE id = " + id);
                int linhas = pStm.executeUpdate();
                return true;
                
            } catch (SQLException ex) {
                //O ideal seria propagar a excessãp para não engessar
                System.out.println("Erro apagar usuario:" + ex.getMessage());
            }
        }        
        return false; 
    }
}
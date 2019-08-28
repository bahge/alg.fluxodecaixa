package alg.fluxodecaixa.telas;

import alg.fluxodecaixa.usuarioModel.DAO.UsuarioDAO;
import alg.fluxodecaixa.usuarioModel.Usuario;
import alg.fluxodecaixa.util.ConBD;
import alg.fluxodecaixa.util.RoundJPassField;
import alg.fluxodecaixa.util.RoundJTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
*/
public class telaPrincipal extends JFrame{
    
    private JLabel          lbPicLogin   = new JLabel();
    private JLabel          lbLogin      = new JLabel();
    private JLabel          lbSenha      = new JLabel();
    private String          imageLogin   = "/alg/fluxodecaixa/util/imagens/login.png";
    private Font            fontLabel    = new Font("Verdana", 1, 14);
    private JTextField      txtLogin     = new RoundJTextField(15);
    private JPasswordField  txtSenha     = new RoundJPassField(15);
    private Color           backApp      = new Color( 0, 123, 255);
    private JButton         bttLogin     = new JButton();
    /*
    */
    public telaPrincipal(){
        //Configurações do JFrame
        // Tamanho
        setSize(360, 480);
        // Desabilita o redimensionamento
        setResizable(false);
        // Coloca a função de fechar no botão encerrando a aplicação
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Título da Janel
        setTitle("Login");
        // Centrala o form
        setLocationRelativeTo(null);
        // Coloca o ícone na janela
        setIconImage(new ImageIcon(getClass().getResource(imageLogin)).getImage());
        // Altera a cor do background
        getContentPane().setBackground(backApp);
        
        // Cria o container que será usado de painel
        Container cont = getContentPane();
        // Desabilita o layout padrão
        cont.setLayout(null);
        // Tamanho
        cont.setSize(360, 480);
        
        
        // Chama a inicialização de componentes
        inicializarComponentes();      
        // Habilita a visualização
        setVisible(true);
    }
    /*
    */
    public static void main(String args[]) {
        // Instancia a tela principal
        telaPrincipal index = new telaPrincipal();
    }
    /*
    */
    private void inicializarComponentes() {
        // Configurações do Label com a imagem no form de login
        // Adiciona o icone
        lbPicLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageLogin)));
        // Tamanho
        lbPicLogin.setSize(80, 80);
        // Localização
        lbPicLogin.setLocation(140, 40);
        // Adiciona elemento ao painel
        add(lbPicLogin);
        
        // Configurações do Label com a mensagem de Login
        // Tamanho
        lbLogin.setSize(160, 40);
        // Posição
        lbLogin.setLocation(40, 160);
        // Texto apresentado
        lbLogin.setText("Login:");
        // Fonte formatada
        lbLogin.setFont(fontLabel);
        // Cor da fonte
        lbLogin.setForeground(Color.WHITE);
        // Adiciona elemento ao painel
        add(lbLogin);
        
        // Configurações do Label com a mensagem de Senha
        // Tamanho
        lbSenha.setSize(160, 40);
        // Posição
        lbSenha.setLocation(40, 240);
        // Texto apresentado
        lbSenha.setText("Senha:");
        // Fonte formatada
        lbSenha.setFont(fontLabel);
        // Cor da fonte
        lbSenha.setForeground(Color.WHITE);
        // Adiciona elemento ao painel
        add(lbSenha);
        
        // Configurações do campo de texto login
        // Tamanho
        txtLogin.setSize(280, 30);
        // Posição
        txtLogin.setLocation(40, 200);
        // Adiciona elemento ao painel
        add(txtLogin);
        
        // Configurações do campo de password senha
        // Tamanho
        txtSenha.setSize(280, 30);
        // Posição
        txtSenha.setLocation(40, 280);
        // Adiciona elemento ao painel
        add(txtSenha);
        
        // Configurações do botão de Login
        // Tamanho
        bttLogin.setSize(120, 40);
        // Posição
        bttLogin.setLocation(180, 360);
        // Texto apresentado
        bttLogin.setText("Login");
        // Chamada da action quando o botão é acionado
        bttLogin.addActionListener(e -> validarLogin());
        // Formatação do layout do botão
        bttReset(bttLogin);
        // Manupilação dos eventos do mouse sobre o elemento
        bttLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Formatação do layout do botão
                bttSobre(bttLogin);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Formatação do layout do botão
                bttReset(bttLogin);
            }
        });
        // Adiciona elemento ao painel
        add(bttLogin);
    }
/*
*/    
public void bttSobre(JButton btn) {
    // Muda o background do botão
    btn.setBackground(Color.WHITE);
    // Muda a cor da fonte do texto apresentado
    btn.setForeground(new Color(40, 167, 69));
}

/*
*/
public void bttReset(JButton btn) {
    // Muda o background do botão
    btn.setBackground(new Color(40, 167, 69));
    // Muda a cor da fonte do texto apresentado
    btn.setForeground(Color.WHITE);
}

/*
*/
public void validarLogin(){
    // Instancia um novo UsuarioDao para manipulação no BD
    UsuarioDAO usuariodao = new UsuarioDAO();
    // Instancia um novo Usuario para interação com o DAO
    Usuario loginusuario = new Usuario();
    // Captura o valor digitado com campo de login    
    loginusuario.setLogin(txtLogin.getText());
    // Captura o valor digitado com campo de senha
    loginusuario.setSenha(new String(txtSenha.getPassword()));
    // Atribui a variavel r, o retorno da função de logar da Classe UsuarioDAO
    // o retorno será o nível do usuário cadastrado no Banco de dados
    int r = usuariodao.logar(loginusuario);
    System.out.println(r);
    // Se nível é 0 então é Administrador
    if (r == 0) {
        telaAdministracao telaAdm = new telaAdministracao();
        telaAdm.setVisible(true);
        this.setVisible(false);
    // Se nível é maior que 0 então é Usuario
    } else if (r > 0) {
        telaUsuario telaUser = new telaUsuario();
        telaUser.setVisible(true);
        this.setVisible(false);
    // Se nível é menor que 0 então o usuário não foi encontrado no 
    // Banco de dados
    } else {
        JOptionPane.showMessageDialog(
            null,
            "Login ou senha inválidos, usuário não encontrado.",
            "Erro",
            JOptionPane.WARNING_MESSAGE
        );
    }
}

}
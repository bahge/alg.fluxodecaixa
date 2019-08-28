package alg.fluxodecaixa.telas;

import alg.fluxodecaixa.usuarioModel.DAO.UsuarioDAO;
import alg.fluxodecaixa.usuarioModel.Usuario;
import alg.fluxodecaixa.util.RoundJPassField;
import alg.fluxodecaixa.util.RoundJTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.SwingConstants.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class telaAdministracao extends JFrame implements ActionListener {
    // Barra de Ferramentas - menu para aplicação                           
    private JMenuBar     jmbPrincipal       = new JMenuBar();
    // Menu Arquivo
    private JMenu        jmnuArquivo        = new JMenu("Arquivo");
    private JMenuItem    jmiConfig          = new JMenuItem("Configurações");
    private JMenuItem    jmiSair            = new JMenuItem("Sair");
    // Menu Usuários
    private JMenu        jmnuUsuarios          = new JMenu("Usuários");
    private JMenuItem    jmitCadUsuarios        = new JMenuItem("Cadastrar");
    private JMenuItem    jmitListaUsuarios       = new JMenuItem("Listar");
    private String       imageLogin   = "/alg/fluxodecaixa/util/imagens/login.png";
    private String       imageCad   = "/alg/fluxodecaixa/util/imagens/cad.png";
    

    // Cria o objeto que será o container do JFrame
    public  JDesktopPane jdpTela          = new JDesktopPane();

    Tela telaCadUsuario, telaListarUsuario;
    
    /*public static void main(String args[]){
        telaAdministracao telaAdm = new telaAdministracao();
    }*/
    
    public telaAdministracao(){
        // Adiciona o container ao JFrame da janela principal
        getContentPane().add(jdpTela);
        // Adiciona a Barra de Ferramentas
        setJMenuBar(jmbPrincipal);
        // Coloca o ícone na janela
        setIconImage(new ImageIcon(getClass().getResource(imageLogin)).getImage());
        // Inicializa menu
        inicializarMenu();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setResizable(false);
        setVisible(true);
        
    }
    
    /*
    */
    private void inicializarMenu() {
        // Adiciona o menu Arquivo a barra de ferramentas
        jmbPrincipal.add(jmnuArquivo);
        // Adiciona os submenus
        jmnuArquivo.add(jmiConfig);
        jmnuArquivo.add(jmiSair);
   
        // Adiciona o menu Usuarios a barra de ferramentas
        jmbPrincipal.add(jmnuUsuarios);
        jmitCadUsuarios.setIcon(new ImageIcon(getClass().getResource(imageCad)));
        // Adiciona o submenu Cadastro de Usuários ao menu Usuários
        jmnuUsuarios.add(jmitCadUsuarios);
        // Adiciona o submenu Lista de Usuários ao menu Usuários
        jmnuUsuarios.add(jmitListaUsuarios);
   
        // Adiciona o actioListener aos itens do menu Usuários
        jmitCadUsuarios.addActionListener(this);
        jmitListaUsuarios.addActionListener(this);
        jmiConfig.addActionListener(this);
        jmiSair.addActionListener(this);
   //adiciona actionlistener ao item "cliente" do menu,
   //para que os eventos sejam tratados
   /*jmCadCliente.addActionListener(this);
   jmCadFornecedor.addActionListener(this);
   jmSair.addActionListener(this);*/
    }

    
    //Eventos do Menu
    @Override
    public void actionPerformed(ActionEvent evt) {

        // Evento do SubMenu Cadastro de Usuário
        if (evt.getSource() == jmitCadUsuarios) {
            //Se não for null, a tela já está visível e é exibida
            if (telaCadUsuario == null)
                //Instancia da tela de Cadastro de Usuários
                telaCadUsuario = new Tela("Cadastro de Usuários", this);
            //Exibe a tela
            jdpTela.moveToFront(telaCadUsuario);
            // Coloca o ícone na janela
            telaCadUsuario.setSize(800,540);
            telaCadUsuario.setVisible(true);
            
        }
        // Evento do SubMenu Lista de Usuário
        if (evt.getSource() == jmitListaUsuarios) {
            //Se não for null, a tela já está visível e é exibida
            if (telaListarUsuario == null)
                //Instancia da tela de Listar Usuários
                telaListarUsuario = new Tela("Listar Usuários", this);
            //Exibe a tela
            jdpTela.moveToFront(telaListarUsuario);
            telaListarUsuario.setSize(800,540);
            telaListarUsuario.setVisible(true);

        }
        // Evento do SubMenu Config
        if (evt.getSource() == jmiConfig) {
            telaConfig config = new telaConfig();
        }
        // Evento do SubMenu Cadastro de Sair
        if (evt.getSource() == jmiSair) {
            System.exit(0);
        }
    }
}

class Tela extends JInternalFrame {
    private JPanel          jpInterno = new JPanel();
    private JLabel          lbPic = new JLabel();
    private JLabel          lbLogin = new JLabel();
    private JLabel          lbSenha = new JLabel();
    private JLabel          lbNome = new JLabel();
    private JLabel          lbNivel = new JLabel();
    private JLabel          lbStatus = new JLabel();
    private JLabel          lbEmail = new JLabel();
    private JTextField      txtLogin = new RoundJTextField(15);
    private JTextField      txtNome = new RoundJTextField(15);
    private JTextField      txtEmail = new RoundJTextField(15);
    private JPasswordField  txtSenha = new RoundJPassField(15);
    private Font            fontLabel    = new Font("Verdana", 1, 14);
    private String          imageCad   = "/alg/fluxodecaixa/util/imagens/cadastro.png";
    private JButton         bttCadastrar = new JButton();
    private JRadioButton    jrNivelAdm = new JRadioButton();
    private JRadioButton    jrNivelUser = new JRadioButton();
    private JRadioButton    jrStatusAtivo = new JRadioButton();
    private JRadioButton    jrStatusInativo = new JRadioButton();
    private Color           backApp      = new Color( 0, 123, 255);

   private telaAdministracao telaAdministracao;
    // Barra de Ferramentas - menu para aplicação                           
    private JMenuBar     jmbPrincipal       = new JMenuBar();
    // Menu Arquivo
    private JMenu        jmnuArquivo        = new JMenu("Arquivo");
    private JMenuItem    jmiSair            = new JMenuItem("Sair");                           
   
    public Tela(String titulo, telaAdministracao telaAdministracao) {
    // Configura a nova tela
    super(titulo);
    setSize(500,400);
    setVisible(true);
    // Verifica qual tela foi chamada
    if (titulo == "Cadastro de Usuários") {
        // Inicializa os componentes do cadastro
        inicializarComponentesCadastro();
    }
    if (titulo == "Listar Usuários") {
        // Inicializa os componentes da lista de usuários
        inicializarComponentesListar();
    }
    // Define a tela da administração
    this.telaAdministracao = telaAdministracao;
    // Adiciona o container a tela de administação
    telaAdministracao.jdpTela.add(this);
    // Adiciona o menu da Principal a tela de administração
    telaAdministracao.add(jmbPrincipal);
    // Adiciona menus e submenus ao menu principal
    jmbPrincipal.add(jmnuArquivo);
    jmnuArquivo.add(jmiSair);
    // Define o menu principal
    setJMenuBar(jmbPrincipal);
    // Adiciona a ação de sair no botão sair
    jmiSair.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        setVisible(false);
                    }
                }
    );
    }

    private void inicializarComponentesCadastro() {
        // Adiciona o JPanel interno do Cadastro e define o layout.
        add(jpInterno);
        jpInterno.setLayout(null);
        
        // Personalizar Componentes Cadastro
        lbPic.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageCad)));
        txtLogin.setSize(580, 40);
        txtLogin.setLocation(140,100);
        txtNome.setSize(580, 40);
        txtNome.setLocation(140,160);
        txtEmail.setSize(580, 40);
        txtEmail.setLocation(140,220);
        txtSenha.setSize(580, 40);
        txtSenha.setLocation(140,280);
        lbPic.setSize(160, 80);
        lbPic.setLocation(100,10);
        lbLogin.setSize(80, 40);
        lbLogin.setLocation(40,100);
        lbLogin.setText("Login: ");
        lbLogin.setHorizontalAlignment(RIGHT);
        lbLogin.setFont(fontLabel);
        lbNome.setSize(80, 40);
        lbNome.setLocation(40,160);
        lbNome.setText("Nome: ");
        lbNome.setHorizontalAlignment(RIGHT);
        lbNome.setFont(fontLabel);
        lbEmail.setSize(80, 40);
        lbEmail.setLocation(40,220);
        lbEmail.setText("E-mail: ");
        lbEmail.setHorizontalAlignment(RIGHT);
        lbEmail.setFont(fontLabel);
        lbSenha.setSize(80, 40);
        lbSenha.setLocation(40,280);
        lbSenha.setText("Senha: ");
        lbSenha.setHorizontalAlignment(RIGHT);
        lbSenha.setFont(fontLabel);
        bttCadastrar.setSize(120, 40);
        bttCadastrar.setLocation(600, 360);
        bttCadastrar.setText("Cadastrar");
        lbNivel.setSize(80, 40);
        lbNivel.setLocation(40, 340);
        lbNivel.setText("Nível: ");
        lbNivel.setHorizontalAlignment(RIGHT);
        lbNivel.setFont(fontLabel);
        jrNivelAdm.setSize(160, 40);
        jrNivelAdm.setLocation(140, 340);
        jrNivelAdm.setText("Administrador");
        // Adicionar ação ao clicar no RadioButton
        jrNivelAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNivelUser.setSelected(false);
            }
        });
        jrNivelUser.setSize(160, 40);
        jrNivelUser.setLocation(300, 340);
        jrNivelUser.setText("Usuário");
        // Adicionar ação ao clicar no RadioButton
        jrNivelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNivelAdm.setSelected(false);
            }
        });
        lbStatus.setSize(80, 40);
        lbStatus.setLocation(40, 400);
        lbStatus.setText("Status: ");
        lbStatus.setHorizontalAlignment(RIGHT);
        lbStatus.setFont(fontLabel);
        jrStatusAtivo.setSize(160, 40);
        jrStatusAtivo.setLocation(140, 400);
        jrStatusAtivo.setText("Ativo");
        // Adicionar ação ao clicar no RadioButton
        jrStatusAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrStatusInativo.setSelected(false);
            }
        });
        jrStatusInativo.setSize(160, 40);
        jrStatusInativo.setLocation(300, 400);
        jrStatusInativo.setText("Inativo");
        // Adicionar ação ao clicar no RadioButton
        jrStatusInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrStatusAtivo.setSelected(false);
            }
        });
        
        // Chamada da action quando o botão é acionado
        // Formatação do layout do botão
        bttReset(bttCadastrar);
        // Manupilação dos eventos do mouse sobre o elemento
        bttCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Formatação do layout do botão
                bttSobre(bttCadastrar);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Formatação do layout do botão
                bttReset(bttCadastrar);
            }
        });
        // Adicionar ao Botão de cadastrar Usuario
        bttCadastrar.addActionListener(e -> inserirUsuario());
        
        // Adição dos elementos ao painel de cadastro
        jpInterno.add(lbPic);
        jpInterno.add(bttCadastrar);
        jpInterno.add(txtLogin);
        jpInterno.add(txtNome);
        jpInterno.add(txtEmail);
        jpInterno.add(txtSenha);
        jpInterno.add(lbLogin);
        jpInterno.add(lbNome);
        jpInterno.add(lbEmail);
        jpInterno.add(lbSenha);
        jpInterno.add(lbNivel);
        jpInterno.add(jrNivelAdm);
        jpInterno.add(jrNivelUser);
        jpInterno.add(lbStatus);
        jpInterno.add(jrStatusAtivo);
        jpInterno.add(jrStatusInativo);

    }
    
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
    
    public void inserirUsuario(){
        // Instancia um usuario novo
        Usuario novoUsuario = new Usuario();
        // Instancia um usuariodao para manipulação do banco de dados
        UsuarioDAO cad = new UsuarioDAO();
        // Define os valores do usuário
        novoUsuario.setLogin(txtLogin.getText());
        novoUsuario.setNome(txtNome.getText());
        novoUsuario.setEmail(txtEmail.getText());
        novoUsuario.setSenha(new String(txtSenha.getPassword()));
        if (jrNivelAdm.isSelected()){
            novoUsuario.setNivel(0);
        } else {
            novoUsuario.setNivel(1);
        }
        if (jrStatusAtivo.isSelected()){
            novoUsuario.setStatus(1);
        } else {
            novoUsuario.setStatus(0);
        }
        // Chama o método de cadastrar novo usuário
        boolean retorno = cad.cadastrar(novoUsuario);
        
        if (retorno) {
            // Mostra uma mensagem se o usuário for cadastrado
            JOptionPane.showMessageDialog(
            null,
            "Usuário cadastrado com sucesso",
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE
            );
            // Limpa os campos
            resetCampos();
        }
        
    }
    
    private void resetCampos(){
        // Apaga e desmarca todos os campos
        txtLogin.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        jrNivelAdm.setSelected(false);
        jrNivelUser.setSelected(false);
        jrStatusAtivo.setSelected(false);
        jrStatusInativo.setSelected(false);
    }
    
    private void inicializarComponentesListar() {
        // Inicializa a instancia da Tabela
        JTable tbUsuario = new JTable();
        // Adiciona o container interno
        add(jpInterno);
        // Altera o Layout do container interno
        jpInterno.setLayout(new GridLayout(1, 1));
        // Personalizar Componentes Lista
        tbUsuario.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Login", "Nome", "Email", "Status", "Nível"
            }
        ));
        // Formatação da tabela com a largura preferivel das colunas
        TableColumnModel columnModel = tbUsuario.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(100);
        // Instancia o usuarioDAO para manipular o BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        // Cria uma array list para receber a lista de alunos e chama o método Listar
        ArrayList<Usuario> listaUsuarios = usuarioDAO.listar();
        // Instancia o modelo da tabela para adicionar as linhas
        DefaultTableModel tabelaModel = (DefaultTableModel) tbUsuario.getModel();
        // Loop de preenchimento das linhas
        for(Usuario usuario : listaUsuarios) {
            // Instancia um objeto linha
            Object[] linha = new Object[6];
            // Carrega os valores para o objeto linha
            linha[0] = usuario.getId();
            linha[1] = usuario.getLogin();
            linha[2] = usuario.getNome();
            linha[3] = usuario.getEmail();
            if (usuario.getStatus() == 0){
                linha[4] = "Inativo";
            } else {
                linha[4] = "Ativo";
            }
            if (usuario.getNivel() == 0) {
                linha[5] = "Administrador";
            } else {
                linha[5] = "Usuário";
            }
            // Adiciona a linha
            tabelaModel.addRow(linha);
        }
        
        tbUsuario.setVisible(true);
        tbUsuario.setSize(480, 300);
        
        JScrollPane scrollpane = new JScrollPane(tbUsuario);
        
        jpInterno.add(scrollpane);
    }
}

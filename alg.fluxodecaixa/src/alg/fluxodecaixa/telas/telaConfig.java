package alg.fluxodecaixa.telas;

import alg.fluxodecaixa.util.ConBD;
import alg.fluxodecaixa.util.Config;
import alg.fluxodecaixa.util.RoundJPassField;
import alg.fluxodecaixa.util.RoundJTextField;
import alg.fluxodecaixa.util.criaArquivoInexistente;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
*/
public class telaConfig extends JFrame{
    
    private JLabel          lbPicConfig     = new JLabel();
    private JLabel          lbHost          = new JLabel();
    private JLabel          lbbdname        = new JLabel();
    private JLabel          lbporta         = new JLabel();
    private JLabel          lbusuario       = new JLabel();
    private JLabel          lbsenha         = new JLabel();
    private String          imageConfig     = "/alg/fluxodecaixa/util/imagens/conf.png";
    private Font            fontLabel       = new Font("Verdana", 1, 14);
    private JTextField      txthost         = new RoundJTextField(15);
    private JTextField      txtbdname       = new RoundJTextField(15);
    private JTextField      txtporta        = new RoundJTextField(15);
    private JTextField      txtusuario      = new RoundJTextField(15);
    private JPasswordField  txtsenha        = new RoundJPassField(15);
    private Color           backApp         = new Color( 0, 123, 255);
    private JButton         bttSalvar        = new JButton();
    /*
    */
    public telaConfig(){
        //Configurações do JFrame
        // Tamanho
        setSize(600, 480);
        // Desabilita o redimensionamento
        setResizable(false);
        // Coloca a função de fechar no botão encerrando a aplicação
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Título da Janel
        setTitle("Configurações");
        // Centraliza o form
        setLocationRelativeTo(null);
        // Coloca o ícone na janela
        setIconImage(new ImageIcon(getClass().getResource(imageConfig)).getImage());
        // Altera a cor do background
        getContentPane().setBackground(backApp);
        
        // Cria o container que será usado de painel
        Container cont = getContentPane();
        // Desabilita o layout padrão
        cont.setLayout(null);
        // Tamanho
        cont.setSize(600, 480);
        
        
        // Chama a inicialização de componentes
        inicializarComponentes();      
        // Habilita a visualização
        setVisible(true);
        
        // Verificar se o arquivo de configuração está preenchido
        // Instancia a classe ConBD
        ConBD conn = new ConBD();
        if (ConBD.getBDhost() != null) { 
            txthost.setText(ConBD.getBDhost());
            txtbdname.setText(ConBD.getBDname());
            txtporta.setText(ConBD.getBDport());
            txtusuario.setText(ConBD.getBDuser());
            txtsenha.setText(ConBD.getBDpass());
        }
    }
    /*
    */
    public static void main(String args[]) {
        // Instancia a tela principal
        telaConfig index = new telaConfig();
    }/*
    */
    private void inicializarComponentes() {
        // Configurações do Label com a imagem no form de configurações
        // Adiciona o icone
        lbPicConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageConfig)));
        // Tamanho
        lbPicConfig.setSize(118, 106);
        // Localização
        lbPicConfig.setLocation(241, 40);
        // Adiciona elemento ao painel
        add(lbPicConfig);
        
        // Configurações da conjunto host
        // Tamanho
        lbHost.setSize(160, 40);
        txthost.setSize(400, 30);
        // Posição
        lbHost.setLocation(40, 160);
        txthost.setLocation(160, 160);
        // Texto apresentado
        lbHost.setText("Host:");
        // Fonte formatada
        lbHost.setFont(fontLabel);
        // Cor da fonte
        lbHost.setForeground(Color.WHITE);
        // Adiciona os elementos ao painel
        add(lbHost);
        add(txthost);
        
        // Configurações da conjunto bdname
        // Tamanho
        lbbdname.setSize(160, 40);
        txtbdname.setSize(400, 30);
        // Posição
        lbbdname.setLocation(40, 200);
        txtbdname.setLocation(160, 200);
        // Texto apresentado
        lbbdname.setText("Database:");
        // Fonte formatada
        lbbdname.setFont(fontLabel);
        // Cor da fonte
        lbbdname.setForeground(Color.WHITE);
        // Adiciona os elementos ao painel
        add(lbbdname);
        add(txtbdname);
        
        // Configurações da conjunto porta
        // Tamanho
        lbporta.setSize(160, 40);
        txtporta.setSize(400, 30);
        // Posição
        lbporta.setLocation(40, 240);
        txtporta.setLocation(160, 240);
        // Texto apresentado
        lbporta.setText("Porta:");
        // Fonte formatada
        lbporta.setFont(fontLabel);
        // Cor da fonte
        lbporta.setForeground(Color.WHITE);
        // Adiciona os elementos ao painel
        add(lbporta);
        add(txtporta);

        // Configurações da conjunto usuario
        // Tamanho
        lbusuario.setSize(160, 40);
        txtusuario.setSize(400, 30);
        // Posição
        lbusuario.setLocation(40, 280);
        txtusuario.setLocation(160, 280);
        // Texto apresentado
        lbusuario.setText("Usuário:");
        // Fonte formatada
        lbusuario.setFont(fontLabel);
        // Cor da fonte
        lbusuario.setForeground(Color.WHITE);
        // Adiciona os elementos ao painel
        add(lbusuario);
        add(txtusuario);
        
        // Configurações da conjunto senha
        // Tamanho
        lbsenha.setSize(160, 40);
        txtsenha.setSize(400, 30);
        // Posição
        lbsenha.setLocation(40, 320);
        txtsenha.setLocation(160, 320);
        // Texto apresentado
        lbsenha.setText("Senha:");
        // Fonte formatada
        lbsenha.setFont(fontLabel);
        // Cor da fonte
        lbsenha.setForeground(Color.WHITE);
        // Adiciona os elementos ao painel
        add(lbsenha);
        add(txtsenha);
        
        // Configurações do botão de Salvar
        // Tamanho
        bttSalvar.setSize(120, 40);
        // Posição
        bttSalvar.setLocation(440, 360);
        // Texto apresentado
        bttSalvar.setText("Salvar");
        // Chamada da action quando o botão é acionado
        bttSalvar.addActionListener(e -> salvarConfig());
        // Formatação do layout do botão
        bttReset(bttSalvar);
        // Manupilação dos eventos do mouse sobre o elemento
        bttSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Formatação do layout do botão
                bttSobre(bttSalvar);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Formatação do layout do botão
                bttReset(bttSalvar);
            }
        });
        // Adiciona elemento ao painel
        add(bttSalvar);
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
    
    public void salvarConfig(){
        Config conf;
        try {
            conf = new Config();
            boolean salvar = conf.setConfig(
                txthost.getText(),
                this.txtbdname.getText(),
                this.txtporta.getText(),
                this.txtusuario.getText(),
                new String(this.txtsenha.getPassword())
                );
            if (salvar){
                JOptionPane.showMessageDialog(
                null,
                "Salvo com sucesso.",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
                this.dispose();
            }
        } catch (criaArquivoInexistente ex) {
            Logger.getLogger(telaConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
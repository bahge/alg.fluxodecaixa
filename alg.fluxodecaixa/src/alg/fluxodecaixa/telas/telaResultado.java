/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg.fluxodecaixa.telas;

import alg.fluxodecaixa.resultado.despesa.despesa;
import alg.fluxodecaixa.resultado.despesa.despesaDAO;
import alg.fluxodecaixa.resultado.receita.receita;
import alg.fluxodecaixa.resultado.receita.receitaDAO;
import alg.fluxodecaixa.resultado.relatorio.relatorioDAO;
import alg.fluxodecaixa.usuarioModel.DAO.UsuarioDAO;
import alg.fluxodecaixa.usuarioModel.Usuario;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author bahge
 */
public class telaResultado extends JFrame{
    private JTable tblResultados = new JTable();
    
    public telaResultado(int tipo){      
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setResizable(false);
        setLayout(new GridLayout(1, 1));
        preencherTabelaResultados(tblResultados, tipo);
        tblResultados.setSize(800, 500);
        tblResultados.setVisible(true);
        add(tblResultados);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        switch(tipo) {
            case 1:
                setTitle("RELATÓRIO DE RECEITAS");
                break;
            case 2:
                setTitle("RELATÓRIO DE DESPESAS");
                break;
        }
        String mensagem = "";
        relatorioDAO relatorio = new relatorioDAO();
        
        float diferenca = relatorio.consultar();
        if (diferenca > 0) {   
                mensagem = "A situação é boa \n Você acumulou: "+diferenca+"\n Sobrou dinheiro e você está superavitario!\nO Paulo manda parabéns!";
        } else if (diferenca < 0) {   
                mensagem = "A situação não é boa\n  Você acumulou: "+diferenca+"\nViajou bastante é deficitário!\nA Cris vai interditar você!";
        } else {   
                mensagem = "A situação não melhorou nem piorou.\n Segue na mesma!\nComo tchê fala, não sofre por antecedência!";
        }
        JOptionPane.showMessageDialog(
            null,
            mensagem,
            "Acontece!!",
            JOptionPane.INFORMATION_MESSAGE
        );
        
    }
    /*
    public static void main(String args[]){
        telaResultado tela = new telaResultado(1);
    }
    */
    private void preencherTabelaResultados (JTable tbResultados, int tipo){
        tbResultados.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo", "Valor", "Mes", "Ano"
            }
        ));
        String[] tit = new String [] {"Código", "Tipo", "Valor", "Mes", "Ano"};
        
        if (tipo == 1) {
            // Instancia o usuarioDAO para manipular o BD
            receitaDAO receitas = new receitaDAO();
            // Cria uma array list para receber a lista de alunos e chama o método Listar
            ArrayList<receita> listaReceita = receitas.listar();
            // Instancia o modelo da tabela para adicionar as linhas
            DefaultTableModel tabelaModel = (DefaultTableModel) tbResultados.getModel();
            // Limpa campos da tabela
            tabelaModel.setRowCount(0);
            // Loop de preenchimento das linhas
            tabelaModel.addRow(tit);
            for(receita receitaVar : listaReceita) {
                // Instancia um objeto linha
                Object[] linha = new Object[6];
                // Carrega os valores para o objeto linha
                linha[0] = receitaVar.getId();
                // Ver enum
                int i = receitaVar.getTipo();
                switch(i){
                    case 1:
                        linha[1] = "Trabalhistas";
                        break;
                    case 2:
                        linha[1] = "Patrimoniais";
                        break;
                }
                linha[2] = receitaVar.getValor();
                linha[3] = receitaVar.getMes();
                linha[4] = receitaVar.getAno();
                // Adiciona a linha
                tabelaModel.addRow(linha);
            }  
        }
        if (tipo == 2) {
            // Instancia o usuarioDAO para manipular o BD
            despesaDAO despesas = new despesaDAO();
            // Cria uma array list para receber a lista de alunos e chama o método Listar
            ArrayList<despesa> listaDespesa = despesas.listar();
            // Instancia o modelo da tabela para adicionar as linhas
            DefaultTableModel tabelaModel = (DefaultTableModel) tbResultados.getModel();
            // Limpa campos da tabela
            tabelaModel.setRowCount(0);
            // Loop de preenchimento das linhas
            tabelaModel.addRow(tit);
            for(despesa despesaVar : listaDespesa) {
                // Instancia um objeto linha
                Object[] linha = new Object[6];
                // Carrega os valores para o objeto linha
                linha[0] = despesaVar.getId();
                // Ver enum
                int i = despesaVar.getTipo();
                switch(i){
                    case 1:
                        linha[1] = "Alimentação";
                        break;
                    case 2:
                        linha[1] = "Moradia";
                        break;
                    case 3:
                        linha[1] = "Educação";
                        break;
                    case 4:
                        linha[1] = "Saúde";
                        break;
                    case 5:
                        linha[1] = "Transporte";
                        break;
                    case 6:
                        linha[1] = "Outras";
                        break;
                }
                linha[2] = despesaVar.getValor();
                linha[3] = despesaVar.getMes();
                linha[4] = despesaVar.getAno();
                // Adiciona a linha
                tabelaModel.addRow(linha);
            }  
        }
        
    }
  
}

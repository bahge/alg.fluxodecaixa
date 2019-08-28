package alg.fluxodecaixa.resultado.receita;

import alg.fluxodecaixa.interfaces.controleDeGastos;
import alg.fluxodecaixa.resultado.resultado;

public class receita extends resultado implements controleDeGastos{
    
    
    @Override
    public void inserir(resultado novoResultado) {
        receitaDAO novaReceitaDAO = new receitaDAO();
        receita novaReceita = new receita();
        novaReceita = (receita) novoResultado; 
        boolean resultado = novaReceitaDAO.cadastrar(novaReceita);
        System.out.println(resultado);
    }

    @Override
    public void consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


/*System.out.println(
                novaReceita.getValor() + "\n"+
                novaReceita.getAno() + "\n"+
                novaReceita.getMes() + "\n"+
                novaReceita.getTipo() + "\n"                                
                    );*/
        
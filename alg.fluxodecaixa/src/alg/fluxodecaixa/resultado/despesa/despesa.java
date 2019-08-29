package alg.fluxodecaixa.resultado.despesa;

import alg.fluxodecaixa.interfaces.controleDeGastos;
import alg.fluxodecaixa.resultado.receita.receita;
import alg.fluxodecaixa.resultado.receita.receitaDAO;
import alg.fluxodecaixa.resultado.resultado;

public class despesa extends resultado implements controleDeGastos {
    private int contadespesa;

    @Override
    public void inserir(resultado novoResultado) {
        despesaDAO novaDespesaDAO = new despesaDAO();
        despesa novaDespesa = new despesa();
        novaDespesa = (despesa) novoResultado; 
        boolean resultado = novaDespesaDAO.cadastrar(novaDespesa);
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

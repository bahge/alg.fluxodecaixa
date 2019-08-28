package alg.fluxodecaixa.interfaces;

import alg.fluxodecaixa.resultado.resultado;

public interface controleDeGastos {
    public void inserir(resultado novoResultado);
    public void consultar(int id);
    public void editar(int id);
}

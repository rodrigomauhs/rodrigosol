package br.ufmg.dcc.pos.tl.glc.model;


public class Producao implements Comparable<Producao>{
    private Agrupamento agrupamento;
    private Variavel variavel;

    public Producao(Variavel v, Agrupamento a){
	this.variavel = v;
	this.agrupamento = a;
    }
    
    @Override
    public String toString() {
	return variavel + "-->" +  agrupamento; 
    }

    public int compareTo(Producao o) {
	return this.toString().compareTo(o.toString());
    }

    public Agrupamento getAgrupamento() {
        return agrupamento;
    }

    public Variavel getVariavel() {
        return variavel;
    }
    
    
}

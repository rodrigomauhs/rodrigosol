package br.ufmg.dcc.pos.tl.glc.model;

import java.util.ArrayList;
import java.util.Collection;

public class Agrupamento {
    public Collection<Simbolo> getAgrupamento() {
        return agrupamento;
    }

    public void setAgrupamento(Collection<Simbolo> agrupamento) {
        this.agrupamento = agrupamento;
    }

    private Collection<Simbolo> agrupamento = new ArrayList<Simbolo>();
    
    public Agrupamento(Variaveis v, Alfabeto z, String str) {
	for(int i = 0; i < str.length(); i++){
	    char c = str.charAt(i);
	    if(isVariavel(c)){
		comporAgrupamento(v.get(String.valueOf(c)));
	    }else{
		comporAgrupamento(z.get(String.valueOf(c)));
	    }
	}
    }
    
    private boolean isVariavel(char c) {
	return ((int)c >= 60) && ((int)c <= 90) ? true : false; 
    }

    public void comporAgrupamento(Simbolo s){
	agrupamento.add(s);
    }
    
    @Override
    public String toString() {
	StringBuffer sb = new StringBuffer();
	for (Simbolo s : agrupamento) {
	    sb.append(s);
	}
	return sb.toString();
    }
    
    public boolean equals(Agrupamento obj) {
        return this.toString().equals(obj.toString());
    }

    public boolean pertence(Simbolo y) {
	for (Simbolo s : agrupamento) {
	    if(s.equals((Variavel)y)){
		return true;
	    }
	}
	return false;
    }
}

package br.ufmg.dcc.pos.tl.glc.model;

import java.util.Collection;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Regras {
    public Collection<Producao> producoes = new TreeSet<Producao>();
    public Collection<Producao> getProducoes() {
        return producoes;
    }

    private Variaveis v;
    private Alfabeto z;
    
    public Regras(Variaveis v,Alfabeto z){
	this.v = v;
	this.z = z;
    }
    
    public void add(String l, String r){
	
	Variavel var = v.get(l);
	StringTokenizer st = new StringTokenizer(r,"|");
	while(st.hasMoreElements()){
	    Agrupamento agru = new Agrupamento(v,z,st.nextToken());
	    producoes.add(new Producao(var,agru));
	}
    }

    public void add(Producao p) {
	producoes.add(p);
    }
}


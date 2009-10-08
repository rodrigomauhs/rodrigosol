package br.ufmg.dcc.pos.tl.glc.model;

import java.util.Collection;
import java.util.TreeSet;

public class Variaveis {
    public Collection<Variavel> variaveis = new TreeSet<Variavel>();

    public Variaveis(String str) {
	str = str.toUpperCase();
	for(int i = 0; i < str.length(); i++){
	    variaveis.add(new Variavel(String.valueOf(str.charAt(i))));
	}

    }

    public Collection<Variavel> getVariaveis() {
	return variaveis;
    }

    public void add(String var) {
	variaveis.add(new Variavel(var));

    }

    public void add(Variavel variavel) {
	variaveis.add(variavel);
    }

    public Variavel get(String l) {
	for (Variavel var : variaveis) {
	    if (var.is(l)) {
		return var;
	    }
	}
	return null;
    }

    public Object get(Variavel variavel) {
	return get(variavel.getVar());
    }

    @Override
    public String toString() {
	StringBuffer sb = new StringBuffer();
	for (Variavel v : this.variaveis) {
	    sb.append(v);
	}
	return sb.toString();

    }

    public void add(Variaveis vars) {
	this.variaveis.addAll(vars.getVariaveis());
    }
}

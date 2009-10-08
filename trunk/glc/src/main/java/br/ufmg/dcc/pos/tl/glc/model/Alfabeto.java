package br.ufmg.dcc.pos.tl.glc.model;

import java.util.Collection;
import java.util.TreeSet;

public class Alfabeto {
    public Collection<Terminal> terminais = new TreeSet<Terminal>();
    
    public Alfabeto(String str){
	str = str.toLowerCase();
	for(int i = 0; i < str.length(); i++){
	    terminais.add(new Terminal(String.valueOf(str.charAt(i))));
	}
    }

    public Collection<Terminal> getTerminais() {
        return terminais;
    }

    public Simbolo get(String c) {
	for (Terminal t : terminais) {
	    if(t.is(c)){
		return t;
	    }
	}
	return null;
    }

}

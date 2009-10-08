package br.ufmg.dcc.pos.tl.glc;

import br.ufmg.dcc.pos.tl.glc.agoritmos.EliminarVarInuteis;
import br.ufmg.dcc.pos.tl.glc.agoritmos.Manipulador;
import br.ufmg.dcc.pos.tl.glc.model.Alfabeto;
import br.ufmg.dcc.pos.tl.glc.model.GLC;
import br.ufmg.dcc.pos.tl.glc.model.Regras;
import br.ufmg.dcc.pos.tl.glc.model.Variaveis;

public class Main {
    public static void main(String[] args) {
	
	Alfabeto z = new Alfabeto("01");
	Variaveis v =  new Variaveis("ABCDEF");
	Regras r = new Regras(v,z);
	
	r.add("A","ABC|AEF|BD");
	r.add("B","B0|0");
	r.add("C","0C|EB");
	r.add("D","1D|1");
	r.add("E","BE");
	r.add("F","1F1|1");
    
	GLC glc = new GLC(v,z,r,v.get("A"));
	System.out.println(glc);
	
	Manipulador m = new EliminarVarInuteis();
	m.manipular(glc);
	System.out.println("Gramatica Final:" + glc);
    }
}

package br.ufmg.dcc.pos.tl.glc;

import br.ufmg.dcc.pos.tl.glc.model.Alfabeto;
import br.ufmg.dcc.pos.tl.glc.model.Producao;
import br.ufmg.dcc.pos.tl.glc.model.Regras;
import br.ufmg.dcc.pos.tl.glc.model.Simbolo;
import br.ufmg.dcc.pos.tl.glc.model.Terminal;
import br.ufmg.dcc.pos.tl.glc.model.Variaveis;
import br.ufmg.dcc.pos.tl.glc.model.Variavel;

public class GLCUtil {

    public static boolean isVarProduzTerminal(Producao p){
	String agru = p.getAgrupamento().toString();
	return (agru.length()==1 && isSoTerminais(agru));
    }

    private static boolean isSoTerminais(String agru) {
	return agru.toLowerCase().equals(agru);
    }

    public static Regras purificar(Alfabeto z, Regras r, Variaveis v) {
	Regras regras = new Regras(v,z);
	for (Producao p : r.getProducoes()) {
	    if(v.get(p.getVariavel()) != null){
		boolean flag = true;
		for (Simbolo s : p.getAgrupamento().getAgrupamento()) {
		    if(!((s instanceof Terminal  && z.get(s.toString()) != null) ||
			 (s instanceof Variavel  && v.get((Variavel)s) != null))){
			    flag = false;
			    break;
		    }
		}
		    
		if(flag){
		    regras.add(p);
		}
		
	    }
	}
	return regras;
    }
}

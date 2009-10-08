package br.ufmg.dcc.pos.tl.glc.agoritmos;

import br.ufmg.dcc.pos.tl.glc.GLCUtil;
import br.ufmg.dcc.pos.tl.glc.model.GLC;
import br.ufmg.dcc.pos.tl.glc.model.Producao;
import br.ufmg.dcc.pos.tl.glc.model.Simbolo;
import br.ufmg.dcc.pos.tl.glc.model.Terminal;
import br.ufmg.dcc.pos.tl.glc.model.Variaveis;
import br.ufmg.dcc.pos.tl.glc.model.Variavel;

public class EliminarVarInuteis implements Manipulador {

    public GLC manipular(GLC glc) {
	Variaveis i1 = passo1(glc);
	System.out.println("i1:" + i1);
	glc.setR(GLCUtil.purificar(glc.getZ(),glc.getR(),i1));
	glc.setV(i1);
	System.out.println("nova GLC:" + glc);
	
	Variaveis i2 = passo2(glc);
	glc.setR(GLCUtil.purificar(glc.getZ(),glc.getR(),i2));
	glc.setV(i2);
	
	return glc;
    }

    private Variaveis passo2(GLC glc) {
	Variaveis i = new Variaveis(glc.getP().toString());
	Variaveis n;
	
	do{
	    n = new Variaveis("");
	    for (Producao p : glc.getR().getProducoes()) {
		for(Simbolo y : p.getAgrupamento().getAgrupamento()){
		    if(y instanceof Variavel){
			if (i.get((Variavel)y) == null) {
			    for(Producao pp: glc.getR().getProducoes()){
				Variavel x = pp.getVariavel();
				if (i.get(x) != null) {
				    if(pp.getAgrupamento().pertence(y)){
					n.add((Variavel)y);
					break;
				    }
				}
			    }
			}
		    }
		}
	    }
	    i.add(n);	    
	}while (!n.getVariaveis().isEmpty());
	
	return i;
    }

    private Variaveis passo1(GLC glc) {

	Variaveis i = new Variaveis("");
	Variaveis n;

	do {
	    n = new Variaveis("");
	    for (Producao p : glc.getR().getProducoes()) {
		if (i.get(p.getVariavel()) == null) {
		    boolean flag = true;
		    for (Simbolo s : p.getAgrupamento().getAgrupamento()) {
			if(!((s instanceof Terminal  && glc.getZ().get(s.toString()) != null) ||
			  (s instanceof Variavel  && i.get((Variavel)s) != null))){
			    flag = false;
			    break;
			}
		    }
		    if(flag){
			n.add(p.getVariavel());
		    }
		}
	    }
	    i.add(n);

	} while (!n.getVariaveis().isEmpty());
	return i;
    }
}

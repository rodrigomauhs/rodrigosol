package br.ufmg.dcc.pos.tl.glc.model;


public class GLC {
    public Variaveis getV() {
        return V;
    }

    public void setV(Variaveis v) {
        V = v;
    }

    public Alfabeto getZ() {
        return Z;
    }

    public void setZ(Alfabeto z) {
        Z = z;
    }

    public Regras getR() {
        return R;
    }

    public void setR(Regras r) {
        R = r;
    }

    public Variavel getP() {
        return P;
    }

    public void setP(Variavel p) {
        P = p;
    }

    private Variaveis V;
    private Alfabeto Z;
    private Regras R;
    private Variavel P;
    
    public GLC(Variaveis V, Alfabeto Z, Regras R, Variavel P){
	this.V = V;
	this.Z = Z;
	this.R = R;
	this.P = P;
    }
    
    @Override
    public String toString() {
	StringBuffer sb = new StringBuffer("G=({");
	sb.append(V).append("},{");
	for (Terminal t : Z.getTerminais()){
	    sb.append(t);
	}
	sb.append("},R,").append(P).append(")\n");
	
	for (Producao p : R.getProducoes()) {
	    sb.append(p.toString()).append("\n");
	}
	
	return sb.toString();
    }
}

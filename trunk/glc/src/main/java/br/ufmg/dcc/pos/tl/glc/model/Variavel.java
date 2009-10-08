package br.ufmg.dcc.pos.tl.glc.model;

public class Variavel extends Simbolo implements Comparable<Variavel> {
    private String var = "";
    public Variavel(String x){
	this.var = x;
    }
    public String getVar() {
        return var;
    }
    public void setVar(String var) {
        this.var = var;
    }
    public boolean equals(Variavel var) {
	return  this.var.equals(var.getVar());
    }
    public boolean is(String val) {
	return var.equals(val);
    }
    
    @Override
    public String toString() {
        return var;
    }
    public int compareTo(Variavel o) {
	return var.compareTo(o.getVar());
    }
    
}

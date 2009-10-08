package br.ufmg.dcc.pos.tl.glc.model;

public class Terminal extends Simbolo implements Comparable<Terminal>{
    String t;
    public Terminal(String t) {
	this.t = t; 
    }
    
    public boolean equals(Terminal ter) {
	return ter.equals(t);
    }

    public boolean is(String t) {
	return this.t.equals(t);
    }
 
    @Override
    public String toString() {
        return t;
    }

    public int compareTo(Terminal o) {
	return t.compareTo(o.getT());
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
}

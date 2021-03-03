package Arvore;

import java.io.Serializable;

public class NoAB<G> implements Serializable{
    private NoAB esq;
    private NoAB dir;
    private NoAB pai;
    private G info;

    public NoAB(){
    }

    public NoAB(G info) {
        this.info = info;
    }

    public NoAB(NoAB esq, NoAB dir,NoAB pai, G info) {
        this.esq = esq;
        this.dir = dir;
        this.pai = pai;
        this.info = info;
    }

        public NoAB(G info, NoAB pai, NoAB esq, NoAB dir) {
        this.info = info;
        this.pai = pai;
        this.esq = esq;
        this.dir = dir;
    }

    public NoAB getPai() {
        return pai;
    }

    public void setPai(NoAB pai) {
        this.pai = pai;
    }

    public NoAB getEsq() {
        return esq;
    }

    public void setEsq(NoAB esq) {
        this.esq = esq;
    }

    public NoAB getDir() {
        return dir;
    }

    public void setDir(NoAB dir) {
        this.dir = dir;
    }

    public G getInfo() {
        return info;
    }

    public void setInfo(G info) {
        this.info = info;
    }  
}
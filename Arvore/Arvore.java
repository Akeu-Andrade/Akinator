package Arvore;

import java.io.Serializable;
public class Arvore<G> implements Serializable{
    private int tamanho;
    private NoAB raiz;
    
    public Arvore() {
        NoAB raiz = null;
        tamanho = 0;
    }

    public NoAB getRaiz() {
        return raiz;
    }
    
    
    protected NoAB criarNo(NoAB esquerda, NoAB direita, NoAB pai, G info) {
        return new NoAB(direita, esquerda, pai, info); 
    }
    
    public int tamanho(){
        return tamanho;
    }
    
    public boolean estaVazia(){
        return raiz == null;
    }
    
    public void addRaiz(G novo){
        tamanho = 1;
        raiz = criarNo(null, null, null, novo);
    }
    
    public void inserirEsquerda(G info) throws Exception{
        if(estaVazia()){
            addRaiz(info);
        }else{
            insEsq(raiz, info);
        }
    }
    
    protected NoAB checarPosition(NoAB v) throws Exception {
    if (v == null || !(v instanceof NoAB))
      throw new Exception("Posição invalida!!!");
    return (NoAB) v;
    }
    
//    if (ref.getEsq() != null)
//            insEsq(ref.getEsq(), info);
    
    private void insEsq(NoAB referencia, G info) throws Exception{
        NoAB ref = checarPosition(referencia);
        NoAB novo = criarNo(null, null, ref, info);
        ref.setEsq(novo);
        tamanho++;
    }
    
    public void inserirDireita(G info) throws Exception{
        if(estaVazia()){
            addRaiz(info);
        }else{
            insDir(raiz, info);
        }
    }
    
    private void insDir(NoAB referencia, G info) throws Exception{
        NoAB ref = checarPosition(referencia);
        NoAB novo = criarNo(null, null, ref, info);
        ref.setDir(novo);
        tamanho++;
    }

}
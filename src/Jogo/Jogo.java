package Jogo;

import Arvore.Arvore;
import Arvore.NoAB;
import Pesistencia.IOObjeto;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class Jogo implements Serializable {
    Arvore arv = new Arvore();
    private String path = "C:\\Users\\Akeu-ifs\\Documents\\JogoArvoreBinaria\\arquivo2.dat";

    public Jogo() throws Exception {
        arv = lerJogo();
        if (arv.estaVazia()) {
            primeiraRodada();
            salvarJogo();
            return;
        }
        regraDeNegocio(arv.getRaiz());
        salvarJogo();
    }

    private boolean estaNaFolha(NoAB arv) {
        return arv.getDir() == null && arv.getEsq() == null;
    }

    String msg= null;
    private void regraDeNegocio(NoAB arv) {
        if (arv == null) {
            return;
        }
        if(estaNaFolha(arv)){
            JOptionPane.showMessageDialog(null, "Você pensou em: ");
        }
        int op = opcao((String) arv.getInfo());
        //System.out.println(arv);
        if(op == 1 && estaNaFolha(arv)){
            JOptionPane.showMessageDialog(null, "É eu sei, eu sou demais!!! ");
        } if(op == 1){
            if (arv.getDir() != null){
                regraDeNegocio(arv.getDir());
            }
        }else if(op == 2){
            //System.out.println(arv.getEsq());
            if(arv.getEsq() == null){
                JOptionPane.showMessageDialog(null, "Ainda estou em fase de teste, me ajude a aumentar a probablidade de acerto.");
                NoAB no = new NoAB(arv.getInfo());
                arv.setEsq(no);
                tst = 1;
                while (tst == 1) {                    
                    strtst = JOptionPane.showInputDialog("Adicione uma caricterisitica do que voce pensou: ");
                    tst = tratamento(strtst);
                }
                arv.setInfo(strtst);
                tst = 1;
                while (tst == 1) {                    
                    strtst = JOptionPane.showInputDialog("Adicione o que voce pensou: ");
                    tst = tratamento(strtst);
                }
                arv.setDir(adicionar(strtst));
            }else{
                regraDeNegocio(arv.getEsq());
            }
        }
    }

    private NoAB adicionar(String str){
        NoAB no = new NoAB(str);
        return no;
    }

    private int opcao(String arv){
        int op = JOptionPane.showConfirmDialog(null, arv, "Responda", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            return 1;
        } else {
            return 2;
        }
    }
    private int tratamento(String str){
        if (str != null && str.trim().length() > 0) {
            return 0;
        }else{
            return 1;
        }
    }
    int tst = 1;
    String strtst = null;
    private void primeiraRodada() throws Exception {
        while (tst == 1) {            
            strtst = JOptionPane.showInputDialog("Digite uma pergunta caracteristica do que voce pensou: ");
            tst = tratamento(strtst);
        }
        arv.addRaiz(strtst);
        tst = 1;
        while(tst == 1){
            strtst = JOptionPane.showInputDialog("Digite o que você pensou: ");
            tst = tratamento(strtst);
        }
        arv.inserirDireita(strtst);
        tst = 1;
        while(tst == 1){
            strtst = JOptionPane.showInputDialog("Digite qualquer outra coisa não carecteristico: ");
            tst = tratamento(strtst);
        }
        arv.inserirEsquerda(strtst);
    }

    private Arvore lerJogo() {
        try {
            IOObjeto iOObjeto = new IOObjeto(path);
            arv = (Arvore) iOObjeto.ler();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arv;
    }

    private void salvarJogo() {
        try {
            IOObjeto iOObjeto = new IOObjeto(path);
            iOObjeto.escrever(arv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

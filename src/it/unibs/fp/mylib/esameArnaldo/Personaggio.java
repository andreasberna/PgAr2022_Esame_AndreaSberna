package it.unibs.fp.mylib.esameArnaldo;

import java.util.ArrayList;

public class Personaggio {
    String nome;
    int vitaIniziale = 20;
    int valoreAttaccoBase = 5;
    int valoreDifesaBase = 5;
    int[] posizione = new int[2];
    int potenza = 1;
    //ArrayList<Oggetti> inventario = new ArrayList<Oggetti> ();


    public Personaggio(String nome, int vitaIniziale, int valoreAttaccoBase, int valoreDifesaBase, int[] posizione, int potenza) {
        this.nome = nome;
        this.vitaIniziale = vitaIniziale;
        this.valoreAttaccoBase = valoreAttaccoBase;
        this.valoreDifesaBase = valoreDifesaBase;
        this.posizione = posizione;
        this.potenza = potenza;
    }

    public String getNome() {
        return nome;
    }

    public int getVitaIniziale() {
        return vitaIniziale;
    }

    public void setVitaIniziale(int vitaIniziale) {
        this.vitaIniziale = vitaIniziale;
    }

    public int getValoreAttaccoBase() {
        return valoreAttaccoBase;
    }

    public void setValoreAttaccoBase(int valoreAttaccoBase) {
        this.valoreAttaccoBase = valoreAttaccoBase;
    }

    public int getValoreDifesaBase() {
        return valoreDifesaBase;
    }

    public void setValoreDifesaBase(int valoreDifesaBase) {
        this.valoreDifesaBase = valoreDifesaBase;
    }

    public int[] getPosizione() {
        return posizione;
    }

    public void setPosizione(int[] posizione) {
        this.posizione = posizione;
    }

    public int getPotenza() {
        return potenza;
    }

    public void setPotenza(int potenza) {
        this.potenza = potenza;
    }

    public void movimento(){
        Character lettera = null;
        switch (lettera){
            case 'w':
                getPosizione()[1] += 1;
                break;
            case 's':
                getPosizione ()[1] -= 1;
                break;
            case 'a':
                getPosizione ()[0] -= 1;
                break;
            case 'd':
                getPosizione ()[0] += 1;
        }
    }
}

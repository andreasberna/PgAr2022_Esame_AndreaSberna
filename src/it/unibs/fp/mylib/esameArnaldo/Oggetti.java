package it.unibs.fp.mylib.esameArnaldo;

import java.util.ArrayList;
import java.util.Random;

public class Oggetti {

    public class Arma extends Oggetti {
        String[] nomiPredefiniti = {"Alabarda", "AsciaBipenne", "Falcetto", "Giavellotto", "Maglio", "Lancia", "Pugnale", "SpadaCorta", "Scimitarra", "MazzaFrusto", "MartelloLeggero", "Picca", "Randello", "Stocco", "Tridente", "SpadaLunga", "PicconeDaGuerra", "Mazza", "Falcione", "Frusta", "BastoneFerrato"};
        String nomeArma;
        int potenzaArma;

        public Arma(String nomeArma, int potenzaArma) {
            this.nomeArma = nomeArma;
            this.potenzaArma = potenzaArma;
        }

        public String getNomeArma() {
            return nomeArma;
        }

        public String setNomeArma() {
            Random rndArma = new Random ();
            return this.nomeArma = nomiPredefiniti[rndArma.nextInt (nomiPredefiniti.length + 1)];
        }

        public int getPotenzaArma() {
            return potenzaArma;
        }

        public int setPotenzaArma() {
            Random rndPotenzaA = new Random ();
            return this.potenzaArma = (int) rndPotenzaA.nextInt ((55 - 35) +1);
        }

        public Arma generaArma(){
            String nomeA = setNomeArma ();
            int potenzaA = setPotenzaArma ();
            Arma a = new Arma (nomeA, potenzaA);
            return a;
        }
    }

    public class Scudo extends Oggetti {
        int vita = 5;

        public Scudo(int vita) {
            this.vita = vita;
        }

        public int getVita() {
            return vita;
        }

        public void setVita(int vita) {
            this.vita = vita;
        }

        public Scudo generaScudo(){
            Scudo s = new Scudo (this.vita);
            return s;
        }
    }

    public class Pozione extends Oggetti{
        int vitaGenerata;

        public Pozione(int vitaGenerata) {
            this.vitaGenerata = vitaGenerata;
        }

        public int generaVita(Integer vitaAttuale){
            this.vitaGenerata = (int) vitaAttuale / 2;
            return this.vitaGenerata;
        }

        public Pozione generaPozione(){
            this.vitaGenerata = generaVita (null);
            Pozione p = new Pozione (this.vitaGenerata);
            return p;
        }
    }

    public Oggetti creaOggetto(){
        Arma spada = null;
        Scudo scudo = null;
        Pozione pozione = null;
        int[] checkValue = {1,1,1,1,1,1,1,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,1,1,1,1,1,1,1,3,3,3,3,3,3,3,3,3,3,3,3,3};
        Random rndV = new Random ();
        int valore = rndV.nextInt (0,100);
        if (checkValue[valore] == 1) {spada.generaArma (); return spada;}
        else if (checkValue[valore] == 2) {scudo.generaScudo (); return scudo;}
        if (checkValue[valore] == 3) {pozione.generaPozione (); return pozione;}
        return null;
    }

}

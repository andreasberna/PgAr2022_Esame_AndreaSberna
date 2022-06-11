package it.unibs.fp.mylib.esameArnaldo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mostro {
    String nomeMostro;
    int vitaIniziale;
    int attaccoIniziale = 5;
    int difesaIniziale = 5;
    int arma;
    int[] posizioneMostro = new int[2];
    String str = "Dijkstra";

    public Mostro(String nomeMostro, int vitaIniziale, int attaccoIniziale, int difesaIniziale, int arma, int[] posizioneMostro) {
        this.nomeMostro = nomeMostro;
        this.vitaIniziale = vitaIniziale;
        this.attaccoIniziale = attaccoIniziale;
        this.difesaIniziale = difesaIniziale;
        this.arma = arma;
        this.posizioneMostro = posizioneMostro;
    }

    public String getNomeMostro() {
        return nomeMostro;
    }

    public String setNomeMostro() {
        this.nomeMostro = findPermutations (str) ;
        return this.nomeMostro;
    }

    public int getVitaIniziale() {
        return vitaIniziale;
    }

    public void setVitaIniziale(int vitaIniziale) {
        Random rnd1 = new Random ();
        int maxValVita = 25;
        int minValVita = 15;
        this.vitaIniziale = rnd1.nextInt ((maxValVita - minValVita) + 1);
    }

    public int getAttaccoIniziale() {
        return attaccoIniziale;
    }

    public void setAttaccoIniziale(int attaccoIniziale) {
        this.attaccoIniziale = attaccoIniziale;
    }

    public int getDifesaIniziale() {
        return difesaIniziale;
    }

    public void setDifesaIniziale(int difesaIniziale) {
        this.difesaIniziale = difesaIniziale;
    }

    public int getArma() {
        return arma;
    }

    public int setArma() {
        Random rnd2 = new Random ();
        int maxVal = 55;
        int minVal = 35;
        this.arma = rnd2.nextInt ((maxVal - minVal) + 1);
        return this.arma;
    }

    public int[] getPosizioneMostro() {
        return posizioneMostro;
    }

    public void setPosizioneMostro(int[] posizioneMostro) {
        this.posizioneMostro = posizioneMostro;
    }

    public static String findPermutations(String str)
    {
        // caso base
        if (str == null || str.length() == 0) {
            return null;
        }

        // crea un ArrayList vuoto per memorizzare le permutazioni (parziali).
        List<String> partial = new ArrayList<> ();

        // inizializza la lista con il primo carattere della stringa
        partial.add(String.valueOf(str.charAt(0)));

        // fare per ogni carattere della stringa specificata
        for (int i = 1; i < str.length(); i++)
        {
            // considera una per una le permutazioni parziali costruite in precedenza

            // (itera indietro per evitare ConcurrentModificationException)
            for (int j = partial.size() - 1; j >= 0 ; j--)
            {
                // rimuove la permutazione parziale corrente da ArrayList
                String s = partial.remove(j);

                // Inserisce il carattere successivo della stringa specificata
                // possibili posizioni di permutazione parziale corrente. Quindi
                // inserisce ciascuna di queste stringhe di nuova costruzione nell'elenco

                for (int k = 0; k <= s.length(); k++)
                {
                    // Consiglio: usa StringBuilder per la concatenazione
                    partial.add(s.substring(0, k) + str.charAt(i) + s.substring(k));
                }
            }
        }
        Random rnd3 = new Random ();

        return partial.get (rnd3.nextInt (partial.size () + 1));
    }

    public Mostro generaMostro(){
        String nome = setNomeMostro ();
        Mostro m = new Mostro (setNomeMostro (), this.vitaIniziale, this.attaccoIniziale, this.difesaIniziale, setArma (), this.posizioneMostro );
        return m;
    }
}

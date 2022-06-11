package it.unibs.fp.mylib.esameArnaldo;

import it.unibs.fp.mylib.InputDati;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Chest {
    Oggetti contenuto = null;
    int[] posizione = new int[2];

    public Chest(Oggetti contenuto, int[] posizione) {
        this.contenuto = contenuto;
        this.posizione = posizione;
    }

    public Oggetti getContenuto() {
        return contenuto;
    }

    public Oggetti setContenuto() {
        this.contenuto = contenuto.creaOggetto ();
        return this.contenuto;
    }

    public int[] getPosizione() {
        return posizione;
    }

    public void setPosizione(int[] posizione) {
        this.posizione = posizione;
    }

    public Chest generaChest(){
        Chest cesta = new Chest (setContenuto (), this.posizione);
        return cesta;
    }

    public void interazioneChest(Personaggio player){
        boolean isOpen = false;

        System.out.println ("-------------------------");
        System.out.println ("\n premere 'E' per interagire");
        System.out.println ("-------------------------");

        char carattereDiScelta = InputDati.leggiChar ("");
        if (carattereDiScelta == 'e' || carattereDiScelta == 'E') {
            System.out.println (getContenuto ().toString ());
            isOpen = true;
        }
        else isOpen = false;

        Oggetti oggettoTemporaneo = getContenuto ();

        for (Oggetti o : player.inventario){
            if ( oggettoTemporaneo.equals (player.inventario)) {
                int tuoInt = 0;
                System.out.println ("- inserire 1 se si vuole scambiare l'oggetto: \n- inserire 2 se lo si vuole lasciare a terra:");
                try {
                    BufferedReader leggi = new BufferedReader (new InputStreamReader (System.in));
                    tuoInt = Integer.parseInt (leggi.readLine ());
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                switch (tuoInt) {
                    case 1:
                        player.inventario.remove (o);
                        player.inventario.add (oggettoTemporaneo);
                        break;
                    case 2:
                        break;
                }
            }else
                player.inventario.add (oggettoTemporaneo);
        }
    }
}

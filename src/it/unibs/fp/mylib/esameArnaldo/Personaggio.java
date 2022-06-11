package it.unibs.fp.mylib.esameArnaldo;



import it.unibs.fp.mylib.InputDati;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;



public class Personaggio {
    String nome;
    int vitaIniziale = 20;
    int valoreAttaccoBase = 5;
    int valoreDifesaBase = 5;
    int[] posizione = new int[2];
    int potenza = 1;
    Oggetti.Arma arma = new Oggetti.Arma ("arma base", 1);
    ArrayList<Oggetti> inventario = new ArrayList<> ();
    boolean isAlive = false;

    int getNumeroRighe;
    int getNumeroColonne;
    char[][] mappa = Mappa.creaMappa ("livello1.xml",getNumeroRighe, getNumeroColonne );


    public Personaggio(String nome, int vitaIniziale, int valoreAttaccoBase, int valoreDifesaBase, int[] posizione, int potenza, Oggetti.Arma arma) {
        this.nome = nome;
        this.vitaIniziale = vitaIniziale;
        this.valoreAttaccoBase = valoreAttaccoBase;
        this.valoreDifesaBase = valoreDifesaBase;
        this.posizione = posizione;
        this.potenza = potenza;
        this.arma = arma;
    }

    public Personaggio generaPersonaggio(){
        String nome = InputDati.leggiStringaNonVuota ("inserire il nome dell'eroe: ");
        Personaggio p = new Personaggio (nome, getVitaIniziale (), getValoreAttaccoBase (), getValoreDifesaBase (), getPosizione (), getPotenza (), getArma ());
        return p;
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

    public Oggetti.Arma getArma() {
        return arma;
    }

    public void setArma(Oggetti.Arma arma) {
        this.arma = arma;
    }

    public void movimento(){
        for(int i = 0; i < getNumeroColonne; i++) {
            for (int j = 0; j < getNumeroRighe; j++){
                if (mappa[i][j] == 'O'){
                    setPosizione (new int[]{i, j});
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        char lettera = scanner.next().charAt(0);
        switch (lettera){
            case 'w':
                if (mappa[getPosizione ()[0]][getPosizione ()[1] + 1] == '#'){
                    System.out.println ("mossa non valida, c'è un muro");
                    break;
                }else if (mappa[getPosizione ()[0]][getPosizione ()[1] + 1] == 'C'){
                    Personaggio pers = new Personaggio (this.nome, this.getVitaIniziale (), this.valoreAttaccoBase, this.valoreDifesaBase, getPosizione (), this.potenza, this.arma);
                    Chest cesta = null;
                    cesta.generaChest ();
                    cesta.interazioneChest (pers);
                    setPosizione (new int[]{getPosizione ()[0], getPosizione ()[1] + 1});
                }else if (mappa[getPosizione ()[0]][getPosizione ()[1] + 1] == 'M'){
                    Mostro mostro = null;
                    mostro.generaMostro ();
                    Fight scontro = null;
                    scontro.eseguiScontro ();
                    if (isAlive) setPosizione (new int[]{getPosizione ()[0], getPosizione ()[1] + 1});
                }else if (mappa[getPosizione ()[0]][getPosizione ()[1] + 1] == '.'){
                    setPosizione (new int[]{getPosizione ()[0], getPosizione ()[1] + 1});
                }else if (mappa[getPosizione ()[0]][getPosizione ()[1] + 1] == 'K')
                    System.out.println ("GIOCO COMPLETATO");
                    System.exit (1);
                break;
            case 's':
                if (mappa[getPosizione ()[0]][getPosizione ()[1] - 1] == '#'){
                    System.out.println ("mossa non valida, c'è un muro");
                    break;
                }else if (mappa[getPosizione ()[0]][getPosizione ()[1] - 1] == 'C'){
                    Personaggio pers = new Personaggio (this.nome, this.getVitaIniziale (), this.valoreAttaccoBase, this.valoreDifesaBase, getPosizione (), this.potenza, this.arma);
                    Chest cesta = null;
                    cesta.generaChest ();
                    cesta.interazioneChest (pers);
                    setPosizione (new int[]{getPosizione ()[0], getPosizione ()[1] - 1});
                }else if (mappa[getPosizione ()[0]][getPosizione ()[1] - 1] == 'M'){
                    Mostro mostro = null;
                    mostro.generaMostro ();
                    Fight scontro = null;
                    scontro.eseguiScontro ();
                    if (isAlive) setPosizione (new int[]{getPosizione ()[0], getPosizione ()[1] - 1});
                }else if (mappa[getPosizione ()[0]][getPosizione ()[1] - 1] == '.'){
                    setPosizione (new int[]{getPosizione ()[0], getPosizione ()[1] - 1});
                }else if (mappa[getPosizione ()[0]][getPosizione ()[1] - 1] == 'K')
                    System.out.println ("GIOCO COMPLETATO");
                System.exit (1);
                break;
            case 'a':
                if (mappa[getPosizione ()[0] - 1][getPosizione ()[1]] == '#'){
                    System.out.println ("mossa non valida, c'è un muro");
                    break;
                }else if (mappa[getPosizione ()[0] - 1][getPosizione ()[1]] == 'C'){
                    Personaggio pers = new Personaggio (this.nome, this.getVitaIniziale (), this.valoreAttaccoBase, this.valoreDifesaBase, getPosizione (), this.potenza, this.arma);
                    Chest cesta = null;
                    cesta.generaChest ();
                    cesta.interazioneChest (pers);
                    setPosizione (new int[]{getPosizione ()[0] - 1, getPosizione ()[1]});
                }else if (mappa[getPosizione ()[0] - 1][getPosizione ()[1]] == 'M'){
                    Mostro mostro = null;
                    mostro.generaMostro ();
                    Fight scontro = null;
                    scontro.eseguiScontro ();
                    if (isAlive) setPosizione (new int[]{getPosizione ()[0] - 1, getPosizione ()[1]});
                }else if (mappa[getPosizione ()[0] -1 ][getPosizione ()[1]] == '.'){
                    setPosizione (new int[]{getPosizione ()[0] - 1, getPosizione ()[1]});
                }else if (mappa[getPosizione ()[0] - 1][getPosizione ()[1]] == 'K')
                    System.out.println ("GIOCO COMPLETATO");
                System.exit (1);
                break;
            case 'd':
                if (mappa[getPosizione ()[0] + 1][getPosizione ()[1]] == '#'){
                    System.out.println ("mossa non valida, c'è un muro");
                    break;
                }else if (mappa[getPosizione ()[0] + 1][getPosizione ()[1]] == 'C'){
                    Personaggio pers = new Personaggio (this.nome, this.getVitaIniziale (), this.valoreAttaccoBase, this.valoreDifesaBase, getPosizione (), this.potenza, this.arma);
                    Chest cesta = null;
                    cesta.generaChest ();
                    cesta.interazioneChest (pers);
                    setPosizione (new int[]{getPosizione ()[0] + 1, getPosizione ()[1]});
                }else if (mappa[getPosizione ()[0] + 1][getPosizione ()[1]] == 'M'){
                    Mostro mostro = null;
                    mostro.generaMostro ();
                    Fight scontro = null;
                    scontro.eseguiScontro ();
                    if (isAlive) setPosizione (new int[]{getPosizione ()[0] + 1, getPosizione ()[1]});
                    azioni ();
                }else if (mappa[getPosizione ()[0] + 1 ][getPosizione ()[1]] == '.'){
                    setPosizione (new int[]{getPosizione ()[0] + 1, getPosizione ()[1]});
                }else if (mappa[getPosizione ()[0] + 1][getPosizione ()[1]] == 'K')
                    System.out.println ("GIOCO COMPLETATO");
                System.exit (1);
                break;

        }
    }


    public void azioni(){
        int valoreScelto = 0;
        System.out.println ("-----------------");
        System.out.println ("\nvuoi prendere una pozione per curarti ?");
        System.out.println ("1 - SI\n 2 - NO");
        System.out.println ("\n-----------------");
        try {
            BufferedReader leggi = new BufferedReader (new InputStreamReader (System.in));
            valoreScelto = Integer.parseInt (leggi.readLine ());
        } catch (IOException e) {
            e.printStackTrace ();
        }
        switch (valoreScelto){
            case 1:
                for (Oggetti o : inventario){
                    if (o.equals (Oggetti.Pozione.class)){
                        Oggetti.Pozione poz = new Oggetti.Pozione (getVitaIniziale ());
                        setVitaIniziale (getVitaIniziale () + poz.generaVita (getVitaIniziale ()));
                        inventario.remove (o);
                    }
                }
                break;
            default:
                System.out.println ("hai scelto di riprendere subito la tua avventura");
                break;

        }
    }


}

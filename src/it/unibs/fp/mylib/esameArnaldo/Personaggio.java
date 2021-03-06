package it.unibs.fp.mylib.esameArnaldo;

/**
 * la classe fornisce tutte le informazioni riguardanti il player del gioco e i metodi per potersi muovere ed eseguire le azioni
 */



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
        Scanner scan = new Scanner (System.in);
        String nome = scan.next ();
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

    /**
     * il metodo movimento effettua un reset della posizione del giocatore in qulla nuova, controlla se la casella ?? libera e in questo caso muove il personaggio, oppure analizza le possibilit?? di interazione del perosnaggio con la casella
     */
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
                if (mappa[getPosizione ()[0]][getPosizione ()[1] + 1] > getNumeroRighe){
                    System.out.println ("mossa impossibile, hai raggiunto il bordo superiore della mappa. Non sei mica in un Open World");
                    break;
                }
                if (mappa[getPosizione ()[0]][getPosizione ()[1] + 1] == '#'){
                    System.out.println ("mossa non valida, c'?? un muro");
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
                if (mappa[getPosizione ()[0]][getPosizione ()[1] - 1] < getNumeroRighe){
                    System.out.println ("mossa impossibile, hai raggiunto il bordo inferiore della mappa. Non sei mica in un Open World");
                    break;
                }
                if (mappa[getPosizione ()[0]][getPosizione ()[1] - 1] == '#'){
                    System.out.println ("mossa non valida, c'?? un muro");
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
                if (mappa[getPosizione ()[0] - 1][getPosizione ()[1]] < getNumeroColonne){
                    System.out.println ("mossa impossibile, hai raggiunto il bordo sinistro della mappa. Non sei mica in un Open World");
                    break;
                }
                if (mappa[getPosizione ()[0] - 1][getPosizione ()[1]] == '#'){
                    System.out.println ("mossa non valida, c'?? un muro");
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
                }else if (mappa[getPosizione ()[0] - 1][getPosizione ()[1]] == 'K'){
                    System.out.println ("GIOCO COMPLETATO");
                    System.exit (1);
                }

                break;
            case 'd':
                if (mappa[getPosizione ()[0] + 1][getPosizione ()[1]] > getNumeroColonne){
                    System.out.println ("mossa impossibile, hai raggiunto il bordo destro della mappa. Non sei mica in un Open World");
                    break;
                }
                if (mappa[getPosizione ()[0] + 1][getPosizione ()[1]] == '#'){
                    System.out.println ("mossa non valida, c'?? un muro");
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

    /**
     * azioni permette all'utente di bere una pozione prima di avanzare di casella
     */
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

    public void scegliArma(){
        int armaScelta = 0;
        try {
            BufferedReader leggi = new BufferedReader (new InputStreamReader (System.in));
            armaScelta = Integer.parseInt (leggi.readLine ());
        } catch (IOException e) {
            e.printStackTrace ();
        }
        for (Oggetti o : inventario){
           if(o.equals (Oggetti.Arma.class)){
               o.toString ();
               System.out.println ("\n----------------------------");
               System.out.println ("\n vuoi scegliere quest'arma? ");
               System.out.println ("1 - SI \n2 - NO");
               System.out.println ("\n----------------------------");

               try {
                   BufferedReader leggi = new BufferedReader (new InputStreamReader (System.in));
                   armaScelta = Integer.parseInt (leggi.readLine ());
               } catch (IOException e) {
                   e.printStackTrace ();
               }
               switch (armaScelta){
                   case 1:
                       setArma ((Oggetti.Arma) o);
                       break;
                   case 2:
                       continue;

               }
           }


        }
    }


}

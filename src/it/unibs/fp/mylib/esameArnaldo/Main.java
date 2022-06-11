package it.unibs.fp.mylib.esameArnaldo;

public class Main {
    public static void main(String[] args){
        int getNumeroRighe = 0;
        int getNumeroColonne = 0;
        char[][] mappa = Mappa.creaMappa ("livello1.xml", getNumeroRighe, getNumeroColonne);

        Personaggio player = null;
        player.generaPersonaggio ();

        do {
            player.movimento ();
        }while(player.isAlive);



    }
}

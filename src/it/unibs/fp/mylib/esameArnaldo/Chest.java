package it.unibs.fp.mylib.esameArnaldo;

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
}

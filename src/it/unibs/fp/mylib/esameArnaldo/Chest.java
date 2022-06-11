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

    public void setContenuto(Oggetti contenuto) {
        this.contenuto = contenuto.creaOggetto ();
    }

    public int[] getPosizione() {
        return posizione;
    }

    public void setPosizione(int[] posizione) {
        this.posizione = posizione;
    }
}

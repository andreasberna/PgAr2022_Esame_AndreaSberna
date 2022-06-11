package it.unibs.fp.mylib.esameArnaldo;



import java.util.Random;

public class Fight{
    Personaggio player;
    Mostro mostro;
    double modificatore;
    int dannoP;
    int dannoM;



    public double generaModificatore(){
        int prob = (int) Math.random ();
        if (prob <= 7.5) setModificatore (1.5);
        else setModificatore (1);
        return modificatore;

    }

    public int generaDannoP(){
        this.modificatore = generaModificatore ();
        dannoP = (int) ((((2 * player.getPotenza () * player.valoreAttaccoBase) / (25 * mostro.difesaIniziale)) + 2) * this.modificatore);
        return dannoP;
    }

    public int generaDannoM(){
        this.modificatore = generaModificatore ();
        dannoM = (int) (((2 * mostro.setArma () * mostro.attaccoIniziale) / (25 * player.getValoreDifesaBase ()) + 2) *this.modificatore);;
        return dannoM;
    }

    public void eseguiScontro(){

        do{
            mostro.setVitaIniziale (mostro.getVitaIniziale () - generaDannoP ());
            player.setVitaIniziale (player.getVitaIniziale () - generaDannoM ());
        }while(player.getVitaIniziale () > 0 || mostro.getVitaIniziale () > 0);
        if (player.getVitaIniziale () <= 0) player.isAlive = false;
        else player.isAlive = true;

    }

    public double getModificatore() {
        return modificatore;
    }

    public void setModificatore(double modificatore) {
        this.modificatore = modificatore;
    }

    public int getDannoP() {
        return dannoP;
    }

    public void setDannoP(int danno) {
        this.dannoP = dannoP;
    }

    public int getDannoM() {
        return dannoM;
    }

    public void setDannoM(int dannoM) {
        this.dannoM = dannoM;
    }
}

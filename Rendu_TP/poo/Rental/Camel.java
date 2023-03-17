package Rendu_TP.poo.Rental;

public class Camel extends Car{
    int annee;

    public Camel(int annee) {
        super(annee);
        this.modele = "camel";
        this.annee = annee;
    }

    public int getAnnee() {
        return annee;
    }


}

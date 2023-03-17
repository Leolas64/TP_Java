package Rendu_TP.poo.Rental;

import java.util.Objects;

public class Camel extends Car{
    int annee;
    int yearValid = 5;

    public Camel(int annee) {
        super(annee);
        this.modele = "camel";
        this.annee = annee;
    }

    public int getAnnee() {
        return annee;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Camel)) {
            return false;
        }
        Camel other = (Camel) obj; // Cast obj en Person
        return Objects.equals(modele, other.modele) && annee == other.annee;
    }

}

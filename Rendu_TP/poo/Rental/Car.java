package Rendu_TP.poo.Rental;

import java.util.Objects;

public class Car {
    String modele;
    int annee;

    public Car(int annee) {
        this.annee = annee;
    }

    public Car(String modele, int annee) {
        Objects.requireNonNull(modele);
        this.modele = modele;
        this.annee = annee;
    }

    public String getModel() {
        return modele;
    }

    public int getYear() {
        return annee;
    }

    @Override
    public String toString() {
        return modele + " " + annee;
    }
}

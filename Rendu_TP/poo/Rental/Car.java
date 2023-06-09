package Rendu_TP.poo.Rental;

import java.util.Objects;

public class Car {
    String modele;
    int annee;
    int yearValid = 2;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car other = (Car) obj; // Cast obj en Person
        return Objects.equals(modele, other.modele) && annee == other.annee;
    }

}

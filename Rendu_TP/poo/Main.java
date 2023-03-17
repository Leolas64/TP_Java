package Rendu_TP.poo;

import Rendu_TP.poo.Rental.Car;
import Rendu_TP.poo.Rental.CarRental;

public class Main {
    public static void main(String[] arg){
        Car mustang = new Car("ford mustang", 2014);
        System.out.println(mustang);
        CarRental voitureList = new CarRental();
        voitureList.add(mustang);
    }
}

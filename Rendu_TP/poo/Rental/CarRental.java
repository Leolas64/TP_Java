package Rendu_TP.poo.Rental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CarRental{
    private Car[] cars;
    private Camel[] camels;
    private int count = 0;
    public CarRental() {
    }

    public void add(Car car) {
        if (car.toString() == null)
            return;
        Car[] carList = new Car[count + 1];
        for (int i = 0; i < count; i++) {
            carList[i] = cars[i];
        }
        carList[count] = car;
        count = count + 1;
        cars = carList;
    }

    public void remove(Car car) {
        int i = 0;
        int j = 0;
        for(;i<count;i++,j++){
            if (car.modele == cars[i].modele){
                cars[i] = null;
                j++;
            }
        }
        if(i == j)
            throw new IllegalStateException();
        count--;
    }

    public List<Object> toSell() {
        int currentYear = LocalDate.now().getYear();
        List<Object> vehiclesToSell = new ArrayList<>();

        for (Object vehicle : cars) {
            if (vehicle instanceof Car && currentYear-2 >= ((Car) vehicle).annee) {
                vehiclesToSell.add(vehicle);
            } else if (vehicle instanceof Camel && currentYear-5 >= ((Camel) vehicle).annee) {
                vehiclesToSell.add(vehicle);
            }
        }

        return vehiclesToSell;
    }

    public Car[] getCars() {
        return cars;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        String valRet = "";
        for(int i = 0; i<count; i++)
        {
            valRet = valRet + cars[i];
            if(i != count - 1)
                valRet = valRet + "\n";
        }
        return valRet;
    }


}

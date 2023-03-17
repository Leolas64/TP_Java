package Rendu_TP.poo.Rental;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

@SuppressWarnings("static-method")
public class RentalTest {
    @Test
    public void newCar() {
        Car car = new Car("ford mustang", 2014);
        assertEquals("ford mustang", car.getModel());
    }

    @Test(expected = NullPointerException.class)
    public void newCarNoModel() {
        new Car(null, 2014);
    }

    @Test
    public void carRentalAddRemove() {
        CarRental rental = new CarRental();
        rental.add(new Car("ford mustang", 2013));
        rental.remove(new Car("ford mustang", 2013));
        assertEquals("", rental.toString());
    }

    @Test(expected=IllegalStateException.class)
    public void carRentalRemoveNotExist() {
        CarRental rental = new CarRental();
        rental.remove(new Car("ford mustang", 2013));
    }

    @Test(expected = NullPointerException.class)
    public void caRentalAddNull() {
        CarRental rental = new CarRental();
        rental.add(null);
    }

    @Test
    public void carRentaltoString() {
        CarRental rental = new CarRental();
        rental.add(new Car("audi tt", 2001));
        rental.add(new Car("ford mustang", 2006));
        assertEquals("audi tt 2001\nford mustang 2006", rental.toString());
    }

    @Test
    public void carRentaltoSell() {
        int currentYear = LocalDate.now().getYear();
        CarRental rental = new CarRental();
        rental.add(new Car("ford mustang", currentYear - 3));
        List<?> toSell = rental.toSell();
        assertTrue(toSell.contains(new Car("ford mustang", currentYear - 3)));
    }

    @Test
    public void carRentaltoSellEmpty() {
        int currentYear = LocalDate.now().getYear();
        CarRental rental = new CarRental();
        rental.add(new Car("audi tt", currentYear));
        rental.add(new Car("ford mustang", currentYear - 1));
        List<?> toSell = rental.toSell();
        assertTrue(toSell.isEmpty());
    }

    @Test
    public void newCamel() {
        Camel camel = new Camel(2014);
        assertEquals(camel, new Camel(2014));
    }

    @Test
    public void camelToString() {
        Camel camel = new Camel(2014);
        assertEquals("camel 2014", camel.toString());
    }

    @Test
    public void carRentalCarAndCamel() {
        CarRental rental = new CarRental();
        rental.add(new Car("ford mustang", 2014));
        rental.add(new Camel(2010));
        rental.remove(new Camel(2010));
        rental.remove(new Car("ford mustang", 2014));
    }

    @Test(expected = IllegalStateException.class)
    public void carRentalCarAndCamel2() {
        CarRental rental = new CarRental();
        rental.remove(new Camel(2010));
    }

    @Test
    public void carRentalCarAndCamelToSell() {
        int currentYear = LocalDate.now().getYear();
        CarRental rental = new CarRental();
        rental.add(new Car("ford mustang", currentYear - 10));
        rental.add(new Camel(currentYear - 10));
        List<?> toSell = rental.toSell();
        assertTrue(toSell.contains(new Car("ford mustang", currentYear - 10)));
        assertTrue(toSell.contains(new Camel(currentYear - 10)));
    }

    @Test
    public void carRentalCarAndCamelToSell2() {
        int currentYear = LocalDate.now().getYear();
        CarRental rental = new CarRental();
        rental.add(new Car("ford mustang", currentYear - 3));
        rental.add(new Camel(currentYear - 3));
        List<?> toSell = rental.toSell();
        assertTrue(toSell.contains(new Car("ford mustang", currentYear - 3)));
        assertFalse(toSell.contains(new Camel(currentYear - 3)));
    }

    @Test
    public void findACarByModel() {
        CarRental rental = new CarRental();
        rental.add(new Car("ford mustang", 2020));
        rental.add(new Camel(2003));
        assertEquals(new Car("ford mustang", 2020), rental.findACarByModel("ford mustang").get());
    }

    @Test
    public void findACarByModel2() {
        CarRental rental = new CarRental();
        rental.add(new Car("renault alpine", 1992));
        rental.add(new Camel(1992));
        assertFalse(rental.findACarByModel("ford mustang").isPresent());
    }
}

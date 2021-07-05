package model;

public class Address {

    private int index;
    private String city;
    private String street;
    private int houseNumber;
    private int flatNumber;


    Address(int index, String city, String street,
            int houseNumber, int flatNumber) {
        this.index = index;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "Індекс: " + this.index + "\n" +
                "Місто: " + this.city + "\n" +
                "Адреса: " + this.street + ", " +
                this.houseNumber + ", " + this.flatNumber + "\n";
    }
}

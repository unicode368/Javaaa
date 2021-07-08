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

    public String[] getAddress() {
        return new String[]{String.valueOf(index),
                city,
                street + ", " + String.valueOf(houseNumber)
                        + ", " + String.valueOf(flatNumber)};
    }
}

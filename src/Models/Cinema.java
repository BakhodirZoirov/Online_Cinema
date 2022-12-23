package Models;

import java.util.Objects;

public class Cinema {
    private int id;
    private String name;
    private String address;
    private int numberOfSeats;
    public static int currId=1;
    {
        currId++;
    }

    public static int getCurrId() {
        return currId;
    }

    public static void setCurrId(int currId) {
        Cinema.currId = currId;
    }

    public Cinema(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberOfSeats = numberOfSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return id == cinema.id && numberOfSeats == cinema.numberOfSeats && name.equals(cinema.name) && address.equals(cinema.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, numberOfSeats);
    }
}

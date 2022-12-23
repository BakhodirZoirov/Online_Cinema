package Models;

import Enums.Status;
import java.math.BigDecimal;
import java.util.Objects;

public class Ticket {
    private int id;
    private Movie movie;
    private int price;
    private int seatNumber;
    private Status status;
    public static int currId=1;
    {
        currId++;
    }

    public Ticket(int id, Movie movie, int price, int seatNumber, Status status) {
        this.id = id;
        this.movie = movie;
        this.price = price;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static int getCurrId() {
        return currId;
    }

    public static void setCurrId(int currId) {
        Ticket.currId = currId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", movie=" + movie +
                ", price=" + price +
                ", seatNumber=" + seatNumber +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && seatNumber == ticket.seatNumber && movie.equals(ticket.movie) && price==ticket.price && status == ticket.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, price, seatNumber, status);
    }
}

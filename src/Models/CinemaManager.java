package Models;

import java.util.Objects;

public class CinemaManager {
    private int id;
    private Cinema cinema;
    private User user;

    public static int currId=1;
    {
        currId++;
    }

    public CinemaManager(int id, Cinema cinema, User user) {
        this.id = id;
        this.cinema = cinema;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static int getCurrId() {
        return currId;
    }

    public static void setCurrId(int currId) {
        CinemaManager.currId = currId;
    }

    @Override
    public String toString() {
        return "CinemaManager{" +
                "id=" + id +
                ", cinema=" + cinema +
                ", user=" + user +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaManager that = (CinemaManager) o;
        return id == that.id && cinema.equals(that.cinema) && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cinema, user);
    }
}

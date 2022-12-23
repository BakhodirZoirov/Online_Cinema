package Models;

import java.util.Objects;

public class Order {
    private int id;
    private User user;
    private Ticket ticket;
    private int sum;
    public static int currId=1;
    {
        currId++;
    }

    public Order(int id, User user, Ticket ticket, int sum) {
        this.id = id;
        this.user = user;
        this.ticket = ticket;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
    public static int getCurrId() {
        return currId;
    }

    public static void setCurrId(int currId) {
        Order.currId = currId;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", ticket=" + ticket +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && sum == order.sum && user.equals(order.user) && ticket.equals(order.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, ticket, sum);
    }
}

package Services;

import Enums.Role;
import Models.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static User admin=new User(0,"Admin","admin","123", Role.ADMIN, 0);
    public static List<User> userList=new ArrayList<>();
    public static List<Ticket> ticketList=new ArrayList<>();
    public static List<Order> orderList=new ArrayList<>();
    public static List<Cinema> cinemaList=new ArrayList<>();
    public static List<CinemaManager> cinemaManagerList=new ArrayList<>();
    public static List<Movie> movieList=new ArrayList<>();
}

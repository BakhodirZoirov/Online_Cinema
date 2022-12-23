package Settings;


import Enums.Status;
import Models.*;
import Services.Storage;

import java.util.Scanner;

public class UserSettings implements UserInterSettings{
    private static UserSettings userSettings;

    public static UserSettings getInstance() {

        if (userSettings == null) {
            userSettings = new UserSettings();
        }
        return userSettings;
    }

    @Override
    public void orderTicket(User user) {
        Scanner scanner=new Scanner(System.in);
        Storage.cinemaList.forEach(System.out::println);
        System.out.println("Enter cinema id :");
        int id=scanner.nextInt();
        Cinema cinema=Storage.cinemaList.stream().filter(cinema1 -> cinema1.getId()==id).findFirst().orElse(null);
        if (cinema==null){
            System.err.println("Error cinema id,try again!");
        }
        else{
            Movie movie=cinemaFunc(cinema);
            if (movie==null){
                System.err.println("Error movie id,try again!");
            }
            else{
                Ticket ticket=movieFunc2(movie);
                if (ticket==null){
                    System.err.println("Error ticket id,try again!");
                }
                else{
                    orderFunc3(user,ticket);
                }
            }
        }
    }
    private void orderFunc3(User user,Ticket ticket){
        int userBalance=user.getBalance();
        int price=ticket.getPrice();
        boolean command1=false;
        if (userBalance==price){
            command1=true;
        }
        if (command1){
            Order order=new Order(Order.currId,user,ticket,0);
            for (User user1:Storage.userList) {
                if (user1.equals(user)){
                    user1.setBalance(user1.getBalance()-price);
                }
            }
            Storage.orderList.add(order);
            for (Ticket ticket1: Storage.ticketList) {
                if (ticket1.equals(ticket)){
                    ticket1.setStatus(Status.SOLD);
                }
            }
            System.err.println("Succasuful command!");
        }
        else{
            System.err.println("Error,try again!");
        }
    }
    private Ticket movieFunc2(Movie movie){
        Scanner scanner=new Scanner(System.in);
        for (Ticket ticket2:Storage.ticketList) {
            if (ticket2.getMovie().equals(ticket2) && ticket2.getStatus().equals(Status.AVAILABLE)){
                System.out.println(ticket2);
            }
        }
        int ticketId= scanner.nextInt();
        return Storage.ticketList.stream().filter(ticket -> ticket.getId()==ticketId).findFirst().orElse(null);
    }
    private Movie cinemaFunc(Cinema cinema){
        Scanner scanner=new Scanner(System.in);
        for (Movie movie:Storage.movieList) {
            if (movie.getCinema().equals(cinema)){
                System.out.println(movie);
            }
        }
        System.out.println("Enter movie id : ");
        int movieId= scanner.nextInt();
        return Storage.movieList.stream().filter(movie -> movie.getId()==movieId).findFirst().orElse(null);
    }

    @Override
    public void showUserOrders(User user) {
        for (Order order:Storage.orderList) {
            if (order.getUser().equals(user)){
                System.out.println(order);
            }
        }
    }
}

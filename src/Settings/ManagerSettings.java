package Settings;

import Enums.Status;
import Models.*;
import Services.Storage;

import java.util.Scanner;

public class ManagerSettings implements ManagerInterSettings {
    private static ManagerSettings managerSettings;

    public static ManagerSettings getInstance() {

        if (managerSettings == null) {
           managerSettings = new ManagerSettings();
        }
        return managerSettings;
    }


    @Override
    public void managerAddMovie(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean hasMovie = true;
        for (CinemaManager cinemaManager : Storage.cinemaManagerList) {
            if (cinemaManager.getUser().equals(user)) {
                System.out.println(cinemaManager.getCinema());
                hasMovie = false;
            }
        }
        if (hasMovie) {
            System.out.println("You have not movie");
        } else {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter cinema id:");
            int id = scanner2.nextInt();
            Cinema cinema = Storage.cinemaList.stream().filter(cinema1 -> cinema1.getId() == id).findFirst().orElse(null);
            if (cinema == null) {
                System.err.println("Error try again!");
            } else {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Numbers of tickets : ");
                int numberOfTickets=scanner1.nextInt();
                Scanner scanner3=new Scanner(System.in);
                System.out.println("Movie name:");
                String movieName2 = scanner3.nextLine();
                System.out.println("Price for tickets: ");
                int moviePrice = scanner1.nextInt();
                System.out.println("Enter Date(DD.MM.YYYY):");
                String dateIn = scanner3.nextLine();
                System.out.println("Enter your describtion: ");
                String movieDescribtion = scanner3.nextLine();
                Movie movie = new Movie(Movie.currId, movieName2, dateIn, movieDescribtion,cinema,moviePrice);
                Storage.movieList.add(movie);
                for (int i = 0; i <numberOfTickets ; i++) {
                    Storage.ticketList.add(new Ticket(Ticket.currId,movie,moviePrice,numberOfTickets, Status.AVAILABLE));
                }
                System.err.println("Ticket is added!");
            }
        }
    }
    @Override
    public void showCinema(User user) {
        for (CinemaManager cinemaManager : Storage.cinemaManagerList) {
            if (cinemaManager.getUser().equals(user)) {
                System.out.println(cinemaManager.getCinema());
            }
        }
    }


    @Override
    public void movieInformations(User user) {
            showCinema(user);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cinema Id:");
        int id = scanner.nextInt();
        Cinema cinema = Storage.cinemaList.stream().filter(cinema1 ->
                cinema1.getId() == id).findFirst().orElse(null);
        if (cinema == null) {
            System.err.println("Error id,try again!");
        } else {
            for (Movie movie : Storage.movieList) {
                if (movie.getCinema().equals(cinema)) {
                    System.out.println(movie);
                }
            }
            System.out.println("Enter movie Id:");
            int movieId = scanner.nextInt();
            Movie movie = Storage.movieList.stream().filter(movie1 -> movie1.getId() == movieId).findFirst().orElse(null);

            if (movie == null) {
                System.err.println("Error,please try again!");
            } else {
                for (Ticket ticket : Storage.ticketList) {
                    if (ticket.getMovie().equals(movie)) {
                        System.out.println(ticket);
                    }
                }
            }
        }

    }
}

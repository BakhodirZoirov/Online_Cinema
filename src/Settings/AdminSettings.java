package Settings;

import Enums.Role;
import Models.Cinema;
import Models.CinemaManager;
import Models.User;
import Services.SignInSignUp;
import Services.Storage;

import java.util.Scanner;

public class AdminSettings implements AdminInterSettings {
    private static AdminSettings adminSettings;

    public static AdminSettings getInstance() {

        if (adminSettings == null) {
            adminSettings = new AdminSettings();
        }
        return adminSettings;
    }

    @Override
    public void addCinema() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cinema name: ");
        String cinemaName = scanner.nextLine();
        Cinema cinema = Storage.cinemaList.stream().filter(cinema1 -> cinema1.getName().equals(cinemaName)).findFirst().orElse(null);
        if (cinema == null) {
            System.out.println("Enter your adress: ");
            String adress = scanner.nextLine();
            Storage.cinemaList.add(new Cinema(Cinema.currId, cinemaName, adress));
            System.err.println("Good,cinema added well!");
        } else {
            System.err.println("Error,try again!");
        }
    }

    @Override
    public void addManager() {
        User user = SignInSignUp.getInstance().signUp();
        for (User user1 : Storage.userList) {
            if (user1.equals(user)) {
                user1.setBalance(0);
                user1.setRole(Role.MANAGER);
            }
        }
    }

    @Override
    public void managerToCinema() {
        System.out.println("Add Manager to Cinema!");
        for (User user : Storage.userList) {
            if (user.getRole().equals(Role.MANAGER)) {
                System.out.println(user);
            }
        }
        System.out.println("Manager id : ");
        Scanner scanner = new Scanner(System.in);
        int id1 = scanner.nextInt();
        User manager = Storage.userList.stream().filter(user -> user.getId() == id1).findFirst().orElse(null);
        if (manager == null) {
            System.err.println("Error,manager id is false!");
        } else {
            Storage.cinemaList.forEach(System.out::println);
            System.out.println("Cinema id: ");
            int id2 = scanner.nextInt();
            Cinema cinema1 = Storage.cinemaList.stream().filter(cinema2 -> cinema2.getId() == id2).findFirst().orElse(null);
            if (cinema1 == null) {
                System.err.println("Error,try again!");
            } else {
                CinemaManager cinemaManager = Storage.cinemaManagerList.stream().filter(cinemaManager1 -> cinemaManager1.equals(cinema1) && cinemaManager1.getUser().equals(manager)).findFirst().orElse(null);
                if (cinemaManager == null) {
                    Storage.cinemaManagerList.add(new CinemaManager(CinemaManager.currId, cinema1, manager));
                    System.err.println("Succesuful add!");
                } else {
                    System.err.println("Manager is already manager of this Coworking!");
                }

            }
        }
    }

    @Override
    public void showManager() {
        System.out.println("Show managers : ");
        for (User user : Storage.userList) {
            if (user.getRole().equals(Role.USER)) {
                System.out.println(user);
            }
        }
    }

    @Override
    public void showOrders() {
        System.out.println("Show orders : ");
        Storage.orderList.forEach(System.out::println);
    }
}

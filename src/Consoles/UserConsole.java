package Consoles;

import Models.User;
import Settings.UserSettings;

import java.util.Scanner;

public class UserConsole implements UserInterConsole{
    private static UserConsole userConsole;

    public static UserConsole getInstance() {

        if (userConsole == null) {
            userConsole = new UserConsole();
        }
        return userConsole;
    }
    @Override
    public void openUserConsole(User user) {
    while (true){
        Scanner scanner=new Scanner(System.in);
        System.out.println("1-Order ticket || 2-History of order || 3-Exit");
        int command= scanner.nextInt();
        if (command == 1) {
            UserSettings.getInstance().orderTicket(user);
        } else if (command == 2) {
            UserSettings.getInstance().showUserOrders(user);
        } else if (command == 0) {
            break;
        } else {
            System.err.println("Error command,try again!");
        }
    }
    }
}

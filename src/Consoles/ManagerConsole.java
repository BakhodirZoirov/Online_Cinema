package Consoles;

import Models.User;
import Settings.ManagerSettings;

import java.util.Scanner;

public class ManagerConsole implements ManagerInerConsole{
    private static ManagerConsole managerConsole;

    public static ManagerConsole getInstance() {

        if (managerConsole == null) {
            managerConsole = new ManagerConsole();
        }
        return managerConsole;
    }
    @Override
    public void openManagerConsole(User user) {
        while (true) {
            System.out.println("1-Add movie to cinema || 2-Informations movie  || 3-Exit");
            Scanner scanner=new Scanner(System.in);
            int command= scanner.nextInt();
            if (command==1){
                ManagerSettings.getInstance().managerAddMovie(user);
            } else if (command==2) {
                ManagerSettings.getInstance().movieInformations(user);
            } else if (command==3) {
                break;
            }
            else{
                System.err.println("Error,try again!");
            }

        }
    }
}

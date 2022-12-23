package Consoles;

import Models.User;
import Settings.AdminSettings;

import java.util.Scanner;

public class AdminConsole implements AdminInterConsole{
    private static AdminConsole adminConsole;

    public static AdminConsole getInstance() {

        if (adminConsole == null) {
            adminConsole = new AdminConsole();
        }
        return adminConsole;
    }
    @Override
    public void openAdminConsole(User user) {
        while (true) {
            System.out.println("1-Add cinema || 2-Add manager || 3-Manager to cinema || 4-Exit");
            Scanner scanner=new Scanner(System.in);
            int command= scanner.nextInt();
            if (command==1){
                AdminSettings.getInstance().addCinema();
            } else if (command==2) {
                AdminSettings.getInstance().addManager();
            } else if (command==3) {
                AdminSettings.getInstance().managerToCinema();
            } else if (command==4) {
                break;
            }
            else{
                System.out.println("Error command,try again!");
            }
        }
    }
}

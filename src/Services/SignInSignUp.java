package Services;

import Consoles.AdminConsole;
import Consoles.ManagerConsole;
import Consoles.UserConsole;
import Enums.Role;
import Models.User;
import Services.interfaces.SignInUp;

import java.util.Scanner;

public class SignInSignUp implements SignInUp {
    private static SignInSignUp signInSignUp;

    public static SignInSignUp getInstance() {

        if (signInSignUp == null) {
            signInSignUp = new SignInSignUp();
        }
        return signInSignUp;
    }


    @Override
    public void signIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your login: ");
        String login = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        User findUsers = Storage.userList.stream().filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password)).findFirst().orElse(null);
        if (Storage.admin.getLogin().equals(login) && Storage.admin.getPassword().equals(password)) {
            AdminConsole.getInstance().openAdminConsole(Storage.admin);
        } else if (findUsers == null) {
            System.err.println("Error,try again!");
        } else if (findUsers.getRole().equals(Role.MANAGER)) {
            ManagerConsole.getInstance().openManagerConsole(findUsers);
        } else {
            UserConsole.getInstance().openUserConsole(findUsers);
        }
    }

    @Override
    public User signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login: ");
        String login = scanner.nextLine();
        User findUser = Storage.userList.stream().filter(user -> user.getLogin().equals(login)).findFirst().orElse(null);
        if (findUser == null) {
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter password: ");
            String password = scanner.nextLine();
            User enterUser = new User(User.currId, name, login, password, Role.USER, 600_000);
            Storage.userList.add(enterUser);
            System.err.println("Good,you have registered well! ");
            return enterUser;
        } else {
            System.err.println("Error,try again!");
            return null;
        }
    }
}

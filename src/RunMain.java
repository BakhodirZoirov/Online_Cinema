import Services.SignInSignUp;

import java.util.Scanner;

public class RunMain implements MainMenu{
    private static RunMain runMain;

    public static RunMain getInstance() {
        if (runMain == null) {
            runMain = new RunMain();
        }
        return runMain;
    }
    @Override
    public void startMenu() {
    while (true){
        System.out.println("1-Sign In || 2-Sign Up || 3-Exit");
        Scanner scanner=new Scanner(System.in);
        int command= scanner.nextInt();
        if (command==1){
            SignInSignUp.getInstance().signIn();
        } else if (command==2) {
            SignInSignUp.getInstance().signUp();
        } else if (command==3) {
            System.err.println("The program is over");
            break;
        }
        else {
            System.err.println("Error command,try again please!");
        }
    }
    }
}

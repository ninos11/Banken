import java.util.Scanner;

public class App {
    // Users, pin code and amount
        static String [] name = {"Messi", "Zlatan", "Ronaldo"};
        static String [] pin = {"0001", "0002", "0003"};
        static double[] amount = {0.0, 0.0, 0.0};

        static Scanner input = new Scanner(System.in);


public static void main(String[] args) {
    int userIndex = selectUser();
    if (userIndex == -1) {
        System.out.println("Please select one of the users 1, 2 or 3!");
        return;
    }
    if (!logIn(userIndex)) {
        System.out.println("Too many incorrect attempts. The program is terminated.");
        return;
    }

    System.out.println("Login successful! Welcome, " + name[userIndex] + ".");
    
}

        

// Methods

// Select user method
static int selectUser() {
    System.out.println(" <=== Select user ===> ");
    System.out.println("1. Messi");
    System.out.println("2. Zlatan");
    System.out.println("3. Ronaldo");
    System.out.println("Select on of the users (1, 2 or 3):");

    int choice = input.nextInt();
    input.nextLine();
    
    if (choice >= 1 && choice <= 3) {
        return choice - 1;
    }

    return -1;
}


// Log in method

static boolean logIn (int user){
    for (int attempt = 1; attempt <= 3; attempt++){
        System.out.println("You have only 3 attempts! if you miss all three, the program will close!");
        System.out.println("Pin code for: " + name [user] + "  attempt number: " + attempt);
        
        
        String pinNumber = input.next();
        if (pinNumber.equals (pin[user])) {
            return true;    
        }
        else{
            System.out.println("Wrong PIN!");
        }
    }
    return false;
}

}

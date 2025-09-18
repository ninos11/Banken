import java.util.Scanner;

public class App {
    // Users, pin code and amount
        static String [] name = {"Messi", "Zlatan", "Ronaldo"};
        static String [] pin = {"0001", "0002", "0003"};
        static double[] amount = {0.0, 0.0, 0.0};

        static Scanner input = new Scanner(System.in);


public static void main(String[] args) {
    while (true) {
        int userIndex = selectUser();
    if (userIndex == -1) {
        System.out.println("Please select one of the users 1, 2 or 3!");
        continue;
    }
    if (!logIn(userIndex)) {
        System.out.println("Too many incorrect attempts. The program is terminated.");
        return;
    }

    System.out.println("Login successful! Welcome, " + name[userIndex] + ".");
    Menu(userIndex);
}
    }
    

        

// Methods

// Select user method
static int selectUser() {
    System.out.println(" <=== Select user ===>\n" + "1. Messi\n" + "2. Zlatan\n" + "3. Ronaldo\n" + "4. Close program\n" + "Select on of the users (1, 2, 3 or 4. Close program!)\n");

    int choice = readInt();
    input.nextLine();
    
    if (choice >= 1 && choice <= 3) {
        return choice - 1;
    } else if (choice == 4){
        exitProgram();
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
//User menu

static void Menu(int userIndex) {
        while (true) {
            System.out.println("<=== Menu ===>\n" + "1. Show balance\n" + "2. Deposit\n" + "3. Withdraw\n" + "4. Logout\n" + "5. Close program\n" + "Choose (1-5):\n");
            
            int choice = readInt();
            switch (choice) {
                case 1 -> showBalance(userIndex);
                case 2 -> deposit(userIndex);
                case 3 -> withdraw(userIndex);
                case 4 -> {
                    logOut();
                    return;
                }
                case 5 -> exitProgram();
                default -> System.out.println("Invalid selection. Please try again.");
            }
        }
    }

// Show balance method
static void showBalance(int userIndex){
    System.out.println("Your current balance is:" + amount[userIndex]);
    if (goBack()) {
        return;
    }
}

// Deposit method

static void deposit (int userIndex){
    while (true) {
        System.out.println("Enter amount to deposit:");
    Double value = readPositiveNumber();
    if (value == null) {
        System.out.println("Invalid amount! Pleas try again :)");
        continue;
    }

    else {
        amount[userIndex] += value;
        System.out.println("Deposit successful. New balance:" + amount[userIndex]);
        break;
    }
    
    
    }
    if (goBack()) {
        return;
    }
    
}

// Withdraw method

static void withdraw (int userIndex){

    while (true) {
        System.out.println("Enter amount to withdraw:");
    Double value = readPositiveNumber();
    if (value == null) {
        System.out.println("Invalid amount!");
        continue;
    }
    if (value > amount[userIndex]) {
        System.out.println("Insufficient balance. Available:" + amount[userIndex]);
        continue;
    }

    else{
        amount[userIndex] -= value;
        System.out.println("Withdrawal successful. New balance: " + amount[userIndex]);
        break;
    }
    }
    if (goBack()) {
        return;
    } 
    
    
}


// Logout method

static void logOut(){
    System.err.println("You are now logged out!");
}

// Exit or close program method

static void exitProgram() {
        System.out.println("The program ends. Goodbye!");
        System.exit(0);
    }

// No decimals method
static int readInt() {
        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.print("Enter an integer: ");
        }
        int value = input.nextInt();
        input.nextLine(); 
        return value;
    }

// Read only positive numbers
    static Double readPositiveNumber() {
        if (!input.hasNextDouble()) {
            input.nextLine();
            return null;
        }
        double value = input.nextDouble();
        input.nextLine();
        if (value <= 0) return null;
        return value;
    }

// Go back funtion

    static boolean goBack(){
        System.out.println("Go back to menu? (y): ");
        String answer = input.next().trim().toLowerCase();
        return answer.equals("y");

    }
}

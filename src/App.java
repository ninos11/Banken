import java.util.Scanner;

public class App {
    // Users, pin code and amount
        static String [] name = {"Messi", "Zlatan", "Ronaldo"};
        static String [] pin = {"0001", "0002", "0003"};
        static double[] amountSEK = {0.0, 0.0, 0.0};
        static String[] userCurrency = {"SEK", "SEK", "SEK"};

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

    chooseCurrency(userIndex);

    Menu(userIndex);
}
    }
    

        

// Methods

// Select user method
static int selectUser() {
    System.out.println(" <=== Select user ===>\n" + "1. Messi\n" + "2. Zlatan\n" + "3. Ronaldo\n" + "4. Close program\n" + "Select on of the users (1, 2, 3 or 4. Close program!)\n");

    int choice = readInt();
    
    
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
        
        if (!input.hasNext()) safeExitOnEndOfFile();
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
            System.out.println("<=== Menu ===>\n" + "1. Show balance\n" + "2. Deposit\n" + "3. Withdraw\n" + "4. Change currency\n" + "5. Logout\n" + "6. Close program\n" + "Choose (1-5):\n");
            
            int choice = readInt();
            switch (choice) {
                case 1 -> showBalance(userIndex);
                case 2 -> deposit(userIndex);
                case 3 -> withdraw(userIndex);
                case 4 -> chooseCurrency(userIndex);
                case 5 -> {
                    logOut();
                    return;
                }
                case 6 -> exitProgram();
                default -> System.out.println("Invalid selection. Please try again.");
            }
        }
    }

// Currency Selection method

static void chooseCurrency(int userIndex){
    System.out.println("Choose Currency\n" + "1. SEK\n" + "2. EUR\n" + "3. USD\n" + "Choose (1 - 3)\n");
    int choice = readInt();
    if (choice == 2) userCurrency[userIndex] = "EUR";
    else if (choice == 3) userCurrency[userIndex] = "USD";
    else userCurrency[userIndex] = "SEK";

}

// Exchange currency from SEK and to SEK

static double fromSEK(String currency, double amountSEK) {
    if (currency.equals("EUR")) return amountSEK / 11.0;
    if (currency.equals("USD")) return amountSEK / 9.40;
    return amountSEK;
}

static double toSEK (String currency, double amount){
    if (currency.equals("EUR")) return amount * 11.0;
    if (currency.equals("USD")) return amount * 9.40;
    return amount;
}


// Show balance method
static void showBalance(int userIndex){
    double balance = fromSEK(userCurrency[userIndex], amountSEK[userIndex]);
    System.out.println("Your current balance is:" + round2(balance) + " " + userCurrency[userIndex]);
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
        double valueSEK = toSEK(userCurrency[userIndex], value);
        amountSEK[userIndex] += valueSEK;
        double newBalance = fromSEK(userCurrency[userIndex], amountSEK[userIndex]);
        System.out.println("Deposit successful. New balance:" + round2(newBalance) + " " + userCurrency[userIndex]);
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
    double valueSEK = toSEK(userCurrency[userIndex], value);
    if (valueSEK > amountSEK [userIndex]) {
        double available = fromSEK(userCurrency[userIndex], amountSEK[userIndex]);
        System.out.println("Insufficient balance. Available:" + available + " " + userCurrency[userIndex]);
        continue;
    }

    else{
        amountSEK[userIndex] -= valueSEK;
        double newBalance = fromSEK(userCurrency[userIndex], amountSEK[userIndex]);
        System.out.println("Withdrawal successful. New balance: "+ round2(newBalance));
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
    while (true) {
        if (!input.hasNext()) safeExitOnEndOfFile();
        if (input.hasNextInt()) {
            return input.nextInt();
        }
        System.out.print("Enter an integer: ");
        input.next();
    }
}


// Read only positive numbers
static Double readPositiveNumber() {
    if (!input.hasNext()) safeExitOnEndOfFile();
    if (!input.hasNextDouble()) {
        input.next();
        return null;
    }
    double value = input.nextDouble();
    if (value <= 0) return null;
    return value;
}


// Go back funtion

    static boolean goBack(){
        System.out.println("Go back to menu? (y): ");
        if (!input.hasNext()) safeExitOnEndOfFile();
        String answer = input.next().trim().toLowerCase();
        return answer.equals("y");

    }
// End of file (något nytt för mig)
    static void safeExitOnEndOfFile() {
    System.out.println("Input closed! Run the program again :)");
    try { input.close(); } catch (Exception ignored) {}
    System.exit(0);
   }

   static double round2 (double value) {
    return Math.round(value * 100.0) / 100.0;
    }


}

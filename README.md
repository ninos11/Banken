
# Bank application - Console based java application.

Basic console banking application written in Java.
there is 3 users which have private PIN.

First user - Messi - PIN: 0001
Second user - Zlatan - PIN: 0002
Third user - Ronaldo - PIN: 0003

All three users can login with a PIN, check their balance, deposit and withdraw money and switch between currencies (SEK, USD, EUR).


## Features

* User login with PIN (3 attempts available before the program exit or close!).
* Menu including:
     - Show balance
     - Deposit money
     - Withdraw money
     - Change currency (SEK, USD and EUR)
     - Logout (ex. logout from user 1 and login again with another user)
     - Exit program
* Internal storage in SEK (users will be able to see the balance in chosen currency too).
* Input validation (positive number, integers and safe exit on EOF).

### Installation

* Requirements 
        <------ No external dependencies only: ------>
     - Java 17 or later (any modern JDK will work)

* Compile and Run
     1. Open your terminal "cmd".
     2. You should make sure that you are in correct folder directory!
        - You can change your folder directory in the terminal by this command: 
          cd "your folder link ex. C:\Users\your_name\Desktop\Projekter\banken"
     3. When you are sure that you are in the correct folder in your terminal, you can run this
        command to compile your file: javac -d out src/App.java
     4. After compiling, you can run this command to run the application: java -cp out App

* Usage Example 

     <=== Select user ===>
        1. Messi
        2. Zlatan
        3. Ronaldo
        4. Close program

        Your answer: 1

        Pin code for: Messi
        Your answer: 0001

        Login successful! Welcome, Messi

        Choose Currency
        1. SEK
        2. EUR
        3. USD

        Your answer: 2
        

        <=== Menu ===>
        1. Show balance
        2. Deposit
        3. Withdraw
        4. Change currency
        5. Logout
        6. Close program   
        
        Your answer: ......... (you can countine how you want! )

#### Challenge tasks i chose
* Selected tasks
         1. Multiple users/accounts – each account has its own name, PIN, and balance.
         2. Currency support (SEK, EUR, USD) – the user can choose a currency and see or enter amounts in that currency.
* Why i chose these?
         1. I wanted the program to feel more like a real banking system.
         2. Multiple users make it more practical, and currency support makes it more interesting.
* How I implemented them?
         1. Arrays are used for names, PINs, and balances (name[], pin[], amountSEK[]).
         2. Login requires the correct PIN (three attempts).
* Currency support:
         - All balances are stored internally in SEK and two methods handle conversion:
         1. toSEK(currency, amount) – converts deposits or withdrawals to SEK.
         2. fromSEK(currency, amountSEK) – shows balance in the selected currency.
* Reflection
         - Implementing multiple users and currency support taught me the importance of separating data storage from presentation. By storing all balances in SEK internally and only converting when
         showing or entering amounts, the program became easier to understand and maintain.
         -I also learned the value of input validation, for example when checking that deposits and withdrawals are positive numbers. In addition, I learned how to handle EOF (End Of File) so the program closes safely if the input stream ends unexpectedly.
                     

##### Developmental Proposals for the Future

* Changeable PIN
     - Users should be able to update their PIN code (default 1234) and use the new one for subsequent logins.
* Transaction History
     - Create a simple transaction log that stores the date and amount for each deposit, withdrawal and users can view their own history.   
* Admin Mode
     - Create an administrator mode where all users balances and recent transactions can be reviewed.


###### Contributing

1. Submit changes
     - Create new repo in your github account.
     - Create a new branch (with feature name)
     - Make your changes
     - Commit (with clear comment) and push
     - Create a pull request and merge it.
2. Code style
     - Use clear and consistent naming for your classes and variables
     - Create new method for every function to avoid DRY (Don't repeat your self).
       and write a cooment for every method to explain what the method do!
3. Testing
     - Run the code and make sure that everything work before you push it to github!
4. Issues and Contact
     - Create new issue for every branch to explain what you want to change or create.
     - Report bugs by opening an issue in your repo
     - For question, feel free to caontact me: 
        - Name: Ninos Chimon
        - Email: Ninos.nina@hotmail.com



###### Good luck!  

    








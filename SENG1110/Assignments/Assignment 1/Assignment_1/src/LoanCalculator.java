/*
Name: Isaac DeMaria
Student Number: c3330321
 */

import java.io.*;
import java.util.Scanner;

public class LoanCalculator {
    private int age, months;
    private int clientNum = 0;
    private final int maxClient = 5;
    private double income, amount;
    private String name, account;
    Scanner console = new Scanner(System.in);
    private final Client[] client = new Client[maxClient];

    public void run() throws IOException {
        // Switch statement to select what option. This will repeatedly loop as the program runs, showing the menu
        // after each selection. To terminate the program, the user can enter 8 when at the menu.

        showMenu();
        int option = getPositiveInt();
        console.nextLine();
        while(option != 8) {
            switch(option) {
                case 1: addClient();
                    break;
                case 2: removeClient();
                    break;
                case 3: showClient();
                    break;
                case 4: addAccount();
                    break;
                case 5: removeAccount();
                    break;
                case 6: showAccount();
                    break;
                case 7: outputTxt();
                    break;
                case 8: break;
                default: System.out.println("Error, Invalid Input");
            }
            showMenu();
            option = getPositiveInt();
            console.nextLine();
        }
    }

    public static void main(String[] args) throws IOException {
        LoanCalculator calc = new LoanCalculator();
        calc.run();
    }

    public static void showMenu() {
        System.out.println("Select an option: ");
        System.out.println("1 - add a new client");
        System.out.println("2 - delete a client");
        System.out.println("3 - show a client");
        System.out.println("4 - add a new account");
        System.out.println("5 - delete an account");
        System.out.println("6 - show account details");
        System.out.println("7 - save to file");
        System.out.println("8 - exit Program");
    }

    public void addClient() {
        if (clientNum < maxClient) { // A check is done to ensure the number of clients isn't full
            System.out.print("\nPlease enter your full name: ");
            name = console.nextLine();

            if (isDuplicate(name)) { // Check if the name already exists
                System.out.println("Sorry, a client already exists with that name");
            } else {
                System.out.print("Please enter your age: ");
                age = getPositiveInt();

                System.out.print("Please enter your yearly income: ");
                income = getPositiveInt();
                console.nextLine();

                client[clientNum] = new Client(name, age, income); // Initialise a new client for the array index.
                clientNum++; // Increment to keep track of the number of clients
                System.out.println();
            }
        } else {
            System.out.println("The maximum number of clients has been reached. Returning to menu\n");
        }
    }

    public void removeClient() {
        // Using an override method. Every object in the array beyond the removed index will override the
        // value on it's left. Because of this method, the last element will copy itself. This is not an issue as
        // if the clientNum tally is correct, that index won't be accessible.

        System.out.print("\nPlease enter the name of the client to be deleted: ");
        int index = getClientIndex();
        if (index == -1) {
            System.out.println("That client does not exist, returning to menu\n");
        } else {
            for (int i = index; i < client.length - 1; i ++) {
                client[i] = client[i+1];
            }
            clientNum--; // A client is removed to maintain tally
            System.out.println("Client has successfully been removed");
            pressEnterToContinue();
        }
    }

    public void showClient() {
        System.out.print("\nPlease enter the client name: ");
        int index = getClientIndex();
        if (index == -1) {
            System.out.println("That client does not exist, returning to menu\n");
        } else {
            System.out.println("\n" + client[index].getClientInformation());
            pressEnterToContinue();
        }
    }

    public void addAccount() {
        System.out.print("\nPlease enter the client name attached to the account: ");
        int index = getClientIndex();
        if (index == -1) { // If getClientIndex() returns -1, the client was not found
            System.out.println("That client does not exist, returning to menu\n");
        } else {
            if (client[index].getAccountNum() < 2) { // Check if the number of accounts initialised is not full.
                System.out.print("Please enter how much money you would like to burrow: ");
                amount = getPositiveInt();

                System.out.print("Please enter how many months you would like to take the loan for: ");
                months = getPositiveInt();

                System.out.print("Please enter whether you would like a \"fees\" or \"no fees\" account: ");
                console.nextLine();
                account = console.nextLine();
                while (!account.equalsIgnoreCase("fees") && !account.equalsIgnoreCase("no fees")) {
                    System.out.println("Error, invalid input. Please enter a valid account type.");
                    account = console.nextLine();
                }
                client[index].addAccountData(amount, months, account);
                pressEnterToContinue();
            } else {
                System.out.println("This client has a maximum number of accounts, returning to menu\n");
            }
        }
    }

    public void showAccount() {
        System.out.print("\nPlease enter the client name attached to the account: ");
        int clientIndex = getClientIndex();
        if (clientIndex == -1) { // If getClientIndex() returns -1, the client was not found
            System.out.println("That client does not exist, returning to menu\n");
        } else {
            if (client[clientIndex].getAccountNum() > 0){ // Check if any accounts have been initialised else return to menu
                System.out.print("Account number 1 or 2?: ");
                int accountIndex = console.nextInt() - 1;
                console.nextLine();

                if (accountIndex > client[clientIndex].getAccountNum() - 1) { // Check if the specified account has been initialised
                    System.out.println("Sorry, that account does not exist, returning to menu\n");
                } else { // If the account index is initialised, print the account info.
                    System.out.println(client[clientIndex].getAccountInformation(accountIndex));
                    pressEnterToContinue();
                }
            } else {
                System.out.println("No account exists for this client, returning to menu\n");
            }
        }
    }

    public void removeAccount() {
        System.out.print("\nPlease enter the name of the client: ");
        int clientIndex = getClientIndex();
        if (clientIndex == -1) { // If getClientIndex() returns -1, the client was not found
            System.out.println("That client does not exist, returning to menu\n");
        } else {
            System.out.print("Please enter the account to delete (1) or (2): ");
            int accountIndex = console.nextInt() - 1; // Shift by 1 to get the index position
            console.nextLine();

            if (accountIndex >= client[clientIndex].getAccountNum()) { // If the account index isn't initialised, return.
                System.out.println("Sorry, that account does not exist, returning to menu\n");
            } else {
                client[clientIndex].removeAccount(accountIndex);
                System.out.println("Account has successfully been removed");
                pressEnterToContinue();
            }
        }
    }

    public int getClientIndex() {
        // Reads user input of the client name and searches through all initialised clients for the same name.
        // Return the index position if found, or -1 if not.
        String lookupName = console.nextLine();
        for (int i = 0; i < clientNum; i ++) {
            if (lookupName.equalsIgnoreCase(client[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    public void outputTxt() throws IOException {
        String fileName = "output.txt"; // Store the output in file names "output.txt". This will overwrite each time
                                        // the save to file options is selected.
        BufferedWriter output = new BufferedWriter(new FileWriter(fileName));

        // This bufferString is used repeatedly to separate each client and account.
        String bufferString = "--------------------------------------------------------------------------------------------\n";

        // The clientInfo is a string containing all client info and their accounts. The StringBuilder class is being used
        // to avoid looped string concatenation
        StringBuilder clientInfo = new StringBuilder();
        for (int clientIndex = 0; clientIndex < maxClient; clientIndex++) {
            // For all possible clients (5 in this case) the client's info is appended to the string
            clientInfo.append(bufferString);
            if (clientIndex < clientNum) {
                // If they exist in client[], append the client info (same as showClient())
                clientInfo.append(client[clientIndex].getClientInformation()).append("\n");
                clientInfo.append(bufferString);

                for (int accountIndex = 0; accountIndex < 2; accountIndex++) {
                    // For all possible accounts (2 in this case), the client's account info is appended to the string
                    clientInfo.append(client[clientIndex].getName()).append("'s account ").append(accountIndex + 1).append(",\n");

                    if (accountIndex < client[clientIndex].getAccountNum()) {
                        // If they exist in loan[], append the account info (same as showAccount()).
                        clientInfo.append(client[clientIndex].getAccountInformation(accountIndex)).append("\n");
                    } else {
                        clientInfo.append("no account\n");
                    }
                    clientInfo.append(bufferString);
                    if (accountIndex == 1) {
                        clientInfo.append("\n\n"); // Used to separate the different clients with a double line.
                    }
                }
            } else { // If there is no client for that index, print two of the buffers lines to separate the next client
                clientInfo.append("no client\n");
                clientInfo.append(bufferString + "\n\n");
            }
        }
        try {
            // Write the concatenated string to the file
            output.write(clientInfo.toString());
        } catch (IOException ex) {
            System.out.println("Error outputting to file");
        }
        finally {
            output.close();
            System.out.println("User data has been written to file: "+ fileName);
            pressEnterToContinue();
        }
    }

    public boolean isDuplicate(String checkName) {
        // Checks all initialised clients to see if there is a duplicate name.

        for (int i = 0; i < clientNum; i ++) {
            if (checkName.equalsIgnoreCase(client[i].getName())) {
                return true;
            }
        }
        return false;
    }

    public void pressEnterToContinue() {
        // This is a method that will pause the console until the user presses enter.
        // Allows easier reading of output as otherwise, the menu would scroll the console.

        System.out.println("Press 'Enter' to return to menu");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    public int getPositiveInt() {
        // A method to check if an int is positive. Will ask until a positive int is received.
        // This was turned into a method as it is required for all int inputs - saving space.

        int posInt = console.nextInt();
        while (posInt < 0) {
            System.out.println("Error, invalid input. Please enter a number > 0");
            posInt = console.nextInt();
        }
        return posInt;
    }
}
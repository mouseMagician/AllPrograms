/*
Name: Isaac DeMaria
Student Number: c3330321
 */

import java.util.Scanner;

public class LoanCalculator {

    // Initialise variables and classes

    Scanner console = new Scanner(System.in);
    Client client;
    String account;
    private int end, age, months;
    private double income, amount;

    public void run() {
        do {

            System.out.print("Please enter your full name: ");
            String name = console.nextLine();

            System.out.print("Please enter your age: ");
            age = getPositiveInt();

            System.out.print("Please enter your yearly income: ");
            income = getPositiveInt();

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

            client = new Client(name, age, income, amount, months, account);
            client.calculateAccount();

            System.out.println("\n" + client.getClientInfo());
            System.out.println(client.getAccountInfo());
            System.out.println(client.getPaymentInformation());

            System.out.println("The amortization table is:");
            System.out.println(client.getAccountAmortizationTable());

            System.out.println("(0) exit program (1) rerun program");
            end = console.nextInt();
            console.nextLine();
        } while (end != 0);
    }

    public static void main(String[] args) {
        LoanCalculator calc = new LoanCalculator();
        calc.run();
    }

    public int getPositiveInt() {
        int posInt;
        posInt = console.nextInt();
        while (posInt < 0) {
            System.out.println("Error, invalid input. Please enter a number > 0");
            posInt = console.nextInt();
        }
        return posInt;
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
}
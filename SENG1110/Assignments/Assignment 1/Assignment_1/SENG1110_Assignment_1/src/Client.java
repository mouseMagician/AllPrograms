/*
Name: Isaac DeMaria
Student Number: c3330321
 */

public class Client {

    private String name;
    private String tempString = "";
    private int age;
    private double income;
    Account loan;

    // Initialise constructor

    public Client(String inputName, int inputAge, double inputIncome, double inputAmount, int inputMonths, String inputAccount) {
        name = inputName;
        age = inputAge;
        income = inputIncome;
        loan = new Account(inputAmount, inputMonths, inputAccount);
    }

    public void calculateAccount() { // Run the calculations required to print the client information
        loan.setInterestRate();
        loan.calculateMonthlyPayment();
    }

    public String getName() {
        // This is coded to accept either a single word name, or multiple. If multiple words are given, the first
        // word will be interpreted as the first name and the last word will be interpreted as the last name

        if (name.indexOf(' ') != -1) {
            String firstName = name.substring(0, name.indexOf(' '));
            String lastName = name.substring(name.lastIndexOf(" ") + 1);
            return firstName + " " + lastName;
        } else {
            return name;
        }
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double newIncome) {
        income = newIncome;
    }

    public String getClientInfo() {
        return getName() + ", age " + getAge() + ", income " + getIncome();
    }

    public String getAccountInfo() {
        return "Amount to borrow = " + loan.getAmount() + " to pay in " + loan.getMonths() +
                " months with account type \"" + loan.getAccountType() + "\".";
    }

    public String getPaymentInformation() {
        tempString = "The interest rate will be " + loan.getInterestRate() + "%\n";
        tempString += "The monthly payment will be p = $" + Math.round(loan.getMonthlyPayment()*100.0)/100.0;
        if (loan.getInterestRate() == 6) {
            tempString += ", including the additional $10 in fees per month";
        }
        tempString += "\nThe total payment is $" + Math.round(loan.getTotalPayment()*100.0)/100.0 + "\n";
        tempString += "Total interest paid is " + Math.round(loan.getTotalInterest()*100.0)/100.0 + "\n";
        return tempString;
    }

    public String getAccountAmortizationTable() {
        return loan.getAmortizationTable();
    }
}
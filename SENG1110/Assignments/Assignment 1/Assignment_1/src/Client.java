/*
Name: Isaac DeMaria
Student Number: c3330321
 */

public class Client {

    private String name;
    private int age, accountNum;
    private double income;
    private final int maxAccounts = 2;
    Account[] loan;

    public Client() { // Default constructor
        name = "";
        age = 0;
        income = 0;
        loan = new Account[maxAccounts];
        accountNum = 0;
    }

    public Client(String inputName, int inputAge, double inputIncome) { // Constructor when inputting data
        name = inputName;
        age = inputAge;
        income = inputIncome;
        loan = new Account[maxAccounts];
        accountNum = 0;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public String getName() {
        return name;
    }

    public String getFormattedName() {
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

    public String getClientInformation() {
        return getFormattedName() + ", age: " + getAge() + ", income: $" + getIncome() + ", account(s): " + accountNum;
    }

    public String getAccountInformation(int accountIndex) {
        // Returns a string containing all the account information. The payment information and amortization have been
        // split into separate methods for flexibility down the line (theoretically).

        String tempString = "Amount to borrow = $" + loan[accountIndex].getAmount() + " to pay in " + loan[accountIndex].getMonths() +
                " months with account type \"" + loan[accountIndex].getAccountType() + "\".\n";
        tempString += getPaymentInformation(accountIndex);
        tempString += "The amortization table is:\n";
        tempString += getAccountAmortizationTable(accountIndex);
        return tempString;

    }

    public String getPaymentInformation(int accountIndex) {
        // Formats the payment information

        String tempString = "The interest rate will be " + loan[accountIndex].getInterestRate() + "%\n";
        tempString += "The monthly payment will be p = $" + Math.round(loan[accountIndex].getMonthlyPayment()*100.0)/100.0;
        if (loan[accountIndex].getInterestRate() == 6) {
            tempString += ", including the additional $10 in fees per month";
        }
        tempString += "\nThe total payment is $" + Math.round(loan[accountIndex].getTotalPayment()*100.0)/100.0 + "\n";
        tempString += "Total interest paid is $" + Math.round(loan[accountIndex].getTotalInterest()*100.0)/100.0 + "\n";
        return tempString;
    }

    public String getAccountAmortizationTable(int accountIndex) {
        return loan[accountIndex].getAmortizationTable();
    }

    public void addAccountData(double inputAmount, int inputMonths, String inputAccount) {
        if (accountNum < maxAccounts) { // Check if there is already the maximum number of accounts. If not,
                                        // a new account is initialised and data can be added
            loan[accountNum] = new Account(inputAmount, inputMonths, inputAccount);
            accountNum++; // Increment to keep track of the number of accounts
        }
    }

    public void removeAccount(int accountIndex) {
        // This works the same way as removeClient where the index to the right will replace the index to the left.
        // This will mean the last array index will copy itself, however the accountNum is decremented, so it cannot
        // be accessed.

        for (int i = accountIndex; i < loan.length - 1; i ++) {
            loan[i] = loan[i + 1];
        }
        accountNum--;
    }
}
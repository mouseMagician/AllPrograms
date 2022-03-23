/*
Name: Isaac DeMaria
Student Number: c3330321
 */

public class Account {
    private int numberOfMonths;
    private String accountType;
    private double payment, finalBalance, amount, interestRate, interest, principle;

    public Account() { // Default constructor
        amount = 0;
        numberOfMonths = 0;
        accountType = "";
    }

    public Account(double inputAmount, int inputMonths, String inputAccountType) { // Constructor to initialise
        amount = inputAmount;
        numberOfMonths = inputMonths;
        accountType = inputAccountType;
        setInterestRate();
        calculateMonthlyPayment();
    }

    public void setInterestRate() {
        if ((accountType).equalsIgnoreCase("no fees")) { // Determine rate based on account type
            if (numberOfMonths < 50) {
                interestRate = 0.065;
            } else if (numberOfMonths >= 50 && numberOfMonths <= 100) {
                interestRate = 0.075;
            } else {
                interestRate = 0.085;
            }
        } else {
            interestRate = 0.06;
        }
    }

    public double getInterestRate() {
        // return the interest rate as a percentage
        return interestRate * 100;
    }

    public void setMonths(int newMonths) {
        numberOfMonths = newMonths;
    }

    public int getMonths() {
        return numberOfMonths;
    }

    public void setAmount(double newAmount) {
        amount = newAmount;
        finalBalance = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAccountType(String newAccountType) {
        accountType = newAccountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void calculateMonthlyPayment() {
        double a = 1 + interestRate / 12;
        payment = (amount * interestRate * Math.pow(a, numberOfMonths)) / (12 * (Math.pow(a, numberOfMonths) - 1));
    }

    public double getMonthlyPayment() {
        if (interestRate == 0.06) { // Check if the account type includes the $10 fee
            return payment + 10;
        } else {
            return payment;
        }
    }

    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfMonths;
    }

    public double getTotalInterest() {
        return (payment * numberOfMonths - amount);
    }

    public String getAmortizationTable() {
        // Note: The monthly payment in the amortization table will include the $10 for a fee account.
        String tempString1, tempString2;
        double tempAmount;

        finalBalance = amount;
        StringBuilder build = new StringBuilder(); // Using StringBuilder as to avoid looped string concatenation
        build.append("Month     InitBalance     MonthPayment     InterestPaid     PrinciplePaid     FinalBalance\n");
        for (int j = 1; j <= numberOfMonths; j++) {
            tempAmount = finalBalance;
            interest = tempAmount * interestRate / 12;
            principle = payment - interest;
            finalBalance = tempAmount - payment + interest;

            tempString1 = "%-9d $%-14.2f $%-15.2f $%-15.2f $%-16.2f $%.2f\n"; // String formatting to offset distance and round

            if (finalBalance < 0.00001) { // Fix to avoid $-0.00. Hard print 0.00 if finalBalance approx = 0
                tempString2 = String.format(tempString1, j, tempAmount, getMonthlyPayment(), interest, principle, 0.00);
            } else {
                tempString2 = String.format(tempString1, j, tempAmount, getMonthlyPayment(), interest, principle, finalBalance);
            }
            build.append(tempString2);
        }
        return build.toString(); // Return the string containing the entirety of the table
    }
}
import java.lang.Math;

public class Account {
    private int numberOfMonths;
    private String accountType;
    private double payment, finalBalance, amount, interestRate;
    private int i = 0;

    public Account() {

    }

    public void setInterestRate() {
        if ((accountType.toLowerCase()).equals("no fees")) {
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
        return interestRate;
    }

    public void setMonths(int newMonths) {
        numberOfMonths = 100;
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

    public double calculateMonthlyPayment() {
        double a = 1 + interestRate / 12;
        payment = (amount * interestRate * Math.pow(a, numberOfMonths)) / (12 * (Math.pow(a, numberOfMonths) - 1));

        if (interestRate == 0.06) {
            return payment + 10;
        } else {
            return payment;
        }
    }

    public void incrementI() {
        i++;
    }

    public String getAmortizationTable() {
        incrementI();
        amount = finalBalance;
        double interest = amount * interestRate / 12;
        double principle = payment - interest;
        finalBalance = amount - payment + interest;
        return (i + "         $" + Math.round(amount*100.0)/100.0 + "        $" + Math.round(payment*100.0)/100.0 +
                "         $" + Math.round(interest*100.0)/100.0 + "           $" + Math.round(principle*100.0)/100.0 +
                "           $" + Math.round(finalBalance*100.0)/100.0);
    }
}





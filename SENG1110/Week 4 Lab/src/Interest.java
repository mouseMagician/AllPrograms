import java.util.Scanner;
import java.lang.Math;

public class Interest {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the cost");
        double cost = input.nextDouble();
        System.out.println("What is the number of months");
        int months = input.nextInt();
        System.out.println("What is the interest rate as a percentage");
        double rate = input.nextDouble();

        double interest = cost*(rate/(100*12))*months;
        double total_cost = interest + cost;

        System.out.println("Cost is " + total_cost + " with " + interest + " interest");

    }
}

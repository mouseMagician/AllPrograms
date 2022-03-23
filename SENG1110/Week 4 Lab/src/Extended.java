import java.util.*;

public class Extended
{
    public static void main (String[] args)
    {
        Scanner console = new Scanner(System.in);
        double hours, pretotal;
        double total = 0, rate = 10, overtime = 15;

        System.out.println("Please enter your name: ");
        String name = console.next();
        System.out.println("Please enter how many weeks you have worked: ");
        int num_weeks = console.nextInt();

        for (int i = 1; i <= num_weeks; i++) {
            System.out.println("Please enter number of hours your worked week " + i + ": ");

            for (;;) {
                if (!console.hasNextDouble()) { // Not allow strings
                    String input = console.next();
                    System.out.println(input + " is not a number");
                    continue;
                }
                hours = console.nextDouble();
                if (hours < 0) { // Not allow negative hours worked
                    System.out.println("Please enter a number >= 0");
                    continue;
                }
                break;
            }

            if (hours < 40) {
                total += hours * rate;
            } else {
                total += (40 * rate) + (hours - 40) * overtime;
            }
        }
        pretotal = total;

        if (total <= 1000) {
            total *= 1.1;
            System.out.println("Salary of " + name + " is: $" + total + " with a bonus of: 10%");
        } else if (total > 1000 && total <= 2000) {
            total *= 1.05;
            System.out.println("Salary of " + name + " is: $" + total + " with a bonus of: 5%");
        } else if (total >2000 && total <= 3000) {
            total *= 1.01;
            System.out.println("Salary of " + name + " is: $" + total + " with a bonus of: 1%");
        } else {
            System.out.println("Salary of " + name + " is: $" + total);
        }
    }
}

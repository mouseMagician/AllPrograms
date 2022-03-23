import java.util.*;

public class Assign1
{
    public static void main (String[] args)
    {
        Scanner console = new Scanner(System.in); // Initialise the input scanner

        double hours;
        double total = 0, rate = 10, overtime = 15; // Initialise the variables and rates

        for (int i = 1; i < 6; i++) { // Loop for each of the five weeks
            System.out.println("Please enter number of hours your worked week " + i + ": ");

            for (;;) { // Basically a while loop
                if (!console.hasNextDouble()) { // Not allow strings
                    String input = console.next();
                    System.out.println(input + " is not a number");
                    continue;
                }

                hours = console.nextDouble();
                if (hours < 0) { // Not allow negative hours worked.
                    System.out.println("Please enter a number >= 0");
                    continue;
                }
                break;
            }

            if (hours < 40) { // Calculate the total salary based on the base rate and overtime pay
                total += hours * rate;
            } else {
                total += (40 * rate) + (hours - 40) * overtime;
            }
        }
        System.out.println("Total salary is: $" + total +  "\n");
    }
}
import java.util.*;
import java.lang.Math;

public class Factorialtype
{
    public static void main (String args[])
    {
        double total = 0, fact = 1;
        double sign, n;

        Scanner console = new Scanner(System.in);
        System.out.println("What number of terms?: ");
        int num = console.nextInt();

        for (int j = 1; j <= num; j+= 1) {
            n = (2 * j) -1;
            sign = Math.pow(-1, (j - 1));

            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            total += (fact * sign);
            fact = 1;
        }
        System.out.println(total);
    }
}

// Factorial:
// fac *= (n-1))

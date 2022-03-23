import java.util.*;
import java.lang.Math;

public class Testa
{
    public static void main (String args[])
    {
        int total = 0, fact = 1;
        int sign, n, num, in;

        Scanner console = new Scanner(System.in);
        System.out.println("What odd number 'n' would you like to go to?: ");
        in = console.nextInt();

        num = Math.round(in/2) + 1;
        System.out.println(num);

        for (int j = 1; j <= num; j+= 1) {
            n = (2 * j) -1;
            sign = (int) Math.pow(-1, (j - 1));

            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            total += (fact * sign);
            fact = 1;
        }
        System.out.println(total);
    }
}
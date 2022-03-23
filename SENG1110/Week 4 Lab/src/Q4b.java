import java.util.*;
import java.lang.Math;

public class Q4b {
    public static void main(String args[]) {
        double total = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number n for this series: ");
        int n = input.nextInt();

        for (double i = 2; i <= n+1; i++) {
            total += Math.pow((i-1)/i, 2);
        }
        System.out.println(total);
    }
}

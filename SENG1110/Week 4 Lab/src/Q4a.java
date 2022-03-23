import java.util.*;

public class Q4a {
    public static void main(String args[]) {
        int total = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number n for this series: ");
        int n = input.nextInt();

        for (int i=2; i<=2*n; i+=2) {
            total += i;
        }
        System.out.println(total);
    }
}

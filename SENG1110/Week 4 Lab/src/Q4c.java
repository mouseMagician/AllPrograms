import java.util.*;

public class Q4c {
    public static void main(String args[]) {
        int total = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number n for this series: ");
        int n = input.nextInt();

        for (int i = 1; i <= 2*n - 1; i += 2) {
            total += i*(i+2);
        }
        System.out.println(total);
    }
}

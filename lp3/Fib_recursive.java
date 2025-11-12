import java.util.*;

public class Fib_recursive {

    static int a = 0;
    static int b = 1;
    static int c;

    static void fib(int count) {
        if (count == 0) return;
        c = a + b;
        a = b;
        b = c;
        System.out.print(c + " ");
        fib(count - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        System.out.print("Fibonacci Series: ");
        System.out.print(a + " " + b + " ");
        fib(n - 2); 

        sc.close();
    }
}

import java.util.*;

class NQueen {

    static boolean solutionFound = false;  // flag to stop after first solution

    static boolean isConsistent(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            if (a[i] == a[n]) return false;                 // same column
            if (Math.abs(a[i] - a[n]) == (n - i)) return false; // same diagonal
        }
        return true;
    }

    static void printQ(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("\n One valid solution found!");
    }

    static void enumerator(int[] a, int n) {
        if (solutionFound) return;  // stop recursion once solution is printed

        if (n == a.length) {
            printQ(a);
            solutionFound = true;
        } else {
            for (int i = 0; i < a.length; i++) {
                a[n] = i;
                if (isConsistent(a, n))
                    enumerator(a, n + 1);
                if (solutionFound) return; // exit early after finding one
            }
        }
    }

    static void enumerate(int n) {
        int[] a = new int[n];
        enumerator(a, 0);
        if (!solutionFound)
            System.out.println("No solution exists for " + n + " queens.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        int n = sc.nextInt();
        enumerate(n);
    }
}

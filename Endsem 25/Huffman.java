import java.util.*;

class Node implements Comparable<Node> {
    int freq;
    char ch;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(Node left, Node right) {
        this.ch = '-'; // internal node
        this.freq = left.freq + right.freq;
        this.left = left;
        this.right = right;
    }

    public int compareTo(Node other) {
        return this.freq - other.freq;
    }
}

public class Huffman {
    
    static void printCodes(Node root, String code) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " -> " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter character: ");
            chars[i] = sc.next().charAt(0);
            System.out.print("Enter frequency: ");
            freq[i] = sc.nextInt();
        }

        // Step 1: Add all characters to priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            pq.add(new Node(chars[i], freq[i]));

        // Step 2: Build Huffman Tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node(left, right));
        }

        // Step 3: Print Huffman Codes
        System.out.println("\nHuffman Codes:");
        printCodes(pq.peek(), "");

        sc.close();
    }
}

import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
 
            if (a > b)
                System.out.println("First");
            else if (b > a)
                System.out.println("Second");
            else
                System.out.println(c % 2 == 1 ? "First" : "Second");
        }
    }
}
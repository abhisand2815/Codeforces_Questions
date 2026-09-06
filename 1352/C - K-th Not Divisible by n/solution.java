import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
 
            long ans = ((k - 1) / (n - 1)) * n + (k - 1) % (n - 1) + 1;
 
            System.out.println(ans);
        }
    }
}
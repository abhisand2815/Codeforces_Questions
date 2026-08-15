import java.util.*;
 
public class Main {
    static long range(long a, long b, long c) {
        return Math.max(a, Math.max(b, c))
             - Math.min(a, Math.min(b, c));
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
 
            long ans = range(a, b, c);
 
            ans = Math.min(ans, range(a, b, a + b));
            ans = Math.min(ans, range(a, a + c, c));
            ans = Math.min(ans, range(b + c, b, c));
 
            System.out.println(ans);
        }
    }
}
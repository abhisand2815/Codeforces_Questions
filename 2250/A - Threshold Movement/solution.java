import java.util.*;
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
 
            int n = sc.nextInt();
 
            if ((n & 1) == 1) {
                for (int i = 0; i < n; i++) sc.nextInt();
                System.out.println("NO");
                continue;
            }
 
            int maxEven = Integer.MIN_VALUE;
            int minOdd = Integer.MAX_VALUE;
 
            for (int i = 1; i <= n; i++) {
                int x = sc.nextInt();
 
                if ((i & 1) == 1)
                    minOdd = Math.min(minOdd, x);
                else
                    maxEven = Math.max(maxEven, x);
            }
 
            if (minOdd - maxEven >= 2)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
 
        sc.close();
    }
}
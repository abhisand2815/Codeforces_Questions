import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
 
            int[] a = new int[n];
 
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
 
            int ans = a[0];  // distance from 0 to first station
 
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, a[i] - a[i - 1]);
            }
 
            // Last station -> x -> last station
            ans = Math.max(ans, 2 * (x - a[n - 1]));
 
            System.out.println(ans);
        }
 
        sc.close();
    }
}
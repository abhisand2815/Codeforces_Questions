import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
 
            int compressed = 1;
 
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    compressed++;
                }
            }
 
            int ans = compressed;
 
            for (int i = 1; i < n - 1; i++) {
                int cur = compressed;
 
                if (s.charAt(i - 1) != s.charAt(i)) {
                    cur--;
                }
 
                if (s.charAt(i) != s.charAt(i + 1)) {
                    cur--;
                }
 
                if (s.charAt(i - 1) != s.charAt(i + 1)) {
                    cur++;
                }
 
                ans = Math.min(ans, cur);
            }
 
            System.out.println(ans);
        }
    }
}
import java.util.*;
 
public class Main {
    static final long MOD = 998244353;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
 
            long ans = 0;
 
            // Try all possibilities for first two characters
            for (int a = 0; a <= 1; a++) {
                for (int b = 0; b <= 1; b++) {
 
                    if (s.charAt(0) != '?' && s.charAt(0) - '0' != a)
                        continue;
 
                    if (s.charAt(1) != '?' && s.charAt(1) - '0' != b)
                        continue;
 
                    int x = a;
                    int y = b;
                    boolean ok = true;
 
                    for (int i = 2; i < n; i++) {
 
                        int z = 1 - x;
 
                        if (s.charAt(i) != '?' &&
                            s.charAt(i) - '0' != z) {
                            ok = false;
                            break;
                        }
 
                        x = y;
                        y = z;
                    }
 
                    if (ok)
                        ans++;
                }
            }
 
            System.out.println(ans);
        }
    }
}
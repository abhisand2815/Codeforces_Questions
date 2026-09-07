import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
 
            int dots = 0;
            int maxDots = 0;
            int cur = 0;
 
            for (char c : s.toCharArray()) {
                if (c == '.') {
                    dots++;
                    cur++;
                    maxDots = Math.max(maxDots, cur);
                } else {
                    cur = 0;
                }
            }
 
            System.out.println(maxDots >= 3 ? 2 : dots);
        }
    }
}
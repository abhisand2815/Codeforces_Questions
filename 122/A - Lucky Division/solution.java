import java.util.*;
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        for (int i = 1; i <= n; i++) {
 
            if (isLucky(i) && n % i == 0) {
                System.out.println("YES");
                return;
            }
        }
 
        System.out.println("NO");
    }
 
    static boolean isLucky(int x) {
 
        while (x > 0) {
            int digit = x % 10;
 
            if (digit != 4 && digit != 7)
                return false;
 
            x /= 10;
        }
 
        return true;
    }
}
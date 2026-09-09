import java.util.*;
 
public class Main {
    static boolean composite(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return true;
        }
        return false;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
 
        for (int x = 4; x < n; x++) {
            int y = n - x;
 
            if (composite(x) && composite(y)) {
                System.out.println(x + " " + y);
                return;
            }
        }
    }
}
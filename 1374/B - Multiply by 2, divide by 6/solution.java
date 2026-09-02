import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            long n = sc.nextLong();
 
            int a = 0, b = 0;
 
            while (n % 2 == 0) {
                n /= 2;
                a++;
            }
 
            while (n % 3 == 0) {
                n /= 3;
                b++;
            }
 
            if (n != 1 || a > b) {
                System.out.println(-1);
            } else {
                System.out.println(2 * b - a);
            }
        }
    }
}
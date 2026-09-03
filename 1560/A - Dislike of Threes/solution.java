import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int k = sc.nextInt();
            int count = 0;
            int x = 0;
 
            while (count < k) {
                x++;
 
                if (x % 3 != 0 && x % 10 != 3) {
                    count++;
                }
            }
 
            System.out.println(x);
        }
    }
}
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int prev = sc.nextInt();
        int current = 1;
        int max = 1;
 
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt();
 
            if (x >= prev) {
                current++;
            } else {
                current = 1;
            }
 
            max = Math.max(max, current);
            prev = x;
        }
 
        System.out.println(max);
    }
}
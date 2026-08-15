import java.util.*;
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int[] coins = new int[n];
 
        int total = 0;
 
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
            total += coins[i];
        }
 
        Arrays.sort(coins);
 
        int mine = 0;
        int count = 0;
 
        for (int i = n - 1; i >= 0; i--) {
            mine += coins[i];
            count++;
 
            if (mine > total - mine) {
                break;
            }
        }
 
        System.out.println(count);
    }
}
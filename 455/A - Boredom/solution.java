import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int[] count = new int[100001];
 
        for (int i = 0; i < n; i++) {
            count[sc.nextInt()]++;
        }
 
        long[] dp = new long[100001];
 
        dp[1] = count[1];
 
        for (int i = 2; i <= 100000; i++) {
            dp[i] = Math.max(
                dp[i - 1],
                dp[i - 2] + (long) i * count[i]
            );
        }
 
        System.out.println(dp[100000]);
    }
}
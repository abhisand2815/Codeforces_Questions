import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        long t = sc.nextLong();
 
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
 
        int left = 0;
        long sum = 0;
        int ans = 0;
 
        for (int right = 0; right < n; right++) {
            sum += a[right];
 
            while (sum > t) {
                sum -= a[left++];
            }
 
            ans = Math.max(ans, right - left + 1);
        }
 
        System.out.println(ans);
 
        sc.close();
    }
}
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int[] prices = new int[n];
 
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
 
        Arrays.sort(prices);
 
        int q = sc.nextInt();
 
        while (q-- > 0) {
            int money = sc.nextInt();
 
            int left = 0;
            int right = n;
 
            while (left < right) {
                int mid = left + (right - left) / 2;
 
                if (prices[mid] <= money) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
 
            System.out.println(left);
        }
    }
}
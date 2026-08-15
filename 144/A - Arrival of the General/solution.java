import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int[] a = new int[n];
 
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
 
        int max = 0, min = 101;
        int maxPos = 0, minPos = 0;
 
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
                maxPos = i;
            }
            if (a[i] <= min) {
                min = a[i];
                minPos = i;
            }
        }
 
        int ans = maxPos + (n - 1 - minPos);
 
        if (maxPos > minPos) {
            ans--;
        }
 
        System.out.println(ans);
    }
}
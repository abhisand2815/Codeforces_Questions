import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int s = sc.nextInt();
        int n = sc.nextInt();
 
        int[][] dragons = new int[n][2];
 
        for (int i = 0; i < n; i++) {
            dragons[i][0] = sc.nextInt();
            dragons[i][1] = sc.nextInt();
        }
 
        Arrays.sort(dragons, (a, b) -> a[0] - b[0]);
 
        for (int i = 0; i < n; i++) {
            if (s <= dragons[i][0]) {
                System.out.println("NO");
                return;
            }
 
            s += dragons[i][1];
        }
 
        System.out.println("YES");
    }
}
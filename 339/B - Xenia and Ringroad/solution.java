import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        long time = 0;
        int current = 1;
 
        for (int i = 0; i < m; i++) {
            int next = sc.nextInt();
 
            if (next >= current) {
                time += next - current;
            } else {
                time += n - current + next;
            }
 
            current = next;
        }
 
        System.out.println(time);
 
        sc.close();
    }
}
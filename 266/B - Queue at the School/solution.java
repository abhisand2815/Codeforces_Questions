import java.util.*;
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int t = sc.nextInt();
 
        char[] s = sc.next().toCharArray();
 
        while (t-- > 0) {
 
            for (int i = 0; i < n - 1; i++) {
 
                if (s[i] == 'B' && s[i + 1] == 'G') {
                    char temp = s[i];
                    s[i] = s[i + 1];
                    s[i + 1] = temp;
                    i++; // Skip next position
                }
            }
        }
 
        System.out.println(new String(s));
 
        sc.close();
    }
}
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        String s = sc.next();
 
        s = s.toLowerCase();
 
        boolean[] alphabet = new boolean[26];
 
        for (int i = 0; i < n; i++) {
            alphabet[s.charAt(i) - 'a'] = true;
        }
 
        for (int i = 0; i < 26; i++) {
            if (!alphabet[i]) {
                System.out.println("NO");
                return;
            }
        }
 
        System.out.println("YES");
    }
}
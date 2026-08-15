import java.util.*;
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        String s = sc.next().toLowerCase();
 
        StringBuilder ans = new StringBuilder();
 
        for (char c : s.toCharArray()) {
 
            if (c != 'a' && c != 'e' && c != 'i' &&
                c != 'o' && c != 'u' && c != 'y') {
 
                ans.append('.');
                ans.append(c);
            }
        }
 
        System.out.println(ans);
 
        sc.close();
    }
}
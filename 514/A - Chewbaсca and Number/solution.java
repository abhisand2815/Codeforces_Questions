import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
 
        StringBuilder ans = new StringBuilder();
 
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
 
            if (d >= 5 && !(i == 0 && d == 9))
                d = 9 - d;
 
            ans.append(d);
        }
 
        System.out.println(ans);
    }
}
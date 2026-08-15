import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String a = sc.nextLine();
        String b = sc.nextLine();
 
        StringBuilder ans = new StringBuilder();
 
        for (int i = 0; i < a.length(); i++) {
            ans.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
 
        System.out.println(ans);
    }
}
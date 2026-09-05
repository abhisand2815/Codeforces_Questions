import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
 
            char[] x = a.toCharArray();
            char[] y = b.toCharArray();
 
            char temp = x[0];
            x[0] = y[0];
            y[0] = temp;
 
            System.out.println(new String(x) + " " + new String(y));
        }
    }
}
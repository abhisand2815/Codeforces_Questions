import java.util.*;
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int year = sc.nextInt();
 
        while (true) {
            year++;
 
            String s = String.valueOf(year);
 
            if (s.charAt(0) != s.charAt(1) &&
                s.charAt(0) != s.charAt(2) &&
                s.charAt(0) != s.charAt(3) &&
                s.charAt(1) != s.charAt(2) &&
                s.charAt(1) != s.charAt(3) &&
                s.charAt(2) != s.charAt(3)) {
 
                System.out.println(year);
                break;
            }
        }
 
        sc.close();
    }
}
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine();
 
        if (p.contains("H") || p.contains("Q") || p.contains("9"))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
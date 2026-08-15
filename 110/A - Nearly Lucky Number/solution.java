import java.util.*;
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        String n = sc.next();
 
        int count = 0;
 
        for (char c : n.toCharArray()) {
            if (c == '4' || c == '7')
                count++;
        }
 
        if (isLucky(count))
            System.out.println("YES");
        else
            System.out.println("NO");
 
        sc.close();
    }
 
    static boolean isLucky(int num) {
 
        if (num == 0)
            return false;
 
        while (num > 0) {
            int digit = num % 10;
 
            if (digit != 4 && digit != 7)
                return false;
 
            num /= 10;
        }
 
        return true;
    }
}